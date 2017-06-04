import AutomobilePackage.AutoStore;
import AutomobilePackage.Automobile;

import java.util.ArrayList;

public class InventorySetup {
    ArrayList<InventoryItem> inventoryItems;
    ArrayList<Automobile> automobiles;

    public InventorySetup() {
        getAutomobiles();
        addItems();
    }

    public void addItems() {
        inventoryItems = new ArrayList<InventoryItem>();
        for(Automobile automobile : automobiles) {
            InventoryItem inventoryItem = new InventoryItem(automobile, 10);

//            for(Automobile automobile : automobiles) {
//            InventoryItem inventoryItem = new InventoryItem(automobile.getName(), automobile.getManufacturer(),
//                    automobile.getBodyType(), automobile.getModelYear(),
//                    automobile.getPrice(), 10);

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

    public ArrayList<InventoryItem> getInventoryItems() { return inventoryItems; }

    public InventoryIterator createIterator() {
        return new InventoryIterator(inventoryItems);
    }
}
