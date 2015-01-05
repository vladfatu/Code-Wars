package com.coder.wars.ants.board;

import com.coder.wars.ants.units.Ant;
import com.coder.wars.ants.units.AntUnit;
import com.coder.wars.ants.units.HiveUnit;
import com.coder.wars.engine.board.Board;
import com.coder.wars.engine.board.Direction;
import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.board.Tile;
import com.coder.wars.engine.units.ExpendableUnit;
import com.coder.wars.engine.units.ObstacleUnit;
import com.coder.wars.engine.units.PlayableUnit;
import com.coder.wars.engine.units.Unit;
import com.coder.wars.engine.utils.Utils;

import java.io.BufferedReader;
import java.io.File;
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
        List<Unit> playableUnits = getBoardMatrix()[point.getRow()][point.getColumn()].getPlayableUnits();
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
            this.boardMatrix[antUnit.getPosition().getRow()][antUnit.getPosition().getColumn()].removeUnit(antUnit.getUnitId());
            antUnit.setPosition(Utils.getNewPosition(antUnit.getPosition(), direction));
            this.boardMatrix[antUnit.getPosition().getRow()][antUnit.getPosition().getColumn()].addUnit(antUnit);
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

    public List<HiveUnit> getHives()
    {
        return hives;
    }

}
