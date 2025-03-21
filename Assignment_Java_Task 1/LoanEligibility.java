import java.sql.SQLOutput;
import java.util.*;
public class LoanEligibility {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your credit your Credit Score: ");
        int credit_score=sc.nextInt();
        System.out.print("Enter your income: ");
        double income=sc.nextDouble();
        if(credit_score >= 700 && income >= 50000){
            System.out.println("Congratulations! You are eligible for the loan");
        }
        else{
            System.out.println("Sorry! You are not eligible for the loan");
        }
    }
}
