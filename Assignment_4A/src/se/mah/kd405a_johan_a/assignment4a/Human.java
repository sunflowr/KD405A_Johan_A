package se.mah.kd405a_johan_a.assignment4a;

public class Human {
	private Dog dog;
	private String name;

	/**
	 * Constructor for Human
	 * @param name Name of the human.
	 */
	public Human(String name) {
		this.name = name;
	}
	
	/**
	 * Returns the name of the human
	 * @return Name of the human.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Makes the human owner of a Dog
	 * @param dog The dog the human is buying.
	 */
	public void buyDog(Dog dog) {
		this.dog = dog;
	}
	
	/**
	 * Returns the name of the human and whether it owns a dog, and if so, what the name of the dog is.
	 * @return Name of the human and whether it owns a dog, and if so, what the name of the dog is.
	 */
	public String getInfo() {
		if(dog != null) {
			return name + " äger en hund som heter " + dog.getName();
		} else {
			return name + " äger inte en hund";
		}
	}

}
