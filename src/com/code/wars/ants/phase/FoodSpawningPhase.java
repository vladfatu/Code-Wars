package com.code.wars.ants.phase;

import com.code.wars.engine.board.Point;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.phase.Phase;
import com.code.wars.engine.units.ExpendableUnit;

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

            game.getBoard().getBoardMatrix()[row][column].addUnit(new ExpendableUnit(new Point(row, column), 1));
        }

    }
}
