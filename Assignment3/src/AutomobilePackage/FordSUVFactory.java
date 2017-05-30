package AutomobilePackage;

public class FordSUVFactory implements AutomobileFactory {

    public BodyType createBodyType() {
        return new SUV();
    }

    public Manufacturer createManufacturer() {
        return new Ford();
    }
}
