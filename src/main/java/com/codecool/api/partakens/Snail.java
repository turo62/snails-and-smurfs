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
}
