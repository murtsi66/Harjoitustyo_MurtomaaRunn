package com.example.harjoitustyo_murtomaarunn.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.harjoitustyo_murtomaarunn.Lutemon;
import com.example.harjoitustyo_murtomaarunn.R;
import com.example.harjoitustyo_murtomaarunn.Storage;

import java.util.ArrayList;
import java.util.List;

public class FragmentBattle extends Fragment {

    private Storage storage;
    private RadioGroup rgMove;
    private RadioButton[] rbMove;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = Storage.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle, container, false);
        rgMove = view.findViewById(R.id.rgMoveLutemons);
        rbMove = new RadioButton[] {
                view.findViewById(R.id.rbHome),
                view.findViewById(R.id.rbTrain),
                view.findViewById(R.id.rbBattle)
        };
        return view;
    }

    public void moveLutemons() {
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
