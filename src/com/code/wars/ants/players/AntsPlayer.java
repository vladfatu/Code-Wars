package com.code.wars.ants.players;

import com.code.wars.engine.board.Direction;
import com.code.wars.engine.players.Player;
import com.code.wars.ants.units.HiveUnit;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vlad on 25.12.2014.
 */
public class AntsPlayer extends Player {

    private List<HiveUnit> hives;
    private Map<Integer, Direction> lastMovement;

    public AntsPlayer(int playerId)
    {
        super(playerId);
        this.hives = new ArrayList<HiveUnit>();
    }

    public List<HiveUnit> getHives()
    {
        return hives;
    }

    public void setHives(List<HiveUnit> hives)
    {
        this.hives = hives;
    }

    public Map<Integer, Direction> getLastMovement() {
        return lastMovement;
    }

    public void setLastMovement(Map<Integer, Direction> lastMovement) {
        this.lastMovement = lastMovement;
    }

    public void addFoodSupply(int delta)
    {
        if (this.hives != null && this.hives.size() > 0)
        {
            this.hives.get(0).addFoodSupply(delta);
        }
    }
}
