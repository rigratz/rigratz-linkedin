/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package tools;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;
import java.util.List;

/**
 * Tool for drawing rectangles.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public class Rectangle extends AbstractTool {

    /**
     * Constructor for Rectangle tool.
     */
    public Rectangle() {
        super('R');
    }

    /**
     * Draws a rectangle.
     * 
     * @param theGraphics are the program's graphics.
     * @param thePath is the set of points for the rectangle.
     */
    @Override
    public void drawShape(final Graphics2D theGraphics, final List<Point> thePath) {
        final Point start = getStart(thePath);
        final Point end = getEnd(thePath);
        
        if (calculateWidth(end, start) >= 0 && calculateHeight(end, start) >= 0) {
            
            theGraphics.draw(new Rectangle2D.Double(start.getX(), start.getY(), 
                         calculateWidth(end, start), calculateHeight(end, start)));
        
        } else if (calculateWidth(end, start) >= 0 
                                                    && calculateHeight(end, start) < 0) {
            
            theGraphics.draw(new Rectangle2D.Double(start.getX(), end.getY(), 
                                                              calculateWidth(end, start),
                                                 Math.abs(calculateHeight(end, start))));
        
        } else if (calculateWidth(end, start) < 0 
                                                   && calculateHeight(end, start) >= 0) {
            
            theGraphics.draw(new Rectangle2D.Double(end.getX(), start.getY(), 
                                                    Math.abs(calculateWidth(end, start)),
                                                           calculateHeight(end, start)));
        
        } else {
            
            theGraphics.draw(new Rectangle2D.Double(end.getX(), end.getY(), 
                                                    Math.abs(calculateWidth(end, start)),
                                                 Math.abs(calculateHeight(end, start))));
        }
    }
}
