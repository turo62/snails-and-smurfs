package com.codecool.api.partakens;

import com.codecool.api.enums.Affinity;

public class Smurf {
    private String name;
    private int weight;
    private Affinity like;
    
    public Smurf(String name, int weight, Affinity like) {
        this.name = name;
        this.weight = weight;
        this.like = like;
    }
    
    public String getName() {
        return name;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public Affinity getLike() {
        return like;
    }
}
