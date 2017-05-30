
public class CarBodyType extends BodyType {

    private static CarBodyType carBodyType = new CarBodyType();
    public CarBodyType() {
        super();
    }

    public static BodyType getCarBodyType() {
        return carBodyType;
    }
}
