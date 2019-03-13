package com.codecool;

import com.codecool.api.partakens.Smurf;
import com.codecool.api.partakens.Snail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stable {
    
    private List<Snail> snails = new ArrayList<>();
    private List<Smurf> smurfs = new ArrayList<>();
    
    private static class Racer {
        Snail snail;
        Smurf smurf;
        
        public Racer(Snail snail, Smurf smurf) {
            this.snail = snail;
            this.smurf = smurf;
        }
    }
    
}
