package AutomobilePackage;

public class Highlander extends Automobile {
    AutomobileFactory autoFactory = new ToyotaSUVFactory();

    public Highlander(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Highlander");
        setModelYear(2017);
        setPrice(35999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}
