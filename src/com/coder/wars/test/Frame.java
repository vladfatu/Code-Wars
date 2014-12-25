package com.coder.wars.test;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Vlad on 12/21/2014.
 */
public class Frame extends JFrame {

    private Screen screen;
    private AntsGame game;

    public Frame(AntsGame game)
    {
        this.game = game;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(game.getBoard().getColumnsCount() * 10, game.getBoard().getRowsCount() * 10);
        setTitle("Code Wars");
        setResizable(false);

        init();
    }

    public void init()
    {
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 1, 0, 0));

        screen = new Screen(this.game);
        add(screen);

        setVisible(true);
    }

}
