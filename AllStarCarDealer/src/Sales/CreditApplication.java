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
        if (creditRating < 640 && loanAmount > 21000) {
            System.out.println("Your credit rating allows you to borrow upto $21,000.  Please try again.");
        } else if (creditRating < 680 && loanAmount > 25000) {
            System.out.println("Your credit rating allows you to borrow upto $25,000.  Please try again.");
        } else if (creditRating < 720 && loanAmount > 28000) {
            System.out.println("Your credit rating allows you to borrow upto $28,000.  Please try again.");
        } else {
            state = CREDIT_APPROVED;
        }
        return state;
    }
}
