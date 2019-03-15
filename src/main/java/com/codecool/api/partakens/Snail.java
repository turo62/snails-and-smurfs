package com.codecool.api.partakens;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;

public class Snail {
    private String name;
    private int size;
    private double speed;
    private double fatigability;
    private Food food;
    private Field field;
    private int raceNo = 0;
    
    public Snail(String name, int size, double speed, double fatigability, Food food, Field field, int raceNo) {
        this.name = name;
        this.size = size;
        this.speed = speed;
        this.fatigability = fatigability;
        this.food = food;
        this.field = field;
        this.raceNo = raceNo;
    }
    
    public void setSpeed(int value) {
        this.speed = value;
    }
    
    public void setRaceNo(int raceNo) {
        this.raceNo += raceNo;
    }
    
    public String getName() {
        return name;
    }
    
    public int getSize() {
        return size;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public double getFatigability() {
        return fatigability;
    }
    
    public void setFatigability(double fatigability) {
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
        return "Name: " + getName() +
            ", size: " + getSize() +
            "mm, speed: " + getSpeed() +
            "m/h,  fatigue: " + getFatigability() +
            "%, food: " + getFood() +
            ", racefield: " + getField() +
            ", number of races: " + getRaceNo();
    }
}
