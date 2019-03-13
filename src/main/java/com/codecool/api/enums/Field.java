package com.codecool.api.enums;

public enum Field {
    GRASS(2),
    MARSH(1);
    
    public final int value;
    
    Field(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
