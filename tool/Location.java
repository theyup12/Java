package tool;
public class Location {
    int row;
    int column;
    double maxValue;
    Location(int row_, int column_, double maxValue_){
        this.row = row_;
        this.column = column_;
        this.maxValue = maxValue_; 
    }
    public static Location locateLargest(double [][] a){
        int new_row = 0;
        int new_column = 0; 
        double maxValue = a[new_row][new_column];
        for(int i =0; i < a.length; i++){
            for(int j =0; j < a[i].length; j++){
                if(maxValue > a[i][j]){
                    maxValue = a[i][j];
                    new_row = i;
                    new_column = j;
                }
            }
            
        }
        return new Location(new_row, new_column, maxValue);
    }
}