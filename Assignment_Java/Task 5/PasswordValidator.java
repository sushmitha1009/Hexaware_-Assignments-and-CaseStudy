import java.util.*;
public class PasswordValidator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your password:");
        String password = sc.nextLine();
        if (isValidPassword(password)) {
            System.out.println("You have created a valid password");
        } else {
            System.out.println("Password is not valid. Please follow the valid rules");
        }
    }

    public static boolean isValidPassword(String password) {
        if (password.length() < 8) {
            System.out.println(" password must be at least 8 characters long");
            return false;
        }
        boolean hasUpperCase = false;
        boolean hasDigit=false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                hasUpperCase = true;
            }
            if (Character.isDigit(ch)) {
                hasDigit = true;
            }
        }
        if(!hasUpperCase){
            System.out.println("Password must include one UpperCase!");
        }
        if(!hasDigit){
            System.out.println("Password must include one Digit!");
        }
        return hasUpperCase && hasDigit;
    }
}
