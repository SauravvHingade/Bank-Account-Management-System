import java.util.ArrayList;
import java.util.Scanner;

public class Bank{

    private ArrayList<BankAccount> accounts;
    public Bank() {
        accounts = new ArrayList<>();
    }


    public void addAccount(BankAccount account) {
        accounts.add(account);
        System.out.println("Account Created succesfully");
    }

    public void deposit(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("money deposited sucesfully");
        }
        else{
            System.out.println("account not exist");
        }
    }
    public void withdraw(int accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            try {
                account.withdraw(amount);
            } catch (OverdraftLimitExceededException e) {
               
                e.printStackTrace();
            }
        }
    }


    public BankAccount findAccount(int accountNumber) {
        // We'll implement the method body in the next steps
        for (BankAccount account : accounts) {
            if (account.getAccount_num() == accountNumber) {
                return account;
            }
        }
        return null;
    }


    public void updateAccount(int accountNumber, BankAccount updatedAccount) {
        boolean accountFound = false;

     for (BankAccount account : accounts) {
      if (account.getAccount_num() == accountNumber) {
        // Update the account details
        accountFound = true;
        break;
    }
}

if (!accountFound) {
    System.out.println("Account with account number " + accountNumber + " could not be located.");
}

   
    }

    public void removeAccount(int accountNumber) {
        boolean accountFound = false;
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getAccount_num() == accountNumber) {
                accounts.remove(i);
                System.out.println("The account with account number " + accountNumber + " has been closed.");
                accountFound = true;
                break;
            }
        }
        if (!accountFound) {
            System.out.println("The account with account number " + accountNumber + " could not be found.");
        }
    }


    public void transferFunds(int fromAccountNumber, int toAccountNumber, double amount) {
        BankAccount fromAccount = null;
        BankAccount toAccount = null;
        
        for (BankAccount account : accounts) {
            if (account.getAccount_num() == fromAccountNumber) {
                fromAccount = account;
            } else if (account.getAccount_num() == toAccountNumber) {
                toAccount = account;
            }
        }
        
        if (fromAccount != null && toAccount != null) {
            if (fromAccount.getAccount_bal() >= amount) {
                try {
                    fromAccount.withdraw(amount);
                } catch (OverdraftLimitExceededException e) {
                    
                    e.printStackTrace();
                }
                toAccount.deposit(amount);
                System.out.println("Successfully transferred " + amount + " from account " + fromAccountNumber + " to account " + toAccountNumber);
            } else {
                System.out.println("Insufficient funds in account " + fromAccountNumber);
            }
        } else {
            System.out.println("One or both account numbers are not found.");
        }
    }
    

    private void displayMenu() {
        System.out.println("Welcome to the Bank Management System!");
        System.out.println("Please choose an action:");
        System.out.println("1. Create an account");
        System.out.println("2. Deposit money");
        System.out.println("3. Withdraw money");
        System.out.println("4. Transfer funds");
        System.out.println("5. Generate reports");
        System.out.println("0. Exit");
    }

    public void startBankingSystem() {
    Scanner scanner = new Scanner(System.in);
    int userChoice;
    // int userChoice=scanner.nextInt();
    // scanner.close();

    do {
        displayMenu();
        System.out.print("Enter your choice: ");
        userChoice = scanner.nextInt();
        scanner.nextLine();


        switch (userChoice) {
            case 1:
                // Call method to create an account
                System.out.println("Enter account number :");
                int acc_num=scanner.nextInt();
                System.out.println("enter account balance :");
                double acc_bal=scanner.nextDouble();
                BankAccount bank=new BankAccount(acc_num,acc_bal);
                addAccount(bank);
                break;
            case 2:
            System.out.println("Enter account number :");
            int acc_num2=scanner.nextInt();
            System.out.println("enter account balance :");
            double acc_bal2=scanner.nextDouble();
            deposit(acc_num2, acc_bal2);
            

                break;
            case 3:
                // Call method to withdraw money
                System.out.println("Enter account number :");
                int acc_num3=scanner.nextInt();
                System.out.println("enter account balance :");
                double acc_bal3=scanner.nextDouble();
                withdraw(acc_num3, acc_bal3);;
                break;
            case 4:
                System.out.println("Enter sender's account number :");
                int send_acc=scanner.nextInt();
                System.out.println("Enter reciever's account number :");
                int rec_acc=scanner.nextInt();
                System.out.println("enter the amount you wants to transfer :");
                double balance=scanner.nextDouble();
                transferFunds(send_acc, rec_acc, balance);
                
                break;
            case 5:
                // Call method to generate reports
                generateAccountReport();
                break;
            case 0:
                System.out.println("Exiting the system. Goodbye!");
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        

       
    } while (userChoice != 0);



    

    
}


    public void generateAccountReport() {
        System.out.printf("%-15s %-15s %10s%n", "Account Number", "Account Type", "Balance");
        System.out.println("----------------------------------------------");
        for (BankAccount account : accounts) {
            int accountNumber = account.getAccount_num();
            String accountType = account.getClass().getSimpleName();
            double balance = account.getAccount_bal();
            System.out.printf("%-15d %-15s %10.2f%n", accountNumber, accountType, balance);
        }
    }


    public void displayAccountDetails(int accountNumber) {
        BankAccount account = findAccount(accountNumber);
        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account not found.");
        }
    }
    
    public static void main(String[] args) {
        Bank bank = new Bank();
        
        bank.startBankingSystem();


     
   }
}