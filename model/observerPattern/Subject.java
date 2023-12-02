package model.observerPattern;

public interface Subject {
    void addObserver(SnakeObserver o);
    void removeObserver(SnakeObserver o);
    void notifyObservers(SnakeEvent e);
}
