package se.mah.kd405a_johan_a.assignment7;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import se.mah.k3.klara.PixelController;
import se.mah.k3.klara.PixelController.Screen;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {

	private JPanel contentPane;
	
	private PaintPanel pnlDebugView;

	private static final boolean isTesting = false; // Set to true when testing to skip connecting to screen.

	private PixelController	pixelController;
	private int width;
	private int height;
	private JLabel lblStatus;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Screen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		JComboBox comboBox = new JComboBox();
		// Add screens to combo box.
		for(Screen s : PixelController.Screen.values()) {
			comboBox.addItem(s.name());
		}
		panel.add(comboBox, BorderLayout.NORTH);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ScreenThread(PixelController.Screen.valueOf((String)comboBox.getSelectedItem())).start();
			}
		});
		panel.add(btnConnect, BorderLayout.EAST);
		
		lblStatus = new JLabel("Status: Not connected");
		panel.add(lblStatus, BorderLayout.SOUTH);
		
		JPanel panel2 = new JPanel();
		panel2.setBorder(new TitledBorder(null, "Debug View", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel2, BorderLayout.CENTER);

		// Create a debug view panel for screen debugging.
		pnlDebugView = new PaintPanel();
		pnlDebugView.setOpaque(true);
		pnlDebugView.setBounds(panel2.getInsets().left, panel2.getInsets().top, 256, 256);
		panel2.add(pnlDebugView, BorderLayout.CENTER);
		panel2.setLayout(new BorderLayout(0, 0));
	}
	
	/**
	 * Handles the updating of the screen. 
	 */
	private class ScreenThread extends Thread {
		
		PixelController.Screen screen;
		
		/**
		 * Constructor.
		 * @param activeScreen Screen to connect to and update.
		 */
		ScreenThread(Screen activeScreen) {
			this.screen = activeScreen;
		}
		
		/**
		 * Main loop for the screen.
		 */
		@Override
		public void run() {
			if(!isTesting) {
				// Connect to selected screen.
				pixelController = PixelController.getInstance(screen);
	
				// Wait for connection.
				while(!pixelController.isConnected()) {
					lblStatus.setText("Status: connecting...");
				}
			}
			lblStatus.setText("Status: Connected");
			
			// Get width and height of screen.
			if(!isTesting) {
				width = pixelController.getNumberPixelsWidestSide();
				height = pixelController.getNumberPixelsShortestSide();
			} else {
				width = 256;
				height = 256;
			}
			
			// Resize debug view.
			pnlDebugView.setSize(width, height);

			int ss = 0;
			while(true) {
				// Test draw.
				for(int y = 0; y < height; y++) {
					for(int x = 0; x < width; x++) {
						int r = x % 255;
						int b = y % 255;
						int g = (x ^ y) ^ ss;
						setPixel(x, y, new Color(r, g, b));
					}
				}
				
				ss++;
				if(ss > 255) {
					ss = 0;
				}

				// Redraw debug view.
				pnlDebugView.repaint();

				// Sleep for 1000 / 60 ms.
				try {
					Thread.sleep(1000 / 60);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}
		
		/**
		 * Sets a pixel on the screen.
		 * @param x X position.
		 * @param y Y position.
		 * @param color Color.
		 */
		void setPixel(int x, int y, Color color) {
			if(!isTesting) {
				pixelController.setPixel(x, y, color);
			}
			pnlDebugView.setPixel(x, y, color);
		}
	} 

	
	/**
	 * A panel for painting a debug view for internal testing of screen functions.
	 */
	private class PaintPanel extends JPanel {
		
		BufferedImage image = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
		
		/**
		 * Updates the size of the debug view.
		 */
		@Override
		public void setSize(int width, int height) {
			super.setSize(width, height);
			image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		}

		/**
		 * Draws a pixel on the debug view.
		 * @param x X position.
		 * @param y Y position.
		 * @param color Color.
		 */
		public void setPixel(int x, int y, Color color) {
			Graphics2D gfx2d = (Graphics2D)image.getGraphics();
			gfx2d.setColor(color);
			gfx2d.drawLine(x, y, x, y);
		}
		
		/**
		 * Paint function.
		 * Draws the simulated screen.
		 */
		@Override
		public void paint( Graphics gfx ) {
			super.paint(gfx);

			// Test draw.
			Graphics2D gfx2d = (Graphics2D)gfx;
			gfx2d.drawImage(image, 0, 0, this);
			/*width = getWidth();
			height = getHeight();
			for(int y = 0; y < height; y++) {
				for(int x = 0; x < width; x++) {
					int r = x % 255;
					int b = y % 255;
					int g = r ^ b;
					gfx2d.setColor(new Color(r, g, b));
					gfx2d.drawLine(x, y, x, y);
				}
			}*/
		}
	} 
}
