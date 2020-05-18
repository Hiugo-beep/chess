package Interface;

import Interface.Figure.Course;

public class ElephantCourse implements Course  {
	 ElephantCourse(){}
	public Figure course(Figure f, Field fieldFigure) {
		int count = 0;
		int count_move = 0;
		boolean x_flag_p = false, x_flag_m = false, y_flag_p1 = false, y_flag_m1 = false, y_flag_p2 = false, y_flag_m2 = false;//флаги x и y. на m минус и p плюс
		if(f.location.x ==-1 ||f.location.y ==-1 ) {}
		else
			for (int i = 1; i < 8; i++)
		{
			if (!x_flag_m)
			{
				if (f.location.x - i >= 0)
				{
					if (!y_flag_m1)
					{
						if (f.location.y - i >= 0)
						{
							f.attackingCells[count].addLocation(f.location.x - i, f.location.y - i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureWhite) || (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x - i, f.location.y - i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureBlack || fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureWhite)
								y_flag_m1 = true;
						}
						else
						{
							y_flag_m1 = true;
						}
					}
					if (!y_flag_p1)
					{
						if (f.location.y + i < 8)
						{
							f.attackingCells[count].addLocation(f.location.x - i, f.location.y + i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureWhite) || (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x - i, f.location.y + i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureBlack || fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureWhite)
								y_flag_p1 = true;
						}
						else
						{
							y_flag_p1 = true;
						}
					}
				}
				else
				{
					x_flag_m = true;
				}
			}
			if (!x_flag_p)
			{
				if (f.location.x + i < 8)
				{
					if (!y_flag_m2)
					{
						if (f.location.y - i >= 0)
						{
							f.attackingCells[count].addLocation(f.location.x + i, f.location.y - i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureWhite) || (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x + i, f.location.y - i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureBlack || fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureWhite)
								y_flag_m2 = true;
						}
						else
						{
							y_flag_m2 = true;
						}
					}
					if (!y_flag_p2)
					{
						if (f.location.y + i < 8)
						{
							f.attackingCells[count].addLocation(f.location.x + i, f.location.y + i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureWhite) || (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x + i, f.location.y + i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureBlack || fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureWhite)
								y_flag_p2 = true;
						}
						else
						{
							y_flag_p2 = true;
						}
					}
				}
				else
				{
					x_flag_p = true;
				}
			}
		}
		if (count < f.sizeAttackingCells)
		{
			int l = 0;
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
