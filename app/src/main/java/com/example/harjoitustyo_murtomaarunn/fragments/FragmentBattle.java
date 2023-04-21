package com.example.harjoitustyo_murtomaarunn.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.harjoitustyo_murtomaarunn.Lutemon;
import com.example.harjoitustyo_murtomaarunn.FragmentAdapter;
import com.example.harjoitustyo_murtomaarunn.R;
import com.example.harjoitustyo_murtomaarunn.Storage;

import java.util.ArrayList;
import java.util.List;

public class FragmentBattle extends Fragment {

    private Storage storage;
    private RadioGroup rgMove;
    private RadioButton[] rbMove;
    private RecyclerView recyclerView;
    private FragmentAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storage = Storage.getInstance();
        adapter = new FragmentAdapter(getContext(), storage.getLutemons("battlefield"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_battle, container, false);
        recyclerView = view.findViewById(R.id.rvBattleLutemonList);
        rgMove = view.findViewById(R.id.rgMoveLutemons);
        rbMove = new RadioButton[] {
                view.findViewById(R.id.rbHome),
                view.findViewById(R.id.rbTrain),
                view.findViewById(R.id.rbBattle)
        };
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setAdapter(adapter);
        return view;
    }
}
