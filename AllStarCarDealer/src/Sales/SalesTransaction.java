package Sales;

import Inventory.InventoryTracker;
import Inventory.InventoryViewer;
import Payment.PaymentPicker;
import Payment.PaymentTerm;
import Tools.Toolbox;

import java.io.*;

public class SalesTransaction {

    private InventoryTracker inventoryTracker = InventoryTracker.getTheInventoryTracker();
    private InventoryViewer inventoryViewer = InventoryViewer.getTheInventoryViewer();
    private double price;
    private double downPayment;
    private int creditRating;

    public SalesTransaction(double price) {
        this.price = price;
    }

    public boolean beginTransaction() {
        getCreditDecision(price);
        getPaymentTerm();
        return purchase();
    }

    private void getCreditDecision(double price) {
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
        }
    }

    private double getDownPayment() {
        double returnDownPayment = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            System.out.print("Please choose a down payment amount(default=0):\n");
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

    public int getCreditRating() {
        // returns credit rating entered by the user
        int credit = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            System.out.print("What is your credit score (default=650)? \n");
            String input = reader.readLine();
            if(!Toolbox.isInteger(input))
                input = "650";
            credit = Integer.parseInt(input);
        } catch (IOException e) {
            System.out.println(e) ;
        }
        return credit;
    }

    public void getPaymentTerm() {
        int term = 60;
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));

        try {
            System.out.print("Please choose a payment term in months (default=60):\n36\n48\n60\n72\n");
            String input = reader.readLine();
            if (input.isEmpty()) {
                input = "60";
            }
            if (Integer.parseInt(input) == 36 || Integer.parseInt(input) == 48 || Integer.parseInt(input) == 72) {
                term = Integer.parseInt(input);
            } else {
                term = 60;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        PaymentPicker paymentPicker = new PaymentPicker();
        PaymentTerm paymentTerm = paymentPicker.pickPaymentTerm(price, downPayment, term, creditRating);
        System.out.println(paymentTerm);
    }


    public boolean purchase() {

        int autoIndex = inventoryViewer.getInventoryIndex();
        BufferedReader reader = new BufferedReader(new InputStreamReader( System.in));
        boolean returnContinue = false;
        try {
            // purchasing decision
            System.out.println("\nType 'b' to buy. Otherwise, transaction will be canceled. (default=b):");
            String input = reader.readLine();
            if(input.isEmpty())
                input="b";

            if (input.toLowerCase().equals("b")) {
                inventoryTracker.purchaseItem(autoIndex);
                System.out.println(String.format("%n%nCongratulations! Enjoy your new %s %s!", inventoryTracker.getManufacturer(autoIndex), inventoryTracker.getModelName(autoIndex)));
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        try {
            System.out.println("\nType 'q' to quit. Otherwise, main menu will display:");
            String input = reader.readLine();
            if (input.toLowerCase().equals("q")) {
                returnContinue = false;
            } else {
                returnContinue = true;
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return returnContinue;
    }
}
