package se.mah.kd405a_johan_a.assignment3;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// Create a random generator.
		Random random = new Random();

		// Create ten random bikes to test the bike class.
		ArrayList<Bike> bikes = new ArrayList<Bike>();
		for(int i = 0; i < 9; i++){
			bikes.add(new Bike(Constants.COLORS[random.nextInt(Constants.COLORS.length)], random.nextInt(40), random.nextInt(40000)));
		}
		// Add an bike with invalid color.
		bikes.add(new Bike("notacolor", random.nextInt(40), random.nextInt(40000)));
		/*bikes.add(new Bike("Red", 5, 1000));
		bikes.add(new Bike("Green", 7, 20000));
		bikes.add(new Bike("Black", 40));
		bikes.add(new Bike("White", 30, 500));
		bikes.add(new Bike("Yellow", 10, 100000));
		bikes.add(new Bike("Purple", 15, 7384));
		bikes.add(new Bike("Cyan", 17));
		bikes.add(new Bike("Magenta", 21, 1290));
		bikes.add(new Bike("Gray", 20, 12840));*/

		// Print out the bike properties.
		System.out.println("Bikes:");
		for(int i = 0; i < bikes.size(); i++){
			Bike bike = bikes.get(i);
			System.out.println("id:" + i + ", price: " + bike.getPrice() + ", color: " + bike.getColor() + ", size: " + bike.getSize());
		}
	}
}
