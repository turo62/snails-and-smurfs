package com.codecool;

import com.codecool.api.partakens.Smurf;
import com.codecool.api.partakens.Snail;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public String getWelcomeString() {
        return "Hi!";
    }

    public static void main(String[] args) {
        try {
            /*Snail putris = new Snail("Putris", 210, 1.5, Food.GRASS, Field.MARSH, 0);*/
            Main main = new Main();
            /*putris.setFatigability(15); */
            System.out.println(main.getWelcomeString());
            /*System.out.println(putris);
            System.out.println(putris.getSpeed());*/
            Stable csCsCs = Stable.createLocal();
            HistoricalData HD = new HistoricalData();
            /*racing(csCsCs, HD);
            racing(csCsCs, HD);
            racing(csCsCs, HD);*/
            int simulationCycles = 250;
            simulation(csCsCs, HD, simulationCycles);
            /*System.out.println(csCsCs);*/
            /*ArrayList<String> jockeyList = csCsCs.selectJockeys();
            ArrayList<Snail> horsesList = csCsCs.selectHorses();
            printMyList(jockeyList);
            printMyHorses(horsesList);
            System.out.println(csCsCs.findSmurfWeight(jockeyList.get(2)));
            csCsCs.printStable();*/
        } catch (FileNotFoundException f) {
            System.out.println(f);
        } catch (IOException i) {
            System.out.println(i);
        }
    }
    
    public static void printMyList(ArrayList<String> jockeyList) {
        int riders = jockeyList.size();
        for (int i = 0; i < riders; i++) {
            System.out.println(jockeyList.get(i));
        }
    }
    
    public static void printMyHorses(ArrayList<Snail> horsesList) {
        int riders = horsesList.size();
        for (int i = 0; i < riders; i++) {
            System.out.println(horsesList.get(i));
        }
    }
    
    public static void racing(Stable csCsCs, HistoricalData HD) {
        Snail[] snails = csCsCs.getSnails();
        Smurf[] smurfs = csCsCs.getSmurfs();
        ArrayList<String> result = csCsCs.run(csCsCs.getRacers());
        String filename = "history.csv";
        csCsCs.feeding();
        HD.generateData(result, filename);
    }
    
    public static void simulation(Stable csCsCs, HistoricalData HD, int simulationCycles) {
        for (int i = 0; i < simulationCycles; i++) {
            racing(csCsCs, HD);
        }
        
    }
}


