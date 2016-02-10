package se.mah.kd405a_johan_a.assignment4b;

public class Cat extends Mammal {
	private int numberOfLifes;

	/**
	 * Constructor for Cat.
	 * Note: UML-specs says numberOfLIfes
	 * @param latinName Name in latin.
	 * @param gestationTime Time of gestation in months.
	 * @param numberOfLIfes Number of lifes.
	 */  
	public Cat(String latinName, int gestationTime, int numberOfLIfes){
		super(latinName, gestationTime);
		this.numberOfLifes = numberOfLIfes;
	}

	/**
	 * Note: UML-specs says getNunberOfLifes
	 * @return Number of lifes left.
	 */  
	public int getNunberOfLifes(){
		return numberOfLifes;
	}

	/**
	 * Updates number of lifes.
	 * @param i New value for number of lifes.
	 */
	public void setNumberOfLifes(int i){
		numberOfLifes = i;
	}

	/**
	 * Returns a string with info about the cat.
	 * @return Info about the cat.
	 */
	@Override
	public String getInfo() {
		return "The cat " + getFriendlyName() + " nurses for " + getGestationtime() + " months and has " + numberOfLifes + " lifes";  
	}
}
