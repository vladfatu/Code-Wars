package com.coder.wars.test;

import com.coder.wars.ants.ai.AntsAi;
import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.game.OnRoundFinishedListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vlad on 12/19/2014.
 */
public class Main {

    public static void main(String[] args)
    {
        System.out.println("Hello World!");
        AntsBoard board = new AntsBoard();
        board.readFromMap("maps/maze_map_01.map");

        List<AntsAi> antsAiList = new ArrayList<AntsAi>();
        AntsAi ai = new RandomAi();
        antsAiList.add(ai);
        ai = new RandomAi();
        antsAiList.add(ai);

        AntsGame game = new AntsGame(antsAiList);
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
