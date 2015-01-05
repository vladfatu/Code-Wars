package com.code.wars.engine.game;

import com.code.wars.engine.players.Player;
import com.code.wars.engine.board.Board;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 24.12.2014.
 */
public abstract class Game {

    protected List<Player> players;
    protected Board board;
    protected int roundCount;
    private List<OnRoundFinishedListener> listeners;

    public Game()
    {
        this.players = new ArrayList<Player>();
        this.listeners = new ArrayList<OnRoundFinishedListener>();
    }

    public abstract void startGame();

    public List<Player> getPlayers()
    {
        return players;
    }

    public void addPlayer(Player player)
    {
        this.players.add(player);
    }

    public Board getBoard()
    {
        return board;
    }

    public abstract void setBoard(Board board);

    public int getRoundCount()
    {
        return roundCount;
    }

    public void setRoundCount(int roundCount)
    {
        this.roundCount = roundCount;
    }

    public Player getPlayer(int playerId)
    {
        return this.players.get(playerId);
    }

    public void addOnRoundFinishedListener(OnRoundFinishedListener listener)
    {
        this.listeners.add(listener);
    }

    public void removeOnRoundFinishedLidtener(OnRoundFinishedListener listener)
    {
        this.listeners.remove(listener);
    }

    protected void onRoundFinished()
    {
        for (OnRoundFinishedListener listener : this.listeners)
        {
            listener.onRoundFinished();
        }
    }

}
