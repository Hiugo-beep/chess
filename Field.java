package Interface;

public class Field {
	FieldParametr[][] fieldFigure = new FieldParametr [8][8];
		Field(){
			for(int i = 0;i <8;i++)
				for(int j=0;j<8;j++) {
					fieldFigure[i][j] = new FieldParametr();
				}
		}
		public void deleteField() {}
		void clear(int i, int j) {
			fieldFigure[i][j].clearPositionField();
		}
		public void clear() {
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
				{
					fieldFigure[i][j].figureBlack = false;
					fieldFigure[i][j].figureWhite = false;
					fieldFigure[i][j].battleCountBlack = 0;
					fieldFigure[i][j].battleCountWhite = 0;
				}
		}
		public boolean checkFigure(int x, int y) {
			boolean isBattleCountBlack = fieldFigure[x][y].battleCountBlack > 1;
			boolean isBattleCountWhite = fieldFigure[x][y].battleCountWhite > 1;
			boolean isBattleCount = isBattleCountBlack || isBattleCountWhite;			
			if (isBattleCount)
				return true;
			else return false;
		}
		public boolean checkAttackWhite(int i, int j) {
			boolean isAttackWhite =fieldFigure[i][j].battleCountWhite > 0;
			if (isAttackWhite)
				return true;
			else return false;
		}
		public void figureLocation(Figure mass)
		{
			if (mass.location.x != -1 && mass.location.y != -1)
			{
				if (mass.color == 'w')
				{
					fieldFigure[mass.location.x][mass.location.y].addPositionField('w', mass.personalSymbol, mass.number);
				}
				else
				{
					fieldFigure[mass.location.x][mass.location.y].addPositionField('b', mass.personalSymbol, mass.number);
				}
			}
		}
		public void show() {
			for(int i=0;i<8;i++) {
				for(int j = 0;j<8;j++) {
					if(fieldFigure[i][j].figureBlack)  System.out.printf("b" + fieldFigure[i][j].personalSymbolFigure+fieldFigure[i][j].numberF);
					else if(fieldFigure[i][j].figureWhite) System.out.printf("w" + fieldFigure[i][j].personalSymbolFigure+fieldFigure[i][j].numberF);
					else  System.out.printf("000");
					System.out.print(" ");
					
				}
				System.out.println(" ");
			}
		}
}
