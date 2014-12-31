package com.coder.wars.engine.board;

/**
 * Created by vlad on 19.12.2014.
 */
public class Point {

    private int column;
    private int row;

    public Point(int row, int column)
    {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("Point");
        stringBuffer.append('(').append(this.column).append(", ").append(this.row).append(')');
        return stringBuffer.toString();
    }
}
