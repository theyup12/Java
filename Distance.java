package hw;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class Distance {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, HashMap<String, Integer>> cityDis = new HashMap<String, HashMap<String, Integer>>();
        ArrayList<String> city = new ArrayList<String>();
        boolean check = true;
        while(check){
            String cityName = in.next();
            if(cityName.equals("###")){
                break;
            }
            city.add(cityName);    
        }
        
        for(String i : city){
            HashMap<String, Integer> distance = new HashMap<String, Integer>();
            for(String k : city){
                int num = in.nextInt();
                distance.put(k, num);
                cityDis.put(i, distance);
            }
        }
        
        String city1 = in.next();
        String city2 = in.next();
        System.out.println(cityDis.get(city1).get(city2));
        System.out.println(cityDis);
        in.close();
    }
}
