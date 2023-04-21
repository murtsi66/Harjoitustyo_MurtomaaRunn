package com.example.harjoitustyo_murtomaarunn;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.harjoitustyo_murtomaarunn.fragments.FragmentBattle;
import com.example.harjoitustyo_murtomaarunn.fragments.FragmentHome;
import com.example.harjoitustyo_murtomaarunn.fragments.FragmentTraining;

public class LutemonMoveAdapter extends FragmentStateAdapter {

    public LutemonMoveAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new FragmentHome();
            case 1:
                return new FragmentTraining();
            case 2:
                return new FragmentBattle();
            default:
                return new FragmentHome();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}

