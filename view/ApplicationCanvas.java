package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

import controller.Application;
import model.Food;
import model.Snake;
import model.SnakeNode;

public class ApplicationCanvas extends JPanel 
{
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;

    public ApplicationCanvas() 
    {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.black);
    }

    @Override
    public void paintComponent(Graphics graphics) 
    {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;

        drawScore(graphics2D, Application.gameModel.score);
        drawSnake(graphics2D, Application.gameModel.snake);

        if (Application.gameModel.food != null)
            drawFood(graphics2D, Application.gameModel.food);

        if(Application.gameModel.messages != null)
            drawMessages(graphics2D, Application.gameModel.messages);
    }

    private void drawScore(Graphics2D graphics2D, int score) 
    {
        graphics2D.setColor(Color.white);
        graphics2D.setFont(new Font("Courier New", Font.BOLD, 24));
        graphics2D.drawString("Score: " + score, ApplicationCanvas.WIDTH - 180, 30);
    }

    private void drawSnake(Graphics2D graphics2D, Snake snake) 
    {
        boolean filled = true;
        graphics2D.setColor(Color.blue);
        drawSnakeHead(graphics2D, snake.snakeNodes.get(0));

        for (int i = 1; i < snake.snakeNodes.size(); i++) 
        {
            drawSnakeBody(graphics2D, snake.snakeNodes.get(i), filled);
            filled = !filled;
        }
    }

    private void drawSnakeHead(Graphics2D graphics2D, SnakeNode snakeNode) 
    {
        java.awt.geom.Ellipse2D.Float snakeHead = new Ellipse2D.Float(snakeNode.x, snakeNode.y, ApplicationWindow.GRID_SIZE, ApplicationWindow.GRID_SIZE);
        graphics2D.fill(snakeHead);
    }

    private void drawSnakeBody(Graphics2D graphics2D, SnakeNode snakeNode, boolean filled) 
    {
        java.awt.geom.Rectangle2D.Float snakeBody = new Rectangle2D.Float(snakeNode.x, snakeNode.y, ApplicationWindow.GRID_SIZE, ApplicationWindow.GRID_SIZE);
        
        if (filled) 
            graphics2D.fill(snakeBody);
        else 
            graphics2D.draw(snakeBody);
    }

    private void drawFood(Graphics2D graphics2D, Food food) 
    {
        java.awt.geom.Ellipse2D.Float foodVisual = new Ellipse2D.Float(food.x, food.y, ApplicationWindow.GRID_SIZE, ApplicationWindow.GRID_SIZE);
        graphics2D.setColor(Color.pink);
        graphics2D.fill(foodVisual);
    }

    private void drawMessages(Graphics2D graphics2D, String messages) 
    {
        graphics2D.setColor(Color.yellow);
        graphics2D.setFont(new Font("Courier New", Font.PLAIN, 28));
        graphics2D.drawString(messages, 50, 140);
    }
}