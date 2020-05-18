package Interface;

public class FieldParametr {

	int battleCountWhite;
	int battleCountBlack;
	boolean figureWhite;
	boolean figureBlack;
	int numberF;
	char personalSymbolFigure;
		FieldParametr() {
			battleCountWhite = 0;//НЕ ЗАБЫТЬ ДОБАВИТЬ СИМВОЛ ЭЛЕМЕНТА И ПАРАМЕТР(1или 2)
			battleCountBlack = 0;
			figureWhite = false;
			figureBlack = false;
			personalSymbolFigure = '0';
			numberF=-1;
		}
		public void addPositionField(char symbolColor, char symbolFigure, int numberFigure) {
			if (symbolColor == 'w')
				figureWhite= true;
			else if (symbolColor == 'b')
				figureBlack = true;
			personalSymbolFigure = symbolFigure;
			numberF= numberFigure;
		}
		boolean getColorWhite()
		{
			return figureWhite;
			
		}
		boolean getColorBlack()
		{
			return figureBlack;
			
		}
		public void clearPositionField() {
			figureWhite = false;
			personalSymbolFigure = '0';
			figureBlack = false;
			numberF= -1;
		}
		public void addPositionFieldBattleCount(char c, int i) {
			if (c == 'w')
				battleCountWhite += i;
			else if (c == 'b')
				battleCountBlack+= i;
		}
}

