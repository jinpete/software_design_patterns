package Inventory;

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

// --Commented out by Inspection START (6/18/2017 11:45 PM):
//    public String getBodyType() {
//        return automobile.getBodyType().toString();
//    }
// --Commented out by Inspection STOP (6/18/2017 11:45 PM)

    public double getPrice() {
        return automobile.getPrice();
    }

    public int getQty() {
        return qty;
    }

    public void subtractOne() {
        qty--;
    }

    public void addInventory(int num) {
        qty += num;
    }

    public String toString() {
        return String.format("%-56s%7d",automobile.toString() , qty);
    }
}
