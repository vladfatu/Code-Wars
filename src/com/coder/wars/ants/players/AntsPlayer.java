package com.coder.wars.ants.players;

import com.coder.wars.ants.units.HiveUnit;
import com.coder.wars.engine.players.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 25.12.2014.
 */
public class AntsPlayer extends Player {

    private List<HiveUnit> hives;

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
}
