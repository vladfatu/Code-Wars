package com.coder.wars.engine.board;

import junit.framework.TestCase;
import org.junit.Test;

public class PointTest extends TestCase {

    @Test
    public void testToString()
    {
        Point point = new Point(0, 1);
        assert(point.toString().equals("Point(0, 1)"));
    }

}