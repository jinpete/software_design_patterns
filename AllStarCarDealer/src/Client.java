import AutomobilePackage.AutoStore;
import AutomobilePackage.Automobile;
import AutomobilePackage.Store;
import Payment.PaymentPicker;
import Payment.PaymentTerm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Client {
    private static String bodyType;

    public static void main(String[] args) {
        String modelName;

        getBodyTypeFromUser();

        modelName = getModelFromUser();
        Store autoStore = new AutoStore();
        Automobile automobile = autoStore.getAutomobile(modelName);

        System.out.println("You selected\n\n" + automobile +"\n");

        double price = automobile.getPrice();
        double downPayment = 0;
        int term = 60;
        String creditRating = "average";

        term = getPaymentTerm();
        downPayment = getDownPayment();

        PaymentPicker paymentPicker = new PaymentPicker();
        PaymentTerm paymentTerm = paymentPicker.pickPaymentTerm(price, downPayment, term, creditRating);

        System.out.println(paymentTerm);
        purchase();

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

    public static void getBodyTypeFromUser() {
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

    public static ArrayList<String> getModelList(String bodyType) {
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

    public static int getPaymentTerm() {
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

    public static double getDownPayment() {
        double returnDownPayment = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            System.out.print("Please choose a downpayment amount(default=0):");
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

    public static void purchase() {
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            // purchasing decision
            System.out.println("Accords in stock: 5");
            System.out.print("\nWhat would you like to do?(default=buy):\nbuy\ncancel\n");
            String input = reader.readLine();

            if (input.toLowerCase().equals("buy")) {
                System.out.println("Updated inventory: Accords in stock: 4");
            } else {
                System.out.println("Goodbye~");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }


//    public void purchaseMade(HondaInventory hondaInventory, int qty) {
//        hondaInventory.addInventory(-1);
//    }
}