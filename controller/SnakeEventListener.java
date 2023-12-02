package controller;

import model.SnakeNode;
import model.observerPattern.SnakeObserver;

public class SnakeEventListener implements SnakeObserver 
{
    @Override
    public void hitFood() 
    {
        Application.gameModel.score += 10;
        SnakeNode newSnakeNode = new SnakeNode(-100, -100);
        Application.gameModel.snake.snakeNodes.add(newSnakeNode);
    }

    @Override
    public void hitWall() 
    {
        Application.gameModel.messages = "Hit the wall - Press <Restart>";
        Application.applicationWindow.goNextState();
    }

    @Override
    public void hitSelf() 
    {
        Application.gameModel.messages = "Hit self body - Press <Restart>";
        Application.applicationWindow.goNextState();
    }
}