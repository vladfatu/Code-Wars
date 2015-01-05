package com.code.wars.engine.board;

import com.code.wars.engine.units.ExpendableUnit;
import com.code.wars.engine.units.PlayableUnit;
import com.code.wars.engine.units.ObstacleUnit;
import com.code.wars.engine.units.Unit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by vlad on 24.12.2014.
 */
public class Tile {

    private List<Unit> units;

    public List<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        if (this.units == null)
        {
            this.units = new ArrayList<Unit>();
        }
        this.units.add(unit);
    }

    public void removeUnit(int unitId)
    {
        if (this.units == null)
        {
            this.units = new ArrayList<Unit>();
        }

        Iterator<Unit> unitsIterator = this.units.iterator();
        while (unitsIterator.hasNext())
        {
            if (unitsIterator.next().getUnitId() == unitId)
            {
                unitsIterator.remove();
            }
        }

    }

    public List<ExpendableUnit> getExpendableUnits()
    {
        if (this.units == null)
        {
            return null;
        }
        List<ExpendableUnit> expendableUnits = new ArrayList<ExpendableUnit>();
        for (Unit unit : this.units)
        {
            if (unit instanceof ExpendableUnit)
            {
                expendableUnits.add((ExpendableUnit)unit);
            }
        }
        return expendableUnits;
    }

    public List<PlayableUnit> getPlayableUnits()
    {
        if (this.units == null)
        {
            return null;
        }
        List<PlayableUnit> playableUnits = new ArrayList<PlayableUnit>();
        for (Unit unit : this.units)
        {
            if (unit instanceof PlayableUnit)
            {
                playableUnits.add((PlayableUnit)unit);
            }
        }
        return playableUnits;
    }

    public List<ObstacleUnit> getObstacleUnits()
    {
        if (this.units == null)
        {
            return null;
        }
        List<ObstacleUnit> obstacleUnits = new ArrayList<ObstacleUnit>();
        for (Unit unit : this.units)
        {
            if (unit instanceof ObstacleUnit)
            {
                obstacleUnits.add((ObstacleUnit)unit);
            }
        }
        return obstacleUnits;
    }

    public boolean hasObstacle()
    {
        List<ObstacleUnit> obstacleUnits = getObstacleUnits();
        return (obstacleUnits != null && obstacleUnits.size() > 0);
    }

}
