package Payment;

public class PaymentTester {
    public static void main(String[] args) {
        double price;
        double downPayment;
        String creditRating = "average";

        // get these from user input
        int term = 60;
        price = 31999;
        downPayment = 0;

        PaymentPicker paymentPicker = new PaymentPicker();
        PaymentTerm paymentTerm = paymentPicker.pickPaymentTerm(price, downPayment, term, creditRating);

        System.out.println(paymentTerm);
    }
}
