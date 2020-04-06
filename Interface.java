package Interface;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

class Interface extends JPanel implements ActionListener  {
	JLabel jlab;
 //Массив заголовков таблицы
	String[] headings = {"","","","","","","","","","" };
//Массив содердимого таблицы
	Object [] [] data = {
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
	
	
	//Graphics g;
	//Location back;
	//Location back = new Location();
	//Location forward = new Location();
	//boolean move = false;
	Interface()
	{
		Field chess_field1;
		chess_field1 = new Field();

		//chess_field.Field();
		/*int battle_count_w = 0;
		int battle_count_b = 0;
		boolean figure_w;
		boolean figure_b;
		int number_f;
		char personal_symbol_f;*/
		chess_field1.field_f [7][0].add_position_field('w', 'r', 1);
		
		chess_field1.field_f [7][7].add_position_field('w', 'r', 2);
		chess_field1.field_f[7][1].add_position_field('w', 'h', 1);
		chess_field1.field_f[7][6].add_position_field('w', 'h', 2);
		chess_field1.field_f[7][2].add_position_field('w', 'e', 1);
		chess_field1.field_f[7][5].add_position_field('w', 'e', 2);
		chess_field1.field_f[7][3].add_position_field('w', 'q', 1);
		chess_field1.field_f[7][4].add_position_field('w', 'k', 1);
		
		for(int i=0;i<8;i++)
		{
			chess_field1.field_f[1][i].add_position_field('b', 'p', i+1);
			chess_field1.field_f[6][i].add_position_field('w', 'p', i+1);
		}
		chess_field1.field_f[0][0].add_position_field('b', 'r', 1);
		chess_field1.field_f[0][7].add_position_field('b', 'r', 2);
		chess_field1.field_f[0][1].add_position_field('b', 'h', 1);
		chess_field1.field_f[0][6].add_position_field('b', 'h', 2);
		chess_field1.field_f[0][2].add_position_field('b', 'e', 1);
		chess_field1.field_f[0][5].add_position_field('b', 'e', 2);
		chess_field1.field_f[0][3].add_position_field('b', 'q', 1);
		chess_field1.field_f[0][4].add_position_field('b', 'k', 1);
		//chess_field = chess_field1;
		
		
		JFrame jfrm = new JFrame ("Chess"); //Создание нового котейнера JFrame
		jfrm.getContentPane().setLayout(new FlowLayout());//Установка диспетчера компоновки FlowLayout
		jfrm.setSize(800,800); //Начальный размер фрейма
		//завершение программы при закрытии окна пользователем
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//создание метки для отображения информации,выведенной пользователем
		jlab = new JLabel();
		
		//создание строки меню
		JMenuBar jmb = new JMenuBar();
		
		//создание меню File,Options, Colors
		JMenu jmFile = new JMenu("File");
		//создание пунктов меню File
				JMenuItem jmiOpen = new JMenuItem("Open");
				JMenuItem jmiSave = new JMenuItem("Save");
				JMenuItem jmiExit = new JMenuItem("Exit");
				//Включение пунктов в состав меню File
				jmFile.add(jmiOpen);
				jmFile.add(jmiSave);
				jmFile.addSeparator();
				jmFile.add(jmiExit);
				jmiOpen.addActionListener(this);
				jmiSave.addActionListener(this);
				jmiExit.addActionListener(this);
				//Связывание меню File со строкой меню
				jmb.add(jmFile);
		
		
		
		JMenu jmOptions = new JMenu ("Options");
		//создание пунктов меню Options
		JMenuItem jmiBack = new JMenuItem("Back" );
				JMenuItem jmiReset = new JMenuItem("Reset" );
				//Включение пунктов в состав меню Options
				jmOptions.add(jmiBack);
				jmOptions.addSeparator();
				jmOptions.add(jmiReset);
				
				jmiBack.addActionListener(this);
				jmiReset.addActionListener(this);
				//Связывание меню Options) со строкой меню
				jmb.add(jmOptions);
		JMenu jmHelp = new JMenu("Help");
		//создание пунктов меню Help
		JMenuItem jmiRules = new JMenuItem ("Rules");
		JMenuItem jmiAbout = new JMenuItem ("About");

		//Включение пунктов в состав меню Help
		jmHelp.add(jmiRules);
		jmHelp.addSeparator();
		jmHelp.add(jmiAbout);
		
		jmiAbout.addActionListener(this);
		jmiRules.addActionListener(this);
		//Связывание меню Help со строкой меню
		jmb.add(jmHelp);
		//Включить метки на панель содержимого
		jfrm.getContentPane().add(jlab);
		//Включить меню в состав фрейма
		jfrm.setJMenuBar(jmb);
		 
		
		
		
		//Создание таблицы
		/*DefaultTableModel model = new DefaultTableModel(data, headings)
        {
            //  Returning the Class of each column will allow different
            //  renderers to be used based on Class
            public Class getColumnClass(int column)
            {
                return getValueAt(0, column).getClass();
            }
        };*/
       // JTable jtabField  = new JTable( model );
		JTable jtabField;
		jtabField = new JTable(data, headings);
		JScrollPane jscrlp = new JScrollPane(jtabField);
		jtabField.setPreferredScrollableViewportSize(new Dimension(450, 80));
		ListSelectionModel lsmRow = jtabField.getSelectionModel();
		JLabel jlab1;
		jlab1 = new JLabel();
		jtabField.setRowSelectionAllowed(true);
		jtabField.setColumnSelectionAllowed(false);
		lsmRow.addListSelectionListener (new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				String str = "Selected Rows: ";
				int[] rows = jtabField.getSelectedRows();
				int[] columns = jtabField.getSelectedColumns();
				//int row = jtabField.getSelectedRows();
				//int column = jtabField.getSelectedColumns();
				for(int i=0; i <rows.length; i++) str += rows[i] + " ";
				jlab.setText(str);
				/*if(!move)
				{
				back.add_location(rows[0], columns[0]);
				move = true;
				}
				else
				{
				forward.add_location(rows[0], columns[0]);
				move = false;
				}*/
			}
		}
				);
		jtabField.setRowSelectionAllowed(false);
		jtabField.setColumnSelectionAllowed(true);
		TableColumnModel tcm = jtabField.getColumnModel();
		
		ListSelectionModel lsmCol= tcm.getSelectionModel();
		lsmCol.addListSelectionListener (new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le1) {
				String str2 = "Selected Columns: ";
				int[] rows = jtabField.getSelectedRows();
				int[] columns = jtabField.getSelectedColumns();
				for(int i=0; i <columns.length; i++) str2 += columns[i] + " ";
				jlab1.setText(str2);
				/*if(!move)
				{
				back.add_location(rows[0], columns[0]);
				move = true;
				}
				else
				{
				forward.add_location(rows[0], columns[0]);
				move = false;
				}*/
			}
		}
				);

        
        
        
		JLabel jlab2 = new JLabel();
		TableModel tm;
		//Обработка изменения модели таблицы
		tm = jtabField.getModel();
		tm.addTableModelListener(new TableModelListener() {
			public void tableChanged(TableModelEvent tme) {
				if(tme.getType() == TableModelEvent.UPDATE) {
					//отображние координат ячейки и нового значения
					jlab2.setText("Cell " + tme.getFirstRow() + ", " + tme.getColumn() + " changed."
							+ " The new value: " + tm.getValueAt(tme.getFirstRow(), tme.getColumn()));
					
				}
			}
		});
		TableColumnModel tmc = jtabField.getColumnModel();
		
		//jtabField.setMaximumSize(new Dimension(800, 800));
		
		//JScrollPane jscrlp1 = new JScrollPane(jfrm);
		//jtabField.setPreferredScrollableViewportSize(new Dimension(800, 800));
		//jfrm.getContentPane().add(jscrlp1);
		jtabField.setSize(800, 800);
		//jtabField.setMaximumSize(new Dimension(800, 800));
		//jtabField.setMinimumSize(new Dimension(800, 800));
		
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
		Render render = new Render();
		/*if(move)
		{
			for (int i = 1; i <9; i++) {
				jtabField.getColumnModel().getColumn(i).setCellRenderer(render);
			}
			getTableCellRendererComponentMOVE(JTable table,
			        Object value,
			        boolean isSelected,
			        boolean hasFocus,
			        int row,
			        int column, Location back, Location forward, char color, char figure)
			 render.getTableCellRendererComponentMOVE()
		}
		*/
		//render.get_field(chess_field1);
		for (int i = 1; i <9; i++) {
			jtabField.getColumnModel().getColumn(i).setCellRenderer(render);
		}
		jtabField.setPreferredScrollableViewportSize(new Dimension(800,800));
		jtabField.setRowSelectionAllowed(false);
		jtabField.setColumnSelectionAllowed(false);
		
		
		

		
		
		jfrm.getContentPane().add(jlab);
		jfrm.getContentPane().add(jlab1);
		jfrm.getContentPane().add(jlab2);
		jfrm.getContentPane().add(jscrlp);
        jfrm.pack();
        jfrm.setSize(1000, 1000);
        jfrm.setLocationRelativeTo(null);
        //Отобажение фрейма
		jfrm.setVisible(true);
	}
	public void gameRender()
	{
		//back.draw(g);
	}
	//Обработка событий действий для пункта меню
	public void actionPerformed(ActionEvent ae) {
		//Получение команды действия соответствующей выбранному пункту
			String comStr = ae.getActionCommand();
			if(comStr.equals("Exit")) System.exit(0);
			//jlab.setText(comStr + " Selected");
			gameRender();
	}
		
	public static void main(String args[]) {
		
		//Фрейм оздается в потоке обработки событий
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface();
			}
		});
	}
	
}

