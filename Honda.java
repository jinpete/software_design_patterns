
public class Honda extends Manufacturer {
    private static Honda honda = new Honda();
    public Honda() {
        super();
    }
    public static Honda getHonda() {
        return honda;
    }
}
