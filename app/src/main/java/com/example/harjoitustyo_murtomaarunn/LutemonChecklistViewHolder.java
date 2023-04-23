package com.example.harjoitustyo_murtomaarunn;

import android.view.View;
import android.widget.CheckBox;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonChecklistViewHolder extends RecyclerView.ViewHolder {

    CheckBox checkboxName;

    public LutemonChecklistViewHolder(@NonNull View itemView){
        super(itemView);
        checkboxName = itemView.findViewById(R.id.checkBoxNameColor);
    }
}