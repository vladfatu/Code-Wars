package com.coder.wars.test;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.engine.units.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Vlad on 12/21/2014.
 */
public class Screen extends JPanel{

    private AntsBoard board;

    public Screen(AntsBoard board)
    {
        this.board = board;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        long timestamp = System.currentTimeMillis();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, board.getColumnsCount() * 10, board.getRowsCount() * 10);

        for (int i=0; i < board.getRowsCount(); i++)
        {
            for (int j=0; j < board.getColumnsCount(); j++)
            {
                java.util.List<Unit> obstacleUnits = board.getBoardMatrix()[i][j].getObstacleUnits();
                if (obstacleUnits != null && obstacleUnits.size() != 0)
                {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
                else {
                    List<Unit> playableUnits = board.getBoardMatrix()[i][j].getPlayableUnits();
                    if (playableUnits != null && playableUnits.size() != 0) {
                        g.setColor(Color.YELLOW);
                        g.fillOval(j * 10, i * 10, 10, 10);
                    } else {
                        java.util.List<Unit> expendableUnits = board.getBoardMatrix()[i][j].getExpendableUnits();
                        if (expendableUnits != null && expendableUnits.size() != 0) {
                            g.setColor(Color.CYAN);
                            g.fillRect(j * 10, i * 10, 10, 10);
                        }
                    }
                }
            }
        }

        Image image = Toolkit.getDefaultToolkit().getImage("res/hive.png");
        g.drawImage(image, 400, 400, this);

        System.out.println("Time for paint: " + (System.currentTimeMillis() - timestamp));
    }
}
