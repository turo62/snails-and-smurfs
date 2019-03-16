package com.codecool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.io.FileWriter;

public class HistoricalData {
    private FileWriter writer;
    
    public static ArrayList<ArrayList<String>> load(String fileName) throws FileNotFoundException, IOException {
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
    
    public void generateData(ArrayList<String> result, String fileName) { //writes one simulated round to a file. We recommend the CSV format
        try {
            this.writer = new FileWriter(fileName, true);
            for (String name : result) {
                writer.write(name + ",");
            }
            writer.write("\r\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("File not found!");
        }
    }
    
}
