public class CheckAccount extends BankAccount{

    CheckAccount(int acc_num,double acc_bal){
        super(acc_num,acc_bal);
    }
        
    private int transaction_count;
    private int freetrans_limit=3;
    private double overdraftLimit = 500;

    public void deposit(double amount){
        super.deposit(amount);
        transaction_count++;
        
    }
    public void withdraw(double amount) throws OverdraftLimitExceededException {
        if (amount <= getAccount_bal()) {
            setAccount_bal(getAccount_bal() - amount);
        } else if (amount <= getAccount_bal() + overdraftLimit) {
            overdraftLimit -= (amount - getAccount_bal());
            setAccount_bal(0);
            System.out.println("Overdraft protection used. Remaining overdraft limit: " + overdraftLimit);
        } else {
            throw new OverdraftLimitExceededException("Withdrawal not allowed. Overdraft limit exceeded.");
        }
      
    }

    public void appytransaction_fee(double feePerTransaction){
        int TransactionTocharge=transaction_count-freetrans_limit;
        if(TransactionTocharge>0){
            double fees=TransactionTocharge*feePerTransaction;
           try {
            super.withdraw(fees);
        } catch (OverdraftLimitExceededException e) {
            
            e.printStackTrace();
        }
        }

        transaction_count=0;
    }

    public boolean IfCanWithdraw(double amount) {
        if (amount <= getAccount_bal()+overdraftLimit) {
            setAccount_bal(getAccount_bal() - amount);
            return true;
        } else {
            return false;
        }
    }

    public boolean IfCandeposit(double amount) {
        setAccount_bal(getAccount_bal()  + amount);
    return true;
    }
}
