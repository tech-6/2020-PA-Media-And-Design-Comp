package com.iantimchak.aquasafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NewSample extends AppCompatActivity {

    String sampleName, sampleColor, sampleLocation;
    double samplePH, samplePPM;

    EditText nameField, colorField, locationField, phField, ppmField;
    TextView warningText;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_sample);

        submitButton = findViewById(R.id.submitfield);

        nameField = findViewById(R.id.editName);
        colorField = findViewById(R.id.editColor);
        locationField = findViewById(R.id.editLocation);
        phField = findViewById(R.id.editpH);
        ppmField = findViewById(R.id.editHardness);

        warningText = findViewById(R.id.WarningMessage);
        warningText.setVisibility(View.INVISIBLE);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int counter = 0;

                if(nameField.getText().toString().length() > 0)
                    sampleName = nameField.getText().toString();
                else
                    counter++;

                if(colorField.getText().toString().length() > 0)
                    sampleColor = colorField.getText().toString();
                else
                    counter++;

                if(locationField.getText().toString().length() > 0)
                    sampleLocation = locationField.getText().toString();
                else
                    counter++;

                if(phField.getText().toString().length() > 0)
                    samplePH = Integer.valueOf(phField.getText().toString());
                else
                    counter++;

                if(ppmField.getText().toString().length() > 0)
                    samplePPM = Integer.valueOf(ppmField.getText().toString());
                else
                    counter++;

                if(counter == 0) {
                    WaterSample tempSample = new WaterSample(sampleName, samplePH, samplePPM, sampleColor, sampleLocation);
                    DataCreation insert = new DataCreation();

                    insert.newsample(tempSample);

                    startActivity(new Intent(NewSample.this, MainActivity.class));
                }

                if(counter > 0){
                    warningText.setVisibility(View.VISIBLE);
                }
            }
        });


    }
}
