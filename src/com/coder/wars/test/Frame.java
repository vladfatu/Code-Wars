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
    private int unitSize;

    public Frame(AntsGame game)
    {
        this.game = game;
        this.unitSize = 8;
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(game.getBoard().getColumnsCount() * unitSize, game.getBoard().getRowsCount() * unitSize);
        setTitle("Code Wars");
        setResizable(false);

        init();
    }

    public void init()
    {
        setLocationRelativeTo(null);

        setLayout(new GridLayout(1, 1, 0, 0));

        screen = new Screen(this.game, unitSize);
        add(screen);

        setVisible(true);
    }

}
