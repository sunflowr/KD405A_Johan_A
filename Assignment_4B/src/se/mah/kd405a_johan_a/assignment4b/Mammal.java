package se.mah.kd405a_johan_a.assignment4b;

public abstract class Mammal extends Animal {
	private int gestationTime;
	
	public Mammal(String latinName, int gestationTime){
		super(latinName);
		this.gestationTime = gestationTime;
	}
	
	public int getGestationtime(){
		return gestationTime;
	}

}
