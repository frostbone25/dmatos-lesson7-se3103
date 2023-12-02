package view.statePattern;

import view.ApplicationWindow;

public interface GameState 
{
    void goNext(ApplicationWindow context);
    void animate();
}