package com.codecool.api.partakens;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;

public class Snail {
    private String name;
    private double speed;
    private double fatigability;
    private Food food;
    private Field field;
    private int raceNo = 0;
    
    public Snail(String name, double speed, double fatigability, Food food, Field field, int raceNo) {
        this.name = name;
        this.speed = speed;
        this.fatigability = fatigability;
        this.food = food;
        this.field = field;
        this.raceNo = raceNo;
    }
    
    public String getName() {
        return name;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public double getFatigability() {
        return fatigability;
    }
    
    public void setFatigability(int fatigability) {
        this.fatigability = fatigability;
    }
    
    public Food getFood() {
        return food;
    }
    
    public Field getField() {
        return field;
    }
    
    public int getRaceNo() {
        return raceNo;
    }
    
    public String toString() {
        return "Name: " + getName() + " speed: " + getSpeed() + " cm/h  fatigue: " + getFatigability() + " % food: " + getFood() + " racefield: " + getField() + " number of races: " + getRaceNo();
    }
}
