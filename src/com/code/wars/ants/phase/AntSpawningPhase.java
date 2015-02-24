package com.code.wars.ants.phase;

import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.game.AntsGame;
import com.code.wars.engine.board.Point;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.phase.Phase;
import com.code.wars.ants.units.HiveUnit;

/**
 * Created by vlad on 19.12.2014.
 */
public class AntSpawningPhase implements Phase {

    @Override
    public void executePhase(Game game)
    {
        AntsGame antsGame = (AntsGame) game;
        AntsBoard antsBoard = (AntsBoard) antsGame.getBoard();
        for (HiveUnit hive : antsBoard.getHives())
        {
            Point position = hive.getPosition();
            if (hive.isActive() && hive.getFoodSupply() > 0 && antsBoard.getAntUnit(position) == null)
            {
                antsBoard.addAnt(hive.getPlayerId(), position);
                hive.decreaseFoodSupply(1);
            }
        }

    }
}
