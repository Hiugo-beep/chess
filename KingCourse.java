package Interface;

import Interface.Figure.Course;

public class KingCourse implements Course  {
	KingCourse(){}
	
	
	public Figure course(Figure f, Field fieldFigure) {
	int count_move = 0;
	int count = 0;
	if(f.location.x ==-1 ||f.location.y ==-1 ) {}
	else {
	if (f.location.x - 1 >= 0)
	{
		f.attackingCells[count].addLocation(f.location.x - 1, f.location.y);
		count++;
		if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - 1][f.location.y].figureWhite
			&& fieldFigure.fieldFigure[f.location.x - 1][f.location.y].battleCountBlack == 0)
			|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - 1][f.location.y].figureBlack
				&& fieldFigure.fieldFigure[f.location.x - 1][f.location.y].battleCountWhite == 0))
		{
			f.courseCells[count_move].addLocation(f.location.x - 1, f.location.y);
			count_move++;
		}
		if (f.location.y - 1 >= 0)
		{
			f.attackingCells[count].addLocation(f.location.x - 1, f.location.y - 1);
			count++;

			if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - 1][f.location.y - 1].figureWhite
				&& fieldFigure.fieldFigure[f.location.x - 1][f.location.y - 1].battleCountBlack == 0)
				|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - 1][f.location.y - 1].figureBlack
					&& fieldFigure.fieldFigure[f.location.x - 1][f.location.y - 1].battleCountWhite == 0))
			{
				f.courseCells[count_move].addLocation(f.location.x - 1, f.location.y - 1);
				count_move++;
			}
		}
		if (f.location.y + 1 < 8)
		{
			f.attackingCells[count].addLocation(f.location.x - 1, f.location.y + 1);
			count++;
			if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - 1][f.location.y + 1].figureWhite
				&& fieldFigure.fieldFigure[f.location.x - 1][f.location.y + 1].battleCountBlack == 0)
				|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - 1][f.location.y + 1].figureBlack
					&& fieldFigure.fieldFigure[f.location.x - 1][f.location.y + 1].battleCountWhite == 0))
			{
				f.courseCells[count_move].addLocation(f.location.x - 1, f.location.y + 1);
				count_move++;
			}
		}
	}
	if (f.location.x + 1 < 8)
	{
		f.attackingCells[count].addLocation(f.location.x + 1, f.location.y);
		count++;
		if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + 1][f.location.y].figureWhite
			&& fieldFigure.fieldFigure[f.location.x + 1][f.location.y].battleCountBlack == 0)
			|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + 1][f.location.y].figureBlack
				&& fieldFigure.fieldFigure[f.location.x + 1][f.location.y].battleCountWhite == 0))
		{
			f.courseCells[count_move].addLocation(f.location.x + 1, f.location.y);
			count_move++;
		}
		if (f.location.y - 1 >= 0)
		{
			f.attackingCells[count].addLocation(f.location.x + 1, f.location.y - 1);
			count++;
			if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + 1][f.location.y - 1].figureWhite
				&& fieldFigure.fieldFigure[f.location.x + 1][f.location.y - 1].battleCountBlack == 0)
				|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + 1][f.location.y - 1].figureBlack
					&& fieldFigure.fieldFigure[f.location.x + 1][f.location.y - 1].battleCountWhite == 0))
			{
				f.courseCells[count_move].addLocation(f.location.x + 1, f.location.y - 1);
				count_move++;
			}
		}
		if (f.location.y + 1 < 8)
		{
			f.attackingCells[count].addLocation(f.location.x + 1, f.location.y + 1);
			count++;
			if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + 1][f.location.y + 1].figureWhite
				&& fieldFigure.fieldFigure[f.location.x + 1][f.location.y + 1].battleCountBlack == 0)
				|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + 1][f.location.y + 1].figureBlack
					&& fieldFigure.fieldFigure[f.location.x + 1][f.location.y + 1].battleCountWhite == 0))
			{
				f.courseCells[count_move].addLocation(f.location.x + 1, f.location.y + 1);
				count_move++;
			}
		}
	}
	if (f.location.y - 1 >= 0)
	{
		f.attackingCells[count].addLocation(f.location.x, f.location.y - 1);
		count++;
		if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x][f.location.y - 1].figureWhite
			&& fieldFigure.fieldFigure[f.location.x][f.location.y - 1].battleCountBlack == 0)
			|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x][f.location.y - 1].figureBlack
				&& fieldFigure.fieldFigure[f.location.x][f.location.y - 1].battleCountWhite == 0))
		{
			f.courseCells[count_move].addLocation(f.location.x, f.location.y - 1);
			count_move++;
		}
	}
	if (f.location.y + 1 < 8)
	{
		f.attackingCells[count].addLocation(f.location.x, f.location.y + 1);
		count++;
		if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x][f.location.y + 1].figureWhite
			&& fieldFigure.fieldFigure[f.location.x][f.location.y + 1].battleCountBlack == 0)
			|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x][f.location.y + 1].figureBlack
				&& fieldFigure.fieldFigure[f.location.x][f.location.y + 1].battleCountWhite == 0))
		{
			f.courseCells[count_move].addLocation(f.location.x, f.location.y + 1);
			count_move++;
		}
	}
	}
	if (count < f.sizeAttackingCells)
	{
		int l=0;
		for (l=count; count < f.sizeAttackingCells; count++)
			f.attackingCells[count].addLocation(-1, -1);
	}
	if (count_move < f.sizeCourseCells)
	{
		int l=0;
		for (l=count_move; count_move < f.sizeCourseCells; count_move++)
			f.courseCells[count_move].addLocation(-1, -1);
	}
	return f;
}
}
