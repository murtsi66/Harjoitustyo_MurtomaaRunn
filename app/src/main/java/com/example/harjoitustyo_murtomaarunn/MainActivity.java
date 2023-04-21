package com.example.harjoitustyo_murtomaarunn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void switchToAddLutemon(View view)   {
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }

    public void switchToListLutemons(View view)   {
        Intent intent = new Intent(this, ListLutemonsActivity.class);
        startActivity(intent);
    }

    public void switchToMoveLutemons(View view)   {
        Intent intent = new Intent(this, MoveTabActivity.class);
        startActivity(intent);
    }

    public void switchToBattlefield(View view)   {
        Intent intent = new Intent(this, Battlefield.class);
        startActivity(intent);
    }
}