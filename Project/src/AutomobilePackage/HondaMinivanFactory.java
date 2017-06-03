package AutomobilePackage;

public class HondaMinivanFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new Minivan();
    }

    public Manufacturer createManufacturer() {
        return new Honda();
    }

}

