package com.coder.wars.test;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.engine.game.Game;

/**
 * Created by Vlad on 12/19/2014.
 */
public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        AntsBoard board = new AntsBoard();
        board.readFromMap("maps/maze_map_01.map");
        final Frame frame = new Frame(board);

        Game game = new AntsGame() {
            @Override
            public void onRoundFinished() {
                frame.repaint();
            }
        };

        game.setBoard(board);
        game.startGame();;
    }

}
