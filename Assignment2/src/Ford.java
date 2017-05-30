public class Ford extends Manufacturer {
    private static Ford ford = new Ford();
    public Ford() {
        super();
    }
    public static Ford getFord() {
        return ford;
    }
}
