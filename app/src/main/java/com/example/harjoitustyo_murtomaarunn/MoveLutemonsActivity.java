package com.example.harjoitustyo_murtomaarunn;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MoveLutemonsActivity extends AppCompatActivity {

    private Storage storage;
    private RecyclerView recyclerView;
    private RadioGroup rgMove;
    private RadioButton[] rbMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_lutemons);
        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonMoveAdapter(getApplicationContext(), storage.getLutemons("all")));
        rgMove = findViewById(R.id.rgMoveLutemons);
        rbMove = new RadioButton[] {
                findViewById(R.id.rbHome),
                findViewById(R.id.rbTrain),
                findViewById(R.id.rbBattle)
        };
        for (Lutemon lutemon : storage.getLutemons("all")) {
            lutemon.setChecked(false);
        }
    }

    public void moveLutemons(View view) {
        int selectedMove = rgMove.getCheckedRadioButtonId();
        List<Lutemon> selectedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons("all")) {
            if (lutemon.isChecked()) {
                selectedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : selectedLutemons) {
            switch (selectedMove) {
                case R.id.rbHome:
                    lutemon.setMaxHealth();
                    if (!storage.getLutemons("home").contains(lutemon)) {
                        storage.removeLutemon(lutemon, "battle");
                        storage.removeLutemon(lutemon, "training");
                        storage.addLutemon(lutemon, "home");
                    }
                    break;
                case R.id.rbTrain:
                    if (!storage.getLutemons("training").contains(lutemon)) {
                        storage.removeLutemon(lutemon, "home");
                        storage.removeLutemon(lutemon, "battle");
                        storage.addLutemon(lutemon, "training");
                    }
                    break;
                case R.id.rbBattle:
                    if (!storage.getLutemons("battle").contains(lutemon)) {
                        storage.removeLutemon(lutemon, "home");
                        storage.removeLutemon(lutemon, "training");
                        storage.addLutemon(lutemon, "battle");
                    }
                    break;
            }
        }
        // TODO lisää tallennuss
        storage.saveLutemons();
    }
}
