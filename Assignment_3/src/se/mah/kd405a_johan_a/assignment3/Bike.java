package se.mah.kd405a_johan_a.assignment3;

public class Bike {
	private String color = "black";
	private int price = 0;
	private int size = 0;
	
	/**
	 * Creates a bike.
	 * @param color Color of the bike - only the colors specified in Constants.COLORS are allowed - otherwise black is used. 
	 * @param size Size of the bike in inches - should be between Constants.MIN_SIZE and Constants.MAX_SIZE.
	 */
	public Bike(String color, int size){
		// Validate the color, if not valid use black.
		color = color.trim().toLowerCase();
		for(String c : Constants.COLORS){
			if(color.compareToIgnoreCase(c) == 0){
				this.color = c;
				break;
			}
		}

		// Clamp the size between Constants.MIN_SIZE and Constants.MAX_SIZE
		if(size < Constants.MIN_SIZE){
			this.size = Constants.MIN_SIZE;
		}
		else if(size > Constants.MAX_SIZE){
			this.size = Constants.MAX_SIZE;
		}
		else {
			this.size = size;
		}
	}
	
	/**
	 * Creates a bike.
	 * @param color Color of the bike - only the colors specified in Constants.COLORS are allowed - otherwise black is used. 
	 * @param size Size of the bike in inches - should be between Constants.MIN_SIZE and Constants.MAX_SIZE.
	 * @param price Price of the bike in kr (SEK) - should be between Constants.MIN_PRICE and Constants.MAX_PRICE.
	 */
	public Bike(String color, int size, int price){
		// Validate the color, if not valid use black.
		color = color.trim().toLowerCase();
		for(String c : Constants.COLORS){
			if(color.compareToIgnoreCase(c) == 0){
				this.color = c;
				break;
			}
		}

		// Clamp the price between Constants.MIN_PRICE and Constants.MAX_PRICE
		if(price < Constants.MIN_PRICE){
			this.price = Constants.MIN_PRICE;
		}
		else if(price > Constants.MAX_PRICE){
			this.price = Constants.MAX_PRICE;
		}
		else {
			this.price = price;
		}

		// Clamp the size between Constants.MIN_SIZE and Constants.MAX_SIZE
		if(size < Constants.MIN_SIZE){
			this.size = Constants.MIN_SIZE;
		}
		else if(size > Constants.MAX_SIZE){
			this.size = Constants.MAX_SIZE;
		}
		else {
			this.size = size;
		}
	}
	
	/** Returns the color of the bike.
	 * @return The color of the bike.
	 * */
	public String getColor(){
		return color;
	}
	
	/** Returns the size of the bike.
	 * @return The size of the bike.
	 * */
	public int getSize(){
		return size;
	}
	
	/** Returns the price of the bike.
	 * @return Price of the bike.
	 * */
	public int getPrice(){
		return price;
	}
	
	/**
	 * Sets the price of the bike.
	 * @param price Price of the bike in kr (SEK) - should be between Constants.MIN_PRICE and Constants.MAX_PRICE.
	 */
	public void setPrice(int price){
		// Clamp the price between Constants.MIN_PRICE and Constants.MAX_PRICE
		if(price < Constants.MIN_PRICE){
			this.price = Constants.MIN_PRICE;
		}
		else if(price > Constants.MAX_PRICE){
			this.price = Constants.MAX_PRICE;
		}
		else {
			this.price = price;
		}
	}
}
