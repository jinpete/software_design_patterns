public class FordMinivanFactory implements AutomobileFactory {
    public BodyType createBodyType() {
        return new Minivan();
    }

    public Manufacturer createManufacturer() {
        return new Ford();
    }
}
