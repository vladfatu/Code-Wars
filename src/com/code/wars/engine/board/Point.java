package com.code.wars.engine.board;

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

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (column != point.column) return false;
        if (row != point.row) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = column;
        result = 31 * result + row;
        return result;
    }
}
