//import AutomobileIterator.*;
import AutomobilePackage.*;
import Inventory.*;
//import Payment.*;
import Sales.*;

import java.io.*;
import java.util.*;

public class UserInterface {
    private static String bodyType;
    private static InventoryTracker inventoryTracker = InventoryTracker.getTheInventoryTracker(); // singleton inventory tracker
    private static InventoryViewer inventoryViewer = InventoryViewer.getTheInventoryViewer(); // singleton inventory viewer
    private static double price;

    public static void main(String[] args) {
        String modelName;

        // instantiate inventory observer
        InventoryObserver inventoryObserver = new InventoryObserver(inventoryTracker);

        inventoryViewer.selectMenu(); // ask what user wants to do
        getBodyTypeFromUser();
        modelName = getModelFromUser();
        Store autoStore = new AutoStore();
        Automobile automobile = autoStore.getAutomobile(modelName);

        inventoryViewer.printSelectedAutomobile(modelName);
        price = automobile.getPrice(); // get default price

        SalesTransaction salesTransaction = new SalesTransaction(price);
        salesTransaction.beginTransaction();
    }

    private static String getModelFromUser() {
        String returnModelName = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        ArrayList<String> modelArrayList = new ArrayList<>();
        modelArrayList = getModelList(bodyType);
        try {
            // Display a list of body types
            System.out.print(String.format("Please choose a model (default=%s):%n",modelArrayList.get(0) ));
            for(int i = 0; i < modelArrayList.size(); i++)
                System.out.println(modelArrayList.get(i));
            String input = reader.readLine();

            returnModelName = modelArrayList.contains(input.toLowerCase()) ? input.toLowerCase() : modelArrayList.get(0);
        } catch (IOException e) {
            System.out.println(e);
        }
        return returnModelName;
    }

    private static void getBodyTypeFromUser() {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            // Display a list of body types
            System.out.print("Please choose a body type(default=sedan):\nsedan\nsuv\ntruck\nminivan\n");
            String input = reader.readLine();

            if (input.toLowerCase().equals("suv") || input.toLowerCase().equals("truck") || input.toLowerCase().equals("minivan")) {
                bodyType = input.toLowerCase();
            } else {
                bodyType = "sedan";
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static ArrayList<String> getModelList(String bodyType) {
        ArrayList<String> returnModelList = new ArrayList<>();

        if(bodyType.equals("sedan")) {
            returnModelList.add("accord");
            returnModelList.add("fusion");
            returnModelList.add("camry");
        } else if (bodyType.equals("suv")) {
            returnModelList.add("explorer");
            returnModelList.add("highlander");
            returnModelList.add("pilot");
        } else if (bodyType.equals("truck")) {
            returnModelList.add("f150");
            returnModelList.add("tundra");
            returnModelList.add("ridgeline");
        } else if (bodyType.equals("minivan")) {
            returnModelList.add("odyssey");
            returnModelList.add("sienna");
        }
        return returnModelList;
    }
}