/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package tools;

import java.awt.Point;
import java.util.List;

/**
 * Abstract tool object for creating a variety of shapes.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public abstract class AbstractTool implements Tool {


    /**
     * Letter representing the tool.
     */
    private final char myLetter;
    
    /**
     * Constructor for a tool.
     * 
     * @param theChar a char representing the tool type. Mainly only to be used for debugging.
     */
    public AbstractTool(final char theChar) {
        myLetter = theChar;
    }

    /**
     * Get the letter of the tool.
     * 
     * @return the letter.
     */
    public char getLetter() {
        return myLetter;
    }
    
    /**
     * Gets the start point for a shape.
     * 
     * @param thePath is the path of the mouse drag.
     * 
     * @return the starting point.
     */
    @Override
    public Point getStart(final List<Point> thePath) {
        return thePath.get(0);
    }
    
    /**
     * Gets the end point for a shape.
     * 
     * @param thePath is the path of the mouse drag.
     * 
     * @return the ending point.
     */
    @Override
    public Point getEnd(final List<Point> thePath) {
        return thePath.get(thePath.size() - 1);
    }
    
    /**
     * Gets the width of a shape.
     * 
     * @param theEnd is the ending point.
     * @param theStart is the starting point.
     * 
     * @return the Width.
     */
    @Override
    public double calculateWidth(final Point theEnd, final Point theStart) {
        return theEnd.getX() - theStart.getX();
    }

    /**
     * Gets the height of a shape.
     * 
     * @param theEnd is the ending point.
     * @param theStart is the starting point.
     * 
     * @return the Height.
     */
    @Override
    public double calculateHeight(final Point theEnd, final Point theStart) {
        return theEnd.getY() - theStart.getY();
    }
}
