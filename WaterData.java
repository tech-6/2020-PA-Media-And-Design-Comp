//---WATER DATA CLASS DOCUMENTATION
/**WaterData class uses
  *Water Data contains the information of every WaterSample class.
  *Be able to remove WaterSample objects from its database
  *Be able to edit the contents of a WaterSample object
  *Be able to search for a specific WaterSample object based on its unique ID
  *Be able to call certain methods of a WaterSample object
 */
import java.util.*;

public class WaterData
{
  private ArrayList <WaterSample> samples = new ArrayList<WaterSample>(0);
  
/**
 * Default Constructor
 */ 
  public WaterData(){}
  
/**
 * Smallest method for add()
 * @param newWS A new WaterSample class being added to the WaterData list for analysis
 */
  public void add(WaterSample newWS){ //NEEDS WORK
    int lastInd = 0;
    int lastID = 0;
    
    if(samples.size() > 0){
      
      lastInd = samples.size() - 1; //gets the index for the last position in the array
      lastID = samples.get(lastInd).getID(); //gets the ID of that WaterSample
      if(newWS.getID() < lastID){ //organizing (id least to greatest)
        if(lastInd < 1)
          samples.add(0, newWS);
        if(lastInd > 0)
          samples.add(lastInd - 1, newWS);  //with main(2/17/2020) prints 2, 0, 1, 3?
      }else
        samples.add(newWS);
    }else
      samples.add(newWS);
    
  }//add(WS)
  
/**
   * toString method
   */
  public String toString(){
    String idList = "";
    
    for(WaterSample a: samples){
      if(samples.indexOf(a) == samples.size() - 1)
        idList += a.getID();
      else
        idList += a.getID() + ", ";
    }//for
        
    return "Samples(ID): " + idList;
  }//toString
  
  public String nameList(){return "error";}
}
