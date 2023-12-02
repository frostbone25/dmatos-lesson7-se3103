package controller;

import javax.swing.Timer;
import javax.swing.JFrame;

import model.GameModel;
import view.ApplicationWindow;

public class Application 
{
    public static ApplicationWindow applicationWindow = new ApplicationWindow();
    public static GameModel gameModel = new GameModel();
    public static Timer timer;

    public static final int FramesPerSecond = 4;
    public static final int CalculatedTimeDelay = 1000 / FramesPerSecond;

    public static void main(String[] args) 
    {
        applicationWindow.init();
        applicationWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        applicationWindow.setTitle("Snake Game");
        applicationWindow.setLocation(300, 200);
        applicationWindow.pack();
        applicationWindow.setVisible(true);

        SnakeEventListener snakeEventListener = new SnakeEventListener();
        Application.gameModel.snake.addObserver(snakeEventListener);

        TimerListener timerListener = new TimerListener();
        timer = new Timer(CalculatedTimeDelay, timerListener);
    }
}