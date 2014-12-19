package com.coder.wars.engine.board;

/**
 * Created by vlad on 19.12.2014.
 */
public class Point {

    private int x;
    private int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Point");
        stringBuffer.append('(').append(this.x).append(", ").append(this.y).append(')');
        return stringBuffer.toString();
    }
}
