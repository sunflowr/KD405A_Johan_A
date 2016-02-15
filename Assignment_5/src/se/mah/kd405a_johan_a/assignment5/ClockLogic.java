package se.mah.kd405a_johan_a.assignment5;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

public class ClockLogic {
	
	/**
	 * Handel the real-time updating of the clock logic. 
	 */
	private class ClockLogicThread extends Thread {
		
		/**
		 * Updates the GUI.
		 */
		@Override
		public void run() {
			// Create a decimal format object for formatting the time string.
			DecimalFormat decimalFormat = new DecimalFormat("00");

			while(true) {
				// Get current time.
				Calendar calendar = Calendar.getInstance();
				int hour = calendar.get(Calendar.HOUR_OF_DAY);
				int minute = calendar.get(Calendar.MINUTE);
				int second = calendar.get(Calendar.SECOND);
				
				// Update time in GUI.
				clockGUI.setTimeOnLabel(decimalFormat.format(hour) + ":" + decimalFormat.format(minute) + ":" + decimalFormat.format(second));
				
				if((hour == alarmHour) && (minute == alarmMinute)) {
					clockGUI.activateAlarm(true);
				}
				
				// Sleep for 900ms.
				try {
					Thread.sleep(900);
				} catch (InterruptedException e) {
					e.printStackTrace();
					return;
				}
			}
		}
	} 
	
	private DigitalClockGUI clockGUI;
	private int alarmHour;
	private int alarmMinute;
	private ClockLogicThread clockThread;
	
	/**
	 * Clock logic constructor.
	 * @param digitalClockGUI GUI object connected to the logic.
	 */
	public ClockLogic(DigitalClockGUI digitalClockGUI) {
		this.clockGUI = digitalClockGUI;
		
		// Disable alarm as default.
		this.alarmHour = -1;
		this.alarmMinute = -1;
		
		// Start clock logic thread.
		new ClockLogicThread().start();; 
	}
	
	/**
	 * Updates the alarm time. Invalid value disables the alarm.
	 * @param hours New hour value for the alarm (range: 0-23).
	 * @param minute New minute value for the alarm (range: 0-59).
	 */
	void setAlarm(int hours, int minute) {
		// Make sure the hour value is within range, otherwise set it to -1 to disable alarm.
		if((hours >= 0) && (hours < 24) ){
			alarmHour = hours;
		} else {
			alarmHour = -1;
		}

		// Make sure the minute value is within range, otherwise set it to -1 to disable alarm.
		if((minute >= 0) && (minute < 60) ){
			alarmMinute = minute;
		} else {
			alarmMinute = -1;
		}
		
		// Update GUI.
		// Update the alarm label with new value, or set to "disabled" if invalid value(s) was used.
		if((alarmHour >= 0) && (alarmMinute >= 0))
		{
			// Create a decimal format object for formatting the time string.
			DecimalFormat decimalFormat = new DecimalFormat("00");

			clockGUI.setAlarmTimeOnLabel(decimalFormat.format(hours) + ":" + decimalFormat.format(minute));
		}
		else
		{
			clockGUI.setAlarmTimeOnLabel("disabled");
		}
	}
	
	/**
	 * Clear/disable the alarm
	 */
	void clearAlarm() {
		// Set alarm to -1 to disable alarm.
		setAlarm(-1, -1);
		
		// Notify GUI.
		clockGUI.activateAlarm(false);
	}

}
