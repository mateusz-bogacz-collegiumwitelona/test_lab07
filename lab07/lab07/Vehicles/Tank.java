package lab07.Vehicles;

public class Tank extends Car {
    protected String plates;

    public Tank() {
        super();
        this.plates = getPlates();
        this.isAnonymous = false;
    }

    public String getIdentifier() {
        return "Tank (" + this.plates + ")" ;
    }

    @Override
    public String getAnonymousIdentifier() {
        return getIdentifier();
    }
}