package com.coder.wars.test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vlad on 12/21/2014.
 */
public class Screen extends JPanel{

    public Screen()
    {
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        long timestamp = System.currentTimeMillis();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, 800, 800);

        for (int i=0; i < 79; i++)
        {
            for (int j=0; j < 79; j++)
            {
                g.setColor(Color.YELLOW);
                g.fillOval(i*10, j*10, 10, 10);
            }
        }

        Image image = Toolkit.getDefaultToolkit().getImage("res/hive.png");
        g.drawImage(image, 400, 400, this);

        System.out.println("Time for paint: " + (System.currentTimeMillis() - timestamp));
    }
}
