package com.coder.wars.ants.round;

import com.coder.wars.ants.phase.*;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.phase.Phase;
import com.coder.wars.engine.round.Round;

/**
 * Created by vlad on 19.12.2014.
 */
public class AntsRound implements Round {

    @Override
    public void executeRound(Game game) {

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
