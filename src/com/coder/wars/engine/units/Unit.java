package com.coder.wars.engine.units;

import com.coder.wars.engine.board.Point;

/**
 * Created by vlad on 19.12.2014.
 */
public class Unit {

    private Point position;
    private int unitId;

    public Unit(int unitId, Point position)
    {
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

    public void setUnitId(int unitId) {
        this.unitId = unitId;
    }
}
