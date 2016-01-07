/*
 * TCSS 305
 * 
 * Final Assignment - Tetris
 */

package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;

import model.Board;
import model.Board.GameStatus;
import model.TetrisPiece;

import sound.MusicPlayer;

/**
 * This class creates the GUI for playing Tetris.
 * 
 * @author Riley Gratzer
 * @version 1.0
 */
public class TetrisGUI implements ActionListener, Observer {

    /**
     * Timer's initial delay.
     */
    public static final int INITIAL_DELAY = 1000;
    
    /**
     * Number of random pieces to create.
     */
    private static final int NUM_OF_PIECES = 10000;
    
    /**
     * Initial dimension of info Box.
     */
    private static final Dimension BOX_DIMENSION = new Dimension(200, 480);
    
    /**
     * The frame containing the GUI elements of Tetris.
     */
    private final JFrame myFrame;
    
    /**
     * The game's board.
     */
    private Board myBoard;
    
    /**
     * The panel to draw the game board.
     */
    private final TetrisPanel myPanel;
    
    /**
     * The game's timer.
     */
    private final Timer myTimer;
    
    /**
     * The viewer of the next piece.
     */
    private NextPieceViewer myNextPieceViewer;
    
    /**
     * The game's score panel.
     */
    private ScorePanel myScorePanel;
    
    /**
     * The game's information stored in a box.
     */
    private final Box myInfoBox;
    
    /**
     * The frame's menu bar.
     */
    private final JMenuBar myMenuBar;
    
    /**
     * The menu item to start a game.
     */
    private final JMenuItem myStart;
    
    /**
     * The viewer of a hold piece.
     */
    private HoldPieceViewer myHoldViewer;
    
    /**
     * The game's controls.
     */
    private final Controls myControls;
    
    /**
     * The game's music player.
     */
    private final MusicPlayer myMusic;
    
    /**
     * Constructor of the TetrisGUI.
     */
    public TetrisGUI() {
        myFrame = new JFrame();
        myBoard = new Board();
        myTimer = new Timer(INITIAL_DELAY, this);
        myControls = new Controls();
        myPanel = new TetrisPanel(myBoard, myTimer, myControls);
        myStart = new JMenuItem("Start Game");
        myInfoBox = createInfoBox();
        myMenuBar = createMenuBar();
        myMusic = new MusicPlayer(); 
    }

    /**
     * Forms the GUI and starts the game.
     */
    public void start() {
        myFrame.addKeyListener(myPanel);
        myFrame.setTitle("Tetris");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        myFrame.setJMenuBar(myMenuBar);
        
        myFrame.setResizable(true);
        
        myFrame.add(myPanel, BorderLayout.CENTER);
        myFrame.add(myInfoBox, BorderLayout.EAST);

        myFrame.pack();
        myFrame.setMinimumSize(new Dimension(myFrame.getWidth(), myFrame.getHeight()));
        myFrame.setVisible(true);
    }

    /**
     * Creates 10000 pieces for the game.
     * 
     * @return the list of pieces.
     */
    private List<TetrisPiece> createPieces() {
        final List<TetrisPiece> pieces = new ArrayList<TetrisPiece>();
        for (int i = 0; i < NUM_OF_PIECES; i++) {
            pieces.add(TetrisPiece.getRandomPiece());
        }
        return pieces;
    }
    
    /**
     * Creates a board to play Tetris.
     * 
     */
    protected void createBoard() {
        myBoard = new Board();
        myPanel.newGameBoard(myBoard);
        myBoard.addObserver(this);
        myBoard.addObserver(myPanel);
        myBoard.addObserver(myNextPieceViewer);
        myBoard.addObserver(myScorePanel);
        myBoard.addObserver(myHoldViewer);
        myBoard.setPieceSequence(createPieces());
    }
    
    /**
     * Used to create the GUI's MenuBar.
     * 
     * @return the MenuBar.
     */
    private JMenuBar createMenuBar() {
        final JMenuBar menuBar = new JMenuBar();
        menuBar.add(fileMenu());
        menuBar.add(variantsMenu());
        menuBar.add(helpMenu());
        return menuBar;
    }
    /**
     * Creates the box with Score and next piece information.
     *  
     * @return the info box.
     */
    private Box createInfoBox() {
        createViewers();
        final Box infoBox = new Box(BoxLayout.Y_AXIS);
        infoBox.setBackground(Color.BLUE);
        infoBox.add(myNextPieceViewer);
        
        infoBox.add(myHoldViewer);
        
        infoBox.add(Box.createVerticalGlue());
        
        final ControlPanel c = new ControlPanel();
        infoBox.add(c);
        
        infoBox.add(myScorePanel);
        infoBox.setPreferredSize(BOX_DIMENSION);
        return infoBox;
    }
    
    /**
     * Creates viewers for info box.
     */
    private void createViewers() {
        myNextPieceViewer = new NextPieceViewer();
        myScorePanel = new ScorePanel(myTimer);
        myHoldViewer = new HoldPieceViewer();
    }
    
    /**
     * Creates the File JMenu.
     * 
     * @return the File menu.
     */
    private JMenu fileMenu() {
        final JMenu menu = new JMenu("File");

        /*
         * Magic numbers left in. 100 is an arbitrarily large number
         * used to create a file array so the music loops. Comment written out here
         * so anonymous class would not exceed checkstyle size of 20 lines.
         */
        
        myStart.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                final boolean tempTread = myBoard.isTreadmill();
                createBoard();
                if (tempTread) {
                    myBoard.toggleTreadmill();
                }
                myControls.defaultControls();
                myScorePanel.initialScore();
                myHoldViewer.removePiece();
                myTimer.setDelay(INITIAL_DELAY);
                myTimer.start();
                final File[] music = new File[100];
                for (int i = 0; i < 100; i++) {
                    music[i] = new File("sounds/tetris_v2.mp3");
                }
                myMusic.newList(music);
                myStart.setEnabled(false);
            }
        });
        menu.add(myStart);
        
        final JMenuItem endGame = new JMenuItem("End Game");
        endGame.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myTimer.stop();
                myMusic.stopPlay();
                myControls.gameEnd();
                myStart.setEnabled(true);
            }
        });
        menu.add(endGame);
        menu.addSeparator();
        
        final JMenuItem music = new JMenuItem("Toggle Music On/Off");
        music.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myMusic.togglePause();
            }
        });
        menu.add(music);
        menu.addSeparator();
        
        final JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myFrame.dispatchEvent(new WindowEvent(myFrame, WindowEvent.WINDOW_CLOSING));
            }
        });
        menu.add(exit);
        return menu;
    }
    
    /**
     * Creates the Variants JMenu.
     * 
     * @return the Variants menu.
     */
    private JMenu variantsMenu() {
        final JMenu menu = new JMenu("Variants");
        final JCheckBoxMenuItem tread = new JCheckBoxMenuItem("Treadmill");
        tread.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myBoard.toggleTreadmill();
            }
        });
        menu.add(tread);
        
        final JCheckBoxMenuItem reverse = new JCheckBoxMenuItem("Reverse Gravity");
        reverse.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.toggleFlip();
            }
        });
        menu.add(reverse);
        return menu;
    }
    
    /**
     * Creates the Help JMenu.
     * 
     * @return the help menu.
     */
    private JMenu helpMenu() {
        final JMenu menu = new JMenu("Help");
        final JMenuItem score = new JMenuItem("Scoring...");
        score.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(myFrame, "Scoring System\n\n"
                                   + "Level increases every 10 Line Clears\n\n"
                                   + "1 Line = 40 Points\n2 Lines = 100 Points\n"
                                + "3 Lines = 300 Points\n4 Lines (TETRIS) = 1200"
                                   + "\n\nPoints multiplied by current level", 
                                   "Score", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menu.add(score);
        
        menu.addSeparator();
        
        final String story = "The planet Tetris has declared war on Earth!!!\n\n"
                        + "The Evil Tetris King has deployed his most dangerously shaped\n"
                        + "battleships, the Tetrominos, to wipe out our civilization.\n"
                        + "It is up to you, Earth's most brilliant strategist, to\n"
                        + "corral the Tetrominos into straight lines where they can be\n"
                        + "easily eliminated by our weapons. Good luck, and may\n"
                        + "God have mercy on your soul.";
        final JMenuItem storyItem = new JMenuItem("Story...");
        storyItem.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent theEvent) {
                JOptionPane.showMessageDialog(myFrame, story, "TETRIS", 
                                              JOptionPane.ERROR_MESSAGE);
            }
        });
        menu.add(storyItem);
        return menu;
    }
    
    /**
     * Updates the next piece when notified by an observable passing a GameStatus.
     * 
     * @param theO is the observable.
     * @param theArg is the data being passed by the observable.
     */
    @Override
    public void update(final Observable theO, final Object theArg) {
        if (theArg instanceof GameStatus) {
            myTimer.stop();
            myMusic.stopPlay();
            myStart.setEnabled(true);
            JOptionPane.showMessageDialog(myFrame, "Game Over. Bummer, dude.", "YOU SUCK", 
                                          JOptionPane.CANCEL_OPTION);
        }
    }

    @Override
    public void actionPerformed(final ActionEvent theEvent) {
        final Object source = theEvent.getSource();
        if (source.equals(myTimer)) {
            myBoard.step();
        }
    }
}
