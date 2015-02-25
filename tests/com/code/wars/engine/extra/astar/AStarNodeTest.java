package com.code.wars.engine.extra.astar;

import com.code.wars.engine.board.Point;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AStarNodeTest {

    @Test
    public void testGetNotVisitedNeighboursStandard()
    {
        Point currentPoint = new Point(25, 45);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(25, 44);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        for (AStarNode node : neighbours)
        {
            assertFalse(visitedMap.containsKey(node.getPosition()));
        }

        assert(neighbours.size() == 3);

        assert(neighbours.get(0).getPosition().equals(new Point(24, 45)));
        assert(neighbours.get(1).getPosition().equals(new Point(26, 45)));
        assert(neighbours.get(2).getPosition().equals(new Point(25, 46)));
    }

    @Test
    public void testGetNotVisitedNeighboursNullVisitedMap()
    {
        Point currentPoint = new Point(25, 45);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = null;

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        assert(neighbours.size() == 0);

    }

    @Test
    public void testGetNotVisitedNeighboursRowZero()
    {
        Point currentPoint = new Point(25, 45);
        AStarNode currentNode = new AStarNode(currentPoint, 0, 100);

        Point visitedPoint = new Point(25, 44);
        AStarNode visitedNode = new AStarNode(visitedPoint, 0, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        assert(neighbours.size() == 0);

    }

    @Test
    public void testGetNotVisitedNeighboursColumnZero()
    {
        Point currentPoint = new Point(25, 45);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 0);

        Point visitedPoint = new Point(25, 44);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 0);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        assert(neighbours.size() == 0);

    }

    @Test
    public void testGetNotVisitedNeighboursOutOfBounds1()
    {
        Point currentPoint = new Point(25, 145);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(25, 44);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        assert(neighbours.size() == 0);

    }

    @Test
    public void testGetNotVisitedNeighboursOutOfBounds2()
    {
        Point currentPoint = new Point(125, 45);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(25, 44);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        assert(neighbours.size() == 0);

    }

    @Test
    public void testGetNotVisitedNeighboursEdgeRow1()
    {
        Point currentPoint = new Point(99, 45);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(99, 46);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        for (AStarNode node : neighbours)
        {
            assertFalse(visitedMap.containsKey(node.getPosition()));
        }

        assert(neighbours.size() == 2);

        assert(neighbours.get(0).getPosition().equals(new Point(98, 45)));
        assert(neighbours.get(1).getPosition().equals(new Point(99, 44)));
    }

    @Test
    public void testGetNotVisitedNeighboursEdgeRow2()
    {
        Point currentPoint = new Point(0, 45);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(0, 44);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        for (AStarNode node : neighbours)
        {
            assertFalse(visitedMap.containsKey(node.getPosition()));
        }

        assert(neighbours.size() == 2);

        assert(neighbours.get(0).getPosition().equals(new Point(1, 45)));
        assert(neighbours.get(1).getPosition().equals(new Point(0, 46)));
    }

    @Test
    public void testGetNotVisitedNeighboursEdgeColumn1()
    {
        Point currentPoint = new Point(25, 99);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(26, 99);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        for (AStarNode node : neighbours)
        {
            assertFalse(visitedMap.containsKey(node.getPosition()));
        }

        assert(neighbours.size() == 2);

        assert(neighbours.get(0).getPosition().equals(new Point(24, 99)));
        assert(neighbours.get(1).getPosition().equals(new Point(25, 98)));
    }

    @Test
    public void testGetNotVisitedNeighboursEdgeColumn2()
    {
        Point currentPoint = new Point(25, 0);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(26, 0);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        for (AStarNode node : neighbours)
        {
            assertFalse(visitedMap.containsKey(node.getPosition()));
        }

        assert(neighbours.size() == 2);

        assert(neighbours.get(0).getPosition().equals(new Point(24, 0)));
        assert(neighbours.get(1).getPosition().equals(new Point(25, 1)));
    }

    @Test
    public void testGetNotVisitedNeighboursCorner()
    {
        Point currentPoint = new Point(0, 0);
        AStarNode currentNode = new AStarNode(currentPoint, 100, 100);

        Point visitedPoint = new Point(0, 1);
        AStarNode visitedNode = new AStarNode(visitedPoint, 100, 100);

        Map<Point, AStarNode> visitedMap = new HashMap<Point, AStarNode>();
        visitedMap.put(visitedPoint, visitedNode);

        List<AStarNode> neighbours = currentNode.getNotVisitedNeighbours(visitedMap);

        for (AStarNode node : neighbours)
        {
            assertFalse(visitedMap.containsKey(node.getPosition()));
        }

        assert(neighbours.size() == 1);

        assert(neighbours.get(0).getPosition().equals(new Point(1, 0)));
    }

}