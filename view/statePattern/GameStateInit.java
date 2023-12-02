package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStateInit implements GameState {

    public GameStateInit() {
        App.win.startPauseButton.setText(AppWindow.START_ACTION);
        App.win.restarButton.setEnabled(false);
        App.win.startPauseButton.setEnabled(true);
    }

    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStatePlaying());
    }

    @Override
    public void animate() {
    }
    
}
