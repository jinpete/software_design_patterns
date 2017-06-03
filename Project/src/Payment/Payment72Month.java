package Payment;

public class Payment72Month extends PaymentTerm {
    public Payment72Month() {
        name = "72-Month Financing";
        term = 72;
    }

    public void setCreditRating(String rating) {
        if (rating.equals("excellent")) {
            interestRate = 3.9;
        } else if (rating.equals("good")) {
            interestRate = 4.9;
        } else if (rating.equals("poor")) {
            interestRate = 6.9;
        } else {// average
            interestRate = 5.9;
        }
    }
}
