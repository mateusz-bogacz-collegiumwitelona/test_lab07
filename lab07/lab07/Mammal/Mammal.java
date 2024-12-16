package lab07.Mammal;
import lab07.Parking.Identyfier;
import java.util.Random;

public abstract class Mammal extends  Identyfier{
    protected boolean isAnonymous = false;
    protected String identifier;

    public Mammal() {this.isAnonymous = true;}

    public Mammal(String identifier) {this.identifier = identifier;}

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

    public String getID(){
        return super.getID();
    }

}
