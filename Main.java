import java.util.*;

public class Main
{
  public static void main(String[] args){
    WaterData masterClass = new WaterData();
    
    WaterSample[] list = new WaterSample[10];
    
    WaterSample test = new WaterSample();
    WaterSample test2 = new WaterSample("test", 7.2, 120, "kinda orangee", "Sulfur mine");
    WaterSample test3 = new WaterSample();
    WaterSample test4 = new WaterSample();
    WaterSample test5 = new WaterSample();
    WaterSample test6 = new WaterSample();
    WaterSample test7 = new WaterSample();
    WaterSample test8 = new WaterSample();
   

    masterClass.add(test2);
    masterClass.add(test);
    masterClass.add(test);
    masterClass.add(test3);
    masterClass.add(test7);
    masterClass.add(test4);
    masterClass.add(test5);
    masterClass.add(test8);
    masterClass.add(test6);
    
    System.out.println(masterClass);
  }//@main
}
