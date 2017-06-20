package Inventory;
import Inventory.InventoryTracker;

public class InventoryObserver implements Observer {

    private final int STOCK_THRESHOLD = 5;
    private int currentInStockQty;
    private String modelName;
    private InventoryTracker inventoryTracker = InventoryTracker.getTheInventoryTracker();

    public InventoryObserver(InventoryTracker inventoryTracker) {
        inventoryTracker.addObserver(this);
    }

    public void update(int idx) {
        currentInStockQty = inventoryTracker.getQty(idx);
        modelName = inventoryTracker.getModelName(idx);
        display();
    }

    public void display() {
        if (currentInStockQty <= STOCK_THRESHOLD){
            System.out.println(String.format("Message from observer...%n%nIn Stock Quantity of %s has reached LOW THRESHOLD of 5.%nCurrent in stock quantity is %d",
                    modelName, currentInStockQty));
        }
    }
}

