import java.util.Scanner;

public class checkPassword {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Password: ");
        String password = input.nextLine();
        Boolean check = ispassword(password);
        if(check){
            System.out.println("Valid Password");
        }else{
            System.out.println("Invalid Password");
        }
    }
    public static Boolean ispassword(String password) {
        int j = 0;
        if(password.length() < 10){
            return false;
        }
        for(int i= 0; i < password.length(); i++){
            if(!Character.isLetterOrDigit(password.charAt(i))){
                return false;
            }
            if(Character.isDigit(password.charAt(i))){
                j++;
            }
        }
        if(j < 3){
            return false;
        }
    return true;
    }
}    
