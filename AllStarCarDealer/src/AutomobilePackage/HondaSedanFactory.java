package AutomobilePackage;

public class HondaSedanFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new Sedan();
    }

    public Manufacturer createManufacturer() {
        return new Honda();
    }

}
