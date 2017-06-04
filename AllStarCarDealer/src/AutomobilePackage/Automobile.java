package AutomobilePackage;

public abstract class Automobile {
    String modelName;
    Manufacturer manufacturer;
    BodyType bodyType;

    String sMake;
    String sBody;
    int modelYear;
    double price;

    public abstract void setValues();

    public String getName() {
        return modelName;
    }
    public Manufacturer getManufacturer() { return manufacturer; }
    public BodyType getBodyType() { return bodyType; }
    public int getModelYear() { return modelYear; }

    public void setName(String name) {
        this.modelName = name;
    }

    public void setModelYear(int year) {
        this.modelYear = year;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return this.price;
    }
    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("Model Name: " + modelName + "\n");
        display.append("Make: " + manufacturer + "\n");
        display.append("Body Type: " + bodyType + "\n");
        display.append("Model Year: " + modelYear + "\n");
        display.append(String.format("Price: $%.2f", price) );
        return display.toString();
    }
}
