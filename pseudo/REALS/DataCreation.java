package com.iantimchak.aquasafe;

import android.provider.ContactsContract;

public class DataCreation {
    private WaterData masterCompile = new WaterData();

    public DataCreation(){
    }

    public void newsample(WaterSample newWS){
        masterCompile.add(newWS);
    }
}
