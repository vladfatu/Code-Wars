package com.code.wars.engine.utils;

import com.code.wars.engine.board.Board;
import com.code.wars.engine.board.Direction;
import com.code.wars.engine.board.Point;

/**
 * Created by vlad on 05.01.2015.
 */
public class Utils {

    public static Point getNewPosition(Point oldPosition, Direction direction)
    {
        if (oldPosition != null && direction != null)
        {
            switch (direction)
            {
                case EST:
                {
                    return new Point(oldPosition.getRow(), oldPosition.getColumn() - 1);
                }
                case WEST:
                {
                    return new Point(oldPosition.getRow(), oldPosition.getColumn() + 1);
                }
                case SOUTH:
                {
                    return new Point(oldPosition.getRow() - 1, oldPosition.getColumn());
                }
                case NORTH:
                {
                    return new Point(oldPosition.getRow() + 1, oldPosition.getColumn());
                }
            }
        }
        return null;
    }

    public static boolean isPointValid(Board board, Point point)
    {
        if (point.getRow() < 0
                || point.getColumn() < 0
                || point.getRow() >= board.getRowsCount()
                || point.getColumn() >= board.getColumnsCount()
                || board.getBoardMatrix()[point.getRow()][point.getColumn()].hasObstacle())
        {
            return false;
        }
        return true;
    }

}
