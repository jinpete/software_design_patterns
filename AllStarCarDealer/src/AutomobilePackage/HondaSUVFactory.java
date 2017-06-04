package AutomobilePackage;

public class HondaSUVFactory implements AutomobileFactory {

    public BodyType createBodyType() {
        return new SUV();
    }

    public Manufacturer createManufacturer() {
        return new Honda();
    }

}
