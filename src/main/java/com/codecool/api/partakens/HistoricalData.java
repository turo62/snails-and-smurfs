package com.codecool.api.partakens;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class HistoricalData {
    
    public ArrayList<ArrayList<String>> fileReading(String fileName) throws IOException, FileNotFoundException {
        ArrayList<ArrayList<String>> obj = new ArrayList<ArrayList<String>>();
        FileInputStream is = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line = br.readLine();
        
        while (line != null) {
            ArrayList<String> person = new ArrayList();
            int count = line.split(",").length;
            String[] temp = line.split(",");
            for (int i = 0; i < count; i++) {
                person.add(temp[i]);
            }
            obj.add(person);
            line = br.readLine();
        }
        
        is.close();
        
        return obj;
    }
}
