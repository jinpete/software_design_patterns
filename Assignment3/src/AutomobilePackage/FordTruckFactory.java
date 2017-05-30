package AutomobilePackage;

public class FordTruckFactory implements AutomobileFactory {

    public BodyType createBodyType() {
        return new Truck();
    }

    public Manufacturer createManufacturer() {
        return new Ford();
    }
}
