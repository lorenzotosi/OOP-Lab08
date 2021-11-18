package it.unibo.oop.lab.mvc;

import java.util.ArrayList;
import java.util.List;

public class ControllerImpl implements Controller {

    private final List<String> stringList = new ArrayList<>();
    private String next;
    /**
     * 
     * @param next a
     * 
     */
    public void setNextStringToPrint(final String next) {
        if (next != null) {
            this.next = next;
        } else {
            final String msg = "The string is null";
            throw new IllegalArgumentException(msg);
        }
    }
    /**
     * 
     * @return a
     * 
     */
    public String getNextStringToPrint() {
        return this.next;
    }
    /**
     * 
     * @return a
     * 
     */
    public List<String> getHistoryOfPrints() {
        return this.stringList;
    }
    /**
     * 
     */
    public void printCurrentString() {
        if (this.next != null) {
            System.out.println(this.next);
            this.stringList.add(next);
        } else {
            final String msg = "The string is null";
            throw new IllegalStateException(msg);
        }
    }

}
