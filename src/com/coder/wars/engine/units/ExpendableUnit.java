package com.coder.wars.engine.units;

import com.coder.wars.engine.board.Point;

/**
 * Created by vlad on 19.12.2014.
 */
public class ExpendableUnit extends Unit{

    private int value;

    public ExpendableUnit(Point position, int value)
    {
        super(position);
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
