package AutomobilePackage;

public class Sienna extends Automobile {
    AutomobileFactory autoFactory = new ToyotaMinivanFactory();

    public Sienna(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Sienna");
        setModelYear(2017);
        setPrice(28999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}

