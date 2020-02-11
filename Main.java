import java.util.*;

public class Main
{
  public static void main(String[] args){
    WaterData masterClass = new WaterData();
    
    
    WaterSample test = new WaterSample();
    WaterSample test2 = new WaterSample("test", 7.2, 120, "kinda orangee", "Sulfur mine");
    masterClass.add(test2);
    masterClass.add(test);
    
    System.out.println(masterClass);
  }//@main
}
