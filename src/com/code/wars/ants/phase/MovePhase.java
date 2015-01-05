package com.code.wars.ants.phase;

import com.code.wars.ants.game.AntsGame;
import com.code.wars.engine.board.Direction;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.players.Player;
import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.players.AntsPlayer;
import com.code.wars.engine.phase.Phase;

import java.util.Map;

/**
 * Created by vlad on 19.12.2014.
 */
public class MovePhase implements Phase {

    @Override
    public void executePhase(Game game) {
        AntsGame antsGame = (AntsGame) game;
        AntsBoard antsBoard = (AntsBoard) antsGame.getBoard();
        for (Player player : antsGame.getPlayers())
        {
            Map<Integer, Direction> lastMovement = ((AntsPlayer) player).getLastMovement();
            if (lastMovement != null)
            {
                for (Map.Entry<Integer, Direction> entry : lastMovement.entrySet())
                {
                    antsBoard.moveAnt(entry.getKey(), entry.getValue());
                }
            }
        }
    }

}