package lab07.Mammal;
import java.util.Random;

public class Person extends Mammal{
    protected String name;

    public Person(){
        super();
        Random rand = new Random();

        this.name = getID();
        this.isAnonymous = rand.nextBoolean();
        if (!this.isAnonymous) this.identifier = this.name;
    }

    public Person(String name){
        super(name);
        isAnonymous = false;
    }

    public String getIdentifier() {
        if (this.identifier == null) this.identifier = this.name;
        return this.name;
    }

    public String getAnonymousIdentifier() {
     return "anonymous";
    }

}
