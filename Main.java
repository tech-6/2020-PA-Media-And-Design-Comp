import java.util.*;

public class Main
{
  public static void main(String[] args){
    WaterData masterClass = new WaterData();
    
    
    WaterSample test = new WaterSample();
    masterClass.add(test);
    WaterSample test2 = new WaterSample("test", 7.2, 120, "kinda orangee", "Sulfur mine");
    masterClass.add(test2);
    
    System.out.println(masterClass);
  }//@main
}
