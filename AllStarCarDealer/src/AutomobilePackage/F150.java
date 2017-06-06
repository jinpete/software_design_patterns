package AutomobilePackage;

public class F150 extends Automobile {
    AutomobileFactory autoFactory = new FordTruckFactory();

    public F150(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("F150");
        setModelYear(2017);
        setPrice(28999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }

}