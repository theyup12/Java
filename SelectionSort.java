import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a size of the list:");
        int size = input.nextInt();
        double[] list = new double[size];
        System.out.println("Enter a list:");
        for(int k = 0; k < size; k++){
            list[k] = input.nextDouble();
        }
        for(int i=0; i < list.length - 1; i++){
            double currentMin = list[i];
            int curIndex = i;
            for(int j =i + 1; j < list.length; j++){
                if(currentMin > list[j]){
                    currentMin = list[j];
                    curIndex = j;
                }
            }
            if(curIndex != i){
                list[curIndex] = list[i];
                list[i] = currentMin;
            }
        }
        for(double e : list){
            System.out.println(e);
        }
        
    }
}    
