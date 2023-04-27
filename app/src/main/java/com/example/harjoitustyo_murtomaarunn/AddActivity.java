package com.example.harjoitustyo_murtomaarunn;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.harjoitustyo_murtomaarunn.Lutemons.Black;
import com.example.harjoitustyo_murtomaarunn.Lutemons.Green;
import com.example.harjoitustyo_murtomaarunn.Lutemons.Orange;
import com.example.harjoitustyo_murtomaarunn.Lutemons.Pink;
import com.example.harjoitustyo_murtomaarunn.Lutemons.White;

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
    // Method for adding new lutemons, new lutemon is added straight to home when created
    public void AddLutemon(View view)   {
        name = txtLutemonName.getText().toString();
        switch (rgSelectColor.getCheckedRadioButtonId())    {
            case R.id.rbGreen:
                Green green = new Green(name, "Green");
                Storage.getInstance().addLutemon(green, "home");
                break;
            case R.id.rbOrange:
                Orange orange = new Orange(name, "Orange");
                Storage.getInstance().addLutemon(orange, "home");
                break;
            case R.id.rbWhite:
                White white = new White(name, "White");
                Storage.getInstance().addLutemon(white, "home");
                break;
            case R.id.rbBlack:
                Black black = new Black(name, "Black");
                Storage.getInstance().addLutemon(black, "home");
                break;
            case R.id.rbPink:
                Pink pink = new Pink(name, "Pink");
                Storage.getInstance().addLutemon(pink, "home");
                break;
        }
        Toast.makeText(this, "Uusi lutemon lisätty!", Toast.LENGTH_SHORT).show();
    }
}
