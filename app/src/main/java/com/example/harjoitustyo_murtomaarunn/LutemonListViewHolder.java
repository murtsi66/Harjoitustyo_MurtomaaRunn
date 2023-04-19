package com.example.harjoitustyo_murtomaarunn;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonListViewHolder extends RecyclerView.ViewHolder {
    ImageView imgLutemon;
    TextView lutemonName, lutemonAttack, lutemonDefence, lutemonHealth, lutemonExp;

    public LutemonListViewHolder(@NonNull View itemView){
        super(itemView);
        imgLutemon=itemView.findViewById(R.id.imgLutemon);
        lutemonName = itemView.findViewById(R.id.txtName);
        lutemonAttack= itemView.findViewById(R.id.txtAttack);
        lutemonDefence= itemView.findViewById(R.id.txtDefence);
        lutemonHealth = itemView.findViewById(R.id.txtHealth);
        lutemonExp = itemView.findViewById(R.id.txtExp);
    }

}