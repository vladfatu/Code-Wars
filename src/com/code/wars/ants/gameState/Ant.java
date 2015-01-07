package com.code.wars.ants.gameState;

import com.code.wars.ants.units.AntUnit;
import com.code.wars.engine.board.Point;

/**
 * Created by Vlad on 12/19/2014.
 */
public class Ant {

    private Point position;
    private int playerId;
    private int antId;

    public Ant(AntUnit antUnit)
    {
        this.antId = antUnit.getUnitId();
        this.playerId = antUnit.getPlayerId();
        this.position = antUnit.getPosition();
    }

    public Point getPosition()
    {
        return this.position;
    }

    public int getPlayerId()
    {
        return this.playerId;
    }

    public int getAntId()
    {
        return this.antId;
    }

}
