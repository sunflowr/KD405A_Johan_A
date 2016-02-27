package se.mah.kd405a_johan_a.assignment3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BikeStoreGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtPrice;
	private JTextField txtColor;
	private JTextField txtSize;
	JTextArea txtBikeStoreList;
	
	BikeStore bikeStore = new BikeStore();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BikeStoreGUI frame = new BikeStoreGUI();
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
	public BikeStoreGUI() {
		setTitle("Ultimate Bike Store 3.0");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[grow,fill][grow,fill][grow,fill][75px]", "[grow,fill][][grow,fill]"));
		
		JLabel lblColor = new JLabel("Color");
		panel.add(lblColor, "cell 0 1");
		
		JLabel lblSize = new JLabel("Size");
		panel.add(lblSize, "cell 1 1");
		
		JLabel lblPrice = new JLabel("Price");
		panel.add(lblPrice, "cell 2 1");
		
		txtColor = new JTextField();
		panel.add(txtColor, "cell 0 2,growx");
		txtColor.setColumns(10);
		
		txtSize = new JTextField();
		panel.add(txtSize, "cell 1 2,growx");
		txtSize.setColumns(10);
		
		txtPrice = new JTextField();
		panel.add(txtPrice, "cell 2 2,grow");
		txtPrice.setColumns(10);
		
		JButton btnAdd = new JButton("Add Bike");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Add bike to store.
				bikeStore.addBike(txtColor.getText(), txtSize.getText(), txtPrice.getText());
				
				// Update store list.
				txtBikeStoreList.setText(bikeStore.getAllBikes());
			}
		});
		panel.add(btnAdd, "cell 3 2,grow");
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		txtBikeStoreList = new JTextArea();
		scrollPane.setViewportView(txtBikeStoreList);
	}

}
