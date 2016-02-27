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
import javax.swing.border.EtchedBorder;
import javax.swing.JTabbedPane;
import net.miginfocom.swing.MigLayout;

public class SearchGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextArea txtResult;
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
	private JLabel lblNamn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchGUI frame = new SearchGUI();
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
	public SearchGUI() {
		setTitle("Skanetrafiken SearchApp");
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
		txtSearch.setText("Malmö");
		panel.add(txtSearch, BorderLayout.CENTER);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Sök");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Notify the user that we're searching.
				txtResult.setText("Söker...");
				
				// Start search query thread.
				new GetStationsThread().start();; 
			}
		});
		panel.add(btnSearch, BorderLayout.EAST);
		
		lblNamn = new JLabel("Namn");
		panel.add(lblNamn, BorderLayout.WEST);
		
		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		txtResult = new JTextArea();
		scrollPane.setViewportView(txtResult);
		txtResult.setText("");
		
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
		txtJourneyFrom.setText("80000");
		panel_3.add(txtJourneyFrom, "cell 1 0,grow");
		txtJourneyFrom.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Till");
		panel_3.add(lblNewLabel_2, "cell 0 1,grow");
		
		txtJourneyTo = new JTextField();
		txtJourneyTo.setText("81216");
		panel_3.add(txtJourneyTo, "cell 1 1,grow");
		txtJourneyTo.setColumns(10);
		
		btnJourneySearch = new JButton("Sök");
		btnJourneySearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Notify the user that we're searching.
				txtJourneyResult.setText("Söker...");
				
				// Start search query thread.
				new GetJourneysThread().start();; 
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

	/**
	 * Returns the HOUR and MINUTE part of the calendar argument as a string: "HH::mm"
	 * @param time Calendar time to format.
	 * @return Calendar formated as "HH:mm"
	 */
	String getCalenderAsHHmm(Calendar time) {
		return time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE);
	}
	
	/**
	 * Handles the search query for journeys. 
	 */
	private class GetJourneysThread extends Thread {
		
		/**
		 * Do a search query for journeys.
		 */
		@Override
		public void run() {
			// Find station numbers.
			String fromNbr = txtJourneyFrom.getText().trim();	// 80000 (Malmö C)
			String toNbr = txtJourneyTo.getText().trim();		// 81216 (Lund C)

			// Construct the query URL for searching.
			String searchURL = Constants.getURL(fromNbr, toNbr, 1);

			// Call the Skanetrafiken API with the constructed query URL to retrieve a list of available journeys.
			Journeys journeys = Parser.getJourneys(searchURL);
			ArrayList<Journey> journeyList = journeys.getJourneys();

			// Clear result textarea.
			txtJourneyResult.setText("");

			// Display search result.
			if(!journeyList.isEmpty()) {
				// Get fist journey and print out info about it.
				Journey journey = journeyList.get(0);
				txtJourneyResult.append("Resa:\n");
				txtJourneyResult.append("------------------\n");
				txtJourneyResult.append("Avgår kl. " + getCalenderAsHHmm(journey.getDepDateTime()));
				// If there's a deviation, display it too.
				try {
					int depTimeDeviation = Integer.parseInt(journey.getDepTimeDeviation());
					if(depTimeDeviation != 0) {
						txtJourneyResult.append(" (avvikelse med " + Integer.toString(depTimeDeviation) + " minuter från ordinarie tid)");
					}
				} catch(Exception ex) {
					// Do nothing on error.
				}
				txtJourneyResult.append(" från " + journey.getStartStation().getStationName() +  "\n");
				txtJourneyResult.append("Ankommer kl. " + getCalenderAsHHmm(journey.getArrDateTime()));
				// If there's a deviation, display it too.
				try {
					int arrTimeDeviation = Integer.parseInt(journey.getArrTimeDeviation());
					if(arrTimeDeviation != 0) {
						txtJourneyResult.append(" (avvikelse med " + Integer.toString(arrTimeDeviation) + " minuter från ordinarie tid)");
					}
				} catch(Exception ex) {
					// Do nothing on error.
				}
				txtJourneyResult.append(" till " + journey.getEndStation().getStationName() +  "\n");
				txtJourneyResult.append("Restid: " + journey.getTravelMinutes() + " minuter\n");
				txtJourneyResult.append("Avgår om : " + journey.getTimeToDeparture() + " minuter\n");
				txtJourneyResult.append("Antal byten: " + journey.getNoOfChanges() + "\n");
				txtJourneyResult.append("Antal byten: " + journey.getNoOfChanges() + "\n");
				txtJourneyResult.append("Antal zoner: " + journey.getNoOfZones() +  "\n");
			} else {
				txtJourneyResult.append("Ingen resa funnen.\n");
			}
		}
	} 

	/**
	 * Handles the search query for stations. 
	 */
	private class GetStationsThread extends Thread {
		
		/**
		 * Do a search query for stations.
		 */
		@Override
		public void run() {
		   	// Create a list for holding Stations. 
			ArrayList<Station> searchStations = new ArrayList<Station>();
			
			// Search for all stations that contains the value of txtSearch and add the to the list searchStations.
			searchStations.addAll(Parser.getStationsFromURL(txtSearch.getText().trim()));

			// Clear result textarea.
			txtResult.setText("");

			// Display search result.
			for (Station s: searchStations){
				txtResult.append(s.getStationName() +" number:" + s.getStationNbr() + 
					" longitude: " + s.getLongitude() + " latitude: " + s.getLatitude() + "\n");
			}
		}
	} 
}
