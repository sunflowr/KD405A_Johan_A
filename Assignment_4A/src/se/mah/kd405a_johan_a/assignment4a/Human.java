package se.mah.kd405a_johan_a.assignment4a;

public class Human {
	private Dog dog;
	private String name;
	
	public Human(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void buyDog(Dog dog) {
		this.dog = dog;
	}
	
	/**Returnerar: "x äger en hund som heter y" eller " x äger inte en hund"*/ 
	public String getInfo() {
		if(dog != null) {
			return name + " äger en hund som heter " + dog.getName();
		} else {
			return name + " äger inte en hund";
		}
	}

}
