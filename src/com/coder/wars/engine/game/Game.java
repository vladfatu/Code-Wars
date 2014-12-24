package com.coder.wars.engine.game;

import com.coder.wars.engine.board.Board;
import com.coder.wars.engine.players.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 24.12.2014.
 */
public abstract class Game {

    protected List<Player> players;
    protected Board board;
    protected int roundCount;

    public Game()
    {
        this.players = new ArrayList<Player>();
    }

    public abstract void startGame();

    public abstract void onRoundFinished();

    public List<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public int getRoundCount() {
        return roundCount;
    }

    public void setRoundCount(int roundCount) {
        this.roundCount = roundCount;
    }

}
