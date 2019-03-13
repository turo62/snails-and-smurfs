package com.codecool;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;
import com.codecool.api.partakens.HistoricalData;
import com.codecool.api.partakens.Smurf;
import com.codecool.api.partakens.Snail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Stable {
    
    private String name;
    private Snail[] snails;
    private Smurf[] smurfs;
    
    public Stable(String name, Snail[] snails, Smurf[] smurfs) {
        this.name = name;
        this.snails = snails;
        this.smurfs = smurfs;
    }
    
    /*private static class Racer {
        Snail snail;
        Smurf smurf;
        
        public Racer(Snail snail, Smurf smurf) {
            this.snail = snail;
            this.smurf = smurf;
        }
    }*/
    
    public Stable(String name, String snailsCsvPath, String smurfsCsvPath) throws IOException, FileNotFoundException {
        this.name = name;
        HistoricalData HD = new HistoricalData();
        ArrayList<ArrayList<String>> snail = HD.fileReading(snailsCsvPath);
        ArrayList<ArrayList<String>> smurf = HD.fileReading(smurfsCsvPath);
        Snail[] snails = new Snail[snail.size()];
        Smurf[] smurfs = new Smurf[smurf.size()];
        
        for (int i = 0; i < snail.size(); i++) {
            snails[i] = new Snail(snail.get(i).get(0), Double.parseDouble(snail.get(i).get(1)), Double.parseDouble(snail.get(i).get(2)), Food.valueOf(snail.get(i).get(3)), Field.valueOf(snail.get(i).get(4)), Integer.parseInt(snail.get(i).get(5)));
        }
        
        for (int i = 0; i < smurf.size(); i++) {
            smurfs[i] = new Smurf(smurf.get(i).get(0), Double.parseDouble(smurf.get(i).get(1)));
        }
        
        this.snails = snails;
        this.smurfs = smurfs;
    }
    
    public static Stable createLocal() throws IOException, FileNotFoundException {
        return new Stable("CsCsCs (Csúcs Csigák Csapata)", "./target/snaildata.csv", "./target/smurfdata.csv");
    }
    
    public Snail[] getSnails() {
        return snails;
    }
    
    public Smurf[] getSmurfs() {
        return smurfs;
    }
    
    public String toString() {
        return "Stable " + name + " was settled with " + smurfs.length + " smurfs & " + snails.length + " snails.";
    }
    
    public void printStable() {
        System.out.println("\nJockeys:\n");
        for (Smurf smurf : smurfs) {
            System.out.println("\t" + smurf);
        }
        System.out.println("\nSnails:\n");
        for (Snail snail : snails) {
            System.out.println("\t" + snail);
        }
    }
    
}
