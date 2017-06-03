package AutomobilePackage;

public class Accord extends Automobile {
    AutomobileFactory autoFactory = new HondaSedanFactory();

    public Accord(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Accord");
        setModelYear(2017);
        setPrice(24999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}
