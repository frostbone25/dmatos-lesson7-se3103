package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Direction;

public class KeyPressListenener implements KeyListener 
{
    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) 
    {
        int keyCode = keyEvent.getKeyCode();

        switch (keyCode) 
        {
            case KeyEvent.VK_LEFT:
                Application.gameModel.snake.setDirection(Direction.LEFT);
                break;
            case KeyEvent.VK_RIGHT:
                Application.gameModel.snake.setDirection(Direction.RIGHT);
                break;
            case KeyEvent.VK_UP:
                Application.gameModel.snake.setDirection(Direction.UP);
                break;
            case KeyEvent.VK_DOWN:
                Application.gameModel.snake.setDirection(Direction.DOWN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}
}