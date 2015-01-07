package com.code.wars.ants.gameState;

import com.code.wars.engine.board.Point;

/**
 * Created by vlad on 07.01.2015.
 */
public class Hive {

    private int playerId;
    private boolean isActive;
    private int foodCount;
    private Point position;

    public Hive(int playerId, boolean isActive, Point position, int foodCount)
    {
        this.playerId = playerId;
        this.isActive = isActive;
        this.position = position;
        this.foodCount = foodCount;
    }

    public int getPlayerId()
    {
        return playerId;
    }

    public boolean isActive()
    {
        return isActive;
    }

    public int getFoodCount()
    {
        return foodCount;
    }

    public Point getPosition()
    {
        return position;
    }
}
