package AutomobilePackage;

public class HondaTruckFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new Truck();
    }

    public Manufacturer createManufacturer() {
        return new Honda();
    }

}
