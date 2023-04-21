package com.example.harjoitustyo_murtomaarunn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentAdapter extends RecyclerView.Adapter<LutemonMoveViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons;

    public FragmentAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
    }

    @NonNull
    @Override
    public LutemonMoveViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonMoveViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_move_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonMoveViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        CheckBox checkBox = holder.checkboxName;
        if (checkBox != null) {
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
        }
    }


    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}