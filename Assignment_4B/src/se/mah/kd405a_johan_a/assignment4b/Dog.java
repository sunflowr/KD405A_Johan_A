package se.mah.kd405a_johan_a.assignment4b;

public class Dog extends Mammal {
	private boolean stupid;
	
	/**
	 * Constructor for Dog.
	 * @param latinName Name in latin.
	 * @param gestationTime Time of gestation in months.
	 * @param stupid If the dog is stupid or not.
	 */
	public Dog(String latinName, int gestationTime, boolean stupid){
		super(latinName, gestationTime);
		this.stupid = stupid;		
	}

	/**
	 * Constructor for Dog with friendly name.
	 * @param latinName Name in latin.
	 * @param gestationTime Time of gestation in months.
	 * @param stupid If the dog is stupid or not.
	 * @param friendlyName Friendly name of the dog.
	 */
	public Dog(String latinName, int gestationTime, boolean stupid, String friendlyName){
		super(latinName, gestationTime);
		this.stupid = stupid;
		this.setFriendlyName(friendlyName);
	}

	/**
	 * Tells if the dog is stupid or not.
	 * @return Tells if the dog is stupid or not.
	 */
	public boolean isStupid(){
		return stupid;
	}

	/**
	 * Returns a string with info about the dog.
	 * @return Info about the dog.
	 */
	@Override
	public String getInfo() {
		return "The dog named " + getFriendlyName() + " nurses for " + getGestationtime() + " months and " + (stupid ? "is" : "is not") + " stupid";  
	}

}
