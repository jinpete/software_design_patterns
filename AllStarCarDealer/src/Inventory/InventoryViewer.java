package Inventory;

import java.io.*;
import java.util.*;


public class InventoryViewer {

    private static ArrayList<String> tempAutoList;
    private static int tempAutoIndex;
    private static InventoryTracker inventoryTracker = InventoryTracker.getTheInventoryTracker();
    private static ItemIterator inventoryIterator;
    private static InventoryViewer inventoryViewer = new InventoryViewer();

    public static InventoryViewer getTheInventoryViewer() { return inventoryViewer; }
    public InventoryViewer() {
        setupInventory();
    }

    public boolean printSelectedAutomobile(String modelName) {
        boolean bInStock = false;
        tempAutoIndex = tempAutoList.indexOf(modelName);
        System.out.println("You selected");
        System.out.println("Make      Model Name  Body Type   Model Year  Price     InStock");
        System.out.println("---------------------------------------------------------------");
        System.out.println(inventoryTracker.getInventoryItem(tempAutoIndex));

        if(inventoryTracker.getInventoryItem(tempAutoIndex).getQty() < 1) {
            System.out.println("There's no more " + inventoryTracker.getInventoryItem(tempAutoIndex).getModelName() + " in stock. Please choose another model.\n");
        } else {
            bInStock = true;
        }
        return bInStock;
    }

    public void setInventoryIndexNum(int idx) {
        // this is used to set index number with index number chosen from the inventory
        tempAutoIndex = idx;
    }

    public void printInventory(String sortBy) {
        setupInventory(sortBy);
        System.out.println("Row  Make      Model Name  Body Type   Model Year  Price     InStock");
        System.out.println("--------------------------------------------------------------------");
        int i = 1; // row number to be used to select specific row for inventory management
        while(inventoryIterator.hasNext()) {
            InventoryItem inventoryItem = inventoryIterator.next();
            System.out.println(String.format("%3d  ",i) + inventoryItem.toString());
            tempAutoList.add(inventoryItem.getModelName().toLowerCase());
            i++;
        }
    }

    public void setupInventory(String sortBy) {
        tempAutoList = new ArrayList<>();
        inventoryIterator = inventoryTracker.createIterator(sortBy);
    }

    public static void setupInventory() {
        // default setup to initialize inventory and tempAutoList
        tempAutoList = new ArrayList<>();
        inventoryIterator = inventoryTracker.createIterator("m");
        while(inventoryIterator.hasNext()) {
            InventoryItem inventoryItem = inventoryIterator.next();
            tempAutoList.add(inventoryItem.getModelName().toLowerCase());
        }
    }

    public void selectMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        String sortBy = "m";
        while(true) {
            try {
                System.out.println("Menu:\ntype 'i' to view inventory, 'u' to update inventory. Otherwise, catalog menu will display.");
                String input = reader.readLine();
                if (input.toLowerCase().equals("i")) {
                    System.out.println("Type 'p' to view inventory sorted by price. Otherwise, results will be sorted by manufacturer.");
                    input = reader.readLine();
                    if (input.toLowerCase().equals("p"))
                        sortBy = "p";
                    else
                        sortBy = "m";
                    printInventory(sortBy);
                } else if (input.toLowerCase().equals("u")) {
                    InventoryManager inventoryManagement = new InventoryManager();
                    inventoryManagement.doInventory();
                } else {
                    break;
                }
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    public int getInventoryIndex() {
        return tempAutoIndex;
    }


}
