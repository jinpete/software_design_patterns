package AutomobilePackage;

public class Tundra extends Automobile {
    AutomobileFactory autoFactory = new ToyotaTruckFactory();

    public Tundra(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Tundra");
        setModelYear(2017);
        setPrice(37999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}
