package com.code.wars.ants.phase;

import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.game.AntsGame;
import com.code.wars.ants.units.AntUnit;
import com.code.wars.ants.units.HiveUnit;
import com.code.wars.engine.board.Point;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.phase.Phase;

/**
 * Created by vlad on 19.12.2014.
 */
public class HillRazingPhase implements Phase {

    @Override
    public void executePhase(Game game) {

        AntsGame antsGame = (AntsGame) game;
        AntsBoard antsBoard = (AntsBoard) antsGame.getBoard();
        for (HiveUnit hive : antsBoard.getHives())
        {
            Point position = hive.getPosition();
            AntUnit antUnit = antsBoard.getAntUnit(position);
            if (antUnit != null && antUnit.getPlayerId() != hive.getPlayerId())
            {
                hive.setActive(false);
            }
        }

    }
}
