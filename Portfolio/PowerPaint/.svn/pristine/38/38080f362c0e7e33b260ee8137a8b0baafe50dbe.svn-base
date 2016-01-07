/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

/**
 * This class creates the listener for the grid menu item.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
@SuppressWarnings("serial")
public class GridAction extends AbstractAction {

    /**
     * The panel being acted on.
     */
    private final DrawingPanel myPanel;
    
    /**
     * Constructor of the grid action.
     * 
     * @param theName is the text for the action.
     * @param theMnemonic is the mnemonic key.
     * @param thePanel is the drawing panel.
     */
    public GridAction(final String theName, final Integer theMnemonic, 
                                                                 final DrawingPanel thePanel) {
        super(theName);
        putValue(MNEMONIC_KEY, theMnemonic);
        putValue(SELECTED_KEY, Boolean.FALSE);
        myPanel = thePanel;
    }
    
    /**
     * Implementation of the action performed method of the ActionListener interface.
     * 
     * @param theE is the action event.
     */
    @Override
    public void actionPerformed(final ActionEvent theE) {
        if (myPanel.isGrid()) {
            myPanel.enableGrid(false);
            putValue(SELECTED_KEY, Boolean.FALSE);
        } else {
            myPanel.enableGrid(true);
            putValue(SELECTED_KEY, Boolean.TRUE);
        }                   
    }
}
