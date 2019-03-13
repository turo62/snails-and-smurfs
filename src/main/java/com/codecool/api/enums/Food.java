package com.codecool.api.enums;

public enum Food {
    GRASS(1),
    WORM(2);
    
    public final int value;
    
    Food(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
