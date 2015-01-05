package com.code.wars.test;

import com.code.wars.ants.game.AntsGame;
import com.code.wars.ants.units.HiveUnit;
import com.code.wars.ants.units.AntUnit;
import com.code.wars.engine.units.ExpendableUnit;
import com.code.wars.engine.units.ObstacleUnit;
import com.code.wars.engine.units.PlayableUnit;
import com.code.wars.engine.units.Unit;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Vlad on 12/21/2014.
 */
public class Screen extends JPanel{

    private AntsGame game;
    private int unitSize;
    private Image image;

    public Screen(AntsGame game, int scale)
    {
        this.game = game;
        this.unitSize = scale;
        image = Toolkit.getDefaultToolkit().getImage("res/hive_open.png");
        image = image.getScaledInstance(unitSize * 4, unitSize * 4, 0);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        long timestamp = System.currentTimeMillis();

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(0, 0, game.getBoard().getColumnsCount() * unitSize, game.getBoard().getRowsCount() * unitSize);

        for (int i=0; i < game.getBoard().getRowsCount(); i++)
        {
            for (int j=0; j < game.getBoard().getColumnsCount(); j++)
            {
                java.util.List<ObstacleUnit> obstacleUnits = game.getBoard().getBoardMatrix()[i][j].getObstacleUnits();
                if (obstacleUnits != null && obstacleUnits.size() != 0)
                {
                    g.setColor(Color.BLUE);
                    g.fillRect(j * unitSize, i * unitSize, unitSize, unitSize);
                }
                else {
                    List<PlayableUnit> playableUnits = game.getBoard().getBoardMatrix()[i][j].getPlayableUnits();
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
                            g.drawImage(image, j * unitSize  - (image.getWidth(this)/2) + (unitSize/2), i * unitSize - (image.getHeight(this)/2) + (unitSize/2), this);
                        }
                        AntUnit antUnit = null;
                        for (Unit unit : playableUnits)
                        {
                            if (unit instanceof AntUnit)
                            {
                                antUnit = (AntUnit)unit;
                            }
                        }
                        if (antUnit != null) {
                            switch (antUnit.getPlayerId()) {
                                case 0: {
                                    g.setColor(Color.YELLOW);
                                    break;
                                }
                                case 1: {
                                    g.setColor(Color.RED);
                                    break;
                                }
                                default: {
                                    g.setColor(Color.YELLOW);
                                    break;
                                }
                            }
                            g.fillOval(j * unitSize, i * unitSize, unitSize, unitSize);
                        }
                    } else {
                        java.util.List<ExpendableUnit> expendableUnits = game.getBoard().getBoardMatrix()[i][j].getExpendableUnits();
                        if (expendableUnits != null && expendableUnits.size() != 0) {
                            g.setColor(Color.DARK_GRAY);
                            g.fillRect(j * unitSize, i * unitSize, unitSize, unitSize);
                        }
                    }
                }
            }
        }

        System.out.println("Time for paint: " + (System.currentTimeMillis() - timestamp));
    }
}
