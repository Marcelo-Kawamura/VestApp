package com.example.vestibular.vestibulapp.presentation.problem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.vestibular.vestibulapp.R;
import com.example.vestibular.vestibulapp.domain.entity.ProblemCheck;

import java.util.ArrayList;


/**
 * Created by renan on 05/01/2018.
 */

public class CheckAdapter extends RecyclerView.Adapter<CheckAdapter.CheckHolder> {
    ArrayList<ProblemCheck.Item> items;
    Context context;
    public CheckAdapter(ArrayList items, Context context){
        this.items = items;
    }
    @Override
    public CheckHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cell_problem_check,parent,false);
        return new CheckHolder(view);
    }

    @Override
    public void onBindViewHolder(CheckHolder holder, int position) {
        holder.itemDescription.setText(items.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class CheckHolder extends RecyclerView.ViewHolder{
        public TextView itemDescription;
        public CheckHolder(View itemView) {
            super(itemView);
            itemDescription = itemView.findViewById(R.id.item_description);
        }
    }
}
