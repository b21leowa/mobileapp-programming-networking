package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MountainAdapter extends RecyclerView.Adapter<MountainAdapter.MyViewHolder> {

    private ArrayList<String> mountains;

    public MountainAdapter(ArrayList<String> mountains){
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
        holder.mountainName.setText(mountains.get(position));
    }

    @Override
    public int getItemCount() {
        return this.mountains.size();
    }

    public class MyViewHolder  extends RecyclerView.ViewHolder{
        private TextView mountainName;
        private TextView mountainLocation;
        private TextView mountainSize;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mountainName = itemView.findViewById(R.id.mountain_name);
        }
    }
}
