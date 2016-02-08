package se.mah.kd405a_johan_a.assignment4b;

public abstract class Animal {
	private String latinName;
	private String friendlyName;
	
	public Animal(String latinName){
		this.latinName = latinName;
		this.friendlyName = "noname"; // No friendly name yet.
	}
	
	public abstract String getInfo();
	
	public void setFriendlyName(String name){
		friendlyName = name;
	}
	
	public String getFriendlyName(){
		return "\""+ friendlyName + "\" lat: \"" + latinName + "\"";
	}

}
