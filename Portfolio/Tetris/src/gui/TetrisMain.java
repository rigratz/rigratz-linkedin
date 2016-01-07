/*
 * TCSS 305
 * 
 * Final Assignment - Tetris
 */

package gui;

import com.sun.media.codec.audio.mp3.JavaDecoder;

import java.awt.EventQueue;

import javax.media.Codec;
import javax.media.PlugInManager;

/**
 * This class creates a game of Tetris.
 * 
 * @author Riley Gratzer
 * @version 1.0
 */
public final class TetrisMain {

    /**
     * Private constructor, to prevent instantiation of this class.
     */
    private TetrisMain() {
        throw new IllegalStateException();
    }

    /**
     * The main method, invokes the PowerPaint GUI. Command line arguments are
     * ignored.
     * 
     * @param theArgs Command line arguments.
     */
    public static void main(final String[] theArgs) {
        final Codec c = new JavaDecoder();
        PlugInManager.addPlugIn("com.sun.media.codec.audio.mp3.JavaDecoder",
                                c.getSupportedInputFormats(),
                                c.getSupportedOutputFormats(null),
                                PlugInManager.CODEC);
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final TetrisGUI gui = new TetrisGUI();
                gui.start();    
            }
        });
    }
}
