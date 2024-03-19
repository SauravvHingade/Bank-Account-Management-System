public class BusinessAccount extends BankAccount {

    public double calculateAccountFees() {
        return 10.0; // A flat fee of $10 for every transaction
    }

    public BusinessAccount(int accountNumber, double accountBalance) {
        super(accountNumber, accountBalance);
    }


    public String toString() {
        return "Business Account - Account Number: " + getAccount_num() + ", Account Balance: $" + getAccount_bal();
    }
}