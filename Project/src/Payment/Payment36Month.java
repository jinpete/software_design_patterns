package Payment;

public class Payment36Month extends PaymentTerm {
    public Payment36Month() {
        name = "36-Month Financing";
        term = 36;
    }

    public void setCreditRating(String rating) {
        if (rating.equals("excellent")) {
            interestRate = 0.9;
        } else if (rating.equals("good")) {
            interestRate = 1.9;
        } else if (rating.equals("poor")) {
            interestRate = 3.9;
        } else {// average
            interestRate = 2.9;
        }
    }
}



