package Payment;

public class Payment72Month extends PaymentTerm {
    public Payment72Month() {
        name = "72-Month Financing";
        term = 72;
    }

    public void setInterestRate(int rating) {
        if (rating >= EXCELLENT_CREDIT) {
            interestRate = 3.9;
        } else if (rating >= GOOD_CREDIT) {
            interestRate = 4.9;
        } else if (rating >= FAIR_CREDIT) {
            interestRate = 5.9;
        } else {// poor credit < 640
            interestRate = 6.9;
        }
    }
}
