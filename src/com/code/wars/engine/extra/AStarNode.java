package com.code.wars.engine.extra;

import com.code.wars.engine.board.Point;
import sun.org.mozilla.javascript.ast.AstNode;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by vlad on 24.02.2015.
 */
public class AStarNode {

    private Point position;

    public List<AStarNode> getNotVisitedNeighbours(Map<Point, AStarNode> visitedMap)
    {

    }

    public Point getPosition()
    {
        return position;
    }

    public void setPosition(Point position)
    {
        this.position = position;
    }

}
