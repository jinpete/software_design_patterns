package Payment;

public class Payment48Month extends PaymentTerm {
    public Payment48Month() {
        name = "48-Month Financing";
        term = 48;
    }

    public void setCreditRating(String rating) {
        if (rating.equals("excellent")) {
            interestRate = 1.9;
        } else if (rating.equals("good")) {
            interestRate = 2.9;
        } else if (rating.equals("poor")) {
            interestRate = 4.9;
        } else {// average
            interestRate = 3.9;
        }
    }
}
