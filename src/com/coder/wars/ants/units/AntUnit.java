package com.coder.wars.ants.units;

import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.units.Order;
import com.coder.wars.engine.units.PlayableUnit;

import java.util.ArrayList;

/**
 * Created by vlad on 19.12.2014.
 */
public class AntUnit extends PlayableUnit{

    public AntUnit(int unitId, int playerId, Point position) {
        super(unitId, playerId, position);
    }

    public void setOrder(Order order)
    {
        ArrayList<Order> orders = new ArrayList<Order>();
        orders.add(order);
        setOrders(orders);
    }

}
