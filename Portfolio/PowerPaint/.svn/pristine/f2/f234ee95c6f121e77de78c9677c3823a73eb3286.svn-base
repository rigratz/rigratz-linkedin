/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * This class creates the listener for the Exit menu item.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
@SuppressWarnings("serial")
public class ExitAction extends AbstractAction {

    /**
     * Constructor of the Exit action.
     * 
     * @param theName is the text for the action.
     * @param theMnemonic is the mnemonic key.
     */
    public ExitAction(final String theName, final int theMnemonic) {
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
        System.exit(0);     
    }
    
}
