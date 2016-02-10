package se.mah.kd405a_johan_a.assignment4b;

public abstract class Animal {
	private String latinName;
	private String friendlyName;
	
	/**
	 * Constructor for Animal.
	 * @param latinName Name in latin.
	 */
	public Animal(String latinName){
		this.latinName = latinName;
		this.friendlyName = "noname"; // No friendly name yet.
	}
	
	/**
	 * Returns a string with info about the animal.
	 * @return Info about the animal.
	 */
	public abstract String getInfo();
	
	/**
	 * Sets the friendly name of the animal.
	 * @param name New name of the animal.
	 */
	public void setFriendlyName(String name){
		friendlyName = name;
	}
	
	/**
	 * Returns the friendly name of the animal together with the latin name.
	 * @return The friendly name of the animal together with the latin name.
	 */
	public String getFriendlyName(){
		return "\""+ friendlyName + "\" lat: \"" + latinName + "\"";
	}

}
