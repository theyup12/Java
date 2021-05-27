import java.util.Scanner;

public class common_prefix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String s1 = input.nextLine();
        System.out.println("Enter the second string: ");
        String s2 = input.nextLine();
        int i = 0;
        int count = 0;
        String prefix = " ";

        while(i != s1.length()){
            if(s1.charAt(i) == s2.charAt(i)){
                prefix += s1.charAt(i);
            }
            i++;
        }
        System.out.println(prefix);      
    }
}    