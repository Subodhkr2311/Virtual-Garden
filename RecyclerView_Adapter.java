package com.example.ayush_vg;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class adapter extends RecyclerView.Adapter<DataHolder>{
    Context c;
    ArrayList<SearchF.showd> arr;

    // Constructor for the adapter class
    public adapter(Context c, ArrayList<SearchF.showd> arr){
        this.c = c;
        this.arr = arr;
    }
    public void setFilteredList(ArrayList<SearchF.showd> filteredList){
        this.arr = filteredList;
        notifyDataSetChanged();
    };
    @NonNull
    @Override
    public DataHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(c).inflate(R.layout.recyclerlayoutsearch, parent, false);
        return new DataHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DataHolder holder, int position) {
        holder.NamePlant.setText(arr.get(position).name);
        holder.SpeciesName.setText(arr.get(position).species);
        holder.Uses.setText(arr.get(position).uses);
        holder.PlantImg.setImageResource(arr.get(position).img);
    }

    @Override
    public int getItemCount() {
        return arr.size();
    }
}
