package Payment;

public class Payment60Month extends PaymentTerm {
    public Payment60Month() {
        name = "60-Month Financing";
        term = 60;
    }

    public void setInterestRate(int rating) {
        if (rating >= EXCELLENT_CREDIT) {
            interestRate = 2.9;
        } else if (rating >= GOOD_CREDIT) {
            interestRate = 3.9;
        } else if (rating >= FAIR_CREDIT) {
            interestRate = 4.9;
        } else {// poor credit < 640
            interestRate = 5.9;
        }
    }
}