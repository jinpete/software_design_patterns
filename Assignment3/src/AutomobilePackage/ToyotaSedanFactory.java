package AutomobilePackage;

public class ToyotaSedanFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new Sedan();
    }

    public Manufacturer createManufacturer() {
        return new Toyota();
    }
}

