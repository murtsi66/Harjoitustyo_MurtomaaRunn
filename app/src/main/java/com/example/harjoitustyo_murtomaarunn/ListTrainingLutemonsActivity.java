package com.example.harjoitustyo_murtomaarunn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListTrainingLutemonsActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_training);

        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvTrainingLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FragmentAdapter(getApplicationContext(), storage.getLutemons("home")));
    }
}

