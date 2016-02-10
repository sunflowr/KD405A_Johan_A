package se.mah.kd405a_johan_a.assignment4a;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HumanDogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtHumanName;
	private JTextField txtDogName;
	private JTextArea txtErrorMessage;
	private JTextArea txtInfo;
	
	private Human human;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanDogGUI frame = new HumanDogGUI();
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
	public HumanDogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblHumansAndDogs = new JLabel("Humans and Dogs");
		lblHumansAndDogs.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblHumansAndDogs.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblHumansAndDogs, BorderLayout.NORTH);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.NORTH);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{220, 220, 0};
		gbl_panel_3.rowHeights = new int[]{29, 29, 29, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		txtHumanName = new JTextField();
		GridBagConstraints gbc_txtHumanName = new GridBagConstraints();
		gbc_txtHumanName.fill = GridBagConstraints.BOTH;
		gbc_txtHumanName.insets = new Insets(0, 0, 5, 5);
		gbc_txtHumanName.gridx = 0;
		gbc_txtHumanName.gridy = 0;
		panel_3.add(txtHumanName, gbc_txtHumanName);
		txtHumanName.setColumns(10);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create a new human if the name is at least three characters long.
				if(txtHumanName.getText().length() >= 3){
					human = new Human(txtHumanName.getText());
				} else {
					txtErrorMessage.setText("Human name must be at least three characters long.");
				}
			}
		});
		GridBagConstraints gbc_btnNewHuman = new GridBagConstraints();
		gbc_btnNewHuman.fill = GridBagConstraints.BOTH;
		gbc_btnNewHuman.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewHuman.gridx = 1;
		gbc_btnNewHuman.gridy = 0;
		panel_3.add(btnNewHuman, gbc_btnNewHuman);
		
		txtDogName = new JTextField();
		GridBagConstraints gbc_txtDogName = new GridBagConstraints();
		gbc_txtDogName.fill = GridBagConstraints.BOTH;
		gbc_txtDogName.insets = new Insets(0, 0, 5, 5);
		gbc_txtDogName.gridx = 0;
		gbc_txtDogName.gridy = 1;
		panel_3.add(txtDogName, gbc_txtDogName);
		txtDogName.setColumns(10);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Create a new dog and assign it to a human.
				if(human != null) {
					if(txtDogName.getText().length() >= 3){
						human.buyDog(new Dog(txtDogName.getText()));
					} else {
						txtErrorMessage.setText("Dog name must be at least three characters long.");
					}
				} else {
					txtErrorMessage.setText("Dog need a human in order to be bought. Please make a new human first.");
				}
			}
		});
		GridBagConstraints gbc_btnBuyDog = new GridBagConstraints();
		gbc_btnBuyDog.fill = GridBagConstraints.BOTH;
		gbc_btnBuyDog.insets = new Insets(0, 0, 5, 0);
		gbc_btnBuyDog.gridx = 1;
		gbc_btnBuyDog.gridy = 1;
		panel_3.add(btnBuyDog, gbc_btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Outputs info about a human.
				if(human != null) {
					txtInfo.setText(human.getInfo());
				} else {
					txtErrorMessage.setText("No human available. Please make a new human before printing it's info.");
				}
			}
		});
		GridBagConstraints gbc_btnPrintInfo = new GridBagConstraints();
		gbc_btnPrintInfo.fill = GridBagConstraints.BOTH;
		gbc_btnPrintInfo.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrintInfo.gridx = 1;
		gbc_btnPrintInfo.gridy = 2;
		panel_3.add(btnPrintInfo, gbc_btnPrintInfo);
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.Y_AXIS));
		
		JPanel panel_1 = new JPanel();
		panel_4.add(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Info", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		txtInfo = new JTextArea();
		txtInfo.setBackground(UIManager.getColor("Button.background"));
		txtInfo.setEditable(false);
		panel_1.add(txtInfo, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_4.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "ErrorMessage", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(new BorderLayout(0, 0));
		
		txtErrorMessage = new JTextArea();
		txtErrorMessage.setBackground(UIManager.getColor("Button.background"));
		txtErrorMessage.setEditable(false);
		panel_2.add(txtErrorMessage, BorderLayout.NORTH);
	}

}
