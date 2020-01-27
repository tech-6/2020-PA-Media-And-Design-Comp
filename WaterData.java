import java.util.*;

public class WaterData
{
    /*private double cond;
    private double ph;
    private double ppm;
    */
    
    private ArrayList <String> indices = new ArrayList <String> (0); //marks the indices of each sample tested
    private ArrayList ph = new ArrayList(0); //recording pH levels of water sample
    private ArrayList ppm = new ArrayList(0); //records ppm of water sample
    
    private int mInd = -1;
    private int tang = 0;
    
    public void add(String sName, double p, double parts){//method used for adding new samples to the arrays
        mInd = indices.size();
        indices.add(indices.size() + ". " + sName); //creates a value in indices to connect the information of each arraylist
        ph.add(p);
        ppm.add(parts);
    }//method @add
    
    public WaterData(){
    }//constructor @WaterData
    
    public String sample(int in){//select a specific sample
        if(in > mInd || in < 0)
            return "ERROR: No sample data found";
        else{
            return indices.get(in) + "\n\t" + "pH level: " + ph.get(in) + "\n\tppm level: " + ppm.get(in);
        }
    }//method @sample
    
    
    
    public String toString(){
      String a = "";
      for(String b: indices){
        a += b + "; ";
      }
      return a;
    }
}
