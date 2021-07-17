package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class menuOptions extends JPanel {

    private final JFrame frame = new JFrame();
    private int Height;
    private int Width;
    private int backHeight;
    private int backWidth;
    private String title;

    public menuOptions(JLabel label , int Width , int Height, String title, int backWidth , int backHeight){

        this.Height = Height;
        this.Width = Width;
        this.title = title;
        this.backHeight = backHeight; //630
        this.backWidth = backWidth; //30

        JButton back = new JButton("Back");
        back.setBounds(backWidth,backHeight,70,25);
        back.addActionListener((ActionEvent ae) -> {
            frame.setVisible(false);
            new openingWindow();
        });

        frame.add(this);
        this.add(label);
        label.add(back);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(title);
        frame.setSize(Width,Height);
        frame.setLocation(300,0);
        frame.setVisible(true);
        frame.setResizable(false);
        this.setLayout(new FlowLayout());
        this.repaint();
        this.revalidate();
    }
}
