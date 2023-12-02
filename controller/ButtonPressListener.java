package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ApplicationWindow;

public class ButtonPressListener implements ActionListener 
{
    @Override
    public void actionPerformed(ActionEvent actionEvent) 
    {
        String actionCommand = actionEvent.getActionCommand();

        switch(actionCommand) 
        {
            case ApplicationWindow.START_ACTION:
                Application.gameModel.messages = null;
                Application.applicationWindow.goNextState();
                Application.timer.start();
                break;
            case ApplicationWindow.PAUSE_ACTION:
                Application.applicationWindow.goNextState();
                Application.gameModel.messages = "Paused - Press <Resume>";
                Application.timer.stop();
                Application.applicationWindow.getCanvas().repaint();
                break;
            case ApplicationWindow.RESTART_ACTION:
                Application.gameModel.init();
                Application.applicationWindow.goNextState();
                Application.timer.stop();
                Application.applicationWindow.getCanvas().repaint();
                break;
            case ApplicationWindow.EXIT_ACTION:
                System.exit(0);
                break;
        }
    }
}