package com.code.wars.ants.game;

import com.code.wars.ants.round.AntsRound;
import com.code.wars.engine.players.Player;
import com.code.wars.ants.ai.AntsAi;
import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.players.AntsPlayer;
import com.code.wars.ants.units.HiveUnit;
import com.code.wars.engine.board.Board;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.round.Round;

import java.util.List;

/**
 * Created by vlad on 24.12.2014.
 */
public class AntsGame extends Game {

    private List<AntsAi> antsAiList;

    public AntsGame(List<AntsAi> antsAiList)
    {
        this.roundCount = 100;
        this.antsAiList = antsAiList;
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

    public List<AntsAi> getAntsAiList() {
        return antsAiList;
    }

    public AntsAi getAntsAiByPlayerId(int playerId)
    {
        return this.antsAiList.get(playerId);
    }
}
