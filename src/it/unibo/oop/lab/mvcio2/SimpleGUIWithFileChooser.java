package it.unibo.oop.lab.mvcio2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import it.unibo.oop.lab.mvcio.Controller;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    /*
     * TODO: Starting from the application in mvcio:
     * 
     * 1) Add a JTextField and a button "Browse..." on the upper part of the
     * graphical interface.
     * Suggestion: use a second JPanel with a second BorderLayout, put the panel
     * in the North of the main panel, put the text field in the center of the
     * new panel and put the button in the line_end of the new panel.
     * 
     * 2) The JTextField should be non modifiable. And, should display the
     * current selected file.
     * 
     * 3) On press, the button should open a JFileChooser. The program should
     * use the method showSaveDialog() to display the file chooser, and if the
     * result is equal to JFileChooser.APPROVE_OPTION the program should set as
     * new file in the Controller the file chosen. If CANCEL_OPTION is returned,
     * then the program should do nothing. Otherwise, a message dialog should be
     * shown telling the user that an error has occurred (use
     * JOptionPane.showMessageDialog()).
     * 
     * 4) When in the controller a new File is set, also the graphical interface
     * must reflect such change. Suggestion: do not force the controller to
     * update the UI: in this example the UI knows when should be updated, so
     * try to keep things separated.
     */
    private final JFrame frame = new JFrame();
    public SimpleGUIWithFileChooser(final Controller controller) {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / 2, sh / 2);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("My first graphical interface");
        final JPanel myPanel = new JPanel();
        myPanel.setLayout(new BorderLayout());
        frame.add(myPanel);
        final JTextArea myTextArea = new JTextArea();
        myPanel.add(myTextArea);
        final JButton myButton = new JButton("Save");
        myPanel.add(myButton, BorderLayout.SOUTH);
        myButton.addActionListener(new ActionListener() {

            public void actionPerformed(final ActionEvent e) {
                try {
                    controller.writeOnFile(myTextArea.getText());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });
        //above code from old file
        final JPanel secondPanel = new JPanel();
        secondPanel.setLayout(new BorderLayout());
        frame.add(secondPanel, BorderLayout.NORTH);
        final JTextField myTextField = new JTextField();
        myTextField.setEditable(false);
        //myTextField.setText(controller.getfilePath());
        secondPanel.add(myTextField, BorderLayout.CENTER);
        final JButton browseButton = new JButton("Browse");
        secondPanel.add(browseButton, BorderLayout.LINE_END);
        final JFileChooser fc = new JFileChooser();
        browseButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent e) {
                try {
                    final int returnVal = fc.showSaveDialog(frame);
                            if (returnVal == JFileChooser.APPROVE_OPTION) {
                                final File file = fc.getSelectedFile();
                                myTextField.setText(file.getPath());
                                controller.setNewCurrentFile(file);
                            }
                } catch (Exception h) {
                    JOptionPane.showMessageDialog(fc, h);
                }
            }
        });
        frame.setVisible(true);
    }
    /**
     * 
     * @param args ignored
     * @throws IOException 
     */
    public static void main(final String[] args) {
        new SimpleGUIWithFileChooser(new Controller());
    }
}
