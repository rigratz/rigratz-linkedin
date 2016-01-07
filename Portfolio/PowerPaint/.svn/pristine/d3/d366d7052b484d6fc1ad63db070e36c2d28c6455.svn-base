/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Stroke;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * This class creates the listener for the thickness slider.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public class SliderAction implements ChangeListener {

    /**
     * The panel being acted on.
     */
    private final DrawingPanel myPanel;
    
    /**
     * Constructor of the Slider action.
     * 
     * @param thePanel is the drawing panel.
     */
    public SliderAction(final DrawingPanel thePanel) {
        myPanel = thePanel;
    }
    
    /**
     * Implementation of the action performed method of the ActionListener interface.
     * 
     * @param theE is the action event.
     */
    @Override
    public void stateChanged(final ChangeEvent theE) {
        final JSlider source = (JSlider) theE.getSource();
        final Stroke newStroke = new BasicStroke(source.getValue());
        
        myPanel.setStroke(newStroke);
        
    }
    
}
