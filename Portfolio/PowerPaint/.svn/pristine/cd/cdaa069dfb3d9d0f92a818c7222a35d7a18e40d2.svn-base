/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;
import javax.swing.JMenuItem;

/**
 * This class creates the listener for the Color menu item.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
@SuppressWarnings("serial")
public class ColorAction extends AbstractAction {

    /**
     * The panel being acted on.
     */
    private final DrawingPanel myPanel;
    
    /**
     * Constructor of the Color action.
     * 
     * @param theName is the text for the action.
     * @param theColorIcon is the dynamic color icon.
     * @param theMnemonic is the mnemonic key.
     * @param thePanel is the drawing panel.
     */
    public ColorAction(final String theName, final ColorIcon theColorIcon,
                        final Integer theMnemonic, final DrawingPanel thePanel) {
        super(theName, theColorIcon);
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
        final JColorChooser colorChooser = new JColorChooser();
        final Color newColor = JColorChooser.showDialog(colorChooser,
                                                  "Choose Drawing Color", Color.BLACK);
        myPanel.setColor(newColor);
        ((JMenuItem) theE.getSource()).setIcon(new ColorIcon(newColor));
        
    }
    
}
