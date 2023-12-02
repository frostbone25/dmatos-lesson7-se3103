package view.statePattern;

import controller.Application;
import view.ApplicationWindow;

public class GameStatePaused implements GameState 
{
    public GameStatePaused() 
    {
        Application.applicationWindow.startPauseButton.setText(ApplicationWindow.START_ACTION);
        Application.applicationWindow.restarButton.setEnabled(false);
        Application.applicationWindow.startPauseButton.setEnabled(true);
    }

    @Override
    public void goNext(ApplicationWindow context) 
    {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void animate() {}
}