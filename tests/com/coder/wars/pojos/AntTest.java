package com.coder.wars.pojos;

import org.junit.Test;

import static org.junit.Assert.*;

public class AntTest {

    @Test
    public void testGet0()
    {
        Ant ant = new Ant();
        assert(ant.get0() == 0);
    }

    @Test
    public void testGet0Fail()
    {
        Ant ant = new Ant();
        assert(ant.get0() == 1);
    }

}