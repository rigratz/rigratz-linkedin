/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import javax.swing.Icon;


/**
 * Creates a dynamic color icon. The code is mostly taken right from the supplied
 * CodeBeach.com link in the assignment pdf file. Then I cleaned everything up so it more
 * closely fits our class' code specifications.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public class ColorIcon implements Icon {
    
    /**
     * Height of the icon.
     */
    private static final int HEIGHT = 14;  
    
    /**
     * Width of the icon. 
     */
    private static final int WIDTH = 14;  
  
    /**
     * The icon's color.
     */
    private final Color myColor; 
    
    /**
     * Constructor of the color icon.
     * 
     * @param theColor is the color.
     */
    public ColorIcon(final Color theColor) {  
        myColor = theColor;  
    }  
    
    /**
     * Gets the height of the icon.
     * 
     * @return the icon height.
     */
    public int getIconHeight() {  
        return HEIGHT;  
    }  
    
    /**
     * Gets the width of the icon.
     * 
     * @return the icon width.
     */
    public int getIconWidth() {  
        return WIDTH;  
    }  
    
    /**
     * Paints the color icon.
     * 
     * @param theC the component of the icon.
     * @param theG is the program's graphics.
     * @param theX the X of the rectangle to start at.
     * @param theY the Y of the rectangle to start at.
     */
    public void paintIcon(final Component theC, final Graphics theG, final int theX, 
                                                                              final int theY) {
        theG.setColor(myColor);  
        theG.fillRect(theX, theY, WIDTH - 1, HEIGHT - 1);  
  
        theG.setColor(Color.black);  
        theG.drawRect(theX, theY, WIDTH - 1, HEIGHT - 1);  
    }  
}  
