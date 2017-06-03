package AutomobilePackage;

public class Ridgeline extends Automobile {
    AutomobileFactory autoFactory = new HondaTruckFactory();

    public Ridgeline(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Ridgeline");
        setModelYear(2017);
        setPrice(26999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}

