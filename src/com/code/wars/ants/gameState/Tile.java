package com.code.wars.ants.gameState;

import com.code.wars.ants.units.AntUnit;
import com.code.wars.ants.units.HiveUnit;
import com.code.wars.engine.units.ExpendableUnit;
import com.code.wars.engine.units.ObstacleUnit;
import com.code.wars.engine.units.PlayableUnit;
import com.code.wars.engine.units.Unit;

import java.awt.*;
import java.util.List;

/**
 * Created by vlad on 07.01.2015.
 */
public class Tile {

    private Ant ant;
    private Hive hive;
    private boolean isObstacle;
    private boolean isFood;

    public Tile(com.code.wars.engine.board.Tile tile)
    {
        List<ObstacleUnit> obstacleUnits = tile.getObstacleUnits();
        if (obstacleUnits != null && obstacleUnits.size() != 0)
        {
            this.isObstacle = true;
        }
        else
        {
            List<PlayableUnit> playableUnits = tile.getPlayableUnits();
            if (playableUnits != null && playableUnits.size() != 0)
            {
                for (Unit unit : playableUnits)
                {
                    if (unit instanceof HiveUnit)
                    {
                        HiveUnit hiveUnit = (HiveUnit) unit;
                        this.hive = new Hive(hiveUnit.getPlayerId(), hiveUnit.isActive(), hiveUnit.getPosition(), hiveUnit.getFoodSupply());
                    }
                }
                for (Unit unit : playableUnits)
                {
                    if (unit instanceof AntUnit)
                    {
                        this.ant = new Ant((AntUnit) unit);
                    }
                }
            }

            List<ExpendableUnit> expendableUnits = tile.getExpendableUnits();
            if (expendableUnits != null && expendableUnits.size() != 0)
            {
                this.isFood = true;
            }
        }
    }

    public Ant getAnt()
    {
        return ant;
    }

    public Hive getHive()
    {
        return hive;
    }

    public boolean isObstacle()
    {
        return isObstacle;
    }

    public boolean isFood()
    {
        return isFood;
    }
}
