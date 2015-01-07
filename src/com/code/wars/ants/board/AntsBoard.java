package com.code.wars.ants.board;

import com.code.wars.ants.players.AntsPlayer;
import com.code.wars.ants.gameState.Ant;
import com.code.wars.engine.board.Direction;
import com.code.wars.engine.board.Point;
import com.code.wars.ants.units.AntUnit;
import com.code.wars.ants.units.HiveUnit;
import com.code.wars.engine.board.Board;
import com.code.wars.engine.board.Tile;
import com.code.wars.engine.game.Game;
import com.code.wars.engine.units.ExpendableUnit;
import com.code.wars.engine.units.ObstacleUnit;
import com.code.wars.engine.units.PlayableUnit;
import com.code.wars.engine.units.Unit;
import com.code.wars.engine.utils.Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by vlad on 24.12.2014.
 */
public class AntsBoard extends Board {

    private List<HiveUnit> hives;

    private Map<Integer, AntUnit> antsMap;

    public AntsBoard()
    {
        this.hives = new ArrayList<HiveUnit>();
        this.antsMap = new HashMap<Integer, AntUnit>();
    }

    @Override
    public void readFromMap(String mapFilePath) {

        BufferedReader br = null;

        try {

            String currentLine;

            br = new BufferedReader(new FileReader(mapFilePath));

            if ((currentLine = br.readLine()) != null)
            {
                System.out.println(currentLine);
                this.playerCount = Integer.parseInt(currentLine.split(" ")[1]);
            }

            if ((currentLine = br.readLine()) != null)
            {
                System.out.println(currentLine);
                this.rowsCount = Integer.parseInt(currentLine.split(" ")[1]);
            }

            if ((currentLine = br.readLine()) != null)
            {
                System.out.println(currentLine);
                this.columnsCount = Integer.parseInt(currentLine.split(" ")[1]);
            }

            this.boardMatrix = new Tile[this.rowsCount][this.columnsCount];

            int row=0;
            while ((currentLine = br.readLine()) != null) {
                System.out.println(currentLine);
                for (int i=0; i<currentLine.length();i++)
                {
                    Tile tile = new Tile();
                    this.boardMatrix[row][i] = tile;
                    if (currentLine.charAt(i) == '%')
                    {
                        tile.addUnit(new ObstacleUnit(new Point(row, i)));
                    }
                    else if (currentLine.charAt(i) != '.')
                    {
                        HiveUnit hiveUnit = new HiveUnit(Character.getNumericValue(currentLine.charAt(i)), new Point(row, i));
                        tile.addUnit(hiveUnit);
                        this.hives.add(hiveUnit);
                    }
                }
                row++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try
            {
                if (br != null)
                {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

    }

    public AntUnit getAntUnit(Point point)
    {
        AntUnit antUnit = null;
        List<PlayableUnit> playableUnits = getBoardMatrix()[point.getRow()][point.getColumn()].getPlayableUnits();
        if (playableUnits != null && playableUnits.size() != 0)
        {
            for (Unit unit : playableUnits)
            {
                if (unit instanceof AntUnit)
                {
                    antUnit = (AntUnit)unit;
                }
            }
        }
        return antUnit;
    }

    public void addAnt(int playerId, Point position)
    {
        AntUnit antUnit = new AntUnit(playerId, position);
        this.antsMap.put(antUnit.getUnitId(), antUnit);
        this.boardMatrix[position.getRow()][position.getColumn()].addUnit(antUnit);
    }

    public void moveAnt(int antId, Direction direction)
    {
        AntUnit antUnit = this.antsMap.get(antId);
        if (antUnit != null)
        {
            Point newPosition = Utils.getNewPosition(antUnit.getPosition(), direction);
            if (Utils.isPointValid(this, newPosition))
            {
                this.boardMatrix[antUnit.getPosition().getRow()][antUnit.getPosition().getColumn()].removeUnit(antUnit.getUnitId());
                antUnit.setPosition(newPosition);
                this.boardMatrix[antUnit.getPosition().getRow()][antUnit.getPosition().getColumn()].addUnit(antUnit);
            }
            else
            {
                System.out.println("Move invalid to position: " + newPosition.toString());
            }
        }
    }

    public void removeAnt(int antId)
    {
        AntUnit antUnit = this.antsMap.get(antId);
        if (antUnit != null)
        {
            this.boardMatrix[antUnit.getPosition().getRow()][antUnit.getPosition().getColumn()].removeUnit(antUnit.getUnitId());
            this.antsMap.remove(antId);
            System.out.println("Removed Ant: " + antUnit.toString());
        }
    }

    public List<Ant> getAntsForPlayerId(int playerId)
    {
        List<Ant> ants = new ArrayList<Ant>();
        for (AntUnit antUnit : this.antsMap.values())
        {
            if (antUnit.getPlayerId() == playerId)
            {
                ants.add(new Ant(antUnit));
            }
        }
        return ants;
    }

    public void resolveCollisions()
    {
        for (int i=0; i < this.getRowsCount(); i++)
        {
            for (int j=0; j < this.getColumnsCount(); j++)
            {
                Tile tile = this.boardMatrix[i][j];
                List<PlayableUnit> playableUnits = tile.getPlayableUnits();
                if (playableUnits != null)
                {
                    List<Integer> antIds = new ArrayList<Integer>();
                    for (PlayableUnit playableUnit : playableUnits)
                    {
                        if (playableUnit instanceof AntUnit)
                        {
                            antIds.add(playableUnit.getUnitId());
                        }
                    }
                    if (antIds.size() > 1)
                    {
                        System.out.println("Ant collision detected removed " + antIds.size());
                        for (Integer antId : antIds)
                        {
                            removeAnt(antId);
                        }
                    }
                }
            }
        }
    }

    public void gatherFood(Game game)
    {
        for (int i=0; i < this.getRowsCount(); i++)
        {
            for (int j = 0; j < this.getColumnsCount(); j++)
            {
                Tile tile = this.boardMatrix[i][j];
                List<PlayableUnit> playableUnits = tile.getPlayableUnits();
                AntUnit antUnit = null;
                if (playableUnits != null)
                {
                    for (PlayableUnit playableUnit : playableUnits)
                    {
                        if (playableUnit instanceof AntUnit)
                        {
                            antUnit = (AntUnit) playableUnit;
                        }
                    }
                }

                if (antUnit != null)
                {
                    Point position = antUnit.getPosition();
                    List<Integer> unitIds = new ArrayList<Integer>();
                    List<ExpendableUnit> expendableUnits = tile.getExpendableUnits();
                    if (expendableUnits != null)
                    {
                        for (ExpendableUnit expendableUnit : expendableUnits)
                        {
                            unitIds.add(expendableUnit.getUnitId());
                        }
                        if (unitIds.size() > 0)
                        {
                            for (Integer unitId : unitIds)
                            {
                                AntsPlayer antsPlayer = (AntsPlayer) game.getPlayer(antUnit.getPlayerId());
                                antsPlayer.addFoodSupply(1);
                                System.out.println("Food Gathered for player : " + antsPlayer.getPlayerId() + " at position : " + position);
                                this.boardMatrix[position.getRow()][position.getColumn()].removeUnit(unitId);
                            }
                        }
                    }
                }
            }
        }
    }

    public com.code.wars.ants.gameState.Tile[][] getTileMatrixForPlayer(int playerId)
    {
        int visionDepth = 5;
        com.code.wars.ants.gameState.Tile[][] tileMatrix = new com.code.wars.ants.gameState.Tile[getRowsCount()][getColumnsCount()];

        for (Ant ant : getAntsForPlayerId(playerId))
        {
            int row = ant.getPosition().getRow();
            int column = ant.getPosition().getColumn();

            int startingRow = Math.max(0, row - visionDepth);
            int startingColumn = Math.max(0, column - visionDepth);
            int lastRow = Math.min(getRowsCount() - 1, row + visionDepth);
            int lastColumn = Math.min(getColumnsCount() - 1, column + visionDepth);

            for (int i=startingRow;i<=lastRow;i++)
            {
                for (int j=startingColumn;j<=lastColumn;j++)
                {
                    if (tileMatrix[i][j] == null)
                    {
                        tileMatrix[i][j] = new com.code.wars.ants.gameState.Tile(boardMatrix[i][j]);
                    }
                }
            }
        }

        return tileMatrix;
    }

    public List<HiveUnit> getHives()
    {
        return hives;
    }

}
