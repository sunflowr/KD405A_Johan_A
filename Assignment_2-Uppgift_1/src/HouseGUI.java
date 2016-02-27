import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;

public class HouseGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseGUI frame = new HouseGUI();
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
	public HouseGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		// Create a random generator.
		Random random = new Random();
		
		// --------------------------------------------------------------------
		// Uppgift 1.2
		// --------------------------------------------------------------------
		// Create three houses with randomly picked values.
		House[] threeHouses = new House[3];
		threeHouses[0] = new House(1879, 300);
		threeHouses[1] = new House(1979, 100);
		threeHouses[2] = new House(2009, 800);

		// Print out the size and build year of the houses
		// in the console and in the text area on the GUI.
		System.out.print("Uppgift 1.2\n");
		textArea.append("Uppgift 1.2\n");
		for(int i = 0; i < threeHouses.length; i++) {
			String houseDesc;
			houseDesc = "House " + i + " - size: " + threeHouses[i].getSize() + " kvm, build year: " + threeHouses[i].getYearBuilt() + "\n";
			System.out.print(houseDesc);
			textArea.append(houseDesc);
		}

		// --------------------------------------------------------------------
		// Uppgift 1.3
		// --------------------------------------------------------------------
		// Create ten houses with random values.
		House[] tenHouses = new House[10];
		for(int i = 0; i < tenHouses.length; i++) {
			// Clamp the year built between 1800 and 2015.
			// Clamp the size between 0 and 1000 kvm.
			tenHouses[i] = new House(random.nextInt(215) + 1800, random.nextInt(1000));
		}

		// Print out the size and build year of the houses
		// in the console and in the text area on the GUI.
		System.out.print("\nUppgift 1.3\n");
		textArea.append("\nUppgift 1.3\n");
		for(int i = 0; i < tenHouses.length; i++) {
			String houseDesc;
			houseDesc = "House " + i + " - size: " + tenHouses[i].getSize() + " kvm, build year: " + tenHouses[i].getYearBuilt() + "\n";
			System.out.print(houseDesc);
			textArea.append(houseDesc);
		}

		// --------------------------------------------------------------------
		// Uppgift 1.4
		// --------------------------------------------------------------------
		// Create hundred houses with random values.
		ArrayList<House> hundredHouses = new ArrayList<House>();
		for(int i = 0; i < 100; i++) {
			// Clamp the year built between 1800 and 2015.
			// Clamp the size between 0 and 1000 kvm.
			hundredHouses.add(new House(random.nextInt(215) + 1800, random.nextInt(1000)));
		}

		// Print out the size and build year of the houses
		// in the console and in the text area on the GUI.
		System.out.print("\nUppgift 1.4\n");
		textArea.append("\nUppgift 1.4\n");
		for(int i = 0; i < hundredHouses.size(); i++) {
			String houseDesc;
			houseDesc = "House " + i + " - size: " + hundredHouses.get(i).getSize() + ", build year: " + hundredHouses.get(i).getYearBuilt() + "\n";
			System.out.print(houseDesc);
			textArea.append(houseDesc);
		}
	}
}
