package com.code.wars.ants.gameState;

/**
 * Created by vlad on 07.01.2015.
 */
public class GameState {

    private Tile[][] board;
    private int playerCount;
    private int rowCount;
    private int columnCount;

    public GameState(Tile[][] board, int playerCount, int rowCount, int columnCount)
    {
        this.board = board;
        this.playerCount = playerCount;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }

    public Tile[][] getBoard()
    {
        return board;
    }

    public int getPlayerCount()
    {
        return playerCount;
    }

    public int getRowCount()
    {
        return rowCount;
    }

    public int getColumnCount()
    {
        return columnCount;
    }

    public void prettyPrint()
    {
        System.out.println();
        for (int i=0;i<rowCount;i++)
        {
            for (int j=0;j<columnCount;j++)
            {
                if (board[i][j] == null)
                {
                    System.out.print("?");
                }
                else if (board[i][j].isObstacle())
                {
                    System.out.print("%");
                }
                else if (board[i][j].getHive() != null)
                {
                    System.out.print("o");
                }
                else if (board[i][j].getAnt() != null)
                {
                    System.out.print("x");
                }
                else if (board[i][j].isFood())
                {
                    System.out.print("%");
                }
                else
                {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
