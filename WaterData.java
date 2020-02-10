import java.util.*;

//---WATER SAMPLE CLASS DOCUMENTATION
/**WaterSample class uses:
  *Create a new sample object
  *hold its own unique ID
  *be a part of the static array that lists all
    of the WaterSample objects
  *Analyze water to an extent
  *
  *@constructor (String name)
  *@constructor (String name, pH)
  *@constructor (String name, pH, ppm)
  *@consturctor (String name, pH, ppm, String color)
  *@constructor (String name, pH, ppm, String color, String location) << MAIN (this()) LOCATION
 */

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
  private ArrayList <WaterSample> samples = new ArrayList<WaterSample>();
  
/**
 * Default Constructor
 */ 
  public WaterData(){}
  
/**
 * Smallest method for add()
 * @param newWS A new WaterSample class being added to the WaterData list for analysis
 */
  public void add(WaterSample newWS){
    samples.add(newWS);
  }//add(WS)
  
/**
   * toString method
   */
  public String toString(){
    String idList = "";
    
    for(WaterSample a: samples){
      if(samples.indexOf(a) == samples.size())
        idList += a.getID();
      else
        idList += a.getID() + ", ";
    }//for
        
    return "Samples: " + idList;
  }//toString
}
