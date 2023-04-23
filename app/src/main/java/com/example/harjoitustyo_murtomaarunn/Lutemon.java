package com.example.harjoitustyo_murtomaarunn;

import java.io.Serializable;

public class Lutemon implements Serializable {
    private boolean isChecked;
    private String name;
    private int id;
    private String color;
    private int health;
    private int maxHealth;
    private int experience;
    private int image;
    private int wins;
    private int losses;
    private int trainingDays;
    private int attack;
    private int defence;
    private static int idCounter = 0;
    private Storage storage;

    // Constructor to create a Lutemon object
    public Lutemon(String name, String color)   {
        this.name = name;
        this.color = color;
        this.experience = 0;
        this.trainingDays = 0;
        this.wins = 0;
        this.losses = 0;
        this.id = idCounter++;
        storage = Storage.getInstance();

        switch (color)  {
            case    "Pink":
                this.attack = 7;
                this.defence = 2;
                this.maxHealth = 18;
                this.image = R.drawable.pink_lutemon;
                break;
            case    "Black":
                this.attack = 9;
                this.defence = 0;
                this.maxHealth = 16;
                this.image = R.drawable.black_lutemon;
                break;
            case    "White":
                this.attack = 5;
                this.defence = 4;
                this.maxHealth = 20;
                this.image = R.drawable.white_lutemon;
                break;
            case    "Green":
                this.attack = 6;
                this.defence = 3;
                this.maxHealth = 19;
                this.image = R.drawable.green_lutemon;
                break;
            case    "Orange":
                this.attack = 8;
                this.defence = 1;
                this.maxHealth = 17;
                this.image = R.drawable.orange_lutemon;
                break;
            default:
                System.out.println("Invalid color");
                break;
        }
    }

    public int attack() {
        return attack;
    }

    public int defence()    {
        return defence;
    }

    public void increaseWins()  {
        wins++;
    }

    public void increaseLosses()  {
        losses++;
    }

    public void increaseExp()  {
        experience++;
    }

    public void increaseTrainingDays()  {
        trainingDays++;
    }

    public void printStats()    {
    }

    // Getters and setters for Lutemon attributes
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getExperience() {
        return experience;
    }

    public int getImage() {
        return image;
    }

    public int getWins() {
        return wins;
    }

    public int getLosses() {
        return losses;
    }

    public int getTrainingDays() {
        return trainingDays;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public static int getNumberOfCreatedLutemons()  {
        return idCounter;
    }

    public void setMaxHealth()  {
        health = maxHealth;
    }

    public boolean isChecked()  {
        return isChecked;
    }

    public void setChecked(boolean isChecked)   {
        this.isChecked = isChecked;
    }
}
