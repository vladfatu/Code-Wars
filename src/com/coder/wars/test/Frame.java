package com.coder.wars.test;

import com.coder.wars.ants.board.AntsBoard;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vlad on 12/21/2014.
 */
public class Frame extends JFrame {

    private Screen screen;
    private AntsBoard board;

    public Frame(AntsBoard board)
    {
        this.board = board;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(board.getColumnsCount() * 10, board.getRowsCount() * 10);
        setTitle("Code Wars");
        setResizable(false);

        init();
    }

    public void init()
    {
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 1, 0, 0));

        screen = new Screen(this.board);
        add(screen);

        setVisible(true);
    }

}
