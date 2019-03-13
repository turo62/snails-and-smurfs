package com.codecool;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;
import com.codecool.api.partakens.HistoricalData;
import com.codecool.api.partakens.Snail;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.ArrayList;

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
            System.out.println(csCsCs);
            csCsCs.printStable();
        } catch (FileNotFoundException f) {
            System.out.println(f);
        } catch (IOException i) {
            System.out.println(i);
        }
    }
}


