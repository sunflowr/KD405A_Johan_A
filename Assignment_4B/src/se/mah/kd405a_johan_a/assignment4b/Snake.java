package se.mah.kd405a_johan_a.assignment4b;

public class Snake extends Animal {
	private boolean poisonus;
	
	public Snake(String latinName, boolean poisonus){
		super(latinName);
		this.poisonus = poisonus;
	}

	@Override
	public String getInfo() {
		return "The snake named " + getFriendlyName() + " " + (poisonus ? "is" : "is not") + " poisonous";  
	}

}
