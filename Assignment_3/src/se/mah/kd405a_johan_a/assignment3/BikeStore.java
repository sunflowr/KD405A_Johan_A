package se.mah.kd405a_johan_a.assignment3;

import java.util.ArrayList;

public class BikeStore {
	private ArrayList<Bike> bikes = new ArrayList<Bike>();
	
	/**
	 * Returns a string of all the bikes in the store with a newline between each bike.
	 * @return All the bikes in the store.
	 */
	public String getAllBikes(){
		String allBikes = "";
		for(int i = 0; i < bikes.size(); i++){
			Bike bike = bikes.get(i);
			allBikes += "id:" + i + ", price: " + bike.getPrice() + ", color: " + bike.getColor() + ", size: " + bike.getSize() + "\n";
		}
		
		return allBikes;
	}

	/** Not specified what this function should do in UML...
	 * currently converts size and price to integers and add bike to store.
	 * @param color Color of the bike - only the colors specified in Constants.COLORS are allowed - otherwise black is used. 
	 * @param size Size of the bike in inches - should be between Constants.MIN_SIZE and Constants.MAX_SIZE. If the value is invalid, Constants.MIN_SIZE is used instead.
	 * @param price Price of the bike in kr (SEK) - should be between Constants.MIN_PRICE and Constants.MAX_PRICE. If the value is invalid, Constants.MIN_PRICE is used instead.
	 * @return No specifications on what should be returned in UML.
	 */
	public String addBike(String color, String size, String price){
		// Convert size string to integer.
		int iSize = 0;
		try{
			iSize = Integer.valueOf(size);
		} catch(Exception ex){
			// Size wasn't correctly formated as a number - use Constants.MIN_SIZE instead.
			iSize = Constants.MIN_SIZE;
		}

		// Convert price string to integer.
		int iPrice = 0;
		try{
			iPrice = Integer.valueOf(price);
		} catch(Exception ex){
			// Price wasn't correctly formated as a number - use Constants.MIN_PRICE instead.
			iPrice = Constants.MIN_PRICE;
		}
		
		// Add bike to store.
		bikes.add(new Bike(color, iSize, iPrice));

		// No specifications on what should be returned.
		return "";
	}
}
