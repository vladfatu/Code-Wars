package com.code.wars.ants.phase;

import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.game.AntsGame;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.phase.Phase;

/**
 * Created by vlad on 19.12.2014.
 */
public class FoodGatheringPhase implements Phase {

    @Override
    public void executePhase(Game game) {

        AntsGame antsGame = (AntsGame) game;
        AntsBoard antsBoard = (AntsBoard) antsGame.getBoard();

        antsBoard.gatherFood(game);

    }
}
