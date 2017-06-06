package Payment;

public class Payment48Month extends PaymentTerm {
    public Payment48Month() {
        name = "48-Month Financing";
        term = 48;
    }

    public void setInterestRate(int rating) {
        if (rating >= EXCELLENT_CREDIT) {
            interestRate = 1.9;
        } else if (rating >= GOOD_CREDIT) {
            interestRate = 2.9;
        } else if (rating >= FAIR_CREDIT) {
            interestRate = 3.9;
        } else {// poor credit < 640
            interestRate = 4.9;
        }
    }
}
