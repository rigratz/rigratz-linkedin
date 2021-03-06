/*
 * TCSS 305 - Assignment 5: PowerPaint
 */

package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import tools.Ellipse;
import tools.Line;
import tools.Pencil;
import tools.Picture;
import tools.Rectangle;
import tools.Tool;


/**
 * This is the panel for drawing shapes in PowerPaint.
 * 
 * @author Riley Gratzer
 * @version 1.2
 */
@SuppressWarnings("serial")
public class DrawingPanel extends JPanel {  
    
    /**
     * The line tool.
     */
    public static final Tool LINE = new Line();
    
    /**
     * The rectangle tool.
     */
    public static final Tool RECTANGLE = new Rectangle();
    
    /**
     * The ellipse tool.
     */
    public static final Tool ELLIPSE = new Ellipse();
    
    /**
     * The pencil tool.
     */
    public static final Tool PENCIL = new Pencil();
    
    /**
     * The spacing of grid lines.
     */
    private static final int SPACING = 10;

    /**
     * Undo string for property change purposes.
     */
    private static final String UNDO_STRING = "Undo";
    
    /**
     * Redo/undo string for property change purposes.
     */
    private static final String REDO_UNDO_STRING = "Redo and Undo";
    
    /**
     * Undo string for making a new value in a property change event.
     */
    private static final String U = "U";
    
    /**
     * Redo/undo string for making a new value in a property change event.
     */
    private static final String R_U = "RU";
    
    /**
     * The color of the current shape.
     */
    private Color myColor;
    
    /**
     * List of points for a drawing.
     */
    private final List<Point> myPath;
    
    /**
     * The stroke of the drawing.
     */
    private Stroke myStroke;
    
    /**
     * Boolean value for if user is currently drawing or not.
     */
    private boolean myDrawing;
    
    /**
     * The grid's on or off value.
     */
    private boolean myGrid;

    /**
     * List of all previous shapes.
     */
    private final List<Picture> myPictures;
    
    /**
     * List of undone shapes that can be redone.
     */
    private final List<Picture> myRedoables;
    
    /**
     * The currently selected tool.
     */
    private Tool myTool;
    
    /**
     * Constructor for the drawing panel.
     */
    public DrawingPanel() {
        super();
        
        // Initialize the Drawing Panel's settings.
        initialize();
        
        // Create all necessary Array Lists.
        myPath = new ArrayList<Point>();        
        myPictures = new ArrayList<Picture>();
        myRedoables = new ArrayList<Picture>();
        
        // Add mouse listeners.
        addMouseListener(new MouseActions());
        addMouseMotionListener(new MouseActions());
    }
    
    /**
     * Initializes the settings used for drawing on the panel.
     */
    private void initialize() {
        myTool = PENCIL;
        myStroke = new BasicStroke();
        myColor = Color.BLACK;
        myGrid = false;
    }
    
    /**
     * Paints shapes on the panel.
     * 
     * @param theGraphics is the program's graphics.
     */
    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g = (Graphics2D) theGraphics;
        setBackground(Color.WHITE);
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                           RenderingHints.VALUE_ANTIALIAS_ON);        
        
        // Draw old shapes.
        if (!myPictures.isEmpty()) {
            for (final Picture drawing: myPictures) {
                if (isStrokeVisible(drawing.getStroke())) {
                    g.setColor(drawing.getColor());
                    g.setStroke(drawing.getStroke());
                
                    drawing.getTool().drawShape(g, drawing.getPath());
                }
            }
        }
        
        // Draw current shape.
        if (myDrawing && isStrokeVisible(myStroke)) {
            g.setColor(myColor);
            g.setStroke(myStroke);
            myTool.drawShape(g, myPath);
            myRedoables.clear();
        }
        
        // Draw grid (maybe)
        if (myGrid) {
            g.setColor(Color.GRAY);
            g.setStroke(new BasicStroke());
            drawGrid(g, SPACING);
        }       
    }
    
    /**
     * Changes the drawing color.
     * 
     * @param theColor is the color.
     */
    public void setColor(final Color theColor) {
        myColor = theColor;
    }
    
    /**
     * Returns the drawing color.
     * 
     * @return the color.
     */
    public Color getColor() {
        return myColor;
    }
    
    /**
     * Changes the stroke size.
     * 
     * @param theStroke is the drawing thickness.
     */
    public void setStroke(final Stroke theStroke) {
        myStroke = theStroke;
    }
    
    /**
     * Checks whether the stroke is set to zero or not. Strokes of zero should not 
     * be visible.
     * 
     * @param theStroke to be checked
     * @return the visibility.
     */
    public boolean isStrokeVisible(final Stroke theStroke) {
        return !theStroke.equals(new BasicStroke(0));
    }
    
    /**
     * Erases all drawings.
     */
    public void undoAll() {
        myPictures.clear();
        firePropertyChange("None", 0, "N");
        repaint();
    }
    
    /**
     * Erases last drawing. Erased drawing is also stored for possible redo.
     */
    public void undo() {
        myRedoables.add(myPictures.get(myPictures.size() - 1));
        myPictures.remove(myPictures.size() - 1);
        if (myPictures.isEmpty()) {
            firePropertyChange("Redo", 0, "R");
        } else {
            firePropertyChange(REDO_UNDO_STRING, 0, R_U);
        }
        repaint();
    }
    
    /**
     * Re-draws previously erased drawing.
     */
    public void redo() {
        myPictures.add(myRedoables.get(myRedoables.size() - 1));
        myRedoables.remove(myRedoables.size() - 1);
        if (myRedoables.isEmpty()) {
            firePropertyChange(UNDO_STRING, 0, U);
        } else {
            firePropertyChange(REDO_UNDO_STRING, 0, R_U);
        }
        repaint();
    }
    
    /**
     * Changes the current tool.
     * 
     * @param theTool is the new tool.
     */
    public void setTool(final Tool theTool) {
        myTool = theTool;
        
    }
    
    /**
     * Tells if the grid is enabled or not.
     * 
     * @return the grid's enabled status.
     */
    public boolean isGrid() {
        return myGrid;
    }
    
    /**
     * Changes the grid's enabled status.
     * 
     * @param theEnabler enables or disables the grid.
     */
    public void enableGrid(final boolean theEnabler) {
        myGrid = theEnabler;
        repaint();
    }
    
    /**
     * Gets the list of previously drawn shapes.
     * 
     * @return the list of pictures.
     */
    public List<Picture> getPictures() {
        return myPictures;
    }
    
    /**
     * Gets the list of undone shapes that are redoable.
     * 
     * @return the list of redoable pictures.
     */
    public List<Picture> getRedoables() {
        return myRedoables;
    }
     
    /**
     * Copies a list into a new list.
     * 
     * @param thePath is a list of points for the shape.
     * @return the copy.
     */
    private List<Point> copyPath(final List<Point> thePath) {
        final List<Point> copy = new ArrayList<Point>();
        for (final Point p: thePath) {
            copy.add(p);
        }
        return copy;
    }
    
    /**
     * Draws the grid.
     * 
     * @param theGraphics are the drawing graphics.
     * @param theSpacing is the spacing width of the grid lines.
     */
    private void drawGrid(final Graphics theGraphics, final int theSpacing) {
        for (int i = theSpacing; i <= getSize().width; i += theSpacing) {
            theGraphics.drawLine(i, 0, i, getSize().height);
        }

        for (int i = theSpacing; i <= getSize().height; i += theSpacing) {
            theGraphics.drawLine(0, i, getSize().width, i);
        }
    }

    /**
     * This class creates mouse listeners for drawing.
     * 
     * @author Riley Gratzer
     * @version 1.2
     */
    class MouseActions extends MouseAdapter {

        @Override
        public void mousePressed(final MouseEvent theE) {
            myDrawing = true;
            myPath.clear();
            myPath.add(theE.getPoint());
            repaint();
        }

        @Override
        public void mouseReleased(final MouseEvent theE) {
            myDrawing = false;
            myPath.add(theE.getPoint());
            final Picture drawing = new Picture(myTool, myColor, myStroke, copyPath(myPath));
            if (isStrokeVisible(drawing.getStroke())) {
                myPictures.add(drawing);
            }
            firePropertyChange(UNDO_STRING, 0, U);
            repaint();
            
        }

        @Override
        public void mouseDragged(final MouseEvent theE) {
            myPath.add(theE.getPoint());
            repaint();
        }
    }

}
