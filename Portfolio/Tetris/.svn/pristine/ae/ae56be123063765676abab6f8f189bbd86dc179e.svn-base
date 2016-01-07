/*
 * TCSS 305
 * 
 * Final Assignment - Tetris
 */

package gui;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * This is a class to show the player the controls for Tetris.
 * 
 * @author Riley Gratzer
 * @version 1.0
 */
@SuppressWarnings("serial")
public class ControlPanel extends JPanel {

    /**
     * Initial dimension of the control panel.
     */
    private static final Dimension INITIAL_DIMENSION = new Dimension(200, 80);
    
    /**
     * Used to space out the strings of controls.
     */
    private static final int SPACING = 15;
    
    /**
     * String representation of left.
     */
    private String myLeft;
    
    /**
     * String representation of right.
     */
    private String myRight;
    
    /**
     * String representation of down.
     */
    private String myDown;
    
    /**
     * String representation of drop.
     */
    private String myDrop;
    
    /**
     * String representation of rotate CCW.
     */
    private String myCCW;
    
    /**
     * String representation of rotate CW.
     */
    private String myCW;
    
    /**
     * String representation of hold.
     */
    private String myHold;
    
    /**
     * String representation of pause/resume.
     */
    private String myPause;
    
    /**
     * Constructor of control panel.
     */
    public ControlPanel() {
        super();
        
        this.setPreferredSize(INITIAL_DIMENSION);
        initializeStrings();

        repaint();
    }
    
    /**
     * Assigns the strings for default controls.
     */
    private void initializeStrings() {
        myLeft = "Move Left - Left Arrow";
        myRight = "Move Right - Right Arrow";
        myDown = "Move Down - Down Arrow";
        myDrop = "Drop - Up Arrow";
        
        myCCW = "Rotate CCW - Z";
        myCW = "Rotate CW - X";
        myHold = "Hold - A";
        
        myPause = "Pause/Resume - Enter";
        repaint();
    }

    @Override
    public void paintComponent(final Graphics theGraphics) {
        super.paintComponent(theGraphics);
        final Graphics2D g = (Graphics2D) theGraphics;
        final Dimension size = this.getSize();
        
        final GradientPaint bg = new GradientPaint(0, 0, Color.YELLOW.darker().darker(), 
                                   (int) size.getWidth(), (int) size.getHeight(), Color.BLACK);
        
        g.setPaint(bg);
        g.fillRect(0, 0, (int) size.getWidth(), (int) size.getHeight());

        g.setColor(Color.WHITE);
        
        int y = 0;
        
        g.drawString(myLeft, 0, y);
        y += SPACING;
        
        g.drawString(myRight, 0, y);
        y += SPACING;
        
        g.drawString(myDown, 0, y);
        y += SPACING;
        
        g.drawString(myDrop, 0, y);
        y += SPACING;
        
        g.drawString(myCCW, 0, y);
        y += SPACING;
        
        g.drawString(myCW, 0, y);
        y += SPACING;
        
        g.drawString(myHold, 0, y);
        y += SPACING;
        
        g.drawString(myPause, 0, y);
    }

    
}
