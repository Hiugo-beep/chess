package Interface;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;


public class Render extends DefaultTableCellRenderer {
	Field chess;
	Location back1;
	Location forward1;
	boolean move;
	boolean move1 = true;
public Component getTableCellRendererComponent(JTable table,
                                               Object value,
                                               boolean isSelected,
                                               boolean hasFocus,
                                               int row,
                                               int column) {
   Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
   int value_cell;
 
   
   JLabel label = (JLabel)super.getTableCellRendererComponent(
           table, value, isSelected, hasFocus, row, column);
// Выравнивание строки заголовка
//label.setHorizontalAlignment(SwingConstants.CENTER);
// Размещение изображения в заголовке
;   
Location[] figures = new Location [32];
Field_parametr[][] field_f = new Field_parametr [8][8];
//friend: Field_parametr;
		for(int i=0;i<8;i++) {
			figures[i] = new Location();
			
		}
/*for(int i=0;i<8;i++)
	for(int j=0;j<8;j++)
		if(chess.field_f[i][j].figure_w  )
		{
			if(chess.field_f[i][j].personal_symbol_f == 'r')
			{
				if(chess.field_f[i][j].number_f == 1) figures[0].add_location(i,j);
				else figures[1].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'h')
			{
				if(chess.field_f[i][j].number_f == 1) figures[2].add_location(i,j);
				else figures[3].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'e')
			{
				if(chess.field_f[i][j].number_f == 1) figures[4].add_location(i,j);
				else figures[5].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'q')
			{
				 figures[6].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'k')
			{
				figures[7].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'p')
			{
				for(int k=0;k<8;k++)
					if(chess.field_f[i][j].number_f == i+1) figures[8+i].add_location(i,j);
			}
		}
		else if(chess.field_f[i][j].figure_b  )
		{
			if(chess.field_f[i][j].personal_symbol_f == 'r')
			{
				if(chess.field_f[i][j].number_f == 1) figures[16].add_location(i,j);
				else figures[17].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'h')
			{
				if(chess.field_f[i][j].number_f == 1) figures[18].add_location(i,j);
				else figures[19].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'e')
			{
				if(chess.field_f[i][j].number_f == 1) figures[20].add_location(i,j);
				else figures[21].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'q')
			{
				 figures[22].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'k')
			{
				figures[23].add_location(i,j);
			}
			else if(chess.field_f[i][j].personal_symbol_f == 'p')
			{
				for(int k=0;k<8;k++)
					if(chess.field_f[i][j].number_f == i+1) figures[24+i].add_location(i,j);
			}
		}*/


if ((column == 1 && row == 1)||(column == 8 && row == 1))//((column == figures[0].y+1 && row == figures[0].x+1 )||(column == figures[1].y+1 && row == figures[1].x+1 ))
	label.setIcon(new ImageIcon("res/rB.png"));
else if  ((column == 2 && row == 1)||(column == 7 && row == 1))
	label.setIcon(new ImageIcon("res/hB.png"));
else if  ((column == 3 && row == 1)||(column == 6 && row == 1))
	label.setIcon(new ImageIcon("res/eB.png"));
else if  (column == 4 && row == 1)
	label.setIcon(new ImageIcon("res/qB.png"));
else if  (column == 5 && row == 1)
	label.setIcon(new ImageIcon("res/kB.png"));

else if ((column == 1 && row == 8)||(column == 8 && row == 8))// ((column == figures[0].y+1 && row == figures[0].x+1 )||(column == figures[1].y+1 && row == figures[1].x+1 ))
	label.setIcon(new ImageIcon("res/rW.png"));
else if  ((column == 2 && row == 8)||(column == 7 && row == 8))
	label.setIcon(new ImageIcon("res/hW.png"));
else if  ((column == 3 && row == 8)||(column == 6 && row == 8))
	label.setIcon(new ImageIcon("res/eW.png"));
else if  (column == 4 && row == 8)
	label.setIcon(new ImageIcon("res/qW.png"));
else if  (column == 5 && row == 8)
	label.setIcon(new ImageIcon("res/kW.png"));
else  label.setIcon(null);

for(int i=1;i<9;i++)
{
	if (column == i && row == 2)
		label.setIcon(new ImageIcon("res/pB.png"));	
	else if (column == i && row == 7)
		label.setIcon(new ImageIcon("res/pW.png"));	
	
}
if(row != 0 && row != 9)
{
	   if(row%2 == 0)
	   value_cell=1;
	   else value_cell=2;
	   for(int j=0;j<4;j++)
	   {
		   if (column==value_cell ) {
     cell.setBackground(Color.LIGHT_GRAY);
     break;
		   } 
		   else {
			   cell.setBackground(table.getBackground());
 }
 
 value_cell+=2;
	   }
	 
}
    return cell;
    }
