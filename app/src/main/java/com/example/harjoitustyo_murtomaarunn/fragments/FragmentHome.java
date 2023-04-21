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

public class FragmentHome extends Fragment {

    private Storage storage;
    private RecyclerView recyclerView;
    private FragmentAdapter adapter;

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
        recyclerView.setLayoutManager((new LinearLayoutManager(getActivity())));
        recyclerView.setAdapter(adapter);
        return view;
    }

}
