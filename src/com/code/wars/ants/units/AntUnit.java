package com.code.wars.ants.units;

import com.code.wars.engine.board.Point;
import com.code.wars.engine.units.PlayableUnit;

/**
 * Created by vlad on 19.12.2014.
 */
public class AntUnit extends PlayableUnit {

    private boolean markedForKill;

    public AntUnit(int playerId, Point position) {
        super(playerId, position);
        this.markedForKill = false;
    }

    public void markForKill()
    {
        this.markedForKill = true;
    }

    public boolean isMarkedForKill()
    {
        return  markedForKill;
    }

}
