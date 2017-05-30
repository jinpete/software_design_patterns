import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

public abstract class Automobile {
    String modelName;
    Manufacturer manufacturer;
    BodyType bodyType;
    int modelYear;
    double price;

    public abstract void setValues();

    public String getName() {
        return modelName;
    }
    public void setName(String name) {
        this.modelName = name;
    }

    public void setModelYear(int year) {
        this.modelYear = year;
    }

    public void setPrice(double price) {
        this.price = price;
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
