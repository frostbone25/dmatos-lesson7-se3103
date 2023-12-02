package model;

import java.util.ArrayList;
import java.util.Random;

import controller.Application;
import view.ApplicationCanvas;
import view.ApplicationWindow;

public class GameModel 
{
    public Snake snake;
    public Food food;
    public String messages;
    public int score;

    public GameModel() 
    {
        snake = new Snake();
        init();
    }

    public void init() 
    {
        snake.init();
        score = 0;
        messages = "Click <Start> to Play";
        food = createFood();
    }

    public Food createFood() 
    {
        Random random = new Random();
        int x;
        int y;
        Food newFood;

        do 
        {
            x = random.nextInt(ApplicationCanvas.WIDTH / ApplicationWindow.GRID_SIZE) * ApplicationWindow.GRID_SIZE;
            y = random.nextInt(ApplicationCanvas.HEIGHT / ApplicationWindow.GRID_SIZE) * ApplicationWindow.GRID_SIZE;
        } 
        while (isInsideSnake(x, y));

        newFood = new Food(x, y);

        return newFood;
    }

    private boolean isInsideSnake(int x, int y) 
    {
        for (SnakeNode snakeNode : snake.snakeNodes) 
        {
            if (snakeNode.x == x && snakeNode.y == y)
                return true;
        }

        return false;
    }

    public boolean snakeGotFood() 
    {
        Food food = Application.gameModel.food;
        SnakeNode snakeHead = Application.gameModel.snake.snakeNodes.get(0);

        return food.x == snakeHead.x && food.y == snakeHead.y;
    }

    public boolean snakeLeftScene() 
    {
        SnakeNode snakeHead = Application.gameModel.snake.snakeNodes.get(0);

        return snakeHead.x <= 0 || snakeHead.x >= ApplicationCanvas.WIDTH || snakeHead.y <= 0 || snakeHead.y >= ApplicationCanvas.HEIGHT;
    }

    public boolean snakeHitsItsBody() 
    {
        ArrayList<SnakeNode> snakeNodes = Application.gameModel.snake.snakeNodes;
        
        SnakeNode snakeHeadNode = snakeNodes.get(0);

        for (int i = 1; i < snakeNodes.size(); i++) 
        {
            SnakeNode snakeBodyNode = snakeNodes.get(i);

            if (snakeHeadNode.x == snakeBodyNode.x && snakeHeadNode.y == snakeBodyNode.y) 
                return true;
        }

        return false;
    }
}