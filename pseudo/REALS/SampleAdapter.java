package com.iantimchak.aquasafe;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class SampleAdapter extends RecyclerView.Adapter<SampleAdapter.ViewHolder> {
    ArrayList<WaterSample> mainSamples;
    private int index;
    private static final String TAG = "SampleList";
    private Context mContext;


    //constructor(arraylist)
    public SampleAdapter(ArrayList<WaterSample> array, Context context) {
        mainSamples = array;
        mContext = context;
    }


    @NonNull
    @Override
    public SampleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String idtext = "Sample ID: " + mainSamples.get(position).getID();
        index = position;

        holder.sampleName.setText(mainSamples.get(position).getName());
        holder.uid.setText(idtext);
        holder.parentLayout.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Clicked on: " + mainSamples.get(position).getName());

                int uID = mainSamples.get(position).getID();

                Intent intent = new Intent(mContext, AnalysisActivity.class);
                intent.putExtra("Sample_id", uID);
                Log.e(TAG, "ID returned to AnalysisActivity: " + uID);

                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mainSamples.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView sampleName, uid;
        public LinearLayout parentLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            sampleName = itemView.findViewById(R.id.sampleName);
            uid = itemView.findViewById(R.id.uid);
            parentLayout = itemView.findViewById(R.id.parent_layout);


        }
    }
}
