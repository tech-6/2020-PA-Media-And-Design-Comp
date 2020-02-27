package com.iantimchak.aquasafe;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


public class AnalysisActivity extends AppCompatActivity {

    private static final String TAG = "Analysis";
    WaterData masterControl = new WaterData();
    TextView listedSample, pHTitle, ppmTitle, colTitle, locTitle, phedit, ppmedit, coledit, locedit, summary; //loc is temporarily unused (2/26/2020)
    int uID;
    double pH, ppm;
    int color;

    boolean pHCheck, ppmCheck;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        getIncomingIntent();

        listedSample = findViewById(R.id.sample_name);//title
        listedSample.setText(masterControl.getList().get(uID).getName());

        //pH, ppm, color
        pH = masterControl.getList().get(uID).getPH();
        ppm = masterControl.getList().get(uID).getPPM();

        String check2 = masterControl.getList().get(uID).getColor();
        if(check2.equals("Clear"))
            color = 0;
        else if(check2.equals("Cloudy"))
            color = 1;
        else if(check2.equals("Orange"))
            color = 2;
        else if(check2.equals("Yellow"))
            color = 3;
        else if(check2.equals("Brown"))
            color = 4;
        else
            color = 0;
        /*switch(check2){
            case "Clear":
                color = 0;
                break;

            case "Cloudy":
                color = 1;
                break;

            case "Orange":
                color = 2;
                break;

            case "Yellow":
                color = 3;
                break;

            case "Brown":
                color = 4;
                break;

            default:
                color = 0;
        }*/

        ppmCheck = false;
        pHCheck = false;

        if(pH >= 6.5 && pH <= 8.5){
            pHCheck = true;
        }

        if(ppm < 200){
            ppmCheck = true;
        }


        //this section of code is for customizing the pH blocks on the analysis activity [[
        pHTitle = findViewById(R.id.ph_title);
        pHTitle.setText("pH Level: " + pH);

        phedit = findViewById(R.id.phedit);
        if(pHCheck == true) {
            phedit.setText("The pH levels for this water sample are within an acceptable range.");
            phedit.setTextColor(ContextCompat.getColor(this, R.color.safe));
        }else{
            phedit.setText("The pH levels for this water sample are not within an acceptable range.");
            phedit.setTextColor(ContextCompat.getColor(this, R.color.warningColor));
        }
        //]]
        //this section of code is for customizing the ppm blocks on the analysis activity [[
        ppmTitle = findViewById(R.id.ppm_title);
        ppmTitle.setText("Hardness Level: " + ppm + "ppm");

        ppmedit = findViewById(R.id.ppmedit);
        if(ppmCheck == true){
            ppmedit.setText("The hardness levels for the water sample are within an accepted range.");
            ppmedit.setTextColor(ContextCompat.getColor(this, R.color.safe));
        }else{
            ppmedit.setText("The hardness levels for the water sample are not within an accepted range.");
            ppmedit.setTextColor(ContextCompat.getColor(this, R.color.warningColor));
        }
        //]]
        //this section of code is for customizing the color blocks on the analysis activity

        //]](TBM)

        //location (TBM)


        int counter = 0;
        int check = 0;

        if(pHCheck == true)
            counter++;

        if(ppmCheck == true)
            counter++;

        if(color == 0)
            counter++;

        if(counter >= 3)
            check = 1;

        if(counter == 2 || counter == 1)
            check = 2;

        if(counter == 0)
            check = 3;

        //this section of code is for customizing the summary blocks on the analysis activity [[
        summary = findViewById(R.id.sumedit);
        if(check == 1){
            summary.setText("By the information given on this water sample it is determined to be safe to drink.");
            summary.setTextColor(ContextCompat.getColor(this, R.color.safe));
            Log.e(TAG, "SUM: " + summary.getText());
        }
        if(check == 2){
            summary.setText("By the information given on this water sample it is unsure whether or not it is safe to use. If the water is clear, then it is most likely safe to drink.");
            summary.setTextColor(ContextCompat.getColor(this, R.color.unsure));
        }
        if(check == 3){
            summary.setText("By the information given on this water sample it is determined to be unsafe to drink.");
            summary.setTextColor(ContextCompat.getColor(this, R.color.warningColor));
        }

    }

    private void getIncomingIntent(){
        if(getIntent().hasExtra("Sample_id")){
            int sampleID = getIntent().getIntExtra("Sample_id", masterControl.getList().size() - 1);

            Log.e(TAG, "sampleID: " + sampleID);
            uID = sampleID;
        }
    }
}
