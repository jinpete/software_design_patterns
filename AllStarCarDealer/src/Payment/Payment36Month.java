package Payment;

public class Payment36Month extends PaymentTerm {
    public Payment36Month() {
        name = "36-Month Financing";
        term = 36;
    }

    public void setInterestRate(int rating) {
        if (rating >= EXCELLENT_CREDIT) {
            interestRate = 0.9;
        } else if (rating >= GOOD_CREDIT) {
            interestRate = 1.9;
        } else if (rating >= FAIR_CREDIT) {
            interestRate = 2.9;
        } else {// poor credit < 640
            interestRate = 3.9;
        }
    }
}



