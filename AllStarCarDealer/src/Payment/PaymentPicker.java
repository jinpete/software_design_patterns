package Payment;

public class PaymentPicker {

    public PaymentTerm createPaymentTerm(int term) {
        if (term == 36) {
            return new Payment36Month();
        } else if (term == 48) {
            return new Payment48Month();
        } else if (term == 60) {
            return new Payment60Month();
        } else if (term == 72) {
            return new Payment72Month();
        }
        else return null;
    }

    public PaymentTerm pickPaymentTerm(double price, double downPayment, int term, int creditRating) {
        PaymentTerm paymentTerm = createPaymentTerm(term);
        paymentTerm.setPrice(price);
        paymentTerm.setDownPayment(downPayment);
        paymentTerm.setInterestRate(creditRating);
        paymentTerm.setMonthlyPayment();

        return paymentTerm;
    }

}
