/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package tools;

import java.awt.Color;
import java.awt.Point;
import java.awt.Stroke;
import java.util.List;

/**
 * Picture is an object that stores the data for shapes to be drawn.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public class Picture {

    /**
     * The color of the shape.
     */
    private final Color myColor;
    
    /**
     * The size of the stroke.
     */
    private final Stroke myStroke;

    /**
     * The set of points for the shape.
     */
    private final List<Point> myPath;

    /**
     * The tool used for the shape.
     */
    private final Tool myTool;
    
    /**
     * Constructor of the picture object.
     * 
     * @param theTool the tool used to draw the shape.
     * @param theColor the color of the shape.
     * @param theStroke the stroke of the shape.
     * @param thePath is a set of points for the shape.
     */
    public Picture(final Tool theTool, final Color theColor, final Stroke theStroke, 
                   final List<Point> thePath) {
        myTool = theTool;
        myPath = thePath;
        myColor = theColor;
        myStroke = theStroke;      
    }
    
    /**
     * Gets the color of the shape.
     *  
     * @return the color.
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     * Gets the stroke of the shape.
     * 
     * @return the stroke.
     */
    public Stroke getStroke() {
        return myStroke;
    }

    /**
     * Gets the path of points for the shape.
     * 
     * @return the path.
     */
    public List<Point> getPath() {
        return myPath;
    }
    
    /**
     * Gets the tool used to draw the shape.
     * 
     * @return the tool.
     */
    public Tool getTool() {
        return myTool;
    }
}
