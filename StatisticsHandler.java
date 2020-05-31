package Interface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
class MyNewPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("res/back.jpg").getImage();
        g.drawImage (image,0,0,this);
    }
}
public class StatisticsHandler {

    String nameFile = "";
    int countFileName = 1;


    String FileWay = "C://Users//admin//Desktop//CHESSFILES//";

    FileFormat[] filesForSort;
    JTable jtabField;
    JButton next;
    JLabel labMove;
    StartField fieldChess;
    Location newPosition;

    Location oldPosition;
    Location redCell;
    String[] headings = {"","","","","","","","","","" };//Массив заголовков таблицы
    Object [] [] data = {//Массив содержимого таблицы
            //0   1  2  3  4  5  6  7  8  9
            {"","            A","            B","            C","            D","            E","            F","            G","            H",""}	,         //0
            {"           1","","","","","","","","","           1"}	,         //1
            {"           2","","","","","","","","","           2"}	,         //2
            {"           3","","","","","","","","","           3"}	,         //3
            {"           4","","","","","","","","","           4"}	,         //4
            {"           5","","","","","","","","","           5"}	,         //5
            {"           6","","","","","","","","","           6"}	,         //6
            {"           7","","","","","","","","","           7"}	,         //7
            {"           8","","","","","","","","","           8"}	,         //8
            {"","            A","            B","            C","            D","            E","            F","            G","            H",""}	          //9

    };
    RenderStat render;
    JFrame frame;
    String mostVisitedField = "";
    StatisticsHandler (){
        oldPosition = new Location();
        fieldChess = new StartField();
        redCell = new Location();
        newPosition = new Location();
        filesForSort = new FileFormat[17];
        for(int i=0;i<17;i++)
        filesForSort[i] = new FileFormat();
    }
    public void startStatistics(){
        frame = new JFrame ("Sorting games by the number of moves");      //Создание нового элемента JFrame
        frame.setSize(1400,1400); //Начальный размер фрейма
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//завершение программы при закрытии окна пользователем
        labMove = new JLabel("The most   visited field is RED!");
        labMove.setPreferredSize(new Dimension(500, 500));
        labMove.setForeground(Color.RED);
        Font font = new Font("Verdana", Font.BOLD, 25);
        labMove.setFont(font);
        //Создание таблицы
        int redCellX=0, reCellY=0;
        int oldX=0, oldY=0;
        int newX=0, newY=0;
        int maxSize = 0;
        int count = 0;
        String temp = FileWay;
        temp += nameFile;
        File myFile = new File(temp);
        for(int i=0;i<17 ;i++) {
            nameFile = "" + countFileName + ".txt";
            temp = FileWay;
            temp += nameFile;
            myFile = new File(temp);

            if(myFile.exists()){

                filesForSort[i].name = nameFile;
                filesForSort[i].readLengthFile();
                count++;

            }
            countFileName++;
        }
        String finalStr = "";
        for(int i = 0;i<17;i++){
            if(filesForSort[i].length == 0)break;
            maxSize += filesForSort[i].length;
            finalStr += filesForSort[i].fileSTR;
        }
        int massPos[];
        massPos = new int [4];
        mostMovement.checkMostFrequentMovement(finalStr,massPos);
        int massRedCell[];
        massRedCell = new int[4];
        MostVisitedField.checkMostVisitedField(finalStr, massRedCell);
        System.out.println("OLDX " + massPos[0]);
        System.out.println("OLDY " + massPos[1]);
        System.out.println("NEWX " + massPos[2]);
        System.out.println("NEWX " + massPos[3]);
        System.out.println("CELLREDX " + massRedCell[0]);
        System.out.println("CELLREDX " + massRedCell[1]);
        oldPosition.x = massPos[0];
        oldPosition.y = massPos[1];
        newPosition.x = massPos[2];
        newPosition.y = massPos[3];
        redCell.x = massRedCell[0];
        redCell.y = massRedCell[1];
        jtabField = new JTable(data, headings) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ListSelectionModel lsmRow = jtabField.getSelectionModel();
        ListSelectionModel lsmColumn = jtabField.getSelectionModel();
        JLabel jlabRow = new JLabel();
        jlabRow.setPreferredSize(new Dimension(200, 200));
        jtabField.setRowSelectionAllowed(true);
        jtabField.setColumnSelectionAllowed(true);
        jtabField.setSize(800, 800);
        jtabField.setRowHeight(0, 10);
        jtabField.setRowHeight(9, 10);
        jtabField.setRowHeight(1, 80);
        jtabField.setRowHeight(2, 80);
        jtabField.setRowHeight(3, 80);
        jtabField.setRowHeight(4, 80);
        jtabField.setRowHeight(5, 80);
        jtabField.setRowHeight(6, 80);
        jtabField.setRowHeight(7, 80);
        jtabField.setRowHeight(8, 80);
        jtabField.setBackground(Color.WHITE);
        //всобачить получение от обработчика поля
        fieldChess.firstPosition();
        render = new RenderStat();
        render.setRedCell(redCell);
        render.setField(fieldChess.fieldChess);
        for (int i = 1; i <9; i++) {
            jtabField.getColumnModel().getColumn(i).setCellRenderer(render);
        }
        JButton exit;
        exit = new JButton("EXIT");
        exit.addActionListener(new ExitListener());
        JLabel jlabBack = new JLabel();
        jlabBack.setPreferredSize(new Dimension(350, 350));

        next = new JButton( "Most frequently\n committed movement");
        next.addActionListener(new MoveListener());
        MyNewPanel panel;
        panel = new MyNewPanel();
        panel.setLayout(new FlowLayout());
        panel.add(BorderLayout.WEST,labMove);
        panel.add(BorderLayout.EAST,exit);
        panel.add(BorderLayout.CENTER,jtabField);
        panel.add(BorderLayout.SOUTH,next);
        panel.setPreferredSize(new Dimension(1400, frame.getHeight()));
        frame.getContentPane().add(panel);
        frame.setLocationRelativeTo(null);
        //Отобажение фрейма
        frame.setVisible(true);
    }
    class MoveListener  implements ActionListener {//слушатель кноки ВЫХОД
        public void actionPerformed(ActionEvent event) {

            fieldChess.setNewPosition(newPosition,oldPosition);
            fieldChess.newPositionInField();
            render.setField(fieldChess.fieldChess);
            for (int i = 1; i <9; i++) {
                jtabField.getColumnModel().getColumn(i).setCellRenderer(render);
            }
            frame.repaint();

        }
    }
    class ExitListener implements ActionListener {//слушатель кноки ВЫХОД
        public void actionPerformed(ActionEvent event) {
            frame.dispose();
        }
    }
    public void startSortNotation(){
        nameFile = "" + countFileName + ".txt";
        // определяем объект для каталога
        String temp = FileWay;
        temp += nameFile;
        String[] names;
        String[] way;
        names = new String[17];
        way = new String[17];

        filesForSort = new FileFormat[17];
        for(int i = 0;i<17;i++) {
            names[i]="";
            way[i]="";

            filesForSort[i] = new FileFormat();
        }
        File myFile = new File(temp);
        int count = 0;
        for(int i=0;i<17 ;i++) {
            nameFile = "" + countFileName + ".txt";
            temp = FileWay;
            temp += nameFile;
            myFile = new File(temp);
            if(myFile.exists()){

                filesForSort[i].name = nameFile;
                filesForSort[i].readLengthFile();
                count++;

            }
            countFileName++;
        }
        if(count!=17) {
            for (int i = count; i < 17; i++) {
                filesForSort[i].name = "";
                filesForSort[i].length = 0;
                filesForSort[i].fileSTR = "";
            }
        }
    }
}
