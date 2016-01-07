/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package tools;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import java.util.List;

/**
 * Tool for drawing straight lines.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public class Line extends AbstractTool {

    /**
     * Constructor for the line object.
     */
    public Line() {
        super('L');
    }

    /**
     * Draws a line.
     * 
     * @param theGraphics is the program's graphics.
     * @param thePath is a set of points.
     */
    @Override
    public void drawShape(final Graphics2D theGraphics, final List<Point> thePath) {
        theGraphics.draw(new Line2D.Double(getStart(thePath), getEnd(thePath)));       
    }
}
