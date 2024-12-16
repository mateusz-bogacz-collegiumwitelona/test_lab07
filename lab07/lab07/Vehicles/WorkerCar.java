package lab07.Vehicles;
import java.util.Random;

public class WorkerCar extends Car{
    protected String plates;
    protected String color;
    protected String model;
    protected String name;
    private final boolean hasSubscription;


    public WorkerCar() {
        super();
        Random rand = new Random();

        this.isAnonymous = rand.nextBoolean();

        this.model = getModel();
        this.color = getColor();
        this.plates = getPlates();
        this.hasSubscription = rand.nextBoolean();

        if(!this.isAnonymous) this.identifier = this.name;
    }

    public boolean hasSubscription(){
        return hasSubscription;
    }

    @Override
    public String getIdentifier() {
        if (this.identifier == null) this.identifier = this.name;
        return this.identifier + " [worker] (" + this.plates + ") by " + this.color + " " + this.model;
    }

    @Override
    public String getAnonymousIdentifier() {
        return getIdentifier();
    }
}
