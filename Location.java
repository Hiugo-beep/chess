package Interface;

public class Location {
		int x = 0;
		int y = 0;
		Location(){x=-1; y=-1;}
		Location(int i, int j){
			x=i; y=j;
		}
		public void addLocation(int x1, int y1) {
			boolean checkFigureOnTheBoardX = x1 > -1 && x1 < 8;
			boolean figureDieX = x1 == -1;
			boolean figureLocationX = checkFigureOnTheBoardX || figureDieX;
			if (figureLocationX)
			{
				x = x1;
			}
			boolean checkFigureOnTheBoardY = y1 > -1 && y1 < 8;
			boolean figureDieY = y1 == -1;
			boolean figureLocationY = checkFigureOnTheBoardY || figureDieY;
			if (figureLocationY)
			{
				y = y1;
			}
		}

}
