package com.code.wars.ants.round;

import com.code.wars.ants.phase.*;
import com.code.wars.engine.players.Player;
import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.game.AntsGame;
import com.code.wars.ants.players.AntsPlayer;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.phase.Phase;
import com.code.wars.engine.round.Round;

/**
 * Created by vlad on 19.12.2014.
 */
public class AntsRound implements Round {

    @Override
    public void executeRound(Game game) {

        AntsGame antsGame = (AntsGame) game;
        AntsBoard antsBoard = (AntsBoard) antsGame.getBoard();
        for (Player player : antsGame.getPlayers())
        {
            ((AntsPlayer) player).setLastMovement(antsGame.getAntsAiByPlayerId(player.getPlayerId()).onTurnStarted(antsBoard.getAntsForPlayerId(player.getPlayerId())));
        }

        Phase phase = new MovePhase();
        phase.executePhase(game);
        phase = new BattleResolutionPhase();
        phase.executePhase(game);
        phase = new HillRazingPhase();
        phase.executePhase(game);
        phase = new FoodGatheringPhase();
        phase.executePhase(game);
        phase = new AntSpawningPhase();
        phase.executePhase(game);
        phase = new FoodSpawningPhase();
        phase.executePhase(game);

    }
}
