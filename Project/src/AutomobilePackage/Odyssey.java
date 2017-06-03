package AutomobilePackage;

public class Odyssey extends Automobile {
    AutomobileFactory autoFactory = new HondaMinivanFactory();

    public Odyssey(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Odyssey");
        setModelYear(2017);
        setPrice(28999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}
