package com.code.wars.engine.extra.astar;

import com.code.wars.engine.board.Point;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by vlad on 14.01.2015.
 */
public abstract class AStar {

    public void getShortestPath(Boolean [][] visibilityMatrix, Point origin, Point destination)
    {
        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        Set<Point> nodesToVisit = new HashSet<Point>();
        nodesToVisit.add(origin);

    }

    public abstract int heuristicDistance(Point startPoint, Point endPoint);

}
