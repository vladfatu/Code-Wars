package com.code.wars.engine.extra.astar;

import com.code.wars.engine.board.Point;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by vlad on 24.02.2015.
 */
public class AStarNode {

    private Point position;
    private int rowSize;
    private int columnSize;
    private boolean isValid;
    private int score;
    private int estimatedScore;
    private AStarNode parent;

    public  AStarNode(Point position, int rowSize, int columnSize)
    {
        this.position = position;
        this.rowSize = rowSize;
        this.columnSize = columnSize;
        checkIfValid();
    }

    public List<AStarNode> getNotVisitedNeighbours(Map<Point, AStarNode> visitedMap)
    {
        List<AStarNode> neighbours = new ArrayList<AStarNode>();
        if (visitedMap != null && isValid)
        {
            Point point;
            if (this.position.getRow() > 0)
            {
                point = new Point(this.position.getRow() - 1, this.position.getColumn());
                if (!visitedMap.containsKey(point))
                {
                    neighbours.add(new AStarNode(point, rowSize, columnSize));
                }
            }
            if (this.position.getRow() + 1 < this.rowSize)
            {
                point = new Point(this.position.getRow() + 1, this.position.getColumn());
                if (!visitedMap.containsKey(point))
                {
                    neighbours.add(new AStarNode(point, rowSize, columnSize));
                }
            }
            if (this.position.getColumn() > 0)
            {
                point = new Point(this.position.getRow(), this.position.getColumn() - 1);
                if (!visitedMap.containsKey(point))
                {
                    neighbours.add(new AStarNode(point, rowSize, columnSize));
                }
            }
            if (this.position.getColumn() + 1 < this.columnSize)
            {
                point = new Point(this.position.getRow(), this.position.getColumn() + 1);
                if (!visitedMap.containsKey(point))
                {
                    neighbours.add(new AStarNode(point, rowSize, columnSize));
                }
            }
        }
        return neighbours;
    }

    private void checkIfValid()
    {
        if (this.position != null && rowSize > 0 && columnSize > 0
                && this.position.getRow() >= 0
                && this.position.getRow() < this.rowSize
                && this.position.getColumn() >= 0
                && this.position.getColumn() < this.columnSize)
        {
            this.isValid = true;

        } else
        {
            this.isValid = false;
        }
    }

    public Point getPosition()
    {
        return position;
    }

    public void setPosition(Point position)
    {
        this.position = position;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    public AStarNode getParent()
    {
        return parent;
    }

    public void setParent(AStarNode parent)
    {
        this.parent = parent;
    }

    public int getEstimatedScore()
    {
        return estimatedScore;
    }

    public void setEstimatedScore(int estimatedScore)
    {
        this.estimatedScore = estimatedScore;
    }
}
