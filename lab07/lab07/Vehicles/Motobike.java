package lab07.Vehicles;
import java.util.Random;

public class Motobike extends Vehicle {
    protected String name;
    protected String plates;


    public Motobike() {
        super();
        Random rand = new Random();
        this.plates = getPlates();

        this.name = getID();
        this.isAnonymous = rand.nextBoolean();

        if(!this.isAnonymous) this.identifier = this.name;
    }

    public Motobike(String name) {
        super(name);
        this.isAnonymous = false;
    }

    public String getIdentifier() {
        if (this.identifier == null) this.identifier = this.name;

        return this.identifier + " by Motobike (" + this.plates + ")";
    }

    @Override
    public String getAnonymousIdentifier() {
        return "anonymous by Motobike (" + this.plates + ")" ;
    }
}
