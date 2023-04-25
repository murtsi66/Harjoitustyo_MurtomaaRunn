package com.example.harjoitustyo_murtomaarunn;

import java.io.Serializable;
import java.util.ArrayList;

// Three arraylists for storing Lutemon. Each Lutemon can be only in one list at a time.

public class Storage implements Serializable {
    private static Storage instance = null;
    protected ArrayList<Lutemon> homeLutemons;
    protected ArrayList<Lutemon> trainingLutemons;
    protected ArrayList<Lutemon> battlefieldLutemons;

    protected Storage() {
        homeLutemons = new ArrayList<>();
        trainingLutemons = new ArrayList<>();
        battlefieldLutemons = new ArrayList<>();
        instance = this;
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    // Methods to move Lutemons between places

    public void addLutemon(Lutemon lutemon, String lutemonPlace) {
        switch (lutemonPlace) {
            case "home":
                homeLutemons.add(lutemon);
                lutemon.setMaxHealth();
                break;
            case "training":
                trainingLutemons.add(lutemon);
                break;
            case "battlefield":
                battlefieldLutemons.add(lutemon);
                break;
            default:
                break;
        }
    }

    public void removeLutemon(Lutemon lutemon, String lutemonPlace) {
        switch (lutemonPlace) {
            case "home":
                homeLutemons.remove(lutemon);
                break;
            case "training":
                trainingLutemons.remove(lutemon);
                break;
            case "battlefield":
                battlefieldLutemons.remove(lutemon);
                break;
            default:
                break;
        }
    }

    // Method to get list of Lutemons in each place
    public ArrayList<Lutemon> getLutemons(String lutemonPlace) {
        switch (lutemonPlace) {
            case "home":
                return homeLutemons;
            case "training":
                return trainingLutemons;
            case "battlefield":
                return battlefieldLutemons;
            default:
                return null;
        }
    }
}
