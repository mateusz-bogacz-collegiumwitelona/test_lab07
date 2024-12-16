package lab07.Vehicles;
import java.util.Random;

public class Escooter extends Bike {
    protected String name;
    public Escooter() {
        super();
        Random rand = new Random();

        this.name = getID();
        this.isAnonymous = rand.nextBoolean();

        if(!this.isAnonymous) this.identifier = this.name;
    }

    public Escooter(String name) {
        super(name);
        this.isAnonymous = false;
    }

    @Override
    public String getIdentifier() {
        if (this.identifier == null) this.identifier = this.name;

        return this.identifier + " by escooter";
    }

    @Override
    public String getAnonymousIdentifier() {
        return "anonymous by escooter";
    }
}
