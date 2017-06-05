package AutomobileIterator;

import AutomobilePackage.Automobile;
import AutomobilePackage.BodyType;
import AutomobilePackage.Manufacturer;
import java.util.*;

public class InventoryItem {
    Automobile automobile;
//    String modelName;
//    Manufacturer manufacturer;
//    BodyType bodyType;
//    int modelYear;
//    double price;
    int qty;

//    public InventoryItem(String modelName, Manufacturer manufacturer, BodyType bodyType, int modelYear, double price, int qty) {
//        this.modelName = modelName;
//        this.manufacturer = manufacturer;
//        this.bodyType = bodyType;
//        this.modelYear = modelYear;
//        this.price = price;
//        this.qty = qty;
//    }

    public InventoryItem(Automobile automobile, int qty) {
        this.automobile = automobile;
        this.qty = qty;
    }

    public String getModelName() {
        return automobile.getName();
    }

    public String getManufacturer() {
        return automobile.getManufacturer().toString();
    }

    public String getBodyType() {
        return automobile.getBodyType().toString();
    }

//    public int getModelYear() {
//        return modelYear;
//    }
//
    public double getPrice() {
        return automobile.getPrice();
    }

    public int getQty() {
        return qty;
    }

    public String toString() {
        return String.format("%-56s%7d%n",automobile.toString() , qty);
    }

//    public String toString() {
//        return "Name: " + getModelName() + "\nManufacturer: " + manufacturer.toString() + "\nType: " + bodyType
//                + "\nModel Year: " + getModelYear() + "\nPrice: $" + price + "\nQty in stock: " + qty;
//    }


}
