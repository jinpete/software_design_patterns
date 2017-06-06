import AutomobileIterator.*;
import Inventory.*;

public class InventoryIteratorTester {

    public static void main(String[] args) {
        InventoryTracker inv = InventoryTracker.getInstance();
        ItemIterator inventoryIterator = inv.createIterator("p");
        System.out.println("Make      Model Name  Body Type   Model Year  Price     InStock");
        System.out.println("---------------------------------------------------------------");
        while(inventoryIterator.hasNext()) {
            InventoryItem inventoryItem = inventoryIterator.next();
            System.out.println(inventoryItem.toString());
        }
    }
}