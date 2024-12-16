package lab07.Vehicles;
import java.util.Random;

public class Delivery extends Car {
    protected String name;
    protected String plates;

    public String getName(){
        Random rand = new Random();

        String[] brand = {"DHL", "DPD", "Fedex"};
        int index = rand.nextInt(brand.length);

        return brand[index];
    }

    public Delivery(){
        super();
        this.name = getName();
        this.plates = getPlates();
        this.isAnonymous = false;
    }

    public String getIdentifier() {
        return this.name + " delivery (" + this.plates + ")";
    }

    @Override
    public String getAnonymousIdentifier() {
        return getIdentifier();
    }
}
