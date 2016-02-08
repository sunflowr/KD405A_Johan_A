package se.mah.kd405a_johan_a.assignment4b;

public class Cat extends Mammal {
	private int numberOfLifes;

	/** @note UML-specs says numberOfLIfes */  
	public Cat(String latinName, int gestationTime, int numberOfLIfes){
		super(latinName, gestationTime);
		this.numberOfLifes = numberOfLIfes;
	}

	/** @note UML-specs says getNunberOfLifes */  
	public int getNunberOfLifes(){
		return numberOfLifes;
	}

	public void setNumberOfLifes(int i){
	}

	@Override
	public String getInfo() {
		return "The cat " + getFriendlyName() + " nurses for " + getGestationtime() + " months and has " + numberOfLifes + " lifes";  
	}
}
