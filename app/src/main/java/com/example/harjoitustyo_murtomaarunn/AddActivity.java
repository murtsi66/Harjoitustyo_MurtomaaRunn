package com.example.harjoitustyo_murtomaarunn;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {
    private Context context;
    private RadioGroup rgSelectColor;
    private RadioButton rbGreen, rbWhite, rbPink, rbBlack, rbOrange;
    private EditText txtLutemonName;
    private String name, color;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        rgSelectColor = findViewById(R.id.rgSelectColor);
        rbWhite = findViewById(R.id.rbWhite);
        rbGreen = findViewById(R.id.rbGreen);
        rbPink = findViewById(R.id.rbPink);
        rbOrange = findViewById(R.id.rbOrange);
        rbBlack = findViewById(R.id.rbBlack);
        txtLutemonName = findViewById(R.id.txtEditName);
    }

    public void AddLutemon(View view)   {
        switch (rgSelectColor.getCheckedRadioButtonId())    {
            case R.id.rbGreen:
                color = "Green";
                break;
            case R.id.rbOrange:
                color = "Orange";
                break;
            case R.id.rbWhite:
                color = "White";
                break;
            case R.id.rbBlack:
                color = "Black";
                break;
            case R.id.rbPink:
                color = "Pink";
                break;
        }
        name = txtLutemonName.getText().toString();
        Lutemon lutemon = new Lutemon(name, color);
        Storage storage = Storage.getInstance();
        storage.addLutemon(lutemon, "all");
        storage.addLutemon(lutemon, "home");
        Toast.makeText(this, "Uusi lutemon lisätty!", Toast.LENGTH_SHORT).show();
        // TODO korjaa tallennus
        storage.saveLutemons();
    }
}
