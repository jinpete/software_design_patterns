
public class TruckBodyType extends BodyType {
    private static TruckBodyType truckBodyType = new TruckBodyType();
    public TruckBodyType() {
        super();
    }

    public static BodyType getTruckBodyType() {
        return truckBodyType;
    }
}
