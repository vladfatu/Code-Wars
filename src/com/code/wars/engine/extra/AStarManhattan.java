package com.code.wars.engine.extra;

import com.code.wars.engine.board.Point;
import com.code.wars.engine.extra.astar.AStar;

/**
 * Created by vlad on 14.01.2015.
 */
public class AStarManhattan extends AStar {

    @Override
    public int heuristicDistance(Point startPoint, Point endPoint)
    {
        return Math.abs(startPoint.getColumn() - endPoint.getColumn()) + Math.abs(startPoint.getRow() - endPoint.getRow());
    }
}
