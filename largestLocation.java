import java.util.Scanner;
import tool.Location;
public class largestLocation {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns in the array: ");
        int row = input.nextInt();
        int columns = input.nextInt();

        double[][] arr = new double[row][columns];
        System.out.println("Enter the array: ");
        for(int i =0; i < row; i++){
            for(int j = 0; j < columns; j++){
                arr[i][j] = input.nextDouble();
            }
        }
        
        Location location = location.locateLargest(arr);
        System.out.println("The location of the largest element is " 
        + location.maxValue + "at (" + location.row + ", " +location.column + ")");
    }

}
