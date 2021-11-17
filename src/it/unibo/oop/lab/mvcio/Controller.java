package it.unibo.oop.lab.mvcio;

import java.io.IOException;
import java.io.PrintStream;

public class Controller {

    /*
     * This class must implement a simple controller responsible of I/O access. It
     * considers a single file at a time, and it is able to serialize objects in it.
     * 
     * Implement this class with:
     * 
     * 1) A method for setting a File as current file
     * 
     * 2) A method for getting the current File
     * 
     * 3) A method for getting the path (in form of String) of the current File
     * 
     * 4) A method that gets a String as input and saves its content on the current
     * file. This method may throw an IOException.
     * 
     * 5) By default, the current file is "output.txt" inside the user home folder.
     * A String representing the local user home folder can be accessed using
     * System.getProperty("user.home"). The separator symbol (/ on *nix, \ on
     * Windows) can be obtained as String through the method
     * System.getProperty("file.separator"). The combined use of those methods leads
     * to a software that runs correctly on every platform.
     */
    private String filePath = System.getProperty("user.home")
    + System.getProperty("file.separator")
    + Controller.class.getSimpleName() + ".txt";
    private String fileName = Controller.class.getSimpleName();
    /**
     * 
     * @return the filePath
     */
    public String getfilePath() {
        return filePath;
    }
    /**
     * 
     * this method sets a new current file.
     * 
     * @param name is the new file name
     */
    public void setNewCurrentFile(final String name) {
        this.filePath = System.getProperty("user.home")
                + System.getProperty("file.separator")
                + name + ".txt";
        this.fileName = name;
    }
    /**
     * 
     * @return the file name
     */
    public String getCurrentFile() {
        return fileName;
    }
    /**
     * 
     * @param string is the string that is going to be written on file
     * @throws IOException
     */
    public void writeOnFile(final String string) throws IOException {
        try (PrintStream ps = new PrintStream(filePath)) {
            ps.print(string);
        }
    }
    /**
     * 
     * @param args ignored
     */
    public static void main(final String[] args) {
        final Controller c1 = new Controller();
        System.out.println(c1.getCurrentFile());
        c1.setNewCurrentFile("aa");
        System.out.println(c1.getCurrentFile());
    }
}
