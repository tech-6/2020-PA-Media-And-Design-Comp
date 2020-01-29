
import java.util.*;
import java.text.*;

class Main
{
  public static void main(String[] args){
    DecimalFormat df = new DecimalFormat("###.##");
      
    Scanner in = new Scanner(System.in);
    int flag = 0;
    boolean pHc = false;
    boolean ppmc = false;
   
    WaterData test = new WaterData();
    
    for(int i = 0; i < 31; i++){//creating 30 random test samples
        test.add(("AutoSample" + ""), Double.parseDouble(df.format((Math.random()*2.51) + 6)), (int)(Math.random()*150));
    }
    
    System.out.println(test);//printing out the list
    
    
    System.out.println("Would you like to search for a sample? (0 for yes, anything else for no)");
    int test1 = in.nextInt();
    
    if(test1 == 0){
      while(flag == 0){
        System.out.println(test.sample());
    
        System.out.println("Would you like to continue searching? (0 for yes, anything else for no)");
        flag = in.nextInt();
      }
    }
    /*while(flag == 0){
      System.out.println("Please name the new water sample");
      String title = in.nextLine();
    
      System.out.println("Enter the pH level of the sample");
      double pH = in.nextDouble();
    
      System.out.println("Enter the ppm level of the sample");
      double ppm = in.nextDouble();
      
    
      WaterData test = new WaterData(title, pH, ppm);
     System.out.println("Sample cataloged. \n" + test);
     
     if(pH >= 6.5 && pH<= 7.5)
       pHc = true;
     else
       pHc = false;
    
     if(ppm < 500)
       ppmc = true;
     else
       ppmc = false;
    
     if(pHc == true && ppmc == true)
       System.out.println("The water is acceptable to drink based off of the pH and ppm levels.");
     else
       System.out.println("The water is not recommended for consumption, it may be harmful.");
     
    System.out.println("Input 0 to continue, anything else to disengage");
    flag = in.nextInt();
    }*/
  }//main method
}
