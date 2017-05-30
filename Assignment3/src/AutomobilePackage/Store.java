package AutomobilePackage;

public abstract class Store {
    abstract Automobile createAuto(String name);

    public Automobile getAutomobile(String type) {
        Automobile automobile = createAuto(type);
        automobile.setValues();
        return automobile;
    }
}
