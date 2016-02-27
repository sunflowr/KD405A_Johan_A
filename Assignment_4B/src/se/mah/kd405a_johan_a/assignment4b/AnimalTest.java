package se.mah.kd405a_johan_a.assignment4b;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;

public class AnimalTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalTest frame = new AnimalTest();
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
	public AnimalTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 696, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new TitledBorder(null, "Animallist", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		JTextArea txtAnimalList = new JTextArea();
		txtAnimalList.setBackground(UIManager.getColor("Button.background"));
		txtAnimalList.setEditable(false);
		scrollPane.setViewportView(txtAnimalList);
		
		// Add a few animals to a list.
		ArrayList<Animal> animals = new ArrayList<Animal>();
		animals.add(new Dog("Canis latrans", 3, true));
		animals.add(new Dog("Canis latrans", 3, true, "Karo"));
		Cat c = new Cat("Lynx Lynx", 5, 4);
		c.setFriendlyName("Missen");
		animals.add(c);
		animals.add(new Cat("Lynx Lynx", 5, 4));
		animals.add(new Snake("Python regius", true));
		animals.add(new Dog("Canis aureus", 4, false));
		animals.add(new Cat("Lynx pardinus", 5, 9));
		animals.add(new Snake("Leiopython fredparken", false));
		
		// Output the info of the animals to the GUI.
		txtAnimalList.setText("");
		for(Animal animal : animals){
			txtAnimalList.append(animal.getInfo() + "\n");
		}
	}

}
