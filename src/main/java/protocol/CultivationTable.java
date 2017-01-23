package protocol;

import java.util.Arrays;

public class CultivationTable{
private String[][] day;
private int rows;    
private CultivationTable(Builder b){
    this.day = b.day;
    }
public String[][] getDays(){return day;}
@Override
public String toString(){
String t = "";
    for (int y = 0; y<rows; y++){
        for (int x = 0; x < 10; x++)
        {
            t += day[y][x] + " - " ;
        }
        t += "\n";//System.lineSeparator();    
}
return Arrays.deepToString(day);
}

    public static class Builder{
private String[][] day;
        public Builder(String[][] ta){
 day = ta;

        }

        //public Builder add(int n, int day, String val){
           // day[n][day] = val;
            
        //}
        public Builder addAll(String[][] vals){
            this.day = vals;
            return this;
        }
        public CultivationTable build(){
            CultivationTable ct = new CultivationTable(this);
            return ct;
        }
    }
}
