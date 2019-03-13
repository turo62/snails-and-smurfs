package com.codecool.api.partakens;

public class Smurf {
    private String name;
    private double weight;
    
    public Smurf(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public String toString() {
        return "Name: " + name + ", weight: " + weight + "gr.";
    }
}
