package com.coder.wars.ants.ai;

import com.coder.wars.engine.board.Direction;

import java.util.Map;

/**
 * Created by Vlad on 1/2/2015.
 */
public interface AntsAi {

    public Map<Integer, Direction> onTurnStarted();

}
