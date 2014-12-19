package com.coder.wars.test;

import static org.junit.Assert.*;

public class MainTest {

    @org.junit.Test
    public void testGetFail() throws Exception {
        Main.main(new String[2]);
    }
}