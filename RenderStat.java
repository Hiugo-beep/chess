package Interface;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.concurrent.TimeUnit;

public class RenderStat extends DefaultTableCellRenderer {
    Field chess;
    Location redCell;



    RenderStat(){

        chess=  new Field();
        redCell = new Location();

    }
    public Component getTableCellRendererComponent(JTable table,
                                                   Object value,
                                                   boolean isSelected,
                                                   boolean hasFocus,
                                                   int row,
                                                   int column) {
        Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        int value_cell;
        JLabel label = (JLabel)super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
//System.out.println(row + " " + column);
        int x = row -1;
        int y = column -1;


        boolean RightX = x > -1 && x <8;
        boolean RightY = y > -1 && y<8;
        boolean RightPosition = RightX && RightY;
        if (RightPosition) {
            boolean isColorWhite = chess.fieldFigure[x][y].figureWhite;
            boolean isColorBlack = chess.fieldFigure[x][y].figureBlack;
            boolean isHorse = chess.fieldFigure[x][y].personalSymbolFigure=='h';
            boolean isRook = chess.fieldFigure[x][y].personalSymbolFigure=='r';
            boolean isElephant = chess.fieldFigure[x][y].personalSymbolFigure=='e';
            boolean isPawn = chess.fieldFigure[x][y].personalSymbolFigure=='p';
            boolean isQueen = chess.fieldFigure[x][y].personalSymbolFigure=='q';
            boolean isKing = chess.fieldFigure[x][y].personalSymbolFigure=='k';
            if(isColorWhite) {
                if(isRook) label.setIcon(new ImageIcon("res/rW.png"));
                else if(isHorse) label.setIcon(new ImageIcon("res/hW.png"));
                else if(isElephant) label.setIcon(new ImageIcon("res/eW.png"));
                else if(isPawn) label.setIcon(new ImageIcon("res/pW.png"));
                else if(isKing) label.setIcon(new ImageIcon("res/kW.png"));
                else if(isQueen) label.setIcon(new ImageIcon("res/qW.png"));
            }
            else if(isColorBlack) {
                if(isRook) label.setIcon(new ImageIcon("res/rB.png"));
                else if(isHorse) label.setIcon(new ImageIcon("res/hB.png"));
                else if(isElephant) label.setIcon(new ImageIcon("res/eB.png"));
                else if(isPawn) label.setIcon(new ImageIcon("res/pB.png"));
                else if(isKing) label.setIcon(new ImageIcon("res/kB.png"));
                else if(isQueen) label.setIcon(new ImageIcon("res/qB.png"));
            }
            else label.setIcon(null);
        } else label.setIcon(null);
        boolean isntNullCell = (row != 0 && row != 9);
        if(isntNullCell)
        {
            boolean rowEven = row%2 == 0;
            if(rowEven)
                value_cell=1;
            else value_cell=2;
            for(int j=0;j<4;j++)
            {
                boolean isRightColumn = (column==value_cell);
                if (isRightColumn) {
                    cell.setBackground(Color.LIGHT_GRAY);
                    break;
                }
                else {
                    cell.setBackground(table.getBackground());
                }
                value_cell+=2;
            }
        }
        boolean redRowRight = redCell.x == x;
        boolean redColumnRight = redCell.y == y;
        boolean redRightCell = redRowRight && redColumnRight;

        if(redRightCell){
            cell.setBackground(Color.RED);

        }

        return cell;
    }
    public void setField(Field chessField) {
        chess = chessField;
    }
    public void setRedCell(Location temp){
        redCell.addLocation(temp.x, temp.y);
    }


}
