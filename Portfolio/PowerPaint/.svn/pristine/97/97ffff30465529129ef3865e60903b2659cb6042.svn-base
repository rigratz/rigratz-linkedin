/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

/**
 * This class creates the listener for the About menu item.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
@SuppressWarnings("serial")
public class AboutAction extends AbstractAction {

    /**
     * Constructor of the About action.
     * 
     * @param theName is the text for the action.
     * @param theMnemonic is the mnemonic key.
     */
    public AboutAction(final String theName, final int theMnemonic) {
        super(theName);
        putValue(MNEMONIC_KEY, theMnemonic);
        
    }
    
    /**
     * Implementation of the action performed method of the ActionListener interface.
     * 
     * @param theE is the action event.
     */
    @Override
    public void actionPerformed(final ActionEvent theE) {
        JOptionPane.showMessageDialog(null, "TCSS 305 PowerPaint, Winter 2015\n\nPowerPaint"
                                      + " paints powerfully.", 
                               "About PowerPaint", JOptionPane.INFORMATION_MESSAGE);
    }
    
}
