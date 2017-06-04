package AutomobilePackage;

public abstract class Store {
    abstract Automobile createAuto(String name);

    public Automobile getAutomobile(String name) {
        Automobile automobile = createAuto(name);
        automobile.setValues();
        return automobile;
    }
}
