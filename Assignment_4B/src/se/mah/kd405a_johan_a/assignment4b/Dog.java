package se.mah.kd405a_johan_a.assignment4b;

public class Dog extends Mammal {
	private boolean stupid;
	
	public Dog(String latinName, int gestationTime, boolean stupid){
		super(latinName, gestationTime);
		this.stupid = stupid;		
	}

	public Dog(String latinName, int gestationTime, boolean stupid, String friendlyName){
		super(latinName, gestationTime);
		this.stupid = stupid;
		this.setFriendlyName(friendlyName);
	}

	public boolean isStupid(){
		return stupid;
	}

	@Override
	public String getInfo() {
		return "The dog named " + getFriendlyName() + " nurses for " + getGestationtime() + " months and " + (stupid ? "is" : "is not") + " stupid";  
	}

}
