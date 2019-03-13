package com.codecool;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;
import com.codecool.api.partakens.HistoricalData;
import com.codecool.api.partakens.Smurf;
import com.codecool.api.partakens.Snail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stable {
    private Snail[] snails;
    
    public void LoadData() {
        /*ArrayList<ArrayList<String>> snail = new ArrayList<ArrayList<String>>();
        this.snail.HistoricalData.fileReading("/target/snails.csv");*/
        <ArrayList<String>>snail = HistoricalData.fileReading("/target/snaildata.csv");
        Snail[] snails = new Snail[snail.size()];
        
        for (int i = 0; i < snail.size(); i++) {
            snails[i] = new Snail(snail.get(i).get(0), Double.parseDouble(snail.get(i).get(1)), Double.parseDouble(snail.get(i).get(2)), Food.valueOf(snail.get(i).get(3)), Field.valueOf(snail.get(i).get(4)), Integer.parseInt(snail.get(i).get(5)));
        }
        
        this.snails = snails;
    }
    
    private static class Racer {
        Snail snail;
        Smurf smurf;
        
        public Racer(Snail snail, Smurf smurf) {
            this.snail = snail;
            this.smurf = smurf;
        }
    }
    
}
