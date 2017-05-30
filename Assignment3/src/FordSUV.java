public class FordSUV extends Automobile {
    AutomobileFactory autoFactory = new FordSUVFactory();

    public FordSUV(AutomobileFactory autoFactory) {
        this.autoFactory = autoFactory;
    }

    public void setValues() {
        manufacturer = autoFactory.createManufacturer();
        bodyType = autoFactory.createBodyType();
    }
}
