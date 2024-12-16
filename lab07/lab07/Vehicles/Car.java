package lab07.Vehicles;
import java.util.Random;

public class Car extends Vehicle {
    protected String plates;
    protected String color;
    protected String model;
    protected String name;

    public Car() {
        super();
        Random rand = new Random();

        this.isAnonymous = rand.nextBoolean();

        this.name = getID();
        this.model = getModel();
        this.color = getColor();
        this.plates = getPlates();

        if(!this.isAnonymous) this.identifier = this.name;
    }

    public Car(String plates, String name) {
        super(name);
        this.model = getModel();
        this.color = getColor();
        this.plates = getPlates();
        this.isAnonymous = false;
    }

    @Override
    public String getIdentifier() {
        if (this.identifier == null) this.identifier = name;
        return this.identifier + " (" + this.plates + ") by " + this.color + " " + this.model;
    }

    @Override
    public String getAnonymousIdentifier() {
        return "anonymous by car (" + this.plates + ") by " + this.color + " " + this.model;
    }
}