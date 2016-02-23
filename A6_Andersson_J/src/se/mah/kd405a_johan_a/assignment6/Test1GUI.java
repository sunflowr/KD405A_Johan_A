package se.mah.kd405a_johan_a.assignment6;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTabbedPane;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import net.miginfocom.swing.MigLayout;

public class Test1GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextArea txtrResult;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JTabbedPane tabbedPane;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblNewLabel_1;
	private JTextField txtJourneyFrom;
	private JLabel lblNewLabel_2;
	private JTextField txtJourneyTo;
	private JButton btnJourneySearch;
	private JScrollPane scrollPane_1;
	private JLabel lblResultat;
	private JTextArea txtJourneyResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1GUI frame = new Test1GUI();
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
	public Test1GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Sök Hållplats", null, panel_1, null);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtSearch = new JTextField();
		txtSearch.setText("Söksträng");
		panel.add(txtSearch, BorderLayout.CENTER);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Sök");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear result.
				txtrResult.setText("");
				
			   	// Create a list for holding Stations. 
				ArrayList<Station> searchStations = new ArrayList<Station>(); 

				// Search for all stations that contains the value of txtSearch and add the to the list searchStations.
				searchStations.addAll(Parser.getStationsFromURL(txtSearch.getText().trim()));
				for (Station s: searchStations){
					txtrResult.append(s.getStationName() +" number:" + s.getStationNbr() + 
						" longitude: " + s.getLongitude() + " latitude: " + s.getLatitude() + "\n");
				}
			}
		});
		panel.add(btnSearch, BorderLayout.EAST);
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		txtrResult = new JTextArea();
		scrollPane.setViewportView(txtrResult);
		txtrResult.setText("");
		
		lblNewLabel = new JLabel("Resultat");
		scrollPane.setColumnHeaderView(lblNewLabel);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Sök Resa", null, panel_2, null);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new MigLayout("", "[fill][130px,grow]", "[][][]"));
		
		lblNewLabel_1 = new JLabel("Från");
		panel_3.add(lblNewLabel_1, "cell 0 0,grow");
		
		txtJourneyFrom = new JTextField();
		panel_3.add(txtJourneyFrom, "cell 1 0,grow");
		txtJourneyFrom.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Till");
		panel_3.add(lblNewLabel_2, "cell 0 1,grow");
		
		txtJourneyTo = new JTextField();
		panel_3.add(txtJourneyTo, "cell 1 1,grow");
		txtJourneyTo.setColumns(10);
		
		btnJourneySearch = new JButton("Sök");
		btnJourneySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clear result.
				txtJourneyResult.setText("");
				
				// Create a list for holding Stations. 
				ArrayList<Station> searchStations = new ArrayList<Station>();

				// Find station numbers.
				String fromNbr = "80000";
				String toNbr = "81216";

				// Search for all stations that contains the value of txtSearch and add the to the list searchStations.
				searchStations.addAll(Parser.getStationsFromURL(txtJourneyFrom.getText().trim()));
				for (Station s: searchStations){
					// Find station number.
				}

				// Construct the query URL for searching.
				String searchURL = Constants.getURL(fromNbr, toNbr, 1);

				// Call the Skanetrafiken API with the constructed query URL to retrieve a list of available journeys.
				Journeys journeys = Parser.getJourneys(searchURL);
				ArrayList<Journey> journeyList = journeys.getJourneys();
				if(!journeyList.isEmpty()) {
					// Get fist journey and print out info about it.
					Journey journey = journeyList.get(0);
					txtJourneyResult.append("Resa:\n");
					txtJourneyResult.append("------------------\n");
					txtJourneyResult.append("Avgår kl. " + journey.getDepDateTime());
					if(!journey.getArrTimeDeviation().isEmpty()) {
						// If there's a deviation, display it too.
						txtJourneyResult.append("(ny tid: " + journey.getDepTimeDeviation() + ")");
					}
					txtJourneyResult.append(" från " + journey.getStartStation() +  "\n");
					txtJourneyResult.append("Ankommer kl. " + journey.getArrDateTime());
					if(!journey.getArrTimeDeviation().isEmpty()) {
						// If there's a deviation, display it too.
						txtJourneyResult.append("(ny tid: " + journey.getArrTimeDeviation() + ")");
					}
					txtJourneyResult.append(" till " + journey.getEndStation() +  "\n");
					txtJourneyResult.append("Restid: " + journey.getTravelMinutes() + "\n");
					txtJourneyResult.append("Avgår om : " + journey.getTimeToDeparture() + " minuter(?)\n");
					txtJourneyResult.append("Antal byten: " + journey.getNoOfChanges() + "\n");
					txtJourneyResult.append("Antal byten: " + journey.getNoOfChanges() + "\n");
					txtJourneyResult.append("Antal zoner: " + journey.getNoOfZones() +  "\n");
				} else {
					txtJourneyResult.append("Ingen resa funnen.\n");
				}
				for (Journey journey : journeys.getJourneys()) {
					txtJourneyResult.append(journey.getStartStation().toString() + " - ");
					txtJourneyResult.append(journey.getEndStation().toString());
					String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY) + ":" + journey.getDepDateTime().get(Calendar.MINUTE);
					txtJourneyResult.append(" Departs " + time + " that is in " + journey.getTimeToDeparture() + " minutes. And it is " + journey.getDepTimeDeviation() + " min late\n");
				} 
			}
		});
		panel_3.add(btnJourneySearch, "cell 1 2,grow");
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_2.add(scrollPane_1, BorderLayout.CENTER);
		
		lblResultat = new JLabel("Resultat");
		scrollPane_1.setColumnHeaderView(lblResultat);
		
		txtJourneyResult = new JTextArea();
		scrollPane_1.setViewportView(txtJourneyResult);
	}

}
