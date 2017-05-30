
public class SuvBodyType extends BodyType{
    private static SuvBodyType suvBodyType = new SuvBodyType();
    public SuvBodyType() {
        super();
    }

    public static BodyType getSuvBodyType() {
        return suvBodyType;
    }
}
