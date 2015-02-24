package com.code.wars.engine.extra;

import com.code.wars.engine.board.Point;
import org.junit.Test;

public class AStarManhattanTest {

    @Test
    public void testHeuristicDistance()
    {
        AStarManhattan aStar = new AStarManhattan();
        int heuristicDistance = aStar.heuristicDistance(new Point(3, 11), new Point(10, 5));
        assert(heuristicDistance == 13);
    }

    @Test
    public void testHeuristicDistanceSame()
    {
        AStarManhattan aStar = new AStarManhattan();
        int heuristicDistance = aStar.heuristicDistance(new Point(0, 0), new Point(0, 0));
        assert(heuristicDistance == 0);
    }

    @Test
    public void testHeuristicDistanceSameX()
    {
        AStarManhattan aStar = new AStarManhattan();
        int heuristicDistance = aStar.heuristicDistance(new Point(0, 10), new Point(0, 110));
        assert(heuristicDistance == 100);
    }

    @Test
    public void testHeuristicDistanceSameY()
    {
        AStarManhattan aStar = new AStarManhattan();
        int heuristicDistance = aStar.heuristicDistance(new Point(12, 0), new Point(14, 0));
        assert(heuristicDistance == 2);
    }

}