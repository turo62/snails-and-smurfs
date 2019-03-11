package com.codecool.api.enums;

public enum Field {
    GRASS(0),
    MARSH(1),
    SAND(2);
    
    public final int value;
    
    Field(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
