package Inventory;

import AutomobileIterator.*;
import AutomobilePackage.*;
import java.util.*;

public class InventoryTracker implements Comparator<InventoryItem>, Comparable<InventoryItem> {
    List<InventoryItem> inventoryItems;
    ArrayList<Automobile> automobiles;

    private static InventoryTracker inventoryTracker = new InventoryTracker();

    public static InventoryTracker getInstance() {
        return inventoryTracker;
    }

    private InventoryTracker() {
        getAutomobiles();
        addItems();

    }

    public void addItems() {
        inventoryItems = new ArrayList<InventoryItem>();
        for(Automobile automobile : automobiles) {
            InventoryItem inventoryItem = new InventoryItem(automobile, 10);
            inventoryItems.add(inventoryItem);
        }
    }

    public void getAutomobiles() {
        automobiles = new ArrayList<>();
        AutoStore autoStore = new AutoStore();
        automobiles.add(autoStore.getAutomobile("accord"));
        automobiles.add(autoStore.getAutomobile("camry"));
        automobiles.add(autoStore.getAutomobile("explorer"));
        automobiles.add(autoStore.getAutomobile("f150"));
        automobiles.add(autoStore.getAutomobile("fusion"));
        automobiles.add(autoStore.getAutomobile("highlander"));
        automobiles.add(autoStore.getAutomobile("odyssey"));
        automobiles.add(autoStore.getAutomobile("pilot"));
        automobiles.add(autoStore.getAutomobile("ridgeline"));
        automobiles.add(autoStore.getAutomobile("sienna"));
        automobiles.add(autoStore.getAutomobile("tundra"));
    }

    public List<InventoryItem> getInventoryItems() { return inventoryItems; }

    public InventoryIterator createIterator(String sortType) {
        if (sortType.equals("m")) {
            Collections.sort(inventoryItems, new AutomobileComparatorByManufacturer());
        } else {
            Collections.sort(inventoryItems, new AutomobileComparatorByPrice());
        }

        return new InventoryIterator(inventoryItems);
    }


    @Override
    /* sort by manufacturer */
    public int compareTo(InventoryItem inventoryItem) {
        return inventoryItems.get(0).getManufacturer().compareTo(inventoryItem.getManufacturer());
    }

    @Override
    /* this sorts inventory by price */
    public int compare(InventoryItem i1, InventoryItem i2) {
        return ((Double)(i1.getPrice() - i2.getPrice())).intValue();
    }
}
