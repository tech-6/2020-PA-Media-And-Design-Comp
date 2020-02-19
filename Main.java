import java.util.*;

public class Main
{
  public static void main(String[] args){
    WaterData masterClass = new WaterData();
    
    
    WaterSample test = new WaterSample();
    WaterSample test2 = new WaterSample("test", 7.2, 120, "kinda orangee", "Sulfur mine");
    WaterSample test3 = new WaterSample();
    
    System.out.println(test.getID() + " " + test2.getID() + " " + test3.getID());
    masterClass.add(test2);
    masterClass.add(test);
    masterClass.add(test3);
    
    System.out.println(masterClass);
  }//@main
}
