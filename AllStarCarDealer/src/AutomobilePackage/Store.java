package AutomobilePackage;

public abstract class Store {
    abstract Automobile createAutomobile(String name);

    public Automobile getAutomobile(String name) {
        Automobile automobile = createAutomobile(name);
        automobile.setValues();
        return automobile;
    }
}
