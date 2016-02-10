package se.mah.kd405a_johan_a.assignment4b;

public class Snake extends Animal {
	private boolean poisonus;
	
	/**
	 * Constructor for Snake.
	 * @param latinName Name in latin.
	 * @param poisonus If the snake is poisonous or not.
	 */
	public Snake(String latinName, boolean poisonus){
		super(latinName);
		this.poisonus = poisonus;
	}

	/**
	 * Returns a string with info about the snake.
	 * @return Info about the snake.
	 */
	@Override
	public String getInfo() {
		return "The snake named " + getFriendlyName() + " " + (poisonus ? "is" : "is not") + " poisonous";  
	}

}
