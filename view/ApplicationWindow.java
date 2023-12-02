package view;

import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ButtonPressListener;
import controller.KeyPressListenener;
import view.statePattern.GameState;
import view.statePattern.GameStateInit;

public class ApplicationWindow extends JFrame 
{
    private ApplicationCanvas applicationCanvas;
    public static final int GRID_SIZE = 20;

    public JButton startPauseButton;
    public JButton restarButton;
    public JButton exitButton;
    public static final String START_ACTION = "Start";
    public static final String PAUSE_ACTION = "Pause";
    public static final String RESTART_ACTION = "App Restart";
    public static final String EXIT_ACTION = "Exit";

    private GameState gameState;

    public void init() 
    {
        Container contentPane = getContentPane();
        applicationCanvas = new ApplicationCanvas();
        contentPane.add(applicationCanvas, BorderLayout.CENTER);

        JPanel southPanel = new JPanel();
        startPauseButton = new JButton(START_ACTION);
        restarButton = new JButton(RESTART_ACTION);
        exitButton = new JButton(EXIT_ACTION);
        southPanel.add(startPauseButton);
        southPanel.add(restarButton);
        southPanel.add(exitButton);
        contentPane.add(BorderLayout.SOUTH, southPanel);

        ButtonPressListener buttonPressListener = new ButtonPressListener();
        startPauseButton.addActionListener(buttonPressListener);
        restarButton.addActionListener(buttonPressListener);
        exitButton.addActionListener(buttonPressListener);

        KeyPressListenener keyPressListenener = new KeyPressListenener();
        applicationCanvas.addKeyListener(keyPressListenener);
        applicationCanvas.requestFocusInWindow();
        applicationCanvas.setFocusable(true);

        // disable focusable in all other GUI components
        startPauseButton.setFocusable(false);
        restarButton.setFocusable(false);
        exitButton.setFocusable(false);

        gameState = new GameStateInit();
    }

    public void goNextState() 
    {
        gameState.goNext(this);
    }

    public GameState getGameState() 
    {
        return gameState;
    }

    public void setGameState(GameState gameState) 
    {
        this.gameState = gameState;
    }

    public ApplicationCanvas getCanvas() 
    {
        return applicationCanvas;
    }
}