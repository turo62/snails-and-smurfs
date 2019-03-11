package com.codecool.api.enums;

public enum Food {
    GRASS(0),
    LEAVES(1),
    MITES(2),
    EARTHWORM(3);
    
    public final int value;
    
    Food(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
