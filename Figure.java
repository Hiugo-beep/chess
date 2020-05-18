package Interface;

public class Figure {
	int cost;
	char color;
	int number;
	char personalSymbol;
	Location location;
	int sizeCourseCells;
	int sizeAttackingCells;
	Location[] attackingCells;
	Location[] courseCells;
	//Field chessField;
	boolean checkToKing;//шах королю
	Course course;//переменная интерфейса хода
	Figure () {}
	Figure (Course course, char personalSymbF, char colorFigure, int numberFigure) {
		this.course = course;
		color = colorFigure;
		number = numberFigure;
		personalSymbol = personalSymbF;
		checkToKing=false;
		boolean colorWhite = color == 'w';
		if(colorWhite) {
			boolean figurePawn = personalSymbF == 'p';
			if  (personalSymbF == 'h')
			{
				cost = 3;
				sizeCourseCells=8;
				sizeAttackingCells=8;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				if(number == 1) location = new Location(7,1);
				else location = new Location(7,6);
			}			
			else if  (personalSymbF == 'e')
			{
				cost = 3;
				sizeCourseCells=13;
				sizeAttackingCells=13;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				if(number == 1) location = new Location(7,2);
				else location = new Location(7,5);
			}
			else if  (personalSymbF == 'r')
			{
				cost = 5;
				sizeCourseCells=14;
				sizeAttackingCells=14;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				if(number == 1) location = new Location(7,0);
				else location = new Location(7,7);
			}
			else if  (personalSymbF == 'k')
			{
				cost = 10;
				sizeCourseCells=8;
				sizeAttackingCells=8;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				location = new Location(7,4);
			}
			else if  (personalSymbF == 'q')
			{
				cost = 7;
				sizeCourseCells=27;
				sizeAttackingCells=27;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				location = new Location(7,3);
			}
			else
			if(figurePawn) {
				cost = 1;
				sizeCourseCells=4;
				sizeAttackingCells=2;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				switch(numberFigure) {
					case 1: {
						location = new Location(6,1);
						break;
					}
					case 2:{
						location = new Location(6,2);
						break;
					}
					case 3:{
						location = new Location(6,3);
						break;
					}
					case 4:{
						location = new Location(6,4);
						break;
					}
					case 5:{
						location = new Location(6,5);
						break;
					}
					case 6:{
						location = new Location(6,6);
						break;
					}
					case 7:{	
						location = new Location(6,7);
						break;
					}
					case 8:{
						location = new Location(6,8);
						break;
					}
					default:{}
				}
			}
		}
			
		else {
			boolean figurePawn = personalSymbF == 'p';
			if  (personalSymbF == 'h')
			{
				cost = 3;
				sizeCourseCells=8;
				sizeAttackingCells=8;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				if(number == 1) location = new Location(0,1);
				else location = new Location(0,6);
			}	
			else if  (personalSymbF == 'e')
			{
				cost = 3;
				sizeCourseCells=13;
				sizeAttackingCells=13;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				if(number == 1) location = new Location(0,2);
				else location = new Location(0,5);
			}
			else if  (personalSymbF == 'r')
			{
				cost = 5;
				sizeCourseCells=14;
				sizeAttackingCells=14;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				if(number == 1) location = new Location(0,0);
				else location = new Location(0,7);
			}
			else if  (personalSymbF == 'k')
			{
				cost = 10;
				sizeCourseCells=8;
				sizeAttackingCells=8;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				location = new Location(0,4);
			}
			else if  (personalSymbF == 'q')
			{
				cost = 7;
				sizeCourseCells=27;
				sizeAttackingCells=27;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				location = new Location(0,3);
			}
			else
			if(figurePawn) {
				cost = 1;
				sizeCourseCells=4;
				sizeAttackingCells=2;
				attackingCells = new Location [sizeAttackingCells];
				courseCells = new Location [sizeCourseCells];
				for(int i = 0;i<sizeCourseCells;i++)courseCells[i] = new Location();
				for(int i = 0;i<sizeAttackingCells;i++)attackingCells[i] = new Location();
				switch(numberFigure) {
					case 1: {
						location = new Location(1,1);
						break;
					}
					case 2:{
						location = new Location(1,2);
						break;
					}
					case 3:{
						location = new Location(1,3);
						break;
					}
					case 4:{
						location = new Location(1,4);
						break;
					}
					case 5:{
						location = new Location(1,5);
						break;
					}
					case 6:{
						location = new Location(1,6);
						break;
					}
					case 7:{	
						location = new Location(1,7);
						break;
					}
					case 8:{
						location = new Location(1,8);
						break;
					}
					default:{}
				}
			}
		}
		
	}

	/*public void getFieldChess (Field fieldChess) {
		chessField = fieldChess;
	}*/
	public void addLocation(int x, int y) {
		location.addLocation(x, y);
	}
	
	public interface Course{
		Figure course(Figure f, Field fieldFigure);
	}
}
