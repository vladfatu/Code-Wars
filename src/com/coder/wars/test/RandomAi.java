package com.coder.wars.test;

import com.coder.wars.ants.ai.AntsAi;
import com.coder.wars.ants.units.Ant;
import com.coder.wars.engine.board.Direction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Vlad on 1/2/2015.
 */
public class RandomAi implements AntsAi {
    @Override
    public Map<Integer, Direction> onTurnStarted(List<Ant> ants)
    {
        Map<Integer, Direction> antsMap = new HashMap<Integer, Direction>();
        for (Ant ant : ants)
        {
            antsMap.put(ant.getAntId(), getRandomDirection());
        }
        return antsMap;
    }

    private Direction getRandomDirection()
    {
        Random randomGenerator = new Random();
        switch (randomGenerator.nextInt(4))
        {
            case 0:
            {
                return Direction.EST;
            }
            case 1:
            {
                return Direction.WEST;
            }
            case 2:
            {
                return Direction.SOUTH;
            }
            case 3:default:
            {
                return Direction.NORTH;
            }
        }
    }
}
