package Inventory;

public class InventoryTracker {
    private static InventoryTracker inventoryTracker = new InventoryTracker();

    public static InventoryTracker getInstance() {
        return inventoryTracker;
    }

    private InventoryTracker() {
    }




}