import AutomobilePackage.Automobile;
import AutomobilePackage.BodyType;
import AutomobilePackage.Manufacturer;

public class InventoryItem {
    Automobile automobile;
    String modelName;
    Manufacturer manufacturer;
    BodyType bodyType;
    int modelYear;
    double price;
    int qty;

    public InventoryItem(String modelName, Manufacturer manufacturer, BodyType bodyType, int modelYear, double price, int qty) {
        this.modelName = modelName;
        this.manufacturer = manufacturer;
        this.bodyType = bodyType;
        this.modelYear = modelYear;
        this.price = price;
        this.qty = qty;
    }

    public InventoryItem(Automobile automobile, int qty) {
        this.automobile = automobile;
        this.qty = qty;
    }

    public String getModelName() {
        return modelName;
    }

    public String getManufacturer() {
        return manufacturer.toString();
    }

    public String getBodyType() {
        return bodyType.toString();
    }

    public int getModelYear() {
        return modelYear;
    }

    public double getPrice() {
        return price;
    }

    public int getQty() {
        return qty;
    }

    public String toString() {
        return automobile.toString() + "\nQty in stock: " + qty + "\n";
    }

//    public String toString() {
//        return "Name: " + getModelName() + "\nManufacturer: " + manufacturer.toString() + "\nType: " + bodyType
//                + "\nModel Year: " + getModelYear() + "\nPrice: $" + price + "\nQty in stock: " + qty;
//    }

}
