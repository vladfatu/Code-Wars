package com.coder.wars.ants.phase;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.ants.players.AntsPlayer;
import com.coder.wars.engine.board.Direction;
import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.phase.Phase;
import com.coder.wars.engine.players.Player;
import com.coder.wars.engine.utils.Utils;

import java.util.Map;
import java.util.Set;

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