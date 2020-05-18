package Interface;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.io.*;
import java.io.IOException;
import java.util.Arrays;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;
import java.util.Scanner;
import Interface.Interface.ExitListener;

import java.io.FileReader;


public class Notation {
	String nameFile = "";
	int countFileName = 1;
	String game = "";
	String replayStr = "";
	String FileWay = "C://Users//admin//Desktop//CHESSFILES//";
	File file;
	String bufString = "";
	JFrame frame;
	char[] buf;;
	Notation(){
		buf = new char[256];
	}
	public void save() {
		nameFile = "" + countFileName + ".txt";
	 // определяем объект для каталога
		String temp = FileWay;
		temp += nameFile;
    File myFile = new File(temp);
    	
    while(myFile.exists()) {
    	countFileName++;
    	nameFile = "" + countFileName + ".txt";
    	temp = FileWay;
		temp += nameFile;
		myFile = new File(temp);
		
    }
    
    File newFile = new File(temp);
    try
    {
        boolean created = newFile.createNewFile();
        if(created)
            System.out.println("File has been created");
    }
    catch(IOException ex){
        System.out.println(ex.getMessage());
    }  
    if(myFile.canWrite()) {
        System.out.println("File can be written");
        try(FileWriter writer = new FileWriter(temp, false))
        {
            writer.write(game);
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }
    else
        System.out.println("File can not be written");
    
   
	}
	public void replay(){
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
		for(int i = 0;i<17;i++) {
			names[i]="";
			way[i]="";
			openName[i]="";
		}
	

    File myFile = new File(temp);
    int count = 0;
    for(int i=0;i<17 ;i++) {
    	nameFile = "" + countFileName + ".txt";
    	temp = FileWay;
    	temp += nameFile;
    	myFile = new File(temp);
    	if(myFile.exists()){

    			names[i]= nameFile;
    			way[i]= temp;
    			openName[i] = "Press for Open!";
    			count++;
    			
    	}
		countFileName++;
    }
    
		String[] headings = {"",""};//Массив заголовков таблицы
		Object [] [] data = {//Массив содержимого таблицы
			   //0   1  2  3  4  5  6  7  8  9 
				{names[0],openName[0]},         //0
				{names[1],openName[1]},  
				{names[2],openName[2]}	,  
				{names[3],openName[3]}	,  
				{names[4],openName[4]},
				{names[5],openName[5]},         //0
				{names[6],openName[6]},  
				{names[7],openName[7]}	,  
				{names[8],openName[8]}	,
				{names[9],openName[9]},         //0
				{names[10],openName[10]},  
				{names[11],openName[11]}	,  
				{names[12],openName[12]}	,
				{names[13],openName[13]},         //0
				{names[14],openName[14]},  
				{names[15],openName[15]}	,  
				{names[16],openName[16]}	
		};
		
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ExitListener());
			frame = new JFrame ("Save");      //Создание нового элемента JFrame
			frame.setSize(500,500); //Начальный размер фрейма
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
			
			lsmRow.addListSelectionListener (new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent le) {
					int row = jtabField.getSelectedRow();

					if(row<number) {
						openReplay(names[row]);
						frame.dispose();
					}
				}			
					
				}
					);
			

			jtabField.setSize(800, 800);
			
			frame.add(BorderLayout.CENTER,jtabField);
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

	public void openReplay(String nameFile) {
		System.out.println(nameFile);
	 // определяем объект для каталога
		String temp = FileWay;
		temp += nameFile;
    File myFile = new File(temp);
    

    if(myFile.canRead()) {
        System.out.println("File can be readed");
        try(FileReader reader= new FileReader(temp))//FileReader reader = new FileReader(temp))
        {
        	Scanner scan = new Scanner(reader);
                
            int i = 1;
            
            while (scan.hasNextLine()) {

                replayStr+=scan.nextLine();
            }
     
            reader.close();
            } 
        
        catch(IOException ex){
             
            System.out.println(ex.getMessage());
        } 
    }
    else
        System.out.println("File can not be readed");
   frame.setVisible(false);
	}
	
}

