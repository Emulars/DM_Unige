//The BankAccount class represents a bank account with an account number, balance, customer name, email, and phone number.
public class BankAccount {
    private String accountNumber; // The account number of the bank account
    private double balance; // The balance of the bank account
    private String customerName; // The name of the customer
    private String email; // The email of the customer
    private String phoneNumber; // The phone number of the customer

    /**
     * Constructs a BankAccount object with the specified account number, balance, customer name, email, and phone number.
     *
     * @param accountNumber the account number of the bank account
     * @param balance the balance of the bank account
     * @param customerName the name of the customer
     * @param email the email of the customer
     * @param phoneNumber the phone number of the customer
     */
    public BankAccount(String accountNumber, double balance, String customerName, String email, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerName = customerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Returns the account number of the bank account.
     *
     * @return the account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Returns the balance of the bank account.
     *
     * @return the balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Returns the name of the customer.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns the email of the customer.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Returns the phone number of the customer.
     *
     * @return the phone number
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Deposits the specified amount into the bank account.
     *
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance += amount;
    }

    /**
     * Withdraws the specified amount from the bank account.
     * If the amount is greater than the balance, an "Insufficient funds" message is printed.
     *
     * @param amount the amount to withdraw
     * @throws IllegalArgumentException if the amount is greater than the balance
     */
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient funds");
        }
    }
}