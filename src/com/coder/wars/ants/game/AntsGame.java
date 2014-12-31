package com.coder.wars.ants.game;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.players.AntsPlayer;
import com.coder.wars.ants.round.AntsRound;
import com.coder.wars.ants.units.HiveUnit;
import com.coder.wars.engine.board.Board;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.players.Player;
import com.coder.wars.engine.round.Round;

import java.util.List;

/**
 * Created by vlad on 24.12.2014.
 */
public class AntsGame extends Game {

    public AntsGame()
    {
        this.roundCount = 100;
    }

    @Override
    public void startGame()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    @Override
    public void setBoard(Board board)
    {
        this.board = board;
        for (int i=0; i < board.getPlayerCount(); i++)
        {
            Player player = new AntsPlayer(i);
            this.players.add(player);
        }
        List<HiveUnit> hives = ((AntsBoard) board).getHives();
        for (HiveUnit hive : hives)
        {
            ((AntsPlayer)getPlayer(hive.getPlayerId())).getHives().add(hive);
        }
    }
}
