package se.mah.kd405a_johan_a.assignment3;

import java.util.Random;

public class BikeStoreTest {

	public static void main(String[] args) {
		// Create a random generator.
		Random random = new Random();

		// Create a BikeStore and add ten random bikes to the store.
		BikeStore bikeStore = new BikeStore();
		for(int i = 0; i < 9; i++){
			bikeStore.addBike(Constants.COLORS[random.nextInt(Constants.COLORS.length)], Integer.toString(random.nextInt(40)), Integer.toString(random.nextInt(40000)));
		}
		// Add an bike with invalid color.
		bikeStore.addBike("notacolor", Integer.toString(random.nextInt(40)), Integer.toString(random.nextInt(40000)));

		// Print out the bike properties.
		System.out.println("Bikes in the store:");
		System.out.println(bikeStore.getAllBikes());
	}

}
