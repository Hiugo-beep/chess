package Interface;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SortHandler {

    String nameFile = "";
    int countFileName = 1;


    String FileWay = "C://Users//admin//Desktop//CHESSFILES//";

    JFrame frame;
    char[] buf;;
    FileFormat[] filesForSort;
    String bestGame = "";


    SortHandler (){
        buf = new char[256];

    }



    public void startSort(){
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
            }
        }
        int massForSort[];
        massForSort = new int [17];

        for(int i=0;i<17;i++){
            massForSort[i] = filesForSort[i].length;
        }
        int low = 0;
        int high = 16;
        //отправить массив на сортировку
        quickSort.sorting(massForSort, low, high);
        //выбрать номер лучшего
        //выбрать номер худшего
        for(int i=0;i<17;i++){
            if(massForSort[i] != 0) {
                for (int j = 0; j < 17; j++) {

                    if (massForSort[i] == filesForSort[j].length) {
                        if( i == 0){
                            bestGame =  filesForSort[j].name;
                        }
                        temp = FileWay;
                        temp += filesForSort[j].name;
                        names[i]= filesForSort[j].name;
                        way[i]= temp;
                        filesForSort[j].length = 0;

                    }
                }
            }
        }

        String[] headings = {""};//Массив заголовков таблицы


        Object [] [] data = {//Массив содержимого таблицы
                //0   1  2  3  4  5  6  7  8  9
                {names[0]},         //0
                {names[1]},
                {names[2]}	,
                {names[3]}	,
                {names[4]},
                {names[5]},         //0
                {names[6]},
                {names[7]},
                {names[8]},
                {names[9]},         //0
                {names[10]},
                {names[11]},
                {names[12]},
                {names[13]},        //0
                {names[14]},
                {names[15]},
                {names[16]}
        };



        JButton exit = new JButton("Exit");
        exit.addActionListener(new ExitListener());
        frame = new JFrame ("Sorting games by the number of moves");      //Создание нового элемента JFrame
        frame.setSize(200,500); //Начальный размер фрейма
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);//завершение программы при закрытии окна пользователем
        //Создание табицы
        JTable jtabField;
        jtabField = new JTable(data, headings) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        ListSelectionModel lsmRow = jtabField.getSelectionModel();
        jtabField.setRowSelectionAllowed(true);
        jtabField.setColumnSelectionAllowed(true);
        int number = count;


        jtabField.setSize(800, 800);

        frame.add(BorderLayout.NORTH,jtabField);

        frame.add(BorderLayout.SOUTH,exit);
        frame.setLocationRelativeTo(null);
        //Отобажение фрейма
        frame.setVisible(true);
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
        String[] openName;
        names = new String[17];
        way = new String[17];
        openName = new String[17];
        filesForSort = new FileFormat[17];
        for(int i = 0;i<17;i++) {
            names[i]="";
            way[i]="";
            openName[i]="";
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
            }
        }
        int massForSort[];
        massForSort = new int [17];

        for(int i=0;i<17;i++){
            massForSort[i] = filesForSort[i].length;
        }
        int low = 0;
        int high = 16;
        //отправить массив на сортировку
        quickSort.sorting(massForSort, low, high);

        for(int i=0;i<17;i++){
            if(massForSort[i] != 0) {
                for (int j = 0; j < 17; j++) {

                    if (massForSort[i] == filesForSort[j].length) {
                        if( i == 0){
                            bestGame =  filesForSort[j].name;
                        }
                        temp = FileWay;
                        temp += filesForSort[j].name;
                        names[i]= filesForSort[j].name;
                        way[i]= temp;
                        openName[i] = "Press for Open!";
                        filesForSort[j].length = 0;

                    }
                }
            }
        }



    }

}

class FileFormat {
    String FileWay = "C://Users//admin//Desktop//CHESSFILES//";
    int length;
    String name;
    String fileSTR;
    FileFormat() {
        name = new String();
        fileSTR = new String();
    }
    void readLengthFile(){
        String temp = FileWay;
        temp += name;
        File myFile = new File(temp);



        if(myFile.canRead()) {
            System.out.println("File can be readed");
            try(FileReader reader= new FileReader(temp))//FileReader reader = new FileReader(temp))
            {
                Scanner scan = new Scanner(reader);

                int i = 1;

                while (scan.hasNextLine()) {

                    fileSTR+=scan.nextLine();
                }

                reader.close();
            }

            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
        else
            System.out.println("File can not be readed");

        if( fileSTR!="") {


            String buf[];
            buf = new String[1];
            TranslateNotation.TranslateNotationFrom(fileSTR, buf);
            fileSTR = buf[0];
            length = fileSTR.length();
        }
    }
}




