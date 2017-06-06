import AutomobileIterator.*;
import AutomobilePackage.*;
import Inventory.*;
import Payment.*;
import Sales.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UserInterface {
    private static String bodyType;
    private static ArrayList<String> tempAutoList;
    private static int tempAutoIndex;
    private static InventoryTracker inv = InventoryTracker.getInstance();
    private static ItemIterator inventoryIterator;// = inv.createIterator("p");
    private static double price;
    private static double downPayment;
    private static int creditRating;

    public static void main(String[] args) {
        String modelName;

        // new observer
        InventoryObserver inventoryObserver = new InventoryObserver(inv);

        setupInventory(); // default inventory setup
        selectMenu(); // ask what user wants to do
        getBodyTypeFromUser();
        modelName = getModelFromUser();
        Store autoStore = new AutoStore();
        Automobile automobile = autoStore.getAutomobile(modelName);

        printSelectedAutomobile(modelName);
        price = automobile.getPrice();

//        double downPayment = getDownPayment();
//        int creditRating = getCreditRating();

        getCreditDecision(price);

        int term = getPaymentTerm();

        PaymentPicker paymentPicker = new PaymentPicker();
        PaymentTerm paymentTerm = paymentPicker.pickPaymentTerm(price, downPayment, term, creditRating);

        System.out.println(paymentTerm);
        purchase();
    }

    private static void selectMenu() {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        String sortBy = "m";
        while(true) {
            try {
                System.out.println("Menu:\ntype 'i' to view inventory. Otherwise, catalog menu will display.");
                String input = reader.readLine();
                if (input.toLowerCase().equals("i")) {
                    System.out.println("Type 'p' to view inventory sorted by price. Otherwise, results will be sorted by manufacturer.");
                    input = reader.readLine();
                    if (input.toLowerCase().equals("p"))
                        sortBy = "p";
                    printInventory(sortBy);
                } else
                    break;
            }
            catch (IOException e) {
                System.out.println(e);
            }
        }
    }

    private static void printSelectedAutomobile(String modelName) {
        tempAutoIndex = tempAutoList.indexOf(modelName);
        System.out.println("You selected");
        System.out.println("Make      Model Name  Body Type   Model Year  Price     InStock");
        System.out.println("---------------------------------------------------------------");
        System.out.println(inv.getInventoryItem(tempAutoIndex));

    }

    private static void printInventory(String sortBy) {
        setupInventory(sortBy);
        System.out.println("Make      Model Name  Body Type   Model Year  Price     InStock");
        System.out.println("---------------------------------------------------------------");
        while(inventoryIterator.hasNext()) {
            InventoryItem inventoryItem = inventoryIterator.next();
            System.out.println(inventoryItem.toString());
            tempAutoList.add(inventoryItem.getModelName().toLowerCase());
        }
    }

    private static void setupInventory(String sortBy) {
        tempAutoList = new ArrayList<>();
        inventoryIterator = inv.createIterator(sortBy);
    }

    private static void setupInventory() {
        // default setup to initialize inventory and tempAutoList
        tempAutoList = new ArrayList<>();
        inventoryIterator = inv.createIterator("m");
        while(inventoryIterator.hasNext()) {
            InventoryItem inventoryItem = inventoryIterator.next();
            tempAutoList.add(inventoryItem.getModelName().toLowerCase());
        }
    }


    private static void getCreditDecision(double price) {
        creditRating = getCreditRating();
        while(true) {
            downPayment = getDownPayment();

            double loanAmount = price - downPayment;
            int creditDecision = 0; // 0: pending, 1:denied, 2:approved

            CreditApplication creditApplication = new CreditApplication(loanAmount, creditRating);
            creditDecision = creditApplication.applyForCredit();

            if (creditDecision == 1)
                System.out.println("Your credit application has been denied.  Please try again");
            else if (creditDecision == 2) {
                System.out.println("Congratulations! Your credit application has been approved.");
                break;
            }
//        while(true) {
//            if(creditApplication.applyForCredit() ==2)
//                break;

//        }
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

    private static int getCreditRating() {
        // returns credit rating entered by the user
        int credit = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            System.out.print("What is your credit score (default=650)? \n");
            String input = reader.readLine();
            if(!isInteger(input))
                input = "650";
            credit = Integer.parseInt(input);
        } catch (IOException e) {
            System.out.println(e) ;
        }
        return credit;
    }

    private static int getPaymentTerm() {
        int returnPaymentTerm = 60;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            System.out.print("Please choose a payment term in months (default=60):\n36\n48\n60\n72\n");
            String input = reader.readLine();
            if (input.isEmpty()) {
                input = "60";
            }
            if (Integer.parseInt(input) == 36 || Integer.parseInt(input) == 48 || Integer.parseInt(input) == 72) {
                returnPaymentTerm = Integer.parseInt(input);
            } else {
                returnPaymentTerm = 60;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return returnPaymentTerm;
    }

    private static double getDownPayment() {
        double returnDownPayment = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            System.out.print("Please choose a downpayment amount(default=0):\n");
            String input = reader.readLine();

            if(input.isEmpty()) {
                input = "0";
            }

            if (Integer.parseInt(input) > 0 && Integer.parseInt(input) < 50000) {
                returnDownPayment = Integer.parseInt(input);
            } else {
                returnDownPayment = 0;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return returnDownPayment;
    }

    private static void purchase() {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            // purchasing decision
            System.out.println("\nType 'b' to buy. Otherwise, transaction will be canceled. (default=buy):");
            String input = reader.readLine();
            if(input.isEmpty())
                input="b";

            if (input.toLowerCase().equals("b")) {
                inv.buyOne(tempAutoIndex);
                System.out.println(String.format("%n%nCongratulations! Enjoy your new %s %s!", inv.getManufacturer(tempAutoIndex), inv.getModelName(tempAutoIndex)));
            } else {
                System.out.println("Goodbye~");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        int length = str.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (str.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}