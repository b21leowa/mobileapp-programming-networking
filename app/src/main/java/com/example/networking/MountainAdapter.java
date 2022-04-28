package com.example.networking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.MyViewHolder> {

    private ArrayList<Mountain> mountains;

    public MountainAdapter(Context context, ArrayList<Mountain> mountains){
        this.mountains = mountains;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String location = "Location: " + mountains.get(position).getLocation();
        String name = "Name: " + mountains.get(position).getName();
        String size = "Size: " + mountains.get(position).getSizeString();
        holder.mountainName.setText(name);
        holder.mountainLocation.setText(location);
        holder.mountainSize.setText(size);

    }

    @Override
    public int getItemCount() {
        return this.mountains.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        private final TextView mountainName;
        private final TextView mountainLocation;
        private final TextView mountainSize;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mountainName = itemView.findViewById(R.id.mountain_name);
            mountainLocation = itemView.findViewById(R.id.mountain_location);
            mountainSize = itemView.findViewById(R.id.mountain_size);
        }
    }
}
