package game;

import javax.swing.*;

public class GameWindow {
    public GameWindow(){
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Game");
        frame.setSize(810,830);
        frame.setLocation(300,0);
        frame.setVisible(true);
        frame.add(new boardSquares());
        frame.setResizable(false);
    }
}
