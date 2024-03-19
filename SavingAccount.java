public class SavingAccount extends BankAccount{
    double interest_rate;
    SavingAccount(int acc_num,double acc_bal,double interest_rate){
        super(acc_num,acc_bal);
        this.interest_rate=interest_rate;
    }
    public String Account_details(){
        return super.Account_details()+"\n"+"Interest Rate : "+"%"+interest_rate;
    }

    public void earnInterest(){
        double Interest=this.interest_rate*getAccount_bal();
        double Account_bal=getAccount_bal()+Interest;
        setAccount_bal(Account_bal);
        System.out.println("Balance after earning interest : "+getAccount_bal());

    }

    public boolean IfCanWithdraw(double amount) {
        if (amount <= getAccount_bal()) {
            setAccount_bal(getAccount_bal() - amount);
            return true;
        } else {
            return false;
        }
    }


    public boolean IfCaneposit(double amount) {
        double interestEarned = amount * interest_rate;
        setAccount_bal(getAccount_bal() + amount + interestEarned);
        return true;
    }
    


}
