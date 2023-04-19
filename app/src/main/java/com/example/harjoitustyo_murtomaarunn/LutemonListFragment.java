package com.example.harjoitustyo_murtomaarunn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonListFragment extends Fragment {

    private RecyclerView recyclerView;

    private LutemonMoveAdapter adapter;

    private String lutemonType;
    private Storage storage;

    public LutemonListFragment(String lutemonType) {
        this.lutemonType = lutemonType;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lutemon_list, container, false);
        recyclerView = view.findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new LutemonMoveAdapter(getContext(), storage.getLutemons(lutemonType));
        recyclerView.setAdapter(adapter);
        return view;
    }
}