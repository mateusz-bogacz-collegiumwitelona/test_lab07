package lab07.Mammal;

public class Dog extends Mammal {
    public Dog(){this.isAnonymous = true;}

    public String getAnonymousIdentifier() {
        return "Dog";
    }

    @Override
    protected String getIdentifier() {
        return getAnonymousIdentifier();
    }
}
