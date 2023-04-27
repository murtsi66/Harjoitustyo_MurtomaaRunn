package com.example.harjoitustyo_murtomaarunn;

import java.io.Serializable;

public class Lutemon implements Serializable {
    private boolean isChecked;
    protected String name;
    protected int id;
    protected String color;
    protected int health;
    protected int maxHealth;
    protected int experience;
    protected int image;
    protected int wins;
    protected int losses;
    protected int trainingDays;
    protected int attack;
    protected int defence;
    protected static int idCounter = 0;
    Storage storage;

    // Constructor to create a Lutemon object
    public Lutemon(String name, String color, int attack, int defence, int experience, int health, int maxHealth, int trainingDays, int image)   {
        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.maxHealth = maxHealth;
        this.health = health;
        this.experience = experience;
        this.trainingDays = trainingDays;
        this.wins = 0;
        this.losses = 0;
        this.image = image;
        storage = Storage.getInstance();
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
        experience++;
    }

    public void increaseTrainingDays()  {

        trainingDays++;
    }
    public void damageControl(int damage) {
        this.health = this.health - damage;
        if(health < 0){
            health = 0;
        }
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
