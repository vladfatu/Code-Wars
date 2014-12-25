package com.coder.wars.test;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.game.OnRoundFinishedListener;

/**
 * Created by Vlad on 12/19/2014.
 */
public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        AntsBoard board = new AntsBoard();
        board.readFromMap("maps/maze_map_01.map");

        AntsGame game = new AntsGame();
        game.setBoard(board);
        final Frame frame = new Frame(game);
        game.addOnRoundFinishedListener(new OnRoundFinishedListener() {
            @Override
            public void onRoundFinished()
            {
                frame.repaint();
            }
        });

        game.startGame();
    }

}
