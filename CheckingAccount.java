/**
 * CheckingAccount class extends Account with overdraft protection
 */
public class CheckingAccount extends Account {
    private double overdraftLimit;
    private double monthlyFee;
    private int transactionCount;
    private int freeTransactions;

    /**
     * Constructor for CheckingAccount
     */
    public CheckingAccount(String accountNumber, String accountHolder, double initialBalance,
                          double overdraftLimit, double monthlyFee) {
        super(accountNumber, accountHolder, initialBalance, "Checking");
        this.overdraftLimit = overdraftLimit;
        this.monthlyFee = monthlyFee;
        this.transactionCount = 0;
        this.freeTransactions = 10;
    }

    /**
     * Override withdraw to include overdraft protection
     */
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (getBalance() + overdraftLimit >= amount) {
            super.withdraw(amount);
            transactionCount++;
            checkTransactionFee();
            return true;
        } else {
            System.out.println("Withdrawal exceeds overdraft limit.");
            return false;
        }
    }

    /**
     * Check and apply transaction fees
     */
    private void checkTransactionFee() {
        if (transactionCount > freeTransactions) {
            double fee = 2.50;
            super.withdraw(fee);
            System.out.println("Transaction fee applied: $" + fee);
        }
    }

    /**
     * Apply monthly maintenance fee
     */
    public void applyMonthlyFee() {
        super.withdraw(monthlyFee);
        System.out.println("Monthly maintenance fee applied: $" + monthlyFee);
        transactionCount = 0;
    }

    /**
     * Display checking account details
     */
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: $" + overdraftLimit);
        System.out.println("Monthly Fee: $" + monthlyFee);
        System.out.println("Transactions this month: " + transactionCount);
    }
}