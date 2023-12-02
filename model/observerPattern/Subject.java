package model.observerPattern;

public interface Subject 
{
    void addObserver(SnakeObserver snakeObserver);
    void removeObserver(SnakeObserver snakeObserver);
    void notifyObservers(SnakeEvent snakeEvent);
}
