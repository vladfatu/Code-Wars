package com.code.wars.engine.extra.astar;

import com.code.wars.engine.board.Point;

import java.util.*;

/**
 * Created by vlad on 14.01.2015.
 */
public abstract class AStar {

    private static final int UNIT = 1;

    public List<Point> getShortestPath(Boolean [][] visibilityMatrix, Point origin, Point destination)
    {
        int rowSize = visibilityMatrix.length;
        if (rowSize > 0)
        {
            int columnSize = visibilityMatrix[0].length;
            if (columnSize > 0)
            {

                Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
                Map<Point, AStarNode> nodesToVisitMap = new HashMap<Point, AStarNode>();

                AStarNode startNode = new AStarNode(origin, rowSize, columnSize);
                startNode.setScore(0);
                startNode.setEstimatedScore(heuristicDistance(origin, destination));

                nodesToVisitMap.put(startNode.getPosition(), startNode);

                while (!nodesToVisitMap.isEmpty())
                {
                    AStarNode currentNode = getClosestEstimatedNode(nodesToVisitMap);
                    if (currentNode.getPosition().equals(destination))
                    {
                        return reconstructPath(currentNode);
                    }

                    nodesToVisitMap.remove(currentNode.getPosition());
                    visitedMap.put(currentNode.getPosition(), currentNode);

                    List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

                    for (AStarNode node : neighbours)
                    {
                        boolean newNode = false;
                        int tentativeScore = currentNode.getScore() + UNIT;

                        AStarNode nodeToVisit = nodesToVisitMap.get(node.getPosition());
                        if (nodeToVisit == null)
                        {
                            nodeToVisit = node;
                            nodesToVisitMap.put(nodeToVisit.getPosition(), nodeToVisit);
                            newNode = true;
                        }

                        if (newNode || tentativeScore < nodeToVisit.getScore())
                        {
                            nodeToVisit.setParent(currentNode);
                            nodeToVisit.setScore(tentativeScore);
                            nodeToVisit.setEstimatedScore(nodeToVisit.getScore() + heuristicDistance(nodeToVisit.getPosition(), destination));
                        }

                    }

                }
            }
        }

        return null;   //should make this work for fog of war as well

    }

    private List<Point> reconstructPath(AStarNode goalNode)
    {
        List<Point> path = new ArrayList<Point>();
        AStarNode currentNode = goalNode;
        while (currentNode.getParent() != null)
        {
            path.add(currentNode.getPosition());
            currentNode = currentNode.getParent();
        }
        path.add(currentNode.getPosition());
        Collections.reverse(path);
        return path;
    }

    private AStarNode getClosestEstimatedNode(Map<Point, AStarNode> nodesMap)
    {
        AStarNode closestEstimatedNode = null;
        int min = Integer.MAX_VALUE;
        for (AStarNode node : nodesMap.values())
        {
            if (node.getEstimatedScore() < min)
            {
                closestEstimatedNode = node;
                min = node.getEstimatedScore();
            }
        }
        return  closestEstimatedNode;
    }

    public abstract int heuristicDistance(Point startPoint, Point endPoint);

}
