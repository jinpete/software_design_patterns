package AutomobileIterator;

import java.util.Comparator;

public class AutomobileComparatorByManufacturer implements Comparator<InventoryItem> {
    @Override
    public int compare(InventoryItem o1, InventoryItem o2) {
        return o1.getManufacturer().compareTo(o2.getManufacturer());
    }
}
