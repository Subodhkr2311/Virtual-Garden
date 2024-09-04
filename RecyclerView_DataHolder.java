package com.example.ayush_vg;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataHolder extends RecyclerView.ViewHolder {
   TextView NamePlant,Uses,SpeciesName;
   ImageView PlantImg;

    public DataHolder(@NonNull View itemView) {
        super(itemView);
        NamePlant=itemView.findViewById(R.id.NamePlant);
        Uses=itemView.findViewById(R.id.Uses);
        SpeciesName=itemView.findViewById(R.id.SpeciesName);
        PlantImg=itemView.findViewById(R.id.imgVV);
    }
}
