package Interface;

import Interface.Figure.Course;

public class HorseCourse implements Course  {
	HorseCourse(){}
	
	
	public Figure course(Figure f, Field fieldFigure) {

		int x =f.location.x;
		int y =f.location.y;

			int countMove = 0;
			int count = 0;
			boolean xIs2minus = x - 2 >= 0;
			boolean xIs2plus  = x + 2 < 8;
			boolean xIs1minus = x - 1 >= 0;
			boolean xIs1plus = x + 1 < 8;
			boolean yIs2minus = y - 2 >= 0; 
			boolean yIs2plus = y + 2 < 8;
			boolean yIs1minus = y - 1 >= 0;
			boolean yIs1plus = y + 1 < 8;
			boolean isColorWhite = f.color == 'w';
			boolean isColorBlack = f.color == 'b';
			if(f.location.x ==-1 ||f.location.y ==-1 ) {}
			else
			{
			if (xIs2minus)
			{
				if (yIs1minus)
				{
					f.attackingCells[count].addLocation(x - 2, y - 1);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x-2][y - 1].figureWhite)
					{
						f.courseCells[countMove].addLocation(x - 2, y - 1);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x-2][y - 1].figureBlack)
					{
						f.courseCells[countMove].addLocation(x - 2, y - 1);
						countMove++;
					}
				}
				if (yIs1plus)
				{
					f.attackingCells[count].addLocation(x - 2, y + 1);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x - 2][y + 1].figureWhite)
					{
						f.courseCells[countMove].addLocation(x - 2, y + 1);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x-2][y + 1].figureBlack)
					{
						f.courseCells[countMove].addLocation(x - 2, y + 1);
						countMove++;
					}
				}
			}
			if (xIs2plus)
			{
				if (yIs1minus)
				{
					f.attackingCells[count].addLocation(x + 2, y - 1);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x + 2][y - 1].figureWhite)
					{
						f.courseCells[countMove].addLocation(x + 2, y - 1);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x+2][y - 1].figureBlack)
					{
						f.courseCells[countMove].addLocation(x + 2, y - 1);
						countMove++;
					}
				}
				
				if (yIs1plus)
				{
					f.attackingCells[count].addLocation(x + 2, y + 1);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x + 2][y + 1].figureWhite)
					{
						f.courseCells[countMove].addLocation(x + 2, y + 1);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x+2][y+1].getColorBlack())
					{
						f.courseCells[countMove].addLocation(x + 2, y + 1);
						countMove++;
					}
				}
			}
			if (yIs2minus)
			{
				if (xIs1minus)
				{
					f.attackingCells[count].addLocation(x - 2, y - 1);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x - 2][y - 1].figureWhite)
					{
						f.courseCells[countMove].addLocation(x - 2, y - 1);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x-2][y - 1].figureBlack)
					{
						f.courseCells[countMove].addLocation(x - 2, y - 1);
						countMove++;
					}
				}
				if (xIs1plus)
				{
					f.attackingCells[count].addLocation(x +1, y -2);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x +1][y -2].figureWhite)
					{
						f.courseCells[countMove].addLocation(x +1, y -2);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x+1][y -2].figureBlack)
					{
						f.courseCells[countMove].addLocation(x +1, y -2);
						countMove++;
					}
				}
			}
			if (yIs2plus)
			{
				if (xIs1minus)
				{
					f.attackingCells[count].addLocation(x - 1, y + 2);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x - 1][y + 2].figureWhite)
					{
						f.courseCells[countMove].addLocation(x - 1, y + 2);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x-1][y + 2].figureBlack)
					{
						f.courseCells[countMove].addLocation(x - 1, y + 2);
						countMove++;
					}
				}
				if (xIs1plus)
				{
					f.attackingCells[count].addLocation(x +1, y + 2);
					count++;
					if (isColorWhite && !fieldFigure.fieldFigure[x +1][y + 2].figureWhite)
					{
						f.courseCells[countMove].addLocation(x +1, y + 2);
						countMove++;
					}
					else if (isColorBlack && !fieldFigure.fieldFigure[x+1][y + 2].figureBlack)
					{
						f.courseCells[countMove].addLocation(x +1, y + 2);
						countMove++;
					}
				}
			}
			}
			if (count < f.sizeAttackingCells)
			{
				for (int count1=count; count1 < f.sizeAttackingCells; count1++)
					f.attackingCells[count1].addLocation(-1, -1);
			}
			if (countMove < f.sizeCourseCells)
			{
				for (int count1 = countMove;count1 < 8; count1++) {
					f.courseCells[count1].addLocation(-1, -1);
				}
			}
			return f;
		}
}

