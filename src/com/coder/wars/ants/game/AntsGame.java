package com.coder.wars.ants.game;

import com.coder.wars.ants.round.AntsRound;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.round.Round;

/**
 * Created by vlad on 24.12.2014.
 */
public abstract class AntsGame extends Game {

    public AntsGame()
    {
        this.roundCount = 100;
    }

    @Override
    public void startGame()
    {
        for (int i=0; i<this.roundCount; i++)
        {
            System.out.println("Round " + i + " started!");
            Round round = new AntsRound();
            round.executeRound(this);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.onRoundFinished();
        }
        System.out.println("Game Finished");
    }
}
