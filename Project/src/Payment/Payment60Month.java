package Payment;

public class Payment60Month extends PaymentTerm {
    public Payment60Month() {
        name = "60-Month Financing";
        term = 60;
    }

    public void setCreditRating(String rating) {
        if (rating.equals("excellent")) {
            interestRate = 2.9;
        } else if (rating.equals("good")) {
            interestRate = 3.9;
        } else if (rating.equals("poor")) {
            interestRate = 5.9;
        } else {// average
            interestRate = 4.9;
        }
    }
}
