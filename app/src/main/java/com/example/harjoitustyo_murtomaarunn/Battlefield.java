package com.example.harjoitustyo_murtomaarunn;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Battlefield extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;
    private FragmentAdapter adapter;
    private Button btnFight;
    private TextView txtFight;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battlefield);

        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvBattleLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new FragmentAdapter(this, storage.getLutemons("battlefield"));
        recyclerView.setAdapter(adapter);
        btnFight = findViewById(R.id.btnFight);
        txtFight = findViewById(R.id.txtFightSpecs);
        btnFight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fight();
            }
        });
    }


    public void fight() {

        List<Lutemon> fighterLutemons = storage.getLutemons("battlefield");

        for (int i = 0; i < fighterLutemons.size(); i++) {
            Lutemon lutemon = fighterLutemons.get(i);
            if (lutemon.isChecked() && (fighterLutemons.size() < 2)) {
                fighterLutemons.add(lutemon);
            }
        }


        if (fighterLutemons.size() == 2) {
            StringBuilder txtOctagon = new StringBuilder();
            txtOctagon.append("Taistelijat:\n");

            for (Lutemon lutemon : fighterLutemons) {
                txtOctagon.append(String.format("%s: Hyökkäys: %d; Puolustus: %d; Kokemus:%d; Elämät:%d/%d\n", lutemon.getName(), lutemon.attack(), lutemon.defence(), lutemon.getExperience(), lutemon.getHealth(), lutemon.getMaxHealth()));
            }
            //Determining which Lutemon will be attacking and which will be defending in the battle
            Lutemon attackingLutemon = fighterLutemons.get(0);
            Lutemon defendingLutemon = fighterLutemons.get(1);


            boolean endOfBattle = false;
            while (!endOfBattle) {

                int damage = attackingLutemon.attack() - defendingLutemon.defence() + (int) (Math.random() * 5);

                if (damage != 0) {
                    defendingLutemon.damageControl(damage);
                    txtOctagon.append(String.format("%s hyökkää, kohteenaan %s\n", attackingLutemon.getName(), defendingLutemon.getName()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", attackingLutemon.getName(), attackingLutemon.getHealth(), attackingLutemon.getMaxHealth()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", defendingLutemon.getName(), defendingLutemon.getHealth(), defendingLutemon.getMaxHealth()));
                    adapter.notifyDataSetChanged();

                    if (defendingLutemon.getHealth() == 0) {
                        txtOctagon.append(String.format("%s voitti taistelun.\n", attackingLutemon.getName()));
                        txtOctagon.append(String.format("Taistelu on ohi."));
                        attackingLutemon.increaseWins();
                        defendingLutemon.increaseLosses();
                        defendingLutemon.increaseExp();
                        storage.removeLutemon(defendingLutemon, "Battlefield");
                        storage.addLutemon(defendingLutemon, "Home");
                        endOfBattle = true;
                        adapter.notifyDataSetChanged();
                        break;
                    }
                } else {
                    txtOctagon.append(String.format("%s hyökkää, kohteenaan %s\n", attackingLutemon.getName(), defendingLutemon.getName()));
                }

                damage = defendingLutemon.attack() - attackingLutemon.defence() + (int) (Math.random() * 4);

                if (damage > 0) {
                    attackingLutemon.damageControl(damage);
                    txtOctagon.append(String.format("%s hyökkää, kohteenaan %s\n", defendingLutemon.getName(), defendingLutemon.getName()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", attackingLutemon.getName(), attackingLutemon.getHealth(), attackingLutemon.getMaxHealth()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", defendingLutemon.getName(), defendingLutemon.getHealth(), defendingLutemon.getMaxHealth()));
                    adapter.notifyDataSetChanged();

                    if (attackingLutemon.getHealth() == 0) {
                        txtOctagon.append(String.format("%s voitti taistelun.\n", defendingLutemon.getName()));
                        txtOctagon.append(String.format("Taistelu on ohi."));
                        defendingLutemon.increaseWins();
                        attackingLutemon.increaseLosses();
                        defendingLutemon.increaseExp();
                        storage.removeLutemon(attackingLutemon, "Battlefield");
                        storage.addLutemon(attackingLutemon, "Home");
                        endOfBattle = true;
                        adapter.notifyDataSetChanged();
                        break;
                    }
                } else {
                    txtOctagon.append(String.format("%s hyökkää, kohteenaan %s\n", defendingLutemon.getName(), attackingLutemon.getName()));
                }
            }
                txtFight.setText(txtOctagon.toString());
            }
            adapter.notifyDataSetChanged();
        }
    }


