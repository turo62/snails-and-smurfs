package com.codecool;

import com.codecool.api.enums.Field;
import com.codecool.api.enums.Food;
import com.codecool.api.partakens.Snail;

public class Main {

    public String getWelcomeString() {
        return "Hi!";
    }

    public static void main(String[] args) {
        Snail putris = new Snail("Putris", 210, 2, Food.valueOf("EARTHWORM"), Field.MARSH, 0);
        Main main = new Main();
        putris.setFatigability(15);
        System.out.println(main.getWelcomeString());
        System.out.println(putris);
        System.out.println(putris.getSpeed());
    }
}
