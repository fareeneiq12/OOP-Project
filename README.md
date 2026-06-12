# Banking Management System

A comprehensive Object-Oriented Programming (OOP) project implementing a complete banking management system in Java.

## Features

### 1. **Customer Management**
- Register new customers
- Store customer information (ID, name, email, phone)
- Update customer details
- Manage multiple accounts per customer

### 2. **Account Types**
- **Basic Account**: Standard checking/savings functionality
- **Savings Account**: 
  - Interest earning on balance above minimum threshold
  - Monthly interest calculation
  - Minimum balance requirement
- **Checking Account**: 
  - Overdraft protection
  - Transaction fee system (charges after 10 free transactions)
  - Monthly maintenance fees

### 3. **Banking Operations**
- Deposit money
- Withdraw money
- Transfer between accounts
- View account balance
- View account details
- View transaction history

### 4. **Transaction Tracking**
- All transactions are recorded with:
  - Unique transaction ID
  - Transaction type (Deposit, Withdrawal, Transfer)
  - Amount
  - Timestamp
  - Transaction details

## Class Structure

### Core Classes:

1. **Account.java**
   - Base class for all account types
   - Methods: deposit(), withdraw(), transfer(), getBalance()
   - Properties: accountNumber, accountHolder, balance, accountType

2. **SavingsAccount.java** (extends Account)
   - Interest earning functionality
   - Minimum balance enforcement
   - Monthly interest application

3. **CheckingAccount.java** (extends Account)
   - Overdraft protection
   - Transaction fee management
   - Monthly maintenance fees

4. **Customer.java**
   - Customer information management
   - Multiple account management
   - Account lookup functionality

5. **Bank.java**
   - Central bank management system
   - Customer registration
   - Transaction processing
   - Transaction history tracking

6. **Transaction.java**
   - Transaction record storage
   - Timestamp tracking
   - Auto-generated transaction IDs

7. **BankingManagementSystem.java**
   - Main application class
   - Interactive command-line menu
   - User interface and navigation

## How to Run

### Compilation:
```bash
javac *.java
```

### Execution:
```bash
java BankingManagementSystem
```

## Usage Example

```
===== BANKING MANAGEMENT SYSTEM =====
1. Register New Customer
2. Login as Customer
3. View Bank Information
4. View Transaction History
5. Exit
Choose an option: 1

Enter Customer ID: CUST001
Enter Name: John Doe
Enter Email: john@email.com
Enter Phone Number: 555-1234
Customer John Doe registered successfully.

===== CUSTOMER MENU =====
1. Create New Account
2. View Account Details
3. Deposit Money
4. Withdraw Money
5. Transfer Money
6. View All Accounts
7. Logout
Choose an option: 1

Enter Account Number: ACC001
Enter Initial Balance: 5000
Account Type:
1. Savings Account
2. Checking Account
Choose account type: 1
Enter Interest Rate (%): 4.5
Enter Minimum Balance: 1000
Account ACC001 added to customer John Doe
```

## OOP Concepts Implemented

1. **Encapsulation**: Private data members with public getters/setters
2. **Inheritance**: SavingsAccount and CheckingAccount extend Account
3. **Polymorphism**: Method overriding (withdraw, display methods)
4. **Abstraction**: Complex banking operations hidden behind simple interfaces
5. **Collections**: ArrayList used for managing customers, accounts, and transactions

## Features to Extend

- Loan management system
- Credit card integration
- Bill payment system
- Mobile/Online banking interface
- Security and authentication
- Database persistence
- Transaction reports and analytics
- Email notifications

## Author
Developed as an OOP practice project

## License
Open Source
