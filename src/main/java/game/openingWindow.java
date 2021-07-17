package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class openingWindow extends JPanel {
    private final JFrame frame = new JFrame();
    private final JButton btn = new JButton("PLAY");
    private final JButton btn2 = new JButton("ABOUT");
    private final JButton btn3 = new JButton("CREDITS");
    private final JButton btn4 = new JButton("EXIT");
    private final ImageIcon img = new ImageIcon("chessOpen.png");
    private final JLabel label = new JLabel("",img,JLabel.CENTER);

    private int Dheight = 65, Height = 315;

    public openingWindow(){

        //Buttons Action

        btn.setBounds(385,Height,100,38);
        btn.addActionListener((ActionEvent ae) -> {
            frame.setVisible(false);
            System.out.println("Play");
            new GameWindow();
        });

        btn2.setBounds(385,Height+Dheight,100,38);
        btn2.addActionListener((ActionEvent ae) -> {
            frame.setVisible(false);
            ImageIcon aboutImg = new ImageIcon("aboutWindow.png");
            JLabel Alabel = new JLabel("",aboutImg,JLabel.CENTER);
            menuOptions about = new menuOptions(Alabel,801,700, "How To Play",30,620);
        });

        btn3.setBounds(385,Height+2*Dheight,100,38);
        btn3.addActionListener((ActionEvent ae) -> {
            frame.setVisible(false);
            ImageIcon creditsImg = new ImageIcon("G099-credits(801-700).png");
            JLabel Clabel = new JLabel("",creditsImg,JLabel.CENTER);
            menuOptions credits = new menuOptions(Clabel,801,740, "Credits",20,660);
        });

        btn4.setBounds(385,Height+3*Dheight,100,38);
        btn4.addActionListener(openingWindow::actionPerformed);

        frame.add(this);
        label.add(btn);
        label.add(btn2);
        label.add(btn3);
        label.add(btn4);
        this.add(label);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Chess Game");
        frame.setSize(860,750);
        frame.setLocation(300,0);
        frame.setVisible(true);
        frame.setResizable(false);
        this.setLayout(new FlowLayout());
        this.repaint();
        this.revalidate();

    }

    static void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }
}
