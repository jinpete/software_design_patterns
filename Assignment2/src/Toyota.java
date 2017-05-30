
public class Toyota extends Manufacturer{
    private static Toyota toyota = new Toyota();
    public Toyota() {
        super();
    }
    public static Toyota getToyota() {
        return toyota;
    }
}
