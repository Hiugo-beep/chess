package Interface;

import java.util.concurrent.TimeUnit;

import Interface.Figure.Course;

public class FieldHandler implements Runnable{
    final int massSize = 32;
    Thread customer;
    Thread thread;
    Sleeper sleepy;
    Sleeper customSl;
    boolean flagReplay = false;
    Field fieldChess;
    boolean yChange = false;
    Location[] GreanCircles;
    Location selectedFigure;
    Location oldSelectedFigure;
    Notation record;
    ActorServer server;
    ActorServer client;
    int iReplay = 0;
    Figure[] massFigure;
    Location yTryMove;
    int gameEnd = 0;
    boolean easyGame = false;
    FieldHandler() {

        sleepy = new Sleeper("Sleepy", 1500);
        thread = new Thread(this);
        thread.setName("server");
        server.main(thread,customer,sleepy,customSl);
        record = new Notation();
        fieldChess = new Field();
        fieldChess.fieldFigure[7][0].addPositionField('w', 'r', 1);
        fieldChess.fieldFigure[7][7].addPositionField('w', 'r', 2);
        fieldChess.fieldFigure[7][1].addPositionField('w', 'h', 1);
        fieldChess.fieldFigure[7][6].addPositionField('w', 'h', 2);
        fieldChess.fieldFigure[7][2].addPositionField('w', 'e', 1);
        fieldChess.fieldFigure[7][5].addPositionField('w', 'e', 2);
        fieldChess.fieldFigure[7][3].addPositionField('w', 'q', 1);
        fieldChess.fieldFigure[7][4].addPositionField('w', 'k', 1);
        for(int i=0;i<8;i++) {
            fieldChess.fieldFigure[1][i].addPositionField('b', 'p', 1+i);
            fieldChess.fieldFigure[6][i].addPositionField('w', 'p', 1+i);
        }
        fieldChess.fieldFigure[0][0].addPositionField('b', 'r', 1);
        fieldChess.fieldFigure[0][7].addPositionField('b', 'r', 2);
        fieldChess.fieldFigure[0][1].addPositionField('b', 'h', 1);
        fieldChess.fieldFigure[0][6].addPositionField('b', 'h', 2);
        fieldChess.fieldFigure[0][2].addPositionField('b', 'e', 1);
        fieldChess.fieldFigure[0][5].addPositionField('b', 'e', 2);
        fieldChess.fieldFigure[0][3].addPositionField('b', 'q', 1);
        fieldChess.fieldFigure[0][4].addPositionField('b', 'k', 1);

        GreanCircles = new Location[27];
        for(int i=0;i<27;i++) GreanCircles[i] = new Location();
        selectedFigure = new Location();
        oldSelectedFigure = new Location();
        yTryMove = new Location();
        massFigure = new Figure[massSize];
        int count = 0;
        Course pawnWhite1Course = new PawnCourse();
        massFigure[count] = new Figure(pawnWhite1Course,'p','w',1);
        count++;

        Course pawnWhite2Course = new PawnCourse();
        massFigure[count] = new Figure(pawnWhite2Course,'p','w',2);
        count++;

        Course pawnWhite3Course = new PawnCourse();
        massFigure[count]  = new Figure(pawnWhite3Course,'p','w',3);
        count++;

        Course pawnWhite4Course = new PawnCourse();
        massFigure[count] = new Figure(pawnWhite4Course,'p','w',4);
        count++;

        Course pawnWhite5Course = new PawnCourse();
        massFigure[count] = new Figure(pawnWhite5Course,'p','w',5);
        count++;

        Course pawnWhite6Course = new PawnCourse();
        massFigure[count] = new Figure(pawnWhite6Course,'p','w',6);
        count++;

        Course pawnWhite7Course = new PawnCourse();
        massFigure[count] = new Figure(pawnWhite7Course,'p','w',7);
        count++;

        Course pawnWhite8Course = new PawnCourse();
        massFigure[count] = new Figure(pawnWhite8Course,'p','w',8);
        count++;

        Course pawnBlack1Course = new PawnCourse();
        massFigure[count] = new Figure(pawnBlack1Course,'p','b',1);
        count++;

        Course pawnBlack2Course = new PawnCourse();
        massFigure[count] = new Figure(pawnBlack2Course,'p','b',2);
        count++;

        Course pawnBlack3Course = new PawnCourse();
        massFigure[count]  = new Figure(pawnBlack3Course,'p','b',3);
        count++;

        Course pawnBlack4Course = new PawnCourse();
        massFigure[count] = new Figure(pawnBlack4Course,'p','b',4);
        count++;

        Course pawnBlack5Course = new PawnCourse();
        massFigure[count] = new Figure(pawnBlack5Course,'p','b',5);
        count++;

        Course pawnBlack6Course = new PawnCourse();
        massFigure[count] = new Figure(pawnBlack6Course,'p','b',6);
        count++;

        Course pawnBlack7Course = new PawnCourse();
        massFigure[count] = new Figure(pawnBlack7Course,'p','b',7);
        count++;

        Course pawnBlack8Course = new PawnCourse();
        massFigure[count] = new Figure(pawnBlack8Course,'p','b',8);
        count++;

        Course horseWhite1Course = new HorseCourse();
        massFigure[count] = new Figure(horseWhite1Course,'h','w',1);
        count++;
        Course horseWhite2Course = new HorseCourse();
        massFigure[count] = new Figure(horseWhite2Course,'h','w',2);
        count++;
        Course horseBlack1Course = new HorseCourse();
        massFigure[count] = new Figure(horseBlack1Course,'h','b',1);
        count++;
        Course horseBlack2Course = new HorseCourse();
        massFigure[count] = new Figure(horseBlack2Course,'h','b',2);
        count++;

        Course kingBlackCourse = new KingCourse();
        massFigure[count] = new Figure(kingBlackCourse,'k','b',1);
        count++;
        Course kingWhiteCourse = new KingCourse();
        massFigure[count] = new Figure(kingWhiteCourse,'k','w',1);
        count++;

        Course elephantWhite1Course = new ElephantCourse();
        massFigure[count] = new Figure(elephantWhite1Course,'e','w',1);
        count++;
        Course elephantWhite2Course = new ElephantCourse();
        massFigure[count] = new Figure(elephantWhite2Course,'e','w',2);
        count++;
        Course elephantBlack1Course = new ElephantCourse();
        massFigure[count] = new Figure(elephantBlack1Course,'e','b',1);
        count++;
        Course elephantBlack2Course = new ElephantCourse();
        massFigure[count] = new Figure(elephantBlack2Course,'e','b',2);
        count++;

        Course rookWhite1Course = new RookCourse();
        massFigure[count] = new Figure(rookWhite1Course,'r','w',1);
        count++;
        Course rookWhite2Course = new RookCourse();
        massFigure[count] = new Figure(rookWhite2Course,'r','w',2);
        count++;
        Course rookBlack1Course = new RookCourse();
        massFigure[count] = new Figure(rookBlack1Course,'r','b',1);
        count++;
        Course rookBlack2Course = new RookCourse();
        massFigure[count] = new Figure(rookBlack2Course,'r','b',2);
        count++;

        Course queenBlackCourse = new QueenCourse();
        massFigure[count] = new Figure(queenBlackCourse,'q','b',1);
        count++;
        Course queenWhiteCourse = new QueenCourse();
        massFigure[count] = new Figure(queenWhiteCourse,'q','w',1);
        count++;
        thread.start();
    }
    int yBuf = 0;
    int selF = 0;
    public void checkSelectedFigureX() {
       // customer.interrupt();
        //client.stopThread
        server.stopThreadClient();
        System.out.println(" ");
        System.out.println(" ");
        if(record.replayStr.length()>0) replay();
        else {
            int yybuf = oldSelectedFigure.y;
            if(yChange && selectedFigure.y==oldSelectedFigure.y) {
                oldSelectedFigure.y = yBuf;
            }
            if(fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].figureWhite) {


                if(oldSelectedFigure.x==-1 && oldSelectedFigure.y==-1)
                    for(int i=0;i<27;i++) {
                        GreanCircles[i].addLocation(-1, -1);
                    }

                int k=0;

                for(k=0;k<massSize;k++) {
                    if(massFigure[k].location.x == selectedFigure.x && massFigure[k].location.y == selectedFigure.y) {
                        break;
                    }
                }

                if(k!=massSize) {
                    if(massFigure[selF].color != massFigure[k].color && selF>-1 && k>-1) {
                        k=selF;
                    }
                    selF = k;
                    massFigure[k]=massFigure[k].course.course(massFigure[k], fieldChess);
                    System.out.println("coursCells");
                    for(int i=0;i<massFigure[k].sizeCourseCells;i++) {
                        System.out.println(massFigure[k].courseCells[i].x + " "+massFigure[k].courseCells[i].y);
                    }
                    for(int i=0;i<massFigure[k].sizeCourseCells;i++) {
                        if(massFigure[k].courseCells[i].x!=-1 && massFigure[k].courseCells[i].y!=-1) {
                            GreanCircles[i].addLocation(massFigure[k].courseCells[i].x, massFigure[k].courseCells[i].y);
                        }
                    }
                }
            }
            if(oldSelectedFigure.x!=-1 && oldSelectedFigure.y!=-1) {
                for(int i=0;i<27;i++)
                    if(GreanCircles[i].x == selectedFigure.x && GreanCircles[i].y == selectedFigure.y) {
                        if(oldSelectedFigure.x != selectedFigure.x)
                            if((massFigure[selF].color=='b' && !fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].figureBlack) || (massFigure[selF].color=='w' && !fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].figureWhite)) {
                                if((oldSelectedFigure.x >-1 && oldSelectedFigure.y>-1)) {
                                    if(fieldChess.fieldFigure[oldSelectedFigure.x][oldSelectedFigure.y].figureBlack || fieldChess.fieldFigure[oldSelectedFigure.x][oldSelectedFigure.y].figureWhite || yChange) {
                                        record.game += oldSelectedFigure.x;
                                        record.game += oldSelectedFigure.y;
                                        record.game += selectedFigure.x;
                                        record.game += selectedFigure.y;
                                        boolean symbolColor;
                                        System.out.println("selF = " + selF);
                                        char symbolFigure;
                                        int numberFigure;
                                        if((massFigure[selF].color=='b' && !fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].figureWhite) && (massFigure[selF].color=='w' &&!fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].figureBlack)) {
                                            for(int y=0;y<massSize;y++) {
                                                if(massFigure[y].location.x == selectedFigure.x && massFigure[y].location.y == selectedFigure.y) {
                                                    massFigure[y].addLocation(-1, -1);

                                                    break;
                                                }
                                            }
                                        }
                                        selF=0;
                                        symbolColor = massFigure[selF].color=='b';
                                        symbolFigure =  fieldChess.fieldFigure[oldSelectedFigure.x][oldSelectedFigure.y].personalSymbolFigure;
                                        numberFigure = fieldChess.fieldFigure[oldSelectedFigure.x][oldSelectedFigure.y].numberF;

                                        fieldChess.fieldFigure[oldSelectedFigure.x][oldSelectedFigure.y].clearPositionField();
                                        if(symbolColor) {
                                            for(int p=0;p<massSize;p++) {
                                                if(massFigure[p].location.x == selectedFigure.x && massFigure[p].location.y == selectedFigure.y)
                                                    massFigure[p].location.addLocation(-1, -1);
                                            }
                                            fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].addPositionField('b',symbolFigure,numberFigure);
                                            fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].figureWhite = false;
                                        }
                                        else {
                                            for(int p=0;p<massSize;p++) {
                                                if(massFigure[p].location.x == selectedFigure.x && massFigure[p].location.y == selectedFigure.y)
                                                    massFigure[p].location.addLocation(-1, -1);
                                            }
                                            fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].addPositionField('w',symbolFigure,numberFigure);
                                            fieldChess.fieldFigure[selectedFigure.x][selectedFigure.y].figureBlack = false;
                                        }
                                        oldSelectedFigure.x=-1;
                                        oldSelectedFigure.y=-1;
                                        int index;
                                        figureUpdate();
                                        fieldChess.show();
                                        if(easyGame)

                                            index = computerMoveEasy();
                                        else index = computerMove();
                                        if(index == 1) {
                                            gameEnd = 1;
                                        }
                                    }
                                }
                                break;

                            }

                    }
            }
            System.out.println("RECORD STR"+record.replayStr);
            System.out.println("SelectedX " +  selectedFigure.x);
            System.out.println("SelectedY " +  selectedFigure.y);
            System.out.println("OldSelectedX " + oldSelectedFigure.x);
            System.out.println("oldSelectedY " +  oldSelectedFigure.y);
            fieldChess.show();
            oldSelectedFigure.x = selectedFigure.x;
            if(oldSelectedFigure.y == yBuf) {
                oldSelectedFigure.y =yybuf;

            }
        }
        yTryMove.x =-1;
        yTryMove.y=-1;
        yChange = false;
        figureUpdate();
       // customSl.interrupt();
        server.runThreadClient();
        //client.runThread();
    }

    public void checkSelectedFigureY() {
        //ustomer.interrupt();
        server.stopThreadClient();
        //client.stopThread();
        System.out.println("YOU COOL Y " + selectedFigure.y);
        yBuf = oldSelectedFigure.y;
        oldSelectedFigure.y = selectedFigure.y;
        //customSl.interrupt();
        server.runThreadClient();
        //client.runThread();
    }
    public void figureUpdate() {
        int k=0;
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                for(k=0;k<massSize;k++) {
                    if(massFigure[k].personalSymbol == 'p') {
                        if(massFigure[k].location.x==7 &&massFigure[k].color=='b') {
                            System.out.println("WOW  "+ k);
                            int y = massFigure[k].location.y;
                            Course queenNewBlackCourse = new QueenCourse();
                            Figure newQ =new Figure(queenNewBlackCourse,'q','b',1);
                            massFigure[k] = newQ;
                            massFigure[k].location.addLocation(7, y);
                            fieldChess.fieldFigure[7][y].clearPositionField();
                            fieldChess.fieldFigure[7][y].addPositionField('b', 'q', 1);
                        }
                        else if(massFigure[k].location.x==0 &&massFigure[k].color=='w') {
                            int y = massFigure[k].location.y;
                            Course queenNewWhiteCourse = new QueenCourse();
                            Figure newQ  = new Figure(queenNewWhiteCourse,'q','w',1);
                            massFigure[k] = newQ;
                            massFigure[k].location.addLocation(0, y);
                            fieldChess.fieldFigure[0][y].clearPositionField();
                            fieldChess.fieldFigure[0][y].addPositionField('w', 'q', 1);
                        }
                    }
                    char color;
                    if(fieldChess.fieldFigure[i][j].figureBlack) color ='b';
                    else if(fieldChess.fieldFigure[i][j].figureWhite) color ='w';
                    else color = '0';
                    if(massFigure[k].color == color)
                        if(massFigure[k].number == fieldChess.fieldFigure[i][j].numberF)
                            if(massFigure[k].personalSymbol==fieldChess.fieldFigure[i][j].personalSymbolFigure)
                                massFigure[k].location.addLocation(i,j);

                }
            }
        }


    }

    public int computerMoveEasy() {
        int k=0;
        System.out.println("COMP EASY MOVE");
        for(k=0;k<massSize;k++) {
            if(massFigure[k].color == 'b') {
                massFigure[k]=massFigure[k].course.course(massFigure[k], fieldChess);

                System.out.println("coursCells");
                for(int i=0;i<massFigure[k].sizeCourseCells;i++) {
                    System.out.println(massFigure[k].courseCells[i].x + " "+massFigure[k].courseCells[i].y);
                }
                if(massFigure[k].location.x !=-1 && massFigure[k].location.y !=-1) {
                    for(int i=0;i<massFigure[k].sizeCourseCells;i++) {
                        if(massFigure[k].courseCells[i].x!=-1 && massFigure[k].courseCells[i].y!=-1) {

                            if((massFigure[k].color=='b' && !fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureWhite) && (massFigure[k].color=='w' &&!fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureBlack)) {
                                for(int y=0;y<massSize;y++) {
                                    if(massFigure[y].location.x == massFigure[k].courseCells[i].x && massFigure[y].location.y == massFigure[k].courseCells[i].y) {
                                        massFigure[y].addLocation(-1, -1);

                                        break;
                                    }
                                }
                            }
                            record.game += massFigure[k].location.x;
                            record.game += massFigure[k].location.y;
                            record.game += massFigure[k].courseCells[i].x;
                            record.game +=massFigure[k].courseCells[i].y;
                            boolean symbolColor = massFigure[k].color=='b';
                            char symbolFigure =  massFigure[k].personalSymbol;
                            int numberFigure = massFigure[k].number;

                            fieldChess.fieldFigure[massFigure[k].location.x][massFigure[k].location.y].clearPositionField();
                            if(symbolColor) {
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].addPositionField('b',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureWhite = false;
                            }
                            else {
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].addPositionField('w',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureBlack = false;
                            }
                            oldSelectedFigure.x=-1;
                            oldSelectedFigure.y=-1;
                            return 0;
                        }
                    }
                }
            }
        }
        return 1;
    }


    public int computerMove() {
        int k=0;
        System.out.println("COMP EASY MOVE");
        for(k=0;k<massSize;k++) {
            if(massFigure[k].color == 'b') {
                massFigure[k]=massFigure[k].course.course(massFigure[k], fieldChess);

                System.out.println("coursCells");
                for(int i=0;i<massFigure[k].sizeCourseCells;i++) {
                    System.out.println(massFigure[k].courseCells[i].x + " "+massFigure[k].courseCells[i].y);
                }
                if(massFigure[k].location.x !=-1 && massFigure[k].location.y !=-1) {
                    for(int i=0;i<massFigure[k].sizeCourseCells;i++) {
                        if(massFigure[k].courseCells[i].x!=-1 && massFigure[k].courseCells[i].y!=-1) {

                            if((massFigure[k].color=='b' && fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureWhite) && (massFigure[k].color=='w'
                                    &&fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureBlack)) {
                                for(int y=0;y<massSize;y++) {
                                    if(fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureWhite
                                            && massFigure[y].location.x == massFigure[k].courseCells[i].x && massFigure[y].location.y == massFigure[k].courseCells[i].y) {
                                        massFigure[y].addLocation(-1, -1);

                                        break;
                                    }
                                }
                            }
                            record.game += massFigure[k].location.x;
                            record.game += massFigure[k].location.y;
                            record.game += massFigure[k].courseCells[i].x;
                            record.game +=massFigure[k].courseCells[i].y;
                            boolean symbolColor = massFigure[k].color=='b';
                            char symbolFigure =  massFigure[k].personalSymbol;
                            int numberFigure = massFigure[k].number;

                            fieldChess.fieldFigure[massFigure[k].location.x][massFigure[k].location.y].clearPositionField();
                            if(symbolColor) {
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].addPositionField('b',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureWhite = false;
                            }
                            else {
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].addPositionField('w',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureBlack = false;
                            }
                            oldSelectedFigure.x=-1;
                            oldSelectedFigure.y=-1;

                            return 0;
                        }
                    }

                    for(int i=0;i<massFigure[k].sizeAttackingCells;i++) {
                        if(massFigure[k].attackingCells[i].x!=-1 && massFigure[k].attackingCells[i].y!=-1) {

                            if((massFigure[k].color=='b' && fieldChess.fieldFigure[massFigure[k].attackingCells[i].x][massFigure[k].attackingCells[i].y].figureWhite) && (massFigure[k].color=='w' &&fieldChess.fieldFigure[massFigure[k].attackingCells[i].x][massFigure[k].attackingCells[i].y].figureBlack)) {
                                for(int y=0;y<massSize;y++) {
                                    if(fieldChess.fieldFigure[massFigure[k].attackingCells[i].x][massFigure[k].attackingCells[i].y].figureWhite && massFigure[y].location.x == massFigure[k].attackingCells[i].x && massFigure[y].location.y == massFigure[k].attackingCells[i].y) {
                                        massFigure[y].addLocation(-1, -1);

                                        break;
                                    }
                                }
                            }
                            record.game += massFigure[k].location.x;
                            record.game += massFigure[k].location.y;
                            record.game += massFigure[k].courseCells[i].x;
                            record.game +=massFigure[k].courseCells[i].y;
                            boolean symbolColor = massFigure[k].color=='b';
                            char symbolFigure =  massFigure[k].personalSymbol;
                            int numberFigure = massFigure[k].number;

                            fieldChess.fieldFigure[massFigure[k].location.x][massFigure[k].location.y].clearPositionField();
                            if(symbolColor) {
                                fieldChess.fieldFigure[massFigure[k].attackingCells[i].x][massFigure[k].attackingCells[i].y].addPositionField('b',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].attackingCells[i].x][massFigure[k].attackingCells[i].y].figureWhite = false;
                            }
                            else {
                                fieldChess.fieldFigure[massFigure[k].attackingCells[i].x][massFigure[k].attackingCells[i].y].addPositionField('w',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].attackingCells[i].x][massFigure[k].attackingCells[i].y].figureBlack = false;
                            }
                            oldSelectedFigure.x=-1;
                            oldSelectedFigure.y=-1;
                            return 0;
                        }
                    }


                    for(int i=0;i<massFigure[k].sizeCourseCells;i++) {
                        if(massFigure[k].courseCells[i].x!=-1 && massFigure[k].courseCells[i].y!=-1) {

                            if((massFigure[k].color=='b' && !fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureWhite) && (massFigure[k].color=='w' &&!fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureBlack)) {
                                for(int y=0;y<massSize;y++) {
                                    if(massFigure[y].location.x == massFigure[k].courseCells[i].x && massFigure[y].location.y == massFigure[k].courseCells[i].y) {
                                        massFigure[y].addLocation(-1, -1);

                                        break;
                                    }
                                }
                            }
                            record.game += massFigure[k].location.x;
                            record.game += massFigure[k].location.y;
                            record.game += massFigure[k].courseCells[i].x;
                            record.game +=massFigure[k].courseCells[i].y;
                            boolean symbolColor = massFigure[k].color=='b';
                            char symbolFigure =  massFigure[k].personalSymbol;
                            int numberFigure = massFigure[k].number;

                            fieldChess.fieldFigure[massFigure[k].location.x][massFigure[k].location.y].clearPositionField();
                            if(symbolColor) {
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].addPositionField('b',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureWhite = false;
                            }
                            else {
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].addPositionField('w',symbolFigure,numberFigure);
                                fieldChess.fieldFigure[massFigure[k].courseCells[i].x][massFigure[k].courseCells[i].y].figureBlack = false;
                            }
                            oldSelectedFigure.x=-1;
                            oldSelectedFigure.y=-1;
                            return 0;
                        }
                    }
                }
            }
        }

        return 1;
    }

    public void replay() {
        System.out.println("RECORD STR"+record.replayStr);
        if(iReplay==0) {

            for(int i=0;i<8;i++)
                for(int j=0;j<8;j++) {
                    fieldChess.fieldFigure[i][j].clearPositionField();
                }
            fieldChess.fieldFigure[7][0].addPositionField('w', 'r', 1);
            fieldChess.fieldFigure[7][7].addPositionField('w', 'r', 2);
            fieldChess.fieldFigure[7][1].addPositionField('w', 'h', 1);
            fieldChess.fieldFigure[7][6].addPositionField('w', 'h', 2);
            fieldChess.fieldFigure[7][2].addPositionField('w', 'e', 1);
            fieldChess.fieldFigure[7][5].addPositionField('w', 'e', 2);
            fieldChess.fieldFigure[7][3].addPositionField('w', 'q', 1);
            fieldChess.fieldFigure[7][4].addPositionField('w', 'k', 1);
            for(int i=0;i<8;i++) {
                fieldChess.fieldFigure[1][i].addPositionField('b', 'p', 1+i);
                fieldChess.fieldFigure[6][i].addPositionField('w', 'p', 1+i);
            }
            fieldChess.fieldFigure[0][0].addPositionField('b', 'r', 1);
            fieldChess.fieldFigure[0][7].addPositionField('b', 'r', 2);
            fieldChess.fieldFigure[0][1].addPositionField('b', 'h', 1);
            fieldChess.fieldFigure[0][6].addPositionField('b', 'h', 2);
            fieldChess.fieldFigure[0][2].addPositionField('b', 'e', 1);
            fieldChess.fieldFigure[0][5].addPositionField('b', 'e', 2);
            fieldChess.fieldFigure[0][3].addPositionField('b', 'q', 1);
            fieldChess.fieldFigure[0][4].addPositionField('b', 'k', 1);

            int count = 0;
            Course pawnWhite1Course = new PawnCourse();
            massFigure[count] = new Figure(pawnWhite1Course,'p','w',1);
            count++;

            Course pawnWhite2Course = new PawnCourse();
            massFigure[count] = new Figure(pawnWhite2Course,'p','w',2);
            count++;

            Course pawnWhite3Course = new PawnCourse();
            massFigure[count]  = new Figure(pawnWhite3Course,'p','w',3);
            count++;

            Course pawnWhite4Course = new PawnCourse();
            massFigure[count] = new Figure(pawnWhite4Course,'p','w',4);
            count++;

            Course pawnWhite5Course = new PawnCourse();
            massFigure[count] = new Figure(pawnWhite5Course,'p','w',5);
            count++;

            Course pawnWhite6Course = new PawnCourse();
            massFigure[count] = new Figure(pawnWhite6Course,'p','w',6);
            count++;

            Course pawnWhite7Course = new PawnCourse();
            massFigure[count] = new Figure(pawnWhite7Course,'p','w',7);
            count++;

            Course pawnWhite8Course = new PawnCourse();
            massFigure[count] = new Figure(pawnWhite8Course,'p','w',8);
            count++;

            Course pawnBlack1Course = new PawnCourse();
            massFigure[count] = new Figure(pawnBlack1Course,'p','b',1);
            count++;

            Course pawnBlack2Course = new PawnCourse();
            massFigure[count] = new Figure(pawnBlack2Course,'p','b',2);
            count++;

            Course pawnBlack3Course = new PawnCourse();
            massFigure[count]  = new Figure(pawnBlack3Course,'p','b',3);
            count++;

            Course pawnBlack4Course = new PawnCourse();
            massFigure[count] = new Figure(pawnBlack4Course,'p','b',4);
            count++;

            Course pawnBlack5Course = new PawnCourse();
            massFigure[count] = new Figure(pawnBlack5Course,'p','b',5);
            count++;

            Course pawnBlack6Course = new PawnCourse();
            massFigure[count] = new Figure(pawnBlack6Course,'p','b',6);
            count++;

            Course pawnBlack7Course = new PawnCourse();
            massFigure[count] = new Figure(pawnBlack7Course,'p','b',7);
            count++;

            Course pawnBlack8Course = new PawnCourse();
            massFigure[count] = new Figure(pawnBlack8Course,'p','b',8);
            count++;

            Course horseWhite1Course = new HorseCourse();
            massFigure[count] = new Figure(horseWhite1Course,'h','w',1);
            count++;
            Course horseWhite2Course = new HorseCourse();
            massFigure[count] = new Figure(horseWhite2Course,'h','w',2);
            count++;
            Course horseBlack1Course = new HorseCourse();
            massFigure[count] = new Figure(horseBlack1Course,'h','b',1);
            count++;
            Course horseBlack2Course = new HorseCourse();
            massFigure[count] = new Figure(horseBlack2Course,'h','b',2);
            count++;

            Course kingBlackCourse = new KingCourse();
            massFigure[count] = new Figure(kingBlackCourse,'k','b',1);
            count++;
            Course kingWhiteCourse = new KingCourse();
            massFigure[count] = new Figure(kingWhiteCourse,'k','w',1);
            count++;

            Course elephantWhite1Course = new ElephantCourse();
            massFigure[count] = new Figure(elephantWhite1Course,'e','w',1);
            count++;
            Course elephantWhite2Course = new ElephantCourse();
            massFigure[count] = new Figure(elephantWhite2Course,'e','w',2);
            count++;
            Course elephantBlack1Course = new ElephantCourse();
            massFigure[count] = new Figure(elephantBlack1Course,'e','b',1);
            count++;
            Course elephantBlack2Course = new ElephantCourse();
            massFigure[count] = new Figure(elephantBlack2Course,'e','b',2);
            count++;

            Course rookWhite1Course = new RookCourse();
            massFigure[count] = new Figure(rookWhite1Course,'r','w',1);
            count++;
            Course rookWhite2Course = new RookCourse();
            massFigure[count] = new Figure(rookWhite2Course,'r','w',2);
            count++;
            Course rookBlack1Course = new RookCourse();
            massFigure[count] = new Figure(rookBlack1Course,'r','b',1);
            count++;
            Course rookBlack2Course = new RookCourse();
            massFigure[count] = new Figure(rookBlack2Course,'r','b',2);
            count++;

            Course queenBlackCourse = new QueenCourse();
            massFigure[count] = new Figure(queenBlackCourse,'q','b',1);
            count++;
            Course queenWhiteCourse = new QueenCourse();
            massFigure[count] = new Figure(queenWhiteCourse,'q','w',1);
            count++;
        }
        flagReplay = true;
        System.out.println("SIZE " + record.replayStr.length());

        if(iReplay<record.replayStr.length()) {

            //try {
            //thread.start();
            //}catch(InterruptedException e) {}

            int oldX = record.replayStr.charAt(iReplay) - 0x30;
            int oldY = record.replayStr.charAt(iReplay+1) - 0x30;
            int x =record.replayStr.charAt(iReplay+2)- 0x30;
            int y = record.replayStr.charAt(iReplay+3)- 0x30;
            System.out.println("oldX "+oldX);
            System.out.println("oldY "+oldY);
            System.out.println("X "+x);
            System.out.println("Y "+y);
            boolean symbolColor = fieldChess.fieldFigure[oldX][oldY].figureBlack;
            char symbolFigure =  fieldChess.fieldFigure[oldX][oldY].personalSymbolFigure;
            int numberFigure =fieldChess.fieldFigure[oldX][oldY].numberF;

            fieldChess.fieldFigure[oldX][oldY].clearPositionField();
            if(symbolColor) {
                fieldChess.fieldFigure[x][y].addPositionField('b',symbolFigure,numberFigure);
                fieldChess.fieldFigure[x][y].figureWhite = false;
            }
            else {
                fieldChess.fieldFigure[x][y].addPositionField('w',symbolFigure,numberFigure);
                fieldChess.fieldFigure[x][y].figureBlack = false;


            }

            figureUpdate() ;



        }
        iReplay+=4;
        if(iReplay==record.replayStr.length()) {
            record.replayStr="";
            flagReplay = false;
        }

    }
    public void run() {
        try {
            sleepy.join();
        } catch(InterruptedException e) {
            //return;
        }
    }
}

