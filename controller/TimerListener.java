package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.observerPattern.SnakeEvent;
import view.statePattern.GameState;
import view.statePattern.GameStatePlaying;

public class TimerListener implements ActionListener 
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        GameState state = Application.applicationWindow.getGameState();
        state.animate();

        if (state instanceof GameStatePlaying) 
            detectCollision();

        Application.applicationWindow.getCanvas().repaint();
    }

    private void detectCollision() 
    {
        // snake vs. food
        if (Application.gameModel.snakeGotFood()) 
        {
            Application.gameModel.snake.notifyObservers(SnakeEvent.HIT_FOOD);
            Application.gameModel.food = Application.gameModel.createFood();
        }

        // snake vs. walls
        if (Application.gameModel.snakeLeftScene()) 
            Application.gameModel.snake.notifyObservers(SnakeEvent.HIT_WALL);

        // snake vs. self body
        if (Application.gameModel.snakeHitsItsBody()) 
            Application.gameModel.snake.notifyObservers(SnakeEvent.HIT_SELF);
    }
}