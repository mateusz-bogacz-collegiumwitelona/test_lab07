package lab07.Vehicles;
import lab07.Parking.Identyfier;
import java.util.Random;

public abstract class Vehicle extends Identyfier {
    protected boolean isAnonymous = false;
    protected String identifier;

    public Vehicle() {
        this.isAnonymous = true;
    }

    public Vehicle(String identifier) {
        this.identifier = identifier;
    }

    final public String identify() {
        Random rand = new Random();
        if (rand.nextBoolean()) {
            return getAnonymousIdentifier();
        }

        return getIdentifier();
    }

    protected String getAnonymousIdentifier() {
        return "anonymous by " + this.getClass().getSimpleName().toLowerCase();
    }

    abstract protected String getIdentifier();

    public String getPlates() {
        return super.getPlates();
    }

    public String getColor() {
        return super.getColor();
    }

    public String getID(){
        return super.getID();
    }
}
