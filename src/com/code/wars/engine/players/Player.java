package com.code.wars.engine.players;

/**
 * Created by vlad on 19.12.2014.
 */
public class Player {

    private int playerId;

    public Player(int playerId)
    {
        this.playerId = playerId;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
