package AutomobilePackage;

public class Fusion extends Automobile {
    AutomobileFactory autoFactory = new FordSedanFactory();

    public Fusion(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Fusion");
        setModelYear(2017);
        setPrice(21999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }

}