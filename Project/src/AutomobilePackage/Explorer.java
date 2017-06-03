package AutomobilePackage;

public class Explorer extends Automobile {
    AutomobileFactory autoFactory = new FordSUVFactory();

    public Explorer(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
        setName("Explorer");
        setModelYear(2017);
        setPrice(31999);
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }

}
