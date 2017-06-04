package AutomobilePackage;

public class Camry extends Automobile {
    AutomobileFactory autoFactory = new ToyotaSedanFactory();

    public Camry(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Camry");
        setModelYear(2017);
        setPrice(22999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}
