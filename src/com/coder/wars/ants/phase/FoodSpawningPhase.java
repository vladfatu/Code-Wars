package com.coder.wars.ants.phase;

import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.game.Game;
import com.coder.wars.engine.phase.Phase;
import com.coder.wars.engine.units.ExpendableUnit;

import java.util.Random;

/**
 * Created by vlad on 19.12.2014.
 */
public class FoodSpawningPhase implements Phase {

    @Override
    public void executePhase(Game game)
    {
        int foodToSpawnCount = 5;

        for  (int i=0; i < foodToSpawnCount; i++)
        {
            Random r = new Random();
            int column = r.nextInt(game.getBoard().getColumnsCount());
            int row = r.nextInt(game.getBoard().getRowsCount());

            game.getBoard().getBoardMatrix()[row][column].addUnit(new ExpendableUnit(0, new Point(column, row), 1));
        }

    }
}
