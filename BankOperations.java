public interface BankOperations {
    void deposit(double amount);
    void withdraw(double amount) throws OverdraftLimitExceededException;
    String getAccountDetails();
}