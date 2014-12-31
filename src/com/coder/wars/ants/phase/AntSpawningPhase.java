package com.coder.wars.ants.phase;

import com.coder.wars.ants.board.AntsBoard;
import com.coder.wars.ants.game.AntsGame;
import com.coder.wars.ants.players.AntsPlayer;
import com.coder.wars.ants.units.AntUnit;
import com.coder.wars.ants.units.HiveUnit;
import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.phase.Phase;
import com.coder.wars.engine.players.Player;
import com.coder.wars.engine.units.Unit;

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
                antsBoard.getBoardMatrix()[position.getRow()][position.getColumn()].addUnit(new AntUnit(0, hive.getPlayerId(), position));
                hive.decreaseFoodSupply(1);
            }
        }

    }
}
