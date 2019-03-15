package com.codecool;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;
import com.codecool.api.partakens.Smurf;
import com.codecool.api.partakens.Snail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Represents a real stable, containing smurfs and snails doing racing.
 * <p>
 * Note: this is a class-level comment.
 */
public class Stable {
    
    private String name;
    private Snail[] snails;
    private Smurf[] smurfs;
    public final int RACERS = 5;
    int raceLength;
    HashMap<String, Snail> racers = new HashMap<>();
    ArrayList<String> result = new ArrayList<>();
    
    /**
     * The constructor takes 3 arguments matching the stable's fields. Using this constructor initializes a complete stable.
     * <p>
     * Note: this is a constructor-level comment.
     *
     * @param name   name of stable
     * @param snails list of snails in the stable
     * @param smurfs list of smurfs in the stable
     */
    public Stable(String name, Snail[] snails, Smurf[] smurfs) {
        this.name = name;
        this.snails = snails;
        this.smurfs = smurfs;
    }
    
    
    /**
     *This constructor is similar to the other, but instead of taking two arraylists it takes as its argument two CSV filenames.
     *One pointing to `targe/smurfdata.csv` the other pointing to `target/snaildata.csv`.
     *When invoked (e.g. Stable = new Stable("CsCsCs (Csúcs Csigák Csapata)", "snaildata.csv", "smurfdata.csv") it reads and processes
     *the two files to initialize the two arraylist typed field of the class (the Smurf[] and the Snail[] arraylist).
     *
     *Note: this constructor should read the smurfs and snails from the files supplied as argument, create arraylists from these and then
     *invoke the other constructor using the {@code this} keyword to invoke the other constructor.
     * @param name name of the stable
     * @param snailsCsvPath list of snails in stable
     * @param smurfsCsvPath list of smurfs in stable
     * @throws IOException if the CSV paths that were supplied is not valid
     * @throws FileNotFoundException if there were problems while reading the files
     */
    public Stable(String name, String snailsCsvPath, String smurfsCsvPath) throws IOException, FileNotFoundException {
        this.name = name;
        HistoricalData HD = new HistoricalData();
        ArrayList<ArrayList<String>> snail = HD.load(snailsCsvPath);
        ArrayList<ArrayList<String>> smurf = HD.load(smurfsCsvPath);
        Snail[] snails = new Snail[snail.size()];
        Smurf[] smurfs = new Smurf[smurf.size()];
        
        for (int i = 0; i < snail.size(); i++) {
            snails[i] = new Snail(snail.get(i).get(0), Integer.parseInt(snail.get(i).get(1)), Double.parseDouble(snail.get(i).get(2)), Double.parseDouble(snail.get(i).get(3)), Food.valueOf(snail.get(i).get(4)), Field.valueOf(snail.get(i).get(5)), Integer.parseInt(snail.get(i).get(6)));
        }
        
        for (int i = 0; i < smurf.size(); i++) {
            smurfs[i] = new Smurf(smurf.get(i).get(0), Double.parseDouble(smurf.get(i).get(1)));
        }
        
        this.snails = snails;
        this.smurfs = smurfs;
    }
    
    /**
     * This static method is a shortcut for creating a "local" Stable.
     *      * It delegates to one of the constructors above.
     *      * When invoked it creates a Stable object having some real-life data from the implementer snails' real Stable for racing.
     *      *
     *      * Note: this a class or static method-level comment.
     * @return an instance of Stable initialized for racing with methods
     * @throws IOException if there were problems while reading the files
     * @throws FileNotFoundException if the CSV paths that were supplied is not valid
     */
    public static Stable createLocal() throws IOException, FileNotFoundException {
        return new Stable("CsCsCs (Csúcs Csigák Csapata)", "./target/snaildata.csv", "./target/smurfdata.csv");
    }
    
    public Snail[] getSnails() {
        return snails;
    }
    
    public Smurf[] getSmurfs() {
        return smurfs;
    }
    
    public int getRaceLength() {
        return raceLength;
    }
    
    /**
     * Converts some basic data of the stable to printable format.
     * @return stable's data.
     */
    public String toString() {
        return "Stable " + name + " was settled with " + smurfs.length + " smurfs & " + snails.length + " snails.";
    }
    
    /**
     * TO BE MOVED TO LOGGER ASAP.
     * Printing members of the stable.
     */
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
    
    /**
     * Generates random integer out of the provided range
     *
     * Note: this is method-level comment
     * @param range range of integers the random number is generated from. It is actually the number of racers.
     * @return an integer
     */
    public int getRandom(int range) {
        int random = new Random().nextInt(range);
        return random;
    }
    
    /**
     * Generates arraylist of snails actually will do racing.
     *
     * Note: this is method-level comment
     * @return arraylist of racing snails
     */
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
    
    /**
     * Generates arraylist of smurfs actually will do racing.
     *
     * Note: this is method-level comment
     * @return arraylist of racing smurfs
     */
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
    
    /**
     * Generates weight of the required smurf.
     *
     * Note: this is method-level comment
     * @param name name of smurf
     * @return integer weight of smurf
     */
    public double findSmurfWeight(String name) {
        for (Smurf smurf : smurfs) {
            if (smurf.getName().equals(name)) {
                return smurf.getWeight();
            }
        }
        
        return 0;
    }
    
    /**
     * Generates hashmap of racers.
     * <p>
     * Note: this is method-level comment
     *
     * @return hashmap of racers
     */
    public HashMap<String, Snail> getRacers() {
        ArrayList<String> jockey = selectJockeys();
        ArrayList<Snail> horses = selectHorses();
        for (int i = 0; i < RACERS; i++) {
            racers.put(jockey.get(i), horses.get(i));
        }
        
        return racers;
    }
    
    public int setRaceLength() {
        int range = RACERS;
        int raceLength = 10 * getRandom(range);
        
        return raceLength;
    }
    
    /**
     * Sets fatigability by smurf's weight / snail's size ratio
     *
     * @param racers hashmap of racers participating run.
     */
    public void setFittness(HashMap<String, Snail> racers) {
        for (int i = 0; i < racers.size(); i++) {
            Object key = racers.keySet().toArray()[i];
            Snail value = racers.get(key.toString());
            double rate = findSmurfWeight(key.toString()) / value.getSize();
            if (rate >= 5) {
                value.setFatigability(100);
            } else if (rate > 1 && rate < 5) {
                value.setFatigability(70);
            }
        }
    }
    
    public void feeding(HashMap<String, Snail> racers) {
        for (int i = 0; i < racers.size(); i++) {
            Object key = racers.keySet().toArray()[i];
            Snail value = racers.get(key.toString());
            double rate = findSmurfWeight(key.toString()) / value.getSize();
            if (rate >= 5) {
                value.setFatigability(100);
            } else if (rate > 1 && rate < 5) {
                value.setFatigability(70);
            }
        }
    }
    
    public ArrayList<String> run(HashMap<String, Snail> racers) {
    
    }
}
