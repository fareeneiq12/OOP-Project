/**
 * SavingsAccount class extends Account with interest earning capability
 */
public class SavingsAccount extends Account {
    private double interestRate;
    private double minimumBalance;

    /**
     * Constructor for SavingsAccount
     */
    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, 
                         double interestRate, double minimumBalance) {
        super(accountNumber, accountHolder, initialBalance, "Savings");
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    /**
     * Apply monthly interest
     */
    public void applyInterest() {
        if (getBalance() >= minimumBalance) {
            double interest = getBalance() * (interestRate / 100 / 12);
            deposit(interest);
            System.out.println("Interest applied: $" + String.format("%.2f", interest));
        } else {
            System.out.println("Minimum balance not met. No interest applied.");
        }
    }

    /**
     * Override withdraw to check minimum balance
     */
    @Override
    public boolean withdraw(double amount) {
        if (getBalance() - amount < minimumBalance) {
            System.out.println("Withdrawal would violate minimum balance requirement of $" + minimumBalance);
            return false;
        }
        return super.withdraw(amount);
    }

    /**
     * Get interest rate
     */
    public double getInterestRate() {
        return interestRate;
    }

    /**
     * Display savings account details
     */
    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance Required: $" + minimumBalance);
    }
}