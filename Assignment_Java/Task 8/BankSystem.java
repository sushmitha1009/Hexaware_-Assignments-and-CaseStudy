package Bank;
import java.util.*;
public class BankSystem {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        Account account=null;
        System.out.println("Welcome to Bank System");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        System.out.println("Enter your choice: ");
        int choice=sc.nextInt();
        System.out.println("Enter Account Number");
        int accno=sc.nextInt();
        System.out.println("Enter your initial balance");
        float initbalance=sc.nextFloat();

        switch(choice){
            case 1:
                account=new SavingsAccount(accno,initbalance);
                System.out.println("Savings Account created successfully");
                break;
            case 2:
                account=new CurrentAccount(accno,"Current",initbalance);
                System.out.println("Current Account created successfully");
                break;
            default:
                System.out.println("Invalid choice. Exiting..");
        }
        //perform transactions (deposit, withdraw,calculateInterest)
        while(true){
            System.out.println("Banking Operations");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Calculate Interest");
            System.out.println("Enter your choice: ");
            int userchoice=sc.nextInt();
            switch(userchoice){
                case 1:
                    System.out.println("Enter amount to deposit");
                    float depo=sc.nextFloat();
                    account.deposit(depo);
                    System.out.println("Deposit Successful!. New Balance is: "+account.getAccountBalance());
                    break;
                case 2:
                    System.out.println("Enter amount to withdraw");
                    float widr=sc.nextFloat();
                    if(account.withdraw(widr)) {
                        System.out.println("Withdraw Successful!. New Balance is: " + account.getAccountBalance());
                    }
                    break;
                case 3://calculate interest only for savings account
                    if(account instanceof SavingsAccount){
                        account.calculateInterest();
                        System.out.println("Interese calculated successfully!. New Balance is:"+account.getAccountBalance());
                    }
                    else{
                        System.out.println("Interest calculation is not applicable for current account");
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Try Again!");
            }
        }
    }
}
