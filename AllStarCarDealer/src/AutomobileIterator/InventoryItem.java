package AutomobileIterator;

import AutomobilePackage.*;

public class InventoryItem {
    Automobile automobile;
    int qty;

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

    public double getPrice() {
        return automobile.getPrice();
    }

    public int getQty() {
        return qty;
    }

    public void subtractOne() {
        qty--;
    }

    public String toString() {
        return String.format("%-56s%7d%n",automobile.toString() , qty);
    }
}
