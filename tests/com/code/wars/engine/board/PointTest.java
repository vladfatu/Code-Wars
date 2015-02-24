package com.code.wars.engine.board;

import org.junit.Test;

public class PointTest {

    @Test
    public void testToString()
    {
        Point point = new Point(0, 1);
        System.out.println(point.toString());
        assert(point.toString().equals("Point(1, 0)"));
    }

}