/*
JAMES NGUYEN
820268781
Monday/Wednesday 5:30pm
*/
package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> patterns = readPattern(args[0]);
        System.out.println("Patterns: " + patterns);

        Queue values = readValues(args[1]);
        System.out.println("Values: " + Arrays.toString(values.peek(values.size())));

        Decode decoder = new Decode();
        Queue output = decoder.decode(patterns, values);
        output(output);
    }

    private static ArrayList<ArrayList<Integer>> readPattern(String fileName) {
        ArrayList<ArrayList<Integer>> list0 = new ArrayList<>();
        try {
            Scanner file = new Scanner(new File(fileName));
            file.useDelimiter(",");

            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] patternSplits = line.split(",");

                ArrayList<Integer> patternValues = new ArrayList<>();

                for (int i = 0; i <= patternSplits.length - 1; i++) {
                    patternValues.add(Integer.parseInt(patternSplits[i]));
                }
                list0.add(patternValues);
            }

            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list0;
    }

    private static Queue readValues(String fileName) {
        Queue list1 = new Queue();

        try {
            Scanner file = new Scanner(new File(fileName));
            file.useDelimiter(",");

            while (file.hasNextInt()) {
                list1.loadValue(file.nextInt());
            }
            file.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return list1;
    }

    private static void output(Queue output){
        int[] array = output.peek(output.size());
        try {
            File fileName = new File("output.csv");
            FileWriter fileWriter = new FileWriter(fileName);

            for (int i = 0; i <= array.length - 1; i++) {
                fileWriter.write(String.valueOf(array[i]));
                if(i != array.length - 1){
                    fileWriter.write(",");
                }
            }
            fileWriter.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

}

