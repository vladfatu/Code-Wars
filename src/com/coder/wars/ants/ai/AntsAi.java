package com.coder.wars.ants.ai;

import com.coder.wars.ants.units.Ant;
import com.coder.wars.engine.board.Direction;

import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 1/2/2015.
 */
public interface AntsAi {

    public Map<Integer, Direction> onTurnStarted(List<Ant> ants);

}
