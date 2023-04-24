package com.example.harjoitustyo_murtomaarunn.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import com.example.harjoitustyo_murtomaarunn.Lutemon;
import com.example.harjoitustyo_murtomaarunn.FragmentAdapter;
import com.example.harjoitustyo_murtomaarunn.R;
import com.example.harjoitustyo_murtomaarunn.Storage;

import java.util.ArrayList;
import java.util.List;

public class FragmentHome extends Fragment {

    private Storage storage;
    private RecyclerView recyclerView;
    private FragmentAdapter adapter;
    private RadioGroup rgMove;
    private Button btnAdd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = Storage.getInstance();
        adapter = new FragmentAdapter(getContext(), storage.getLutemons("home"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.rvHomeLutemonList);
        recyclerView.setLayoutManager((new LinearLayoutManager(getContext())));
        adapter = new FragmentAdapter(getContext(), storage.getLutemons("home"));
        recyclerView.setAdapter(adapter);
        btnAdd = view.findViewById(R.id.btnTrainChosen);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveLutemons();
            }
        });
        rgMove = view.findViewById(R.id.rgMoveLutemons);
        return view;
    }

    public void moveLutemons() {
        int selectedMove = rgMove.getCheckedRadioButtonId();
        List<Lutemon> selectedLutemons = new ArrayList<>();
        for (Lutemon lutemon : storage.getLutemons("home")) {
            if (lutemon.isChecked()) {
                selectedLutemons.add(lutemon);
            }
        }
        for (Lutemon lutemon : selectedLutemons) {
            switch (selectedMove) {
                case R.id.rbHome:
                    lutemon.setMaxHealth();
                    if (!storage.getLutemons("home").contains(lutemon)) {
                        storage.removeLutemon(lutemon, "home");
                        storage.addLutemon(lutemon, "home");
                    }
                    break;
                case R.id.rbTrain:
                    if (!storage.getLutemons("training").contains(lutemon)) {
                        storage.removeLutemon(lutemon, "home");
                        storage.addLutemon(lutemon, "training");
                    }
                    break;
                case R.id.rbBattle:
                    if (!storage.getLutemons("battlefield").contains(lutemon)) {
                        storage.removeLutemon(lutemon, "home");
                        storage.addLutemon(lutemon, "battlefield");
                    }
                    break;
            }
        }
        adapter.notifyDataSetChanged();
        rgMove.clearCheck();
        for (Lutemon lutemon : selectedLutemons) {
            lutemon.setChecked(false);
        }

        // TODO lisää tallennuss
        storage.saveLutemons();
    }
}