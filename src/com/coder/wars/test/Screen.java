package com.coder.wars.test;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.ants.units.HiveUnit;
import com.coder.wars.engine.units.PlayableUnit;
import com.coder.wars.engine.units.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Vlad on 12/21/2014.
 */
public class Screen extends JPanel{

    private AntsGame game;

    public Screen(AntsGame game)
    {
        this.game = game;
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        long timestamp = System.currentTimeMillis();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, game.getBoard().getColumnsCount() * 10, game.getBoard().getRowsCount() * 10);

        for (int i=0; i < game.getBoard().getRowsCount(); i++)
        {
            for (int j=0; j < game.getBoard().getColumnsCount(); j++)
            {
                java.util.List<Unit> obstacleUnits = game.getBoard().getBoardMatrix()[i][j].getObstacleUnits();
                if (obstacleUnits != null && obstacleUnits.size() != 0)
                {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * 10, i * 10, 10, 10);
                }
                else {
                    List<Unit> playableUnits = game.getBoard().getBoardMatrix()[i][j].getPlayableUnits();
                    if (playableUnits != null && playableUnits.size() != 0)
                    {
                        HiveUnit hiveUnit = null;
                        for (Unit unit : playableUnits)
                        {
                            if (unit instanceof HiveUnit)
                            {
                                hiveUnit = (HiveUnit)unit;
                            }
                        }
                        if (hiveUnit != null)
                        {
                            Image image = Toolkit.getDefaultToolkit().getImage("res/hive.png");
                            g.drawImage(image, j * 10, i * 10, this);
                        }
                        switch (hiveUnit.getPlayerId())
                        {
                            case 0:
                            {
                                g.setColor(Color.YELLOW);
                                break;
                            }
                            case 1:
                            {
                                g.setColor(Color.RED);
                                break;
                            }
                            default:
                            {
                                g.setColor(Color.YELLOW);
                                break;
                            }
                        }
                        g.fillOval(j * 10, i * 10, 10, 10);
                    } else {
                        java.util.List<Unit> expendableUnits = game.getBoard().getBoardMatrix()[i][j].getExpendableUnits();
                        if (expendableUnits != null && expendableUnits.size() != 0) {
                            g.setColor(Color.CYAN);
                            g.fillRect(j * 10, i * 10, 10, 10);
                        }
                    }
                }
            }
        }

        System.out.println("Time for paint: " + (System.currentTimeMillis() - timestamp));
    }
}
