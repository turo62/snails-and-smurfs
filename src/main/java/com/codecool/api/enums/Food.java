package com.codecool.api.enums;

public enum Food {
    GRASS(0),
    LEAVES(1),
    MITES(4),
    EARTHWORM(5);
    
    public final int value;
    
    Food(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
