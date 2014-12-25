package com.coder.wars.ants.units;

import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.units.PlayableUnit;

/**
 * Created by vlad on 25.12.2014.
 */
public class HiveUnit extends PlayableUnit {

    private int foodSupply;

    public HiveUnit(int unitId, int playerId, Point position)
    {
        super(unitId, playerId, position);
        this.foodSupply = 5;
    }

    public int getFoodSupply()
    {
        return foodSupply;
    }

    public void addFoodSupply(int delta)
    {
        this.foodSupply += delta;
    }

    public void decreaseFoodSupply(int delta)
    {
        if (this.foodSupply > delta)
        {
            this.foodSupply -= delta;
        } else
        {
            this.foodSupply = 0;
        }
    }

}
