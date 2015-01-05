package com.code.wars.engine.units;

import com.code.wars.engine.board.Point;

import java.util.List;

/**
 * Created by vlad on 19.12.2014.
 */
public class PlayableUnit extends Unit{

    private List<Order> orders;
    private int playerId;

    public PlayableUnit(int playerId, Point position)
    {
        super(position);
        this.playerId = playerId;
    }

    public void executeOrders()
    {
        if (orders != null)
        {
            for (Order order : orders)
            {
                order.executeOrder();
            }
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

}
