package Inventory;

import AutomobilePackage.*;
import java.util.*;

public class InventoryTracker implements Comparator<InventoryItem>, Comparable<InventoryItem> {
    List<InventoryItem> inventoryItems;
    ArrayList<Automobile> automobiles;

    private ArrayList<Observer> observers;
    private static int tempIndexNum;

    private static InventoryTracker inventoryTracker = new InventoryTracker();

    public static InventoryTracker getTheInventoryTracker() {
        return inventoryTracker;
    }

    private InventoryTracker() {
        observers = new ArrayList<Observer>();
        getAutomobiles();
        addItems();

    }

    public void addObserver(Observer o) {
        observers.add(o);
    }


    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(tempIndexNum);
        }
    }
    public void addItems() {
        inventoryItems = new ArrayList<InventoryItem>();
        for(Automobile automobile : automobiles) {
            InventoryItem inventoryItem = new InventoryItem(automobile, 6);
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

//    public List<InventoryItem> getInventoryItems() { return inventoryItems; }

    public InventoryIterator createIterator(String sortType) {
        if (sortType.equals("m")) {
            Collections.sort(inventoryItems, new AutomobileComparatorByManufacturer());
        } else {
            Collections.sort(inventoryItems, new AutomobileComparatorByPrice());
        }

        return new InventoryIterator(inventoryItems);
    }

    public InventoryItem getInventoryItem(int idx) {
        return inventoryItems.get(idx);
    }

    public void purchaseItem(int idx) {
        inventoryItems.get(idx).subtractOne();
        tempIndexNum = idx;
        notifyObservers();
    }

    public void add(int idx, int qty) {
        inventoryItems.get(idx).addInventory(qty);
    }


    public int getQty(int i) {
        return inventoryItems.get(i).getQty();
    }

    public String getModelName(int i) {
        return inventoryItems.get(i).getModelName();
    }

    public String getManufacturer(int i) {
        return inventoryItems.get(i).getManufacturer();
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
