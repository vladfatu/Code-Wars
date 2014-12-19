package com.coder.wars.ants.units;

import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.units.Order;

/**
 * Created by Vlad on 12/19/2014.
 */
public class Ant {

    private AntUnit antUnit;

    public Point getPosition()
    {
        return this.antUnit.getPosition();
    }

    public int getPlayerId()
    {
        return this.antUnit.getPlayerId();
    }

    public int getAntId()
    {
        return this.antUnit.getUnitId();
    }

}
