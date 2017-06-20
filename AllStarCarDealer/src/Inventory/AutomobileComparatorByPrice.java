package Inventory;

import java.util.Comparator;

public class AutomobileComparatorByPrice implements Comparator<InventoryItem> {
    @Override
    public int compare(InventoryItem o1, InventoryItem o2) {
        return  ((Double)(o1.getPrice() - o2.getPrice())).intValue();
    }
}
