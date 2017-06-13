package Inventory;

import AutomobileIterator.ItemIterator;
import Tools.*;
import java.io.*;
import java.util.*;


public class InventoryManagement {
//    private static ArrayList<String> tempAutoList;
//    private static int tempAutoIndex;
    private static InventoryTracker inventoryTracker = InventoryTracker.getTheInventoryTracker();
//    private static ItemIterator inventoryIterator;
    private static InventoryViewer inventoryViewer = InventoryViewer.getTheInventoryViewer();

    public static void main(String[] args) {
        doInventory();
    }

    private static void doInventory() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        inventoryViewer.printInventory("m");

        while (true) {
            try {
                System.out.println("Select the Row number to perform inventory('q' to quit):");
                String input = reader.readLine();
                if (input.toLowerCase().equals("q"))
                    break;
                if (Toolbox.isInteger(input)) {
                    inventoryViewer.setInventoryIndexNum(Integer.parseInt(input) - 1); // row number starts with 1 -> offset 1 for 0-based index
                    System.out.println("Enter number of units to add to inventory:");
                    try {
                        input = reader.readLine();
                        if (Tools.Toolbox.isInteger(input)) {
                            inventoryTracker.add(inventoryViewer.getInventoryIndex(), Integer.parseInt(input));
                            inventoryViewer.printInventory("m");

                        } else
                            System.out.println("Please enter a valid integer");

                    } catch (IOException e) {
                        System.out.println(e);
                    }
                } else
                    System.out.println("Please enter a valid integer");
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
