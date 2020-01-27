
import java.util.*;

class Main
{
  public static void main(String[] args){
    Scanner in = new Scanner(System.in);
    int flag = 0;
    boolean pHc = false;
    boolean ppmc = false;
   
    WaterData test = new WaterData();
    
    test.add("Johnsonburg Water Athority", 6.9, 150);
    test.add("O I L", 5, 9000);
    test.add("Ridgway", 7.1, 140);
    test.add("St Marys", 7, 100);
    test.add("Colorado", 7, 70);
    
    System.out.println(test);//printing out the list
    
    System.out.println(test.sample(4));//printing out specific indices
    System.out.println(test.sample(3));
    System.out.println(test.sample(2));
    System.out.println(test.sample(0));
    System.out.println(test.sample(1));
    
    
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
