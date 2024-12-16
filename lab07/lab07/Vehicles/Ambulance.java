package lab07.Vehicles;

public class Ambulance extends Car {
    protected String plates;

    public Ambulance() {
        super();
        this.plates = super.getPlates();
        this.isAnonymous = false;
    }


    public String getIdentifier() {
        return "Ambulance (" + this.plates + ")";
    }

    @Override
    public String getAnonymousIdentifier() {
        return getIdentifier();
    }
}
