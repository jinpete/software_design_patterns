
public class MinivanBodyType extends BodyType {
    private static MinivanBodyType minivanBodyType = new MinivanBodyType();
    public MinivanBodyType() {
        super();
    }

    public static MinivanBodyType getMinivanBodyType() {
        return minivanBodyType;
    }
}
