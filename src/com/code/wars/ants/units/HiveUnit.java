package com.code.wars.ants.units;

import com.code.wars.engine.board.Point;
import com.code.wars.engine.units.PlayableUnit;

/**
 * Created by vlad on 25.12.2014.
 */
public class HiveUnit extends PlayableUnit {

    private int foodSupply;
    private boolean isActive;

    public HiveUnit(int playerId, Point position)
    {
        super(playerId, position);
        this.foodSupply = 5;
        this.isActive = true;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public void setActive(boolean isActive)
    {
        this.isActive = isActive;
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
