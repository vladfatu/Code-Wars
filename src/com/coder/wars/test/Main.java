package com.coder.wars.test;

import com.coder.wars.ants.board.AntsBoard;

/**
 * Created by Vlad on 12/19/2014.
 */
public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        AntsBoard board = new AntsBoard();
        board.readFromMap("maps/maze_map_01.map");
        new Frame(board);
    }

}
