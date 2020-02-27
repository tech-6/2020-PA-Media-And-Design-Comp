package com.iantimchak.aquasafe;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class SampleList extends AppCompatActivity {

    WaterData compile = new WaterData();

    RecyclerView mainRecycler;
    RecyclerView.Adapter mainAdapter;
    RecyclerView.LayoutManager mainLayout;

    TextView warningText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_list);

        warningText = findViewById(R.id.warningprompt);
        warningText.setVisibility(View.INVISIBLE);

        ArrayList<WaterSample> list = compile.getList();

        mainRecycler = findViewById(R.id.sampleList);//selects the recyclerview
        mainRecycler.setHasFixedSize(true);//performance enhancing
        mainAdapter = new SampleAdapter(list, this);//sets the adapter for mainRecycler
        mainLayout = new LinearLayoutManager(this);//selects which layout manager is being used

        mainRecycler.setAdapter(mainAdapter); //applies
        mainRecycler.setLayoutManager(mainLayout);//\/


        if(list.size() == 0){
            warningText.setVisibility(View.VISIBLE);
            warningText.setText("No samples");
            warningText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40);
        }



    }
}
