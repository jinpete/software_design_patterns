package Payment;

public abstract class PaymentTerm {
    String name;
    double price;
    double downPayment;
    double loanAmount;
    double interestRate;
    double monthlyPayment;
    int term;


    final int FAIR_CREDIT = 640;
    final int GOOD_CREDIT = 680;
    final int EXCELLENT_CREDIT = 720;

    public PaymentTerm() {

    }

    public abstract void setInterestRate(int creditRating);

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

    public void setMonthlyPayment() {
        loanAmount = price - downPayment;
        double rate = interestRate / 1200;
        double compoundInterest = getCompoundInterest(rate);
        monthlyPayment = loanAmount * rate * compoundInterest / (compoundInterest - 1);
    }

    private double getCompoundInterest(double rate) {
        return Math.pow(1 + rate, term);
    }


    public String toString() {
        StringBuffer display = new StringBuffer();
        display.append("---- " + name + " ----\n");
        display.append(String.format("\nPrice: $%.2f", price ));
        display.append(String.format("\nDownpayment: $%.2f", downPayment ));
        display.append(String.format("\nLoan Amount: $%.2f", loanAmount ));
        display.append(String.format("\nInterest Rate: %.2f%%", interestRate ));
        display.append(String.format("\nMonthly Payment: $%.2f", monthlyPayment ));

        return display.toString();
    }
}
/*
EMI = ( P × r × (1+r)n ) / ((1+r)n − 1)
Where
   EMI = Equated Monthly Installment
   P = Loan Amount - Down payment
   r = Annual Interest rate / 1200
   n = Term (Period or no.of year or months for loan repayment.)
 */