package com.coder.wars.ants.phase;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.ants.units.HiveUnit;
import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.phase.Phase;

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
            if (hive.getFoodSupply() > 0 && antsBoard.getAntUnit(position) == null)
            {
                antsBoard.addAnt(hive.getPlayerId(), position);
                hive.decreaseFoodSupply(1);
            }
        }

    }
}
