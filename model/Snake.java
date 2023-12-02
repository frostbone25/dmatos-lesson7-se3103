package model;

import java.util.ArrayList;

import model.observerPattern.SnakeEvent;
import model.observerPattern.SnakeObserver;
import model.observerPattern.Subject;
import view.ApplicationCanvas;
import view.ApplicationWindow;

public class Snake implements Subject 
{
    public ArrayList<SnakeNode> snakeNodes = new ArrayList<>();

    private final int INIT_XLOC = ApplicationWindow.GRID_SIZE * 7;
    private final int INIT_YLOC = ApplicationWindow.GRID_SIZE * 3;
    private final int INIT_NODES = 6;
    private Direction direction;

    private ArrayList<SnakeObserver> snakeObservers = new ArrayList<>();

    public Snake() 
    {
        init();
    }

    public void init() 
    {
        snakeNodes.clear();
        direction = Direction.RIGHT;

        for(int i = 0; i < INIT_NODES; i++)
        {
            int x = INIT_XLOC - i * ApplicationWindow.GRID_SIZE;
            int y = INIT_YLOC;
            SnakeNode newSnakeNode = new SnakeNode(x, y);

            snakeNodes.add(newSnakeNode);
        }
    }

    public void move() 
    {
        for (int i = snakeNodes.size() - 1; i > 0; i--) 
        {
            snakeNodes.get(i).x = snakeNodes.get(i - 1).x;
            snakeNodes.get(i).y = snakeNodes.get(i - 1).y;
        }

        SnakeNode snakeHead = snakeNodes.get(0);

        switch (direction) 
        {
            case LEFT:
                snakeHead.x -= ApplicationWindow.GRID_SIZE;
                break;
            case RIGHT:
                snakeHead.x += ApplicationWindow.GRID_SIZE;
                break;
            case UP:
                snakeHead.y -= ApplicationWindow.GRID_SIZE;
                break;
            case DOWN:
                snakeHead.y += ApplicationWindow.GRID_SIZE;
                break;
        }
    }

    public void falling() 
    {
        if (snakeNodes.get(0).y >= ApplicationCanvas.HEIGHT - ApplicationWindow.GRID_SIZE) 
            return;

        for (int i = 0; i < snakeNodes.size(); i++) 
            snakeNodes.get(i).y += 5;
    }

    public Direction getDirection() 
    {
        return direction;
    }

    public void setDirection(Direction direction) 
    {
        this.direction = direction;
    }

    @Override
    public void addObserver(SnakeObserver snakeObserver) 
    {
        snakeObservers.add(snakeObserver);
    }

    @Override
    public void removeObserver(SnakeObserver snakeObserver) 
    {
        snakeObservers.remove(snakeObserver);
    }

    @Override
    public void notifyObservers(SnakeEvent snakeEvent) 
    {
        switch (snakeEvent) 
        {
            case HIT_FOOD:

                for(SnakeObserver snakeObserver: snakeObservers)
                    snakeObserver.hitFood();

                break;
            case HIT_SELF:

                for (SnakeObserver snakeObserver: snakeObservers)
                    snakeObserver.hitSelf();

                break;
            case HIT_WALL:

                for (SnakeObserver snakeObserver: snakeObservers)
                    snakeObserver.hitWall();

                break;
        }
    }
}
