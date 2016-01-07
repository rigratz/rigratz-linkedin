/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package tools;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.util.Iterator;
import java.util.List;

/**
 * Tool for drawing free-hand lines and shapes.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
public class Pencil extends AbstractTool {

    /**
     * Constructor of the Pencil tool.
     */
    public Pencil() {
        super('P');
    }

    /**
     * Draws the free-hand lines and shapes.
     * 
     * @param theGraphics is the program's graphics.
     * @param thePath is the path of points to draw.
     */
    @Override
    public void drawShape(final Graphics2D theGraphics, final List<Point> thePath) { 
        final Path2D.Double path = new Path2D.Double();
        if (!thePath.isEmpty()) {
            final Stroke pencilStroke = new BasicStroke(((BasicStroke) 
                                                      theGraphics.getStroke()).getLineWidth(), 
                                                BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            final Iterator<Point> itr = thePath.iterator();
            while (itr.hasNext()) {
                final Point p1 = itr.next();
                if (itr.hasNext()) {
                    final Point p2 = itr.next();
                    path.append(new Line2D.Double(p1, p2), true);
                    path.moveTo(p2.getX(),  p2.getY());
                }
            }
            theGraphics.setStroke(pencilStroke);
            theGraphics.draw(path);
        }
    }
}
