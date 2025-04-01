import java.util.*;
public class BankTransactions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean validtransaction = true;
        ArrayList<String> tr=new ArrayList<>();
        while (validtransaction) {
            System.out.println("Enter your choice:");
            System.out.println("Bank Transaction Menu:");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Transactions");
            System.out.println("4.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the amount for deposit");
                    double deposit=sc.nextDouble();
                    tr.add("Deposited amount: "+ deposit);
                    System.out.println("Amount Deposited Successfully");
                    break;

                case 2:
                    System.out.println("Enter the amount for Withdraw");
                    double withdraw=sc.nextDouble();
                    tr.add("Withdrawn amount: "+ withdraw);
                    System.out.println("Amount withdrawn successfully");
                    break;

                case 3:
                    if(tr.isEmpty()){
                        System.out.println("No transactions yet");
                    }
                    else {
                        for (String tran : tr) {
                            System.out.println(tran);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Final Transaction History:");
                    for(String tran:tr){
                        System.out.println(tran);
                    }
                    System.out.println("Exiting the program");
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter a choice between 1 to 4");
            }
        }
    }
}
