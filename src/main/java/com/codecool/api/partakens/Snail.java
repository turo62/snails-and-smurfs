package com.codecool.api.partakens;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;

public class Snail {
    private String name;
    private int speed;
    private int fatigability;
    private Food food;
    private Field field;
    private int raceNo = 0;
    
    public Snail(String name, int speed, int fatigability, Food food, Field field, int raceNo) {
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
    
    public int getSpeed() {
        return speed;
    }
    
    public int getFatigability() {
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
        return "Name: " + getName() + " speed: " + getSpeed() + "  fatigue: " + getFatigability() + "% food: " + getFood().getValue() + " racefield: " + getField().getValue() + " number of races: " + getRaceNo();
    }
}
