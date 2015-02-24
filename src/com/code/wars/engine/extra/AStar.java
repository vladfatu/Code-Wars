package com.code.wars.engine.extra;

import com.code.wars.engine.board.Point;

/**
 * Created by vlad on 14.01.2015.
 */
public abstract class AStar {

    public void getShortestPath(Boolean [][] visibilityMatrix, Point origin, Point destination)
    {



    }

    public abstract int heuristicDistance(Point startPoint, Point endPoint);

}
