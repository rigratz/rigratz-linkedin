/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package tools;


import java.awt.Graphics2D;
import java.awt.Point;
import java.util.List;

/**
 * This interface is for drawing shapes with different tools.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public interface Tool {

    /**
     * Will draw a shape.
     * 
     * @param theGraphics is the program's graphics.
     * @param thePath is a set of points for a shape.
     */
    void drawShape(final Graphics2D theGraphics, final List<Point> thePath);
    
    /**
     * Gets the starting point of a shape.
     * 
     * @param thePath is a set of points.
     * @return the starting point.
     */
    Point getStart(final List<Point> thePath);
    
    /**
     * Gets the end point of a shape.
     * 
     * @param thePath is a set of points.
     * @return the end point.
     */
    Point getEnd(final List<Point> thePath);
    
    /**
     * Calculates the width of a shape.
     * 
     * @param theEnd the end of the shape.
     * @param theStart the start of the shape.
     * 
     * @return the width.
     */
    double calculateWidth(final Point theEnd, final Point theStart);
    
    /**
     * Calculates the height of a shape.
     * 
     * @param theEnd the end of the shape.
     * @param theStart the start of the shape.
     * 
     * @return the height.
     */
    double calculateHeight(final Point theEnd, final Point theStart);
}
