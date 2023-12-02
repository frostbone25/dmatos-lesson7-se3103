package view.statePattern;

import controller.App;
import view.AppWindow;

public class GameStateOver implements GameState {

    public GameStateOver() {
        App.win.restarButton.setEnabled(true);
        App.win.startPauseButton.setEnabled(false);
    }
    
    @Override
    public void goNext(AppWindow context) {
        context.setGameState(new GameStateInit());
    }

    @Override
    public void animate() {
        App.model.snake.falling();
    }
    
}
