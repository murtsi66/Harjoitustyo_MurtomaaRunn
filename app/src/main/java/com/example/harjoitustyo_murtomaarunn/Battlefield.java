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
    private Context context;
    private Storage storage;
    private RecyclerView recyclerView;
    private FragmentAdapter adapter;
    private Button btnFight;
    private TextView txtFight;


    @Override
    protected void onCreate(Bundle savedInstanceState)  {
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
            Lutemon attacker = fighterLutemons.get(0);
            Lutemon defender = fighterLutemons.get(1);
            boolean battleOver = false;
            while (!battleOver) {
                // Attacker attacks defender
                int damage = attacker.attack() - defender.defence() + (int)(Math.random() * 5);
                if (damage > 0) {
                    defender.damageControl(damage);
                    txtOctagon.append(String.format("%s hyökkää kohti %s:tä\n", attacker.getName(), defender.getName()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", attacker.getName(), attacker.getHealth(), attacker.getMaxHealth()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", defender.getName(), defender.getHealth(), defender.getMaxHealth()));
                    adapter.notifyDataSetChanged();
                    if (defender.getHealth() == 0) {
                        txtOctagon.append(String.format("%s hävisi taistelun.\nTaistelu on ohi.", defender.getName()));
                        attacker.increaseWins();
                        defender.increaseLosses();
                        attacker.increaseExp();
                        battleOver = true;
                        adapter.notifyDataSetChanged();
                        break;
                    }
                } else {
                    txtOctagon.append(String.format("%s hyökkää kohti %s:tä\n", attacker.getName(), defender.getName()));
                }
                // Defender attacks attacker
                damage = defender.attack() - attacker.defence() + (int)(Math.random() * 3);
                if (damage > 0) {
                    attacker.damageControl(damage);
                    txtOctagon.append(String.format("%s hyökkää kohti %s:tä\n", defender.getName(), attacker.getName()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", attacker.getName(), attacker.getHealth(), attacker.getMaxHealth()));
                    txtOctagon.append(String.format("%s: Elämät:%d/%d\n", defender.getName(), defender.getHealth(), defender.getMaxHealth()));
                    adapter.notifyDataSetChanged();
                    if (attacker.getHealth() == 0) {
                        txtOctagon.append(String.format("%s hävisi taistelun.\nTaistelu on ohi.", attacker.getName()));
                        defender.increaseWins();
                        attacker.increaseLosses();
                        defender.increaseExp();
                        battleOver = true;
                        adapter.notifyDataSetChanged();
                        break;
                    }
                } else {
                    txtOctagon.append(String.format("%s hyökkää kohti %s:tä\n", defender.getName(), attacker.getName()));
                }
            }
            txtFight.setText(txtOctagon.toString());
        }
        adapter.notifyDataSetChanged();
        /*for (Lutemon lutemon : storage.getLutemons("battle")) {
            lutemon.setChecked(false);
        }*/
    }
}
        // TODO lisää tallennuss
       /* storage.saveLutemons();
    }
}*/