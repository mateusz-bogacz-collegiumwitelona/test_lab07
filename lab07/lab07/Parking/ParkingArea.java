package lab07.Parking;

import lab07.Vehicles.*;
import lab07.Mammal.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ParkingArea {
    private static final int AVAILABLE_BIKE_SPACES = 30;
    private static final int AVAILABLE_MOTORBIKE_SPACES = 20;
    private static final int AVAILABLE_CAR_SPACES = 50;

    private static final int CAR_SPACE_PRICE = 2;
    private static final int MOTORBIKE_SPACE_PRICE = 5;

    private int bikeSpaceCount = 0;
    private int motorbikeSpaceCount = 0;
    private int carSpaceCount = 0;

    private int entrancesCount = 0;
    private int carsReturned = 0;
    private int motorbikesReturned = 0;
    private int bikesReturned = 0;

    private final Set<String> blacklist = new HashSet<>(Arrays.asList("DSW-007", "KRK-999"));
    private int blacklistCount = 0;

    public void enterVehicles(List<Object> mixedObjects) {
        for (Object obj : mixedObjects) {
            if (obj instanceof Vehicle) {
                handleVehicle((Vehicle) obj);
            } else if (obj instanceof Mammal) {
                handleMammal((Mammal) obj);
            } else {
                System.out.println("Unknown object type: " + mixedObjects.getClass() + " at " + getTime());
            }
        }
        printSummary();
    }

    private void handleVehicle(Vehicle vehicle) {
        switch (vehicle.getClass().getSimpleName()) {
            case "Ambulance":
                System.out.println(vehicle.identify() + " entered (ambulance) at " + getTime());
                entrancesCount++;
                return;

            case "Escooter":
                System.out.println(vehicle.identify() + " entered (escooter) at " + getTime());
                entrancesCount++;
                return;

            case "Delivery":
                if (blacklist.contains(vehicle.getPlates())) {
                    System.out.println(vehicle.identify() + " (delivery truck) can't enter at " + getTime());
                    blacklistCount++;
                } else {
                    System.out.println(vehicle.identify() + " entered (delivery truck) at " + getTime());
                    entrancesCount++;
                }
                return;

            case "Tank":
                System.out.println(vehicle.identify() + " can't enter at " + getTime());
                return;

            case "Bike":
                tryEnter(vehicle, bikeSpaceCount, AVAILABLE_BIKE_SPACES, () -> bikeSpaceCount++, () -> bikesReturned++);
                return;

            case "Motobike":
                if (blacklist.contains(vehicle.getPlates())) {
                    System.out.println(vehicle.identify() + " (motobike) can't enter at " + getTime());
                    blacklistCount++;
                } else {
                    tryEnter(vehicle, motorbikeSpaceCount, AVAILABLE_MOTORBIKE_SPACES, () -> motorbikeSpaceCount++, () -> motorbikesReturned++);
                }
                return;

            case "WorkerCar":
                WorkerCar wc = (WorkerCar) vehicle;
                if (blacklist.contains(wc.getPlates())) {
                    System.out.println(wc.identify() + "(employee) can't enter at " + getTime());
                    blacklistCount++;
                    return;
                }
                if (wc.hasSubscription()) {
                    System.out.println(wc.identify() + " entered with subscription at " + getTime());
                    entrancesCount++;
                } else {
                    tryEnter(vehicle, carSpaceCount, AVAILABLE_CAR_SPACES, () -> carSpaceCount++, () -> carsReturned++);
                }
                return;

            case "Car":
                if (blacklist.contains(vehicle.getPlates())) {
                    System.out.println(vehicle.identify() + " (car) can't enter at " + getTime());
                    blacklistCount++;
                    return;
                }
                tryEnter(vehicle, carSpaceCount, AVAILABLE_CAR_SPACES, () -> carSpaceCount++, () -> carsReturned++);
                return;

            default:
                if (blacklist.contains(vehicle.getPlates())) {
                    System.out.println(vehicle.identify() + " can't enter at " + getTime());
                    blacklistCount++;
                } else {
                    System.out.println(vehicle.identify() + " enter at " + getTime());
                    entrancesCount++;
                }
        }
    }

    private void handleMammal(Mammal mammal) {
        if (mammal instanceof Dog) {
            System.out.println(mammal.identify() + " can't enter at " + getTime());
        } else {
            System.out.println(mammal.identify() + " enter at " + getTime());
            entrancesCount++;
        }
    }

    private boolean tryEnter(Vehicle vehicle, int currentCount, int maxCount, Runnable increment, Runnable incrementReturn) {
        if (currentCount < maxCount) {
            System.out.println(vehicle.identify() + " enter at " + getTime());
            increment.run();
            return true;
        } else {
            System.out.println("No available spaces for " + vehicle.getClass().getSimpleName() + " at " + getTime());
            incrementReturn.run();
            return false;
        }
    }

    private void printSummary() {
        System.out.println("\nSummary:\n");
        System.out.println("Money collected: " + calculateTotalFee() + " zł");
        System.out.println("Entrances count: " + entrancesCount);

        printSpaceUsage("\nCar", carSpaceCount, AVAILABLE_CAR_SPACES);
        printSpaceUsage("Motorbike", motorbikeSpaceCount, AVAILABLE_MOTORBIKE_SPACES);
        printSpaceUsage("Bike", bikeSpaceCount, AVAILABLE_BIKE_SPACES);

        System.out.println("\nCars returned: " + carsReturned);
        System.out.println("Motorbikes returned: " + motorbikesReturned);
        System.out.println("Bikes returned: " + bikesReturned);

        System.out.println("\nBlacklisted vehicles attempted entry: " + blacklistCount);
    }

    private void printSpaceUsage(String type, int used, int available) {
        int percentage = (used * 100) / available;
        System.out.println(type + " spaces occupied: " + used + "/" + available + " (" + percentage + "%)");
    }

    private int calculateTotalFee() {
        return (motorbikeSpaceCount * MOTORBIKE_SPACE_PRICE) + (carSpaceCount * CAR_SPACE_PRICE);
    }

    private String getTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
    }
}
