package AutomobilePackage;

public class ToyotaMinivanFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new Minivan();
    }

    public Manufacturer createManufacturer() {
        return new Toyota();
    }

}
