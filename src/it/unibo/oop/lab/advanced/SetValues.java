package it.unibo.oop.lab.advanced;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SetValues {
    private int min;
    private int max;
    private int attempts;
    private static final String FILE = "config.yml";
    /**
     * read from file.
     */
    public void readFromFile() {
        try (BufferedReader r = new BufferedReader(
             new InputStreamReader(ClassLoader.getSystemResourceAsStream(FILE)))
            ) {
            String s;
            while ((s = r.readLine()) != null) {
                final String[] splitter = s.split(":");
                if (splitter[0].contains("max")) {
                    //System.out.println("max" + splitter[1]);
                    final int num = Integer.parseInt(splitter[1].trim());
                    this.max = num; 
                } else if (splitter[0].contains("min")) {
                    //System.out.println("min" + splitter[1]);
                    final int num = Integer.parseInt(splitter[1].trim());
                    this.min = num;
                } else if (splitter[0].contains("attempts")) {
                    //System.out.println("attempts" + splitter[1]);
                    final int num = Integer.parseInt(splitter[1].trim());
                    this.attempts = num;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 
     * @return a
     */
    public int getMin() {
        return min;
    }
    /**
     * 
     * @return a
     */
    public int getMax() {
        return max;
    }
    /**
     * 
     * @return a
     */
    public int getAttempts() {
        return attempts;
    }
    /**
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        final SetValues s1 = new SetValues();
        s1.readFromFile();
        //System.out.println(s1.getAttempts());
        //System.out.println(s1.getMax());
        //System.out.println(s1.getMin());
    }
}
