import java.util.ArrayList;

public class InventoryIterator implements ItemIterator {
    ArrayList<InventoryItem> inventoryItems;
    int pos = 0;

    public InventoryIterator(ArrayList<InventoryItem> inventoryItems) {
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
