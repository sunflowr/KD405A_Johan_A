package se.mah.kd405a_johan_a.assignment4b;

public abstract class Mammal extends Animal {
	private int gestationTime;
	
	/**
	 * Constructor for Mammal.
	 * @param latinName Name in latin.
	 * @param gestationTime Time of gestation in months.
	 */
	public Mammal(String latinName, int gestationTime){
		super(latinName);
		this.gestationTime = gestationTime;
	}
	
	/**
	 * Returns the gestation time of the mammal.
	 * @return Gestation time in months.
	 */
	public int getGestationtime(){
		return gestationTime;
	}

}
