package com.coder.wars.test;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vlad on 12/21/2014.
 */
public class Frame extends JFrame {

    private Screen screen;

    public Frame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 800);
        setTitle("Code Wars");
        setResizable(false);

        init();
    }

    public void init()
    {
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 1, 0, 0));

        screen = new Screen();
        add(screen);

        setVisible(true);
    }

}
