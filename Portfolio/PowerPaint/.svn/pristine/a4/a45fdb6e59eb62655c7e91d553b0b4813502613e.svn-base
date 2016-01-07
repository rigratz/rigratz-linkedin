/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;


import java.awt.EventQueue;

/**
 * This class is responsible for displaying the PowerPaint GUI.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public final class PowerPaintMain {


    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private PowerPaintMain() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the PowerPaint GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final PowerPaintGUI gui = new PowerPaintGUI();
                gui.start();    
            }
        });
    }

}
