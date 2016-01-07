/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 * This class creates the listener for the pencil menu item.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
@SuppressWarnings("serial")
public class LineAction extends AbstractAction {

    /**
     * The panel being acted on.
     */
    private final DrawingPanel myPanel;
    
    /**
     * Constructor of the Line action.
     * 
     * @param theName is the text for the action.
     * @param theIcon is the tool icon.
     * @param theMnemonic is the mnemonic key.
     * @param thePanel is the drawing panel.
     */
    public LineAction(final String theName, final ImageIcon theIcon,
                        final Integer theMnemonic, final DrawingPanel thePanel) {
        super(theName, theIcon);
        putValue(MNEMONIC_KEY, theMnemonic);
        putValue(SELECTED_KEY, Boolean.TRUE);
        myPanel = thePanel;
    }
    
    /**
     * Implementation of the action performed method of the ActionListener interface.
     * 
     * @param theE is the action event.
     */
    @Override
    public void actionPerformed(final ActionEvent theE) {
        myPanel.setTool(DrawingPanel.LINE);
        putValue(SELECTED_KEY, Boolean.TRUE);
        
    }
    
}
