package com.coder.wars.ants.phase;

import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.ants.players.AntsPlayer;
import com.coder.wars.engine.board.Direction;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.phase.Phase;
import com.coder.wars.engine.players.Player;

import java.util.Map;
import java.util.Set;

/**
 * Created by vlad on 19.12.2014.
 */
public class MovePhase implements Phase {

    @Override
    public void executePhase(Game game) {
        AntsGame antsGame = (AntsGame) game;
        for (Player player : antsGame.getPlayers())
        {
            Map<Integer, Direction> lastMovement = ((AntsPlayer) player).getLastMovement();
            for (Map.Entry<Integer, Direction> entry : lastMovement.entrySet())
            {

            }
        }
    }
}
