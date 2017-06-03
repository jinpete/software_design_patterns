package AutomobilePackage;

public class ToyotaTruckFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new Truck();
    }

    public Manufacturer createManufacturer() {
        return new Toyota();
    }
}

