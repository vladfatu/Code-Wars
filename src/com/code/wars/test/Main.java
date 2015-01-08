package com.code.wars.test;

import com.code.wars.ants.ai.AntsAi;
import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.game.AntsGame;
import com.code.wars.engine.game.OnRoundFinishedListener;

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
//        board.readFromMap("maps/maze_map_01.map");
        board.readFromMap("maps/battle_tutorial.map");

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
