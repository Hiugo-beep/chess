package Interface;

import Interface.Figure.Course;

public class QueenCourse implements Course  {
	 QueenCourse(){}
	public Figure course(Figure f, Field fieldFigure) {
		int count_move = 0;
		int count = 0;
		boolean x_flag_p_e = false, x_flag_m_e = false, y_flag_p1_e = false, y_flag_m1_e = false, y_flag_p2_e = false, y_flag_m2_e = false;//флаги x и y. на m минус и p плюс 
		boolean x_flag_p_l = false, x_flag_m_l = false, y_flag_p_l = false, y_flag_m_l = false;//флаги x и y. на m минус и p плюс 
		if(f.location.x ==-1 ||f.location.y ==-1 ) {}
		else
		for (int i = 1; i < 8; i++)
		{
			//ELEPHANT
			if (!x_flag_m_e)
			{
				if (f.location.x - i >= 0)
				{
					if (!y_flag_m1_e)
					{
						if (f.location.y - i >= 0)
						{
							f.attackingCells[count].addLocation(f.location.x - i, f.location.y - i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureWhite)
								|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x - i, f.location.y - i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureBlack || fieldFigure.fieldFigure[f.location.x - i][f.location.y - i].figureWhite)
								y_flag_m1_e = true;
						}
						else
						{
							y_flag_m1_e = true;
						}
					}
					if (!y_flag_p1_e)
					{
						if (f.location.y + i < 8)
						{
							f.attackingCells[count].addLocation(f.location.x - i, f.location.y + i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureWhite)
								|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x - i, f.location.y + i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureBlack || fieldFigure.fieldFigure[f.location.x - i][f.location.y + i].figureWhite)
								y_flag_p1_e = true;
						}
						else
						{
							y_flag_p1_e = true;
						}
					}
				}
				else
				{
					x_flag_m_e = true;
				}
			}
			if (!x_flag_p_e)
			{
				if (f.location.x + i < 8)
				{
					if (!y_flag_m2_e)
					{
						if (f.location.y - i >= 0)
						{
							f.attackingCells[count].addLocation(f.location.x + i, f.location.y - i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureWhite)
								|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x + i, f.location.y - i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureBlack || fieldFigure.fieldFigure[f.location.x + i][f.location.y - i].figureWhite)
								y_flag_m2_e = true;
						}
						else
						{
							y_flag_m2_e = true;
						}
					}
					if (!y_flag_p2_e)
					{
						if (f.location.y + i < 8)
						{
							f.attackingCells[count].addLocation(f.location.x + i, f.location.y + i);
							count++;
							if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureWhite)
								|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureBlack))
							{
								f.courseCells[count_move].addLocation(f.location.x + i, f.location.y + i);
								count_move++;
							}
							if (fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureBlack || fieldFigure.fieldFigure[f.location.x + i][f.location.y + i].figureWhite)
								y_flag_p2_e = true;
						}
						else
						{
							y_flag_p2_e = true;
						}
					}
				}
				else
				{
					x_flag_p_e = true;
				}
			}
			//ROOK
			if (!x_flag_m_l)
			{
				if (f.location.x - i >= 0)
				{
					f.attackingCells[count].addLocation(f.location.x - i, f.location.y);
					count++;
					if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y].figureWhite)
						|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x - i][f.location.y].figureBlack))
					{
						f.courseCells[count_move].addLocation(f.location.x - i, f.location.y);
						count_move++;
					}
					if (fieldFigure.fieldFigure[f.location.x - i][f.location.y].figureBlack || fieldFigure.fieldFigure[f.location.x - i][f.location.y].figureWhite)
						x_flag_m_l = true;

				}
				else
				{
					x_flag_m_l = true;
				}
			}
			if (!x_flag_p_l)
			{
				if (f.location.x + i < 8)
				{
					f.attackingCells[count].addLocation(f.location.x + i, f.location.y);
					count++;
					if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y].figureWhite)
						|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x + i][f.location.y].figureBlack))
					{
						f.courseCells[count_move].addLocation(f.location.x + i, f.location.y);
						count_move++;
					}
					if (fieldFigure.fieldFigure[f.location.x + i][f.location.y].figureBlack || fieldFigure.fieldFigure[f.location.x + i][f.location.y].figureWhite)
						x_flag_p_l = true;
				}
				else
				{
					x_flag_p_l = true;
				}
			}
			if (!y_flag_m_l)
			{
				if (f.location.y - i >= 0)
				{
					f.attackingCells[count].addLocation(f.location.x, f.location.y - i);
					count++;
					if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x][f.location.y - i].figureWhite)
						|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x][f.location.y - i].figureBlack))
					{
						f.courseCells[count_move].addLocation(f.location.x, f.location.y - i);
						count_move++;
					}
					if (fieldFigure.fieldFigure[f.location.x][f.location.y - i].figureBlack || fieldFigure.fieldFigure[f.location.x][f.location.y - i].figureWhite)
						y_flag_m_l = true;
				}
				else
				{
					y_flag_m_l = true;
				}
			}
			if (!y_flag_p_l)
			{
				if (f.location.y + i < 8)
				{
					f.attackingCells[count].addLocation(f.location.x, f.location.y + i);
					count++;
					if ((f.color == 'w' && !fieldFigure.fieldFigure[f.location.x][f.location.y + i].figureWhite)
						|| (f.color == 'b' && !fieldFigure.fieldFigure[f.location.x][f.location.y + i].figureBlack))
					{
						f.courseCells[count_move].addLocation(f.location.x, f.location.y + i);
						count_move++;
					}
					if (fieldFigure.fieldFigure[f.location.x][f.location.y + i].figureBlack || fieldFigure.fieldFigure[f.location.x][f.location.y + i].figureWhite)
						y_flag_p_l = true;
				}
				else
				{
					y_flag_p_l = true;
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
