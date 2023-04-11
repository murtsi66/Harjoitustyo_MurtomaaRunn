package com.example.harjoitustyo_murtomaarunn;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Storage implements Serializable {
    private static Storage instance = null;
    protected ArrayList<Lutemon> allLutemons;
    protected ArrayList<Lutemon> homeLutemons;
    protected ArrayList<Lutemon> battlefieldLutemons;
    protected ArrayList<Lutemon> trainingLutemons;

    private Storage()   {
        allLutemons = new ArrayList<>();
        homeLutemons = new ArrayList<>();
        battlefieldLutemons = new ArrayList<>();
        trainingLutemons = new ArrayList<>();
        instance = this;
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    // Methods to move Lutemons between places

    public void addLutemon(Lutemon lutemon, String lutemonPlace)    {
        switch (lutemonPlace)   {
            case "all":
                allLutemons.add(lutemon);
                break;
            case "home":
                homeLutemons.add(lutemon);
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

    public void removeLutemon(Lutemon lutemon, String lutemonPlace)    {
        switch (lutemonPlace)   {
            case "all":
                allLutemons.remove(lutemon);
                break;
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
    public ArrayList<Lutemon> getLutemons(String lutemonPlace)    {
        switch (lutemonPlace)   {
            case "all":
                return allLutemons;
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

    public Lutemon getLutemonById(int id)   {
        return allLutemons.get(id);
    }

    public void loadLutemons()  {
        // TEE
    }

    public void saveLutemons()  {
        // TEE
    }
}
