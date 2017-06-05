package Sales;

public class CreditApplication {
    /* state for sales transaction
    *
    * */
    private final static int CREDIT_PENDING = 0;
    private final static int CREDIT_DENIED = 1;
    private final static int CREDIT_APPROVED = 2;

    int state = CREDIT_PENDING;
    double loanAmount = 0;
    int creditRating = 600;
    public CreditApplication(double loanAmount, int creditRating) {
        this.loanAmount = loanAmount;
        this.creditRating = creditRating;
    }

    public int applyForCredit() {
        /*  credit rating
            poor < 640
            average < 680
            good < 720
            excellent >= 720
         */
        state = CREDIT_DENIED;
        if (creditRating < 640 && loanAmount >= 21000) {
            System.out.println("Your credit rating allows you to borrow less than $21,000.  Please try again.");
        } else if (creditRating < 680 && loanAmount >= 25000) {
            System.out.println("Your credit rating allows you to borrow less than $25,000.  Please try again.");
        } else if (creditRating < 720 && loanAmount >= 28000) {
            System.out.println("Your credit rating allows you to borrow less than $28,000.  Please try again.");
        } else {
            state = CREDIT_APPROVED;
        }
        return state;
    }

    public int getState() {
        return state;
    }

    public void setLoanAmount(double loanAmount) {
        /* if credit was denied, allow user to adjust loan amount.
            In order to reapply for loan, new loan amount must be less than previously requested loan amount.
         */
        if (state == CREDIT_DENIED) {
            if (loanAmount >= this.loanAmount)
                System.out.println("New loan amount must be greater than previous loan amount.");
            else
                this.loanAmount = loanAmount;
        } else if (state == CREDIT_APPROVED) {
            System.out.println("Your application was already approved for the amount of " + loanAmount);
        }
    }
}
