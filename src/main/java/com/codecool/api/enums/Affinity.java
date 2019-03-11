package com.codecool.api.enums;

public enum Affinity {
    HATE(0),
    ACCEPT(1),
    LOVE(2);
    
    public final int value;
    
    Affinity(int value) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
}
