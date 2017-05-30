package AutomobilePackage;

public class Pilot extends Automobile {
    AutomobileFactory autoFactory = new HondaSUVFactory();

    public Pilot(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Pilot");
        setModelYear(2017);
        setPrice(34999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}

