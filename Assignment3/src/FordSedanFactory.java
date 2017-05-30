public class FordSedanFactory implements AutomobileFactory {

    public BodyType createBodyType() {
        return new Sedan();
    }

    public Manufacturer createManufacturer() {
        return new Ford();
    }
}
