
public class BankAccount implements BankOperations{
     static int Account_num;
     static double Account_bal;

    public BankAccount() {
        Account_bal = 0;
    }

    public BankAccount(int Account_numb, double initial_bal) {
        Account_num = Account_numb;
        Account_bal = initial_bal;
    }

    public double getAccount_bal() {
        return Account_bal;
    }

    public void setAccount_bal(double newBal) {
        Account_bal = newBal;
    }

    public int getAccount_num() {
        return Account_num;
    }

   
    

    public void setAccount_num(int newNum) {
        Account_num = newNum;
    }

    public void deposit(double amount) {
        Account_bal += amount;
    }

    public void withdraw(double amount) throws OverdraftLimitExceededException {
        if (Account_bal >= amount) {
            Account_bal -= amount;
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public String Account_details() {
        return "Account Number: " + Account_num + "\n" + "Account Balance: $" + Account_bal;
    }
    public String getAccountDetails() {
        return "Account Number: " + Account_num + "\n" + "Account Balance: $" + Account_bal;
    }

}