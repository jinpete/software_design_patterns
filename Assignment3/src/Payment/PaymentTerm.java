package Payment;

public abstract class PaymentTerm {
    String name;
    double price;
    double downPayment;
    double loanAmount;
    int term;
    double interestRate;
    double monthlyPayment;

    public abstract void setCreditRating(String rating);

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDownPayment(double downPayment) {
        this.downPayment = downPayment;
    }

//    public void setTerm(int term) {
//        this.term = term;
//    }
//
//    public void setInterestRate(double interestRate) {
//        this.interestRate = interestRate;
//    }

    public void setMonthlyPayment() {
        loanAmount = price - downPayment;
        double rate = getRate();
        double compoundInterest = getCompoundInterest();
        monthlyPayment = loanAmount * rate * compoundInterest / (compoundInterest - 1);
    }

    private double getRate() {
        return interestRate / 1200;
    }

    private double getCompoundInterest() {
        return Math.pow(1 + getRate(), term);
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