package com.code.wars.ants.ai;

import com.code.wars.ants.gameState.Ant;
import com.code.wars.ants.gameState.GameState;
import com.code.wars.ants.gameState.Hive;
import com.code.wars.engine.board.Direction;

import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 1/2/2015.
 */
public interface AntsAi {

    public Map<Integer, Direction> onTurnStarted(GameState gameState, List<Hive> yourHives, List<Ant> yourAnts);

}
