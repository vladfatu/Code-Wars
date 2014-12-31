package com.coder.wars.ants.board;

import com.coder.wars.ants.units.AntUnit;
import com.coder.wars.ants.units.HiveUnit;
import com.coder.wars.engine.board.Board;
import com.coder.wars.engine.board.Point;
import com.coder.wars.engine.board.Tile;
import com.coder.wars.engine.units.ExpendableUnit;
import com.coder.wars.engine.units.ObstacleUnit;
import com.coder.wars.engine.units.PlayableUnit;
import com.coder.wars.engine.units.Unit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 24.12.2014.
 */
public class AntsBoard extends Board {

    private List<HiveUnit> hives;

    public AntsBoard()
    {
        this.hives = new ArrayList<HiveUnit>();
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
                        tile.addUnit(new ObstacleUnit(0, new Point(row, i)));
                    }
                    else if (currentLine.charAt(i) != '.')
                    {
                        HiveUnit hiveUnit = new HiveUnit(0, Character.getNumericValue(currentLine.charAt(i)), new Point(row, i));
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

    public List<HiveUnit> getHives()
    {
        return hives;
    }

    public void setHives(List<HiveUnit> hives)
    {
        this.hives = hives;
    }
}
