package view.statePattern;

import controller.Application;
import view.ApplicationWindow;

public class GameStateOver implements GameState 
{
    public GameStateOver() 
    {
        Application.applicationWindow.restarButton.setEnabled(true);
        Application.applicationWindow.startPauseButton.setEnabled(false);
    }
    
    @Override
    public void goNext(ApplicationWindow context) 
    {
        context.setGameState(new GameStateInit());
    }

    @Override
    public void animate() 
    {
        Application.gameModel.snake.falling();
    }
}