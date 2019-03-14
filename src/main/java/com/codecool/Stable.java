package com.codecool;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;
import com.codecool.api.partakens.HistoricalData;
import com.codecool.api.partakens.Smurf;
import com.codecool.api.partakens.Snail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Stable {
    
    private String name;
    private Snail[] snails;
    private Smurf[] smurfs;
    public final int RACERS = 5;
    
    public Stable(String name, Snail[] snails, Smurf[] smurfs) {
        this.name = name;
        this.snails = snails;
        this.smurfs = smurfs;
    }
    
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
    
    public int getRandom(int range) {
        int random = new Random().nextInt(range);
        return random;
    }
    
    public ArrayList<Snail> selectHorses() {
        ArrayList<Snail> horses = new ArrayList<>();
        int range = snails.length;
        
        while (horses.size() < RACERS) {
            int horseCode = getRandom(range);
            Snail newSnail = snails[horseCode];
            if (!horses.contains(newSnail)) {
                horses.add(newSnail);
            }
        }
        
        return horses;
    }
    
    public ArrayList<String> selectJockeys() {
        ArrayList<String> jockey = new ArrayList<>();
        int range = smurfs.length;
        
        while (jockey.size() < RACERS) {
            int jockeyCode = getRandom(range);
            String newSmurf = smurfs[jockeyCode].getName();
            if (!jockey.contains(newSmurf)) {
                jockey.add(newSmurf);
            }
        }
        
        return jockey;
    }
    
    public double findSmurfWeight(String name) {
        for (Smurf smurf : smurfs) {
            if (smurf.getName().equals(name)) {
                return smurf.getWeight();
            }
        }
        
        return 0;
    }
}
