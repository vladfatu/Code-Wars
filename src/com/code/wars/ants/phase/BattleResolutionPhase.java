package com.code.wars.ants.phase;

import com.code.wars.ants.board.AntsBoard;
import com.code.wars.ants.game.AntsGame;
import com.code.wars.ants.players.AntsPlayer;
import com.code.wars.ants.units.AntUnit;
import com.code.wars.engine.board.Tile;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.phase.Phase;
import com.code.wars.engine.players.Player;
import com.code.wars.engine.units.PlayableUnit;

import java.util.List;

/**
 * Created by vlad on 19.12.2014.
 */
public class BattleResolutionPhase implements Phase {

    @Override
    public void executePhase(Game game) {

        int attackDepth = 2;

        AntsGame antsGame = (AntsGame) game;
        AntsBoard antsBoard = (AntsBoard) antsGame.getBoard();

        for (int i=0;i<antsBoard.getRowsCount();i++)
        {
            for (int j=0;j<antsBoard.getColumnsCount();j++)
            {
                AntUnit antUnit = getAntUnit(antsBoard.getBoardMatrix()[i][j]);
                if (antUnit != null)
                {
                    int allies = 0;
                    int enemies = 0;
                    int playerId = antUnit.getPlayerId();

                    int row = antUnit.getPosition().getRow();
                    int column = antUnit.getPosition().getColumn();

                    int startingRow = Math.max(0, row - attackDepth);
                    int startingColumn = Math.max(0, column - attackDepth);
                    int lastRow = Math.min(antsBoard.getRowsCount() - 1, row + attackDepth);
                    int lastColumn = Math.min(antsBoard.getColumnsCount() - 1, column + attackDepth);

                    for (int i1=startingRow;i1<=lastRow;i1++)
                    {
                        for (int j1=startingColumn;j1<=lastColumn;j1++)
                        {
                            AntUnit otherAntUnit = getAntUnit(antsBoard.getBoardMatrix()[i1][j1]);
                            if (otherAntUnit != null)
                            {
                                if (otherAntUnit.getPlayerId() == playerId)
                                {
                                    allies++;
                                }
                                else
                                {
                                    enemies++;
                                }
                            }
                        }
                        if (enemies> 0 && enemies >= allies)
                        {
                            antUnit.markForKill();
                        }
                    }
                }
            }
        }

        antsBoard.resolveKills();
    }

    private AntUnit getAntUnit(Tile tile)
    {
        List<PlayableUnit> playableUnits = tile.getPlayableUnits();
        if (playableUnits != null && playableUnits.size() > 0)
        {
            for (PlayableUnit unit : playableUnits)
            {
                if (unit instanceof AntUnit)
                {
                    return (AntUnit) unit;
                }
            }
        }
        return null;
    }
}
