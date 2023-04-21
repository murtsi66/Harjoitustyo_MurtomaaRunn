package com.example.harjoitustyo_murtomaarunn;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListHomeLutemonsActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_home);

        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvHomeLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new FragmentAdapter(getApplicationContext(), storage.getLutemons("home")));
    }
}

