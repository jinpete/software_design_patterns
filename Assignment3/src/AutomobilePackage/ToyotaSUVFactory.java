package AutomobilePackage;

public class ToyotaSUVFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new SUV();
    }

    public Manufacturer createManufacturer() {
        return new Toyota();
    }
}

