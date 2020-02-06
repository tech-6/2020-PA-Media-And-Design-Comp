
//---WATER SAMPLE CLASS DOCUMENTATION
/*WaterSample class uses:
  *Create a new sample object
  *hold its own unique ID
  *be a part of the static array that lists all of the WaterSample objects
  *Analyze water to an extent
  *@constructor (String name)
  *@constructor (String name, pH)
  *@constructor (String name, pH, ppm)
  *@consturctor (String name, pH, ppm, String color)
  *@constructor (String name, pH, ppm, String color, String location) << MAIN (this()) LOCATION
 */

/**
 * @author Ian Timchak
 * @version 1.0
 * @since 2-04-2019
 */ 
public class WaterSample
{
  private static final String[] colorlist = {"Brown", "Yellow", "Orange", "Cloudy", "Clear"};
  
  private String location;
  private String sampleName;
  private String color;
  private double phLevel;
  private double hardness;
  
  //Unique ID
  private static int numID = 0;
  private int uID;

/**
   * Default constructor
   */
  public WaterSample(){
    this("None", 7, 100, "Clear", "None");
  }//constructer WaterSample(this)
  
/**
   * A supplementary constructor to avoid errors
   * @param name Creating a name for the WaterSample being created
   */
  public WaterSample(String name){
    this(name, 7, 100, "Clear", "None");
  }//constructor WaterSample(S)
  
/**
   * A supplementary constructor to avoid errors
   * @param name Creating a name for the WaterSample being created
   * @param ph Recording the ph level of the WaterSample being created
   */    
  public WaterSample(String name, double ph){
    this(name, ph, 100, "Clear", "None");
  }//constructor WaterSample(S, D)
  
/**
   * A supplementary constructor to avoid errors
   * @param name Creating a name for the WaterSample being created
   * @param ph Recording the ph level of the WaterSample being created
   * @param ppm Recording the hardness level of the WaterSample being created
   */  
  public WaterSample(String name, double ph, double ppm){
    this(name, ph, ppm, "Clear", "None");
  }//constructor WaterSample(S, D, D)
  
/**
   * A supplementary constructor to avoid errors
   * @param name Creating a name for the WaterSample being created
   * @param ph Recording the ph level of the WaterSample being created
   * @param ppm Recording the hardness level of the WaterSample being created
   * @param col Recording the "color" of the WaterSample being created
   */
  public WaterSample(String name, double ph, double ppm, String color){
    this(name, ph, ppm, color, "None");
  }//constructor WaterSample(S, D, D, S)
  
 /**
   * This is the largest constructor which holds all relevant data needed in sample analysis
   * @param name Creating a name for the WaterSample being created
   * @param ph Recording the ph level of the WaterSample being created
   * @param ppm Recording the hardness level of the WaterSample being created
   * @param col Recording the "color" of the WaterSample being created
   * @param loc Recording the location of where the WaterSample being created was collected
   */
  public WaterSample(String name, double ph, double ppm, String col, String loc){
    uID = numID;
    numID++;
    
    sampleName = name;
    hardness = ppm;
    phLevel = ph;
    location = loc;
    color = findColor(col);
  }//constructor WaterSample(S, D, D, S, S)
  
/**
 * Finds a matching color in the colorlist array
 * @param col The color input in the constructor
 */ 
  private String findColor(String col){
    for(String a: colorlist){
      if (findKeyword(col, a, 0) >= 0){
        return a;
      }
    }//for
    return "Clear";
  }//find color
  
  /**
   * DISCLAIMER: Code from edhesive's Magpie5 lab.
  * Search for one word in phrase.  The search is not case sensitive.
  * This method will check that the given goal is not a substring of a longer string
  * (so, for example, "I know" does not contain "no").  
  * @param statement the string to search
  * @param goal the string to search for
  * @param startPos the character of the string to begin the search at
  * @return the index of the first occurrence of goal in statement or -1 if it's not found
  */
 private int findKeyword(String statement, String goal, int startPos)
 {
  String phrase = statement.trim();
  //  The only change to incorporate the startPos is in the line below
  int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);
  
  //  Refinement--make sure the goal isn't part of a word 
  while (psn >= 0) 
  {
   //  Find the string of length 1 before and after the word
   String before = " ", after = " "; 
   if (psn > 0)
   {
    before = phrase.substring (psn - 1, psn).toLowerCase();
   }
   if (psn + goal.length() < phrase.length())
   {
    after = phrase.substring(psn + goal.length(), psn + goal.length() + 1).toLowerCase();
   }
   
   //  If before and after aren't letters, we've found the word
   if (((before.compareTo ("a") < 0 ) || (before.compareTo("z") > 0))  //  before is not a letter
     && ((after.compareTo ("a") < 0 ) || (after.compareTo("z") > 0)))
   {
    return psn;
   }
   
   //  The last position didn't work, so let's find the next, if there is one.
   psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
   
  }
  
  return -1;
 }//findKeyword
 
 public String toString(){
   return sampleName + "\n\t Location: " + location + "\n\t Color: " + color + "\n\t pH: " + phLevel + "\n\t Hardness: " + hardness + "\n\t Sample ID: " + uID;
 }//toString
}
