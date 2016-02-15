package se.mah.kd405a_johan_a.assignment5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DigitalClockGUI extends JFrame {

	private JPanel contentPane;
	
	private ClockLogic clockLogic;
	private JTextField txtHours;
	private JTextField txtMinutes;
	private JLabel lblCurrentTime;
	private JLabel lblCurrentAlarmTime;
	private JLabel lblAlarmStatus;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DigitalClockGUI.class.getResource("/se/mah/kd405a_johan_a/assignment5/icon.png")));
		setTitle("The Alarm Clock of Destiny");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(10, 0));
		
		JLabel label1 = new JLabel("Current Time:");
		panel.add(label1, BorderLayout.WEST);
		
		lblCurrentTime = new JLabel("00:00:00");
		panel.add(lblCurrentTime, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 6, 10, 0));
		
		JLabel lblHours = new JLabel("Hours:");
		lblHours.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblHours);
		
		txtHours = new JTextField();
		panel_1.add(txtHours);
		txtHours.setColumns(10);
		
		JLabel lblMinutes = new JLabel("Minutes:");
		lblMinutes.setHorizontalAlignment(SwingConstants.TRAILING);
		panel_1.add(lblMinutes);
		
		txtMinutes = new JTextField();
		panel_1.add(txtMinutes);
		txtMinutes.setColumns(10);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Set new alarm time. 
				int hours;
				int minute;
				try {
					hours = Integer.parseInt(txtHours.getText());
					minute = Integer.parseInt(txtMinutes.getText());
					clockLogic.setAlarm(hours, minute);
				} catch(NumberFormatException ex) {
					System.out.println("Error: number format is wrong!");
				}
			}
		});
		panel_1.add(btnSetAlarm);
		
		JButton btnClearalarm = new JButton("Clear Alarm");
		btnClearalarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clockLogic.clearAlarm();
			}
		});
		panel_1.add(btnClearalarm);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new BorderLayout(10, 0));
		
		JLabel lblNewLabel = new JLabel("Alarm at:");
		panel_3.add(lblNewLabel, BorderLayout.WEST);
		
		lblCurrentAlarmTime = new JLabel("disabled");
		panel_3.add(lblCurrentAlarmTime, BorderLayout.CENTER);
		
		lblAlarmStatus = new JLabel("Waiting for next destiny...");
		lblAlarmStatus.setBackground(new Color(255, 0, 0));
		lblAlarmStatus.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblAlarmStatus.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblAlarmStatus, BorderLayout.CENTER);
		
		// Create a new clock logic instance.
		clockLogic = new ClockLogic(this);
	}
	
	/**
	 * Updates the current time label.
	 * @param time New value.
	 */
	public void setTimeOnLabel(String time) {
		lblCurrentTime.setText(time);
	}
	
	/**
	 * Updates the alarm time label.
	 * @param alarmTime New value.
	 */
	public void setAlarmTimeOnLabel(String alarmTime) {
		lblCurrentAlarmTime.setText(alarmTime);
	}
	
	/**
	 * Called when the alarm is activated/deactivated.
	 * @param activate Whether to activate the alarm or disable it.
	 */
	public void activateAlarm(boolean activate) {
		if(activate)
		{
			// Make a beep sound.
			Toolkit.getDefaultToolkit().beep();
			
			// Set text color of notification to random color.
			Random random = new Random();
			lblAlarmStatus.setForeground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));

			// set notification background color to random.
			lblAlarmStatus.setOpaque(true);
			lblAlarmStatus.setBackground(new Color(random.nextFloat(), random.nextFloat(), random.nextFloat()));
			
			// Set notification message.
			lblAlarmStatus.setText("IT'S TIME!!!");
		} else {
			// Make notification background color transparent.
			lblAlarmStatus.setOpaque(false);
			
			// Set text color of notification to black again.
			lblAlarmStatus.setForeground(Color.black);

			// Set notification message.
			lblAlarmStatus.setText("Waiting for next destiny...");
		} 
	}

}
