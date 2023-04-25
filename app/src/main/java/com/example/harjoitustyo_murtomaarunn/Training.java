package com.example.harjoitustyo_murtomaarunn;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Training extends AppCompatActivity {
    private Context context;
    private Storage storage;
    private RecyclerView recyclerView;
    private FragmentAdapter adapter;
    private Button btnTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvBeastModeList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FragmentAdapter(this, storage.getLutemons("training"));
        recyclerView.setAdapter(adapter);
        btnTrain = findViewById(R.id.btnTrainChosen);
        btnTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                trainLutemons();
            }
        });
    }

    // Method for training lutemons
    public void trainLutemons() {
        List<Lutemon> selectedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons("training")) {
            if (lutemon.isChecked()) {
                selectedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : selectedLutemons) {
            lutemon.increaseExp();
            lutemon.increaseTrainingDays();
        }
        adapter.notifyDataSetChanged();
        for (Lutemon lutemon : selectedLutemons) {
            lutemon.setChecked(false);
        }
        Toast.makeText(this, "Lutemonien Beast Mode aktivoitu!", Toast.LENGTH_LONG).show();
    }
}
