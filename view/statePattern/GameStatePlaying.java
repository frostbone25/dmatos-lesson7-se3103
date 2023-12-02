package view.statePattern;

import controller.Application;
import view.ApplicationWindow;

public class GameStatePlaying implements GameState 
{
    public GameStatePlaying() 
    {
        Application.applicationWindow.startPauseButton.setText(ApplicationWindow.PAUSE_ACTION);
        Application.applicationWindow.restarButton.setEnabled(false);
        Application.applicationWindow.startPauseButton.setEnabled(true);
    }

    @Override
    public void goNext(ApplicationWindow context) 
    {
        if (Application.gameModel.snakeHitsItsBody() || Application.gameModel.snakeLeftScene())
            context.setGameState(new GameStateOver());
        else
            context.setGameState(new GameStatePaused());
    }

    @Override
    public void animate() 
    {
        Application.gameModel.snake.move();
    }
}