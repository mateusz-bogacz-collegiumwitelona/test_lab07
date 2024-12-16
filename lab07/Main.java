import lab07.Parking.ParkingArea;
import lab07.Vehicles.*;
import lab07.Mammal.*;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ParkingArea parkingArea = new ParkingArea();

		System.out.print("Enter the number of objects to generate: ");
		int n = scanner.nextInt();
		List<Object> mixedObjects = generateRandomObjects(n);
		parkingArea.enterVehicles(mixedObjects);
	}

	private static List<Object> generateRandomObjects(int count) {
		Object[] allObjects = {
				new Bike(), new Motobike(), new Car(), new WorkerCar(),
				new Delivery(), new Ambulance(), new Tank(), new Escooter(),
				new Dog(), new Person()
		};


		List<Object> mixedObjects = new ArrayList<>();
		Random random = new Random();

		for (int i = 0; i < count; i++) {
			mixedObjects.add(allObjects[random.nextInt(allObjects.length)]);
		}
		return mixedObjects;
	}
}
