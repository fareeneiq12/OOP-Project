import java.util.ArrayList;
import java.util.List;

/**
 * Customer class represents a bank customer
 */
public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Account> accounts;

    /**
     * Constructor for Customer
     */
    public Customer(String customerId, String name, String email, String phoneNumber) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.accounts = new ArrayList<>();
    }

    /**
     * Add account to customer
     */
    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account " + account.getAccountNumber() + " added to customer " + name);
    }

    /**
     * Remove account from customer
     */
    public boolean removeAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                accounts.remove(account);
                System.out.println("Account " + accountNumber + " removed.");
                return true;
            }
        }
        System.out.println("Account not found.");
        return false;
    }

    /**
     * Get account by account number
     */
    public Account getAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    /**
     * Get all accounts for customer
     */
    public List<Account> getAllAccounts() {
        return accounts;
    }

    /**
     * Get customer ID
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Get customer name
     */
    public String getName() {
        return name;
    }

    /**
     * Get customer email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Update email
     */
    public void setEmail(String email) {
        this.email = email;
        System.out.println("Email updated to: " + email);
    }

    /**
     * Update phone number
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        System.out.println("Phone number updated to: " + phoneNumber);
    }

    /**
     * Display customer information
     */
    public void displayCustomerInfo() {
        System.out.println("\n=== Customer Information ===");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phoneNumber);
        System.out.println("Number of Accounts: " + accounts.size());
        System.out.println("=============================");
    }

    /**
     * Display all accounts for customer
     */
    public void displayAllAccounts() {
        displayCustomerInfo();
        for (Account account : accounts) {
            account.displayAccountDetails();
        }
    }
}