/*
 * TCSS 305
 * 
 * Final Assignment - Tetris
 */

package gui;

import java.awt.event.KeyEvent;


/**
 * Class containing the game's controls.
 * 
 * @author Riley Gratzer
 * @version 1.0
 */

public class Controls {

    /**
     * The left key.
     */
    private int myLeft;
    
    /**
     * The right key.
     */
    private int myRight;
    
    /**
     * The down key.
     */
    private int myDown;
    
    /**
     * The drop key.
     */
    private int myDrop;
    
    /**
     * The Rotate CCW key.
     */
    private int myCCW;
    
    /**
     * The Rotate CW key.
     */
    private int myCW;
    
    /**
     * The hold key.
     */
    private int myHold;
    
    /**
     * The pause key.
     */
    private int myPause;
    
    /**
     * Constructor sets default controls.
     */
    public Controls() {
        gameEnd();
    }
    
/*
 * Public Get methods.
 */
    
    /**
     * Gets the left key.
     * 
     * @return the left key.
     */
    public int getLeft() {
        return myLeft;
    }
    
    /**
     * Gets the right key.
     * 
     * @return the right key.
     */
    public int getRight() {
        return myRight;
    }
    
    /**
     * Gets the down key.
     * 
     * @return the down key.
     */
    public int getDown() {
        return myDown;
    }
    
    /**
     * Gets the drop key.
     * 
     * @return the drop key.
     */
    public int getDrop() {
        return myDrop;
    }
    
    /**
     * Gets the Rotate CCW key.
     * 
     * @return the Rotate CCW key.
     */
    public int getCCW() {
        return myCCW;
    }
    
    /**
     * Gets the Rotate CW key.
     * 
     * @return the Rotate CW key.
     */
    public int getCW() {
        return myCW;
    }
    
    /**
     * Gets the hold key.
     * 
     * @return the hold key.
     */
    public int getHold() {
        return myHold;
    }
    
    /**
     * Gets the pause key.
     * 
     * @return the pause key.
     */
    public int getPause() {
        return myPause;
    }

/*
 * Public Set methods. These are currently unused, but I intend to continue working on this
 * game and add functionality to change keys.
 */
    
    /**
     * Sets a key to the left button.
     * 
     * @param theLeft the new key.
     */
    public void setLeft(final int theLeft) {
        myLeft = theLeft;
    }
    
    /**
     * Sets a key to the right button.
     * 
     * @param theRight the new key.
     */
    public void setRight(final int theRight) {
        myRight = theRight;
    }
    
    /**
     * Sets a key to the down button.
     * 
     * @param theDown the new key.
     */
    public void setDown(final int theDown) {
        myDown = theDown;
    }
    
    /**
     * Sets a key to the drop button.
     * 
     * @param theDrop the new key.
     */
    public void setDrop(final int theDrop) {
        myDrop = theDrop;
    }
    
    /**
     * Sets a key to the RotateCCW button.
     * 
     * @param theCCW the new key.
     */
    public void setCCW(final int theCCW) {
        myCCW = theCCW;
    }
    
    /**
     * Sets a key to the Rotate CW button.
     * 
     * @param theCW the new key.
     */
    public void setCW(final int theCW) {
        myCW = theCW;
    }
    
    /**
     * Sets a key to the hold button.
     * 
     * @param theHold the new key.
     */
    public void setHold(final int theHold) {
        myHold = theHold;
    }
    
    /**
     * Sets a key to the pause button.
     * 
     * @param thePause the new key.
     */
    public void setPause(final int thePause) {
        myPause = thePause;
    }
    
    /**
     * This method sets the controls to the default values.
     */
    public final void defaultControls() {
        myLeft = KeyEvent.VK_LEFT;
        myRight = KeyEvent.VK_RIGHT;
        myDown = KeyEvent.VK_DOWN;
        myDrop = KeyEvent.VK_UP;
        
        myCCW = 'z';
        myCW = 'x';
        myHold = 'a';
        
        myPause = KeyEvent.VK_ENTER;
    }
    
    /**
     * This method makes every button useless while the game is paused, with the exception
     * of the pause button itself.
     */
    public final void gamePaused() {     
        myLeft = -1;
        myRight = -1;
        myDown = -1;
        myDrop = -1;
        
        myCCW = -1;
        myCW = -1;
        myHold = -1;
        
        myPause = KeyEvent.VK_ENTER;
    }
    
    /**
     * This method makes every button useless when the game ends.
     */
    public final void gameEnd() {     
        myLeft = -1;
        myRight = -1;
        myDown = -1;
        myDrop = -1;
        
        myCCW = -1;
        myCW = -1;
        myHold = -1;
        
        myPause = -1;
    }
    
}
