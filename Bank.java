import java.util.ArrayList;
import java.util.List;

/**
 * Bank class manages all customers and operations
 */
public class Bank {
    private String bankName;
    private List<Customer> customers;
    private List<Transaction> transactionHistory;

    /**
     * Constructor for Bank
     */
    public Bank(String bankName) {
        this.bankName = bankName;
        this.customers = new ArrayList<>();
        this.transactionHistory = new ArrayList<>();
    }

    /**
     * Register a new customer
     */
    public Customer registerCustomer(String customerId, String name, String email, String phoneNumber) {
        Customer customer = new Customer(customerId, name, email, phoneNumber);
        customers.add(customer);
        System.out.println("Customer " + name + " registered successfully.");
        return customer;
    }

    /**
     * Get customer by ID
     */
    public Customer getCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                return customer;
            }
        }
        System.out.println("Customer not found.");
        return null;
    }

    /**
     * Remove customer
     */
    public boolean removeCustomer(String customerId) {
        for (Customer customer : customers) {
            if (customer.getCustomerId().equals(customerId)) {
                customers.remove(customer);
                System.out.println("Customer " + customer.getName() + " removed.");
                return true;
            }
        }
        return false;
    }

    /**
     * Process deposit
     */
    public void processDeposit(String customerId, String accountNumber, double amount) {
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            Account account = customer.getAccount(accountNumber);
            if (account != null) {
                if (account.deposit(amount)) {
                    recordTransaction("DEPOSIT", accountNumber, amount);
                }
            } else {
                System.out.println("Account not found.");
            }
        }
    }

    /**
     * Process withdrawal
     */
    public void processWithdrawal(String customerId, String accountNumber, double amount) {
        Customer customer = getCustomer(customerId);
        if (customer != null) {
            Account account = customer.getAccount(accountNumber);
            if (account != null) {
                if (account.withdraw(amount)) {
                    recordTransaction("WITHDRAWAL", accountNumber, amount);
                }
            } else {
                System.out.println("Account not found.");
            }
        }
    }

    /**
     * Process transfer
     */
    public void processTransfer(String fromCustomerId, String fromAccountNumber,
                               String toCustomerId, String toAccountNumber, double amount) {
        Customer fromCustomer = getCustomer(fromCustomerId);
        Customer toCustomer = getCustomer(toCustomerId);

        if (fromCustomer != null && toCustomer != null) {
            Account fromAccount = fromCustomer.getAccount(fromAccountNumber);
            Account toAccount = toCustomer.getAccount(toAccountNumber);

            if (fromAccount != null && toAccount != null) {
                if (fromAccount.transfer(toAccount, amount)) {
                    recordTransaction("TRANSFER", fromAccountNumber + " to " + toAccountNumber, amount);
                }
            } else {
                System.out.println("One or both accounts not found.");
            }
        }
    }

    /**
     * Record transaction in history
     */
    private void recordTransaction(String type, String details, double amount) {
        Transaction transaction = new Transaction(type, details, amount);
        transactionHistory.add(transaction);
    }

    /**
     * Display transaction history
     */
    public void displayTransactionHistory() {
        System.out.println("\n=== Bank Transaction History ===");
        for (Transaction transaction : transactionHistory) {
            transaction.displayTransaction();
        }
        System.out.println("=================================");
    }

    /**
     * Display bank information
     */
    public void displayBankInfo() {
        System.out.println("\n=== Bank Information ===");
        System.out.println("Bank Name: " + bankName);
        System.out.println("Total Customers: " + customers.size());
        System.out.println("Total Transactions: " + transactionHistory.size());
        System.out.println("=========================");
    }

    /**
     * Get all customers
     */
    public List<Customer> getAllCustomers() {
        return customers;
    }
}