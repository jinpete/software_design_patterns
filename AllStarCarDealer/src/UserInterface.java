import AutomobilePackage.*;
import Inventory.*;
import Sales.*;

import java.io.*;
import java.util.*;

public class UserInterface {
    private static String bodyType;
    private static InventoryTracker inventoryTracker = InventoryTracker.getTheInventoryTracker(); // singleton inventory tracker
    private static InventoryViewer inventoryViewer = InventoryViewer.getTheInventoryViewer(); // singleton inventory viewer
//    private static double price;

    public static void main(String[] args) {
        String modelName;
        double price;
        Automobile automobile;
        // instantiate inventory observer
        InventoryObserver inventoryObserver = new InventoryObserver(inventoryTracker);

        while (true) {
            inventoryViewer.selectMenu(); // ask what user wants to do
            while(true) {
                getBodyTypeFromUser();
                modelName = getModelFromUser();
                Store autoStore = new AutoStore();
                automobile = autoStore.getAutomobile(modelName);

                if(inventoryViewer.printSelectedAutomobile(modelName))
                    break;
            }
            price = automobile.getPrice(); // get default price

            SalesTransaction salesTransaction = new SalesTransaction(price);
            boolean continueProgram = salesTransaction.beginTransaction();
            if (!continueProgram) break;
        }
    }

    private static String getModelFromUser() {
        String returnModelName = null;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        ArrayList<String> modelArrayList = new ArrayList<>();
        modelArrayList = getModelList(bodyType);
        try {
            // Display a list of body types
            System.out.print(String.format("Please choose a model (default=%s):%n",modelArrayList.get(0) ));
            for (String aModelArrayList : modelArrayList)
                System.out.println(aModelArrayList);
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