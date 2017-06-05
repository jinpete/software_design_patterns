package AutomobileIterator;

import java.util.*;

public class InventoryIterator implements ItemIterator {
    List<InventoryItem> inventoryItems;
    int pos = 0;

    public InventoryIterator(List<InventoryItem> inventoryItems) {
        this.inventoryItems = inventoryItems;
    }

    /* returns the next item in arraylist */
    public InventoryItem next() {
        InventoryItem inventoryItem = inventoryItems.get(pos);
        pos = pos + 1;
        return inventoryItem;
    }

    public boolean hasNext() {
        return (pos < inventoryItems.size());
    }
}
