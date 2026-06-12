import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Transaction class records bank transactions
 */
public class Transaction {
    private String transactionId;
    private String transactionType;
    private String details;
    private double amount;
    private LocalDateTime timestamp;
    private static int transactionCounter = 1000;

    /**
     * Constructor for Transaction
     */
    public Transaction(String transactionType, String details, double amount) {
        this.transactionId = "TXN" + (++transactionCounter);
        this.transactionType = transactionType;
        this.details = details;
        this.amount = amount;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Get transaction ID
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Get transaction type
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Get transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Get transaction timestamp
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * Display transaction details
     */
    public void displayTransaction() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("Transaction ID: " + transactionId + " | Type: " + transactionType +
                         " | Amount: $" + String.format("%.2f", amount) +
                         " | Time: " + timestamp.format(formatter) +
                         " | Details: " + details);
    }
}