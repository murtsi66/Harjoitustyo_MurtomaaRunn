package com.example.harjoitustyo_murtomaarunn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FragmentAdapter extends RecyclerView.Adapter<LutemonChecklistViewHolder> {

    private Context context;
    private ArrayList<Lutemon> lutemons;

    public FragmentAdapter(Context context, ArrayList<Lutemon> lutemons) {
        this.context = context;
        this.lutemons = lutemons;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LutemonChecklistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonChecklistViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_move_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonChecklistViewHolder holder, int position) {
        Lutemon lutemon = lutemons.get(position);

        CheckBox checkBox = holder.checkboxName;
        if (checkBox != null) {
            checkBox.setText(lutemon.getName() + " (" + lutemon.getColor() + ")");
            checkBox.setChecked(lutemon.isChecked());
            checkBox.setTag(position);
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                    int position = (int) compoundButton.getTag();
                    lutemons.get(position).setChecked(isChecked);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }

}