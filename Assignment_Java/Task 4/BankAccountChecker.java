import java.sql.SQLOutput;
import java.util.*;
public class BankAccountChecker {
    public static void main(String[] args){
        int AccountNumber[]={1234,2345,3456,4567};
        double balances[]={1500.00,2000.00,300.00,4500.00};
        Scanner sc=new Scanner(System.in);
        System.out.println("Please Enter Your PIN Number:");
        int pinNumber=sc.nextInt();
        boolean flag=false;
        for(int i=0;i<AccountNumber.length;i++){
            if(pinNumber==AccountNumber[i]){
                System.out.println("Your Account Balance is:"+balances[i]);
                flag=true;
            }
        }
        if(!flag){
            System.out.println("Sorry! Invalid PIN Number. Please try again!");
        }
    }
}
