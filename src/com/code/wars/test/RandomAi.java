package com.code.wars.test;

import com.code.wars.ants.ai.AntsAi;
import com.code.wars.ants.gameState.Ant;
import com.code.wars.ants.gameState.GameState;
import com.code.wars.ants.gameState.Hive;
import com.code.wars.engine.board.Direction;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by Vlad on 1/2/2015.
 */
public class RandomAi implements AntsAi {
    @Override
    public Map<Integer, Direction> onTurnStarted(GameState gameState, List<Hive> yourHives, List<Ant> yourAnts)
    {
//        gameState.prettyPrint();
        Map<Integer, Direction> antsMap = new HashMap<Integer, Direction>();
        for (Ant ant : yourAnts)
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
