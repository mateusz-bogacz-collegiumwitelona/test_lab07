package lab07.Vehicles;
import lab07.Parking.Identyfier;import lab07.Parking.Identyfier;
import java.util.Random;

public class Bike extends Vehicle {
    protected String name;
    public Bike() {
        super();
        Random rand = new Random();

        this.name = getID();
        this.isAnonymous = rand.nextBoolean();

        if(!this.isAnonymous) this.identifier = this.name;
    }

    public Bike(String name) {
        super(name);
        this.isAnonymous = false;
    }

    public String getIdentifier() {
        if (this.identifier == null) this.identifier = this.name;
        return this.identifier + " by bike";
    }

    @Override
    public String getAnonymousIdentifier() {
        return "anonymous by bike";
    }
}
