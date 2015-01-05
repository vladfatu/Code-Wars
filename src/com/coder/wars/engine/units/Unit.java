package com.coder.wars.engine.units;

import com.coder.wars.engine.board.Point;

/**
 * Created by vlad on 19.12.2014.
 */
public class Unit {

    private Point position;
    private int unitId;
    private static int lastId;

    public Unit(Point position)
    {
        lastId++;
        this.unitId = lastId;
        this.position = position;
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public int getUnitId() {
        return unitId;
    }

}
