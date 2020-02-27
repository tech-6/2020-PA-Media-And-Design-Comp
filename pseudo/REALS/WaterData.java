package com.iantimchak.aquasafe;

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
    private static ArrayList <WaterSample> samples = new ArrayList<WaterSample>(0);

    private static int tempHold;

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

            System.out.println(lastID + " " + lastInd);
            if(newWS.getID() < lastID){
                if(lastInd < 1){
                    samples.add(0, newWS);

                }
                if(lastInd > 0)
                    samples.add(checkOrder(newWS), newWS);
            }else
                samples.add(newWS);
            tempHold = newWS.getID();
        }else
            samples.add(newWS);
        tempHold = newWS.getID();

    }//add(WS)

    /**
     * for ordering the stuff -- BROKEN NEEDS FIXED (2/19/2020)
     * @param newWS A new water sample being checked.
     * @return Returns the index the new water sample is placed in.
     */
    private int checkOrder(WaterSample newWS){
        int ind = Integer.MAX_VALUE;

        for(int i = samples.size() - 1; i >= 0; i--){
            if(samples.get(i).getID() > newWS.getID())
                ind = i;
        }//for

        if(ind < 0)
            ind = 0;

        return ind;
    }//checkOrder

    /**
     * To select the main list
     * @return Returns the list of WaterSample Classes.
     */
    public ArrayList<WaterSample> getList(){

        return samples;
    }



    /**
     * toString method
     * @return list of water samples by ID
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

}