package Interface;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;
class MyPanel extends JPanel {
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("res/back.jpg").getImage();
        g.drawImage (image,0,0,this);
        Image image1 = new ImageIcon("res/chika.gif").getImage();
        g.drawImage (image1,50,0,this);
    }
}

class Interface implements Runnable /*extends JPanel*/  {
    String bestGame = "";
    Field fieldChess;
    Thread thread;
    Sleeper sleepyGUI;
    Scanner scan;
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
    Render render;
    Location selectedFigure;
    Location oldSelectedFigure;
    JFrame frame;
    FieldHandler handField;
    Interface gui;
    //boolean gameOver = false;
    public void go(){
        gui.render.setField(fieldChess);
    }
    Interface()
    {

        sleepyGUI = new Sleeper("SleepyGUI", 1500);
        thread = new Thread(this);
        thread.setName("gui");
        frame = new JFrame ("Chess");      //Создание нового элемента JFrame
        frame.setSize(800,800); //Начальный размер фрейма
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//завершение программы при закрытии окна пользователем
        JMenuBar jmb = new JMenuBar();//создание строки меню


        JMenu jmFile = new JMenu("File");//создание меню File,Options, Colors

        JMenuItem jmiOpen = new JMenuItem("Open");//создание пунктa ОТКРЫТЬ
        jmFile.add(jmiOpen);
        jmiOpen.addActionListener(new OpenListener());



        JMenuItem jmiSave = new JMenuItem("Save");//создание пункта СОХРАНИТЬ

        jmFile.add(jmiSave);
        jmiSave.addActionListener(new SaveListener());
        jmFile.addSeparator();//перегородка между кнопками СОХРАНИТЬ и ВЫХОД


        JMenuItem jmiSort = new JMenuItem("Sort games");
        jmFile.add(jmiSort);
        jmiSort.addActionListener(new SortListener());


        jmFile.addSeparator();//перегородка между кнопками СОХРАНИТЬ и ВЫХОД
        JMenuItem jmiExit = new JMenuItem("Exit");//создание пункта ВЫХОД
        jmFile.add(jmiExit);
        jmiExit.addActionListener(new ExitListener());
        jmb.add(jmFile);//Связывание меню File со строкой меню

        JMenu jmMode = new JMenu
                ("Mode");
        JMenuItem jmiEasy = new JMenuItem("Easy");
        JMenuItem jmiMedium = new JMenuItem("Medium");
        jmiEasy.addActionListener(new EasyListener());
        jmiMedium.addActionListener(new MediumListener());
        jmMode.add(jmiEasy);
        jmMode.add(jmiMedium);
        jmb.add(jmMode);
        JButton next = new JButton("next move");
        next.addActionListener(new ButtonListener());
        JMenu jmOptions = new JMenu ("Options");//создание пунктов меню Options
        JMenuItem jmiStatistics = new JMenuItem("Statistics" );
        jmOptions.add(jmiStatistics);//Включение пункта в состав меню Options
        jmiStatistics.addActionListener(new StatisticsListener());


        jmb.add(jmOptions);		//Связывание меню Options) со строкой меню
        JMenu jmHelp = new JMenu("Help");
        //создание пунктов меню Help
        JMenuItem jmiRules = new JMenuItem ("Rules");
        jmHelp.add(jmiRules);
        jmiRules.addActionListener(new RulesListener());//слушатель для правил
        jmHelp.addSeparator();
        JMenuItem jmiAbout = new JMenuItem ("About");
        jmHelp.add(jmiAbout);
        jmiAbout.addActionListener(new AboutListener());//слушатель на ОБ
        jmb.add(jmHelp);//Связывание меню Help со строкой меню
        frame.getContentPane().setLayout(new FlowLayout());   //Установка диспетчера компоновки FlowLayout
        frame.setJMenuBar(jmb);//Включить меню в состав фрейма

        JLabel labMove = new JLabel("Now is YOUR move!");
        labMove.setPreferredSize(new Dimension(350, 350));
        labMove.setForeground(Color.RED);
        Font font = new Font("Verdana", Font.BOLD, 25);
        labMove.setFont(font);
        //Создание таблицы
        JTable jtabField;
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
        JLabel jlabColumn = new JLabel();
        Location selectedFigure;
        selectedFigure=new Location();
        oldSelectedFigure = new Location();
        lsmRow.addListSelectionListener (new ListSelectionListener() {
                                             public void valueChanged(ListSelectionEvent le) {
                                                 String str, strX, strY;
                                                 strX="";
                                                 strY="";
                                                 str = "Selected Row and Column : ";
                                                 int row = jtabField.getSelectedRow();
                                                 int column = jtabField.getSelectedColumn();
                                                 strX += row;
                                                 strY += column;
                                                 str += row + " " + column;
                                                 selectedFigure.x = row-1;
                                                 selectedFigure.y = column-1;
                                                 if(oldSelectedFigure.x!= selectedFigure.x || oldSelectedFigure.y!= selectedFigure.y) {
                                                     handField.selectedFigure.x = selectedFigure.x;
                                                     oldSelectedFigure.x= selectedFigure.x;
                                                     handField.selectedFigure.y = selectedFigure.y;
                                                     oldSelectedFigure.y= selectedFigure.y;

                                                     //ВАЖНО!!!!!


                                                     //if(!handField.flagReplay) {
                                                     //handField.sleepy.interrupt();
                                                     handField.server.runThreadServer();
                                                     //handField.server.runThread();
                                                     handField.checkSelectedFigureX();
                                                     handField.server.stopThreadServer();
                                                     //handField.thread.interrupt();
                                                     //handField.server.stopThread();
                                                     render.setField(handField.fieldChess);
                                                     render.setGreenField(handField.GreanCircles);

                                                 }
                                                 jlabRow.setText(str);

                                             }
                                         }
        );
        TableColumnModel tcm = jtabField.getColumnModel();
        ListSelectionModel lsmCol= tcm.getSelectionModel();
        lsmCol.addListSelectionListener (new ListSelectionListener() {
                                             public void valueChanged(ListSelectionEvent le) {
                                                 String str, strY;
                                                 strY="";
                                                 str = "Selected Column : ";
                                                 int column = jtabField.getSelectedColumn();
                                                 str +=  column;
                                                 selectedFigure.y = column-1;
                                                 if(oldSelectedFigure.y!= selectedFigure.y) {
                                                     handField.selectedFigure.y = selectedFigure.y;
                                                     oldSelectedFigure.y= selectedFigure.y;
                                                     handField.yChange = true;

                                                     //handField.sleepy.interrupt();
                                                     handField.server.runThreadServer();
                                                     //handField.server.runThread();
                                                     handField.checkSelectedFigureY();
                                                     //handField.thread.interrupt();
                                                     handField.server.stopThreadServer();
                                                     //handField.server.stopThread();


                                                 }
                                                 jlabColumn.setText(str);

                                             }
                                         }
        );
		/*
		TableColumnModel tcm = jtabField.getColumnModel();
		ListSelectionModel lsmCol= tcm.getSelectionModel();
		lsmCol.addListSelectionListener (new ColumnListener(jtabField, jlabColumn));
		*/
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
        //jtabField.addMouseListener(new PlayerListener());
        jtabField.setBackground(Color.WHITE);
        fieldChess = new Field();
        //всобачить получение от обработчика поля
        StartField firstField = new StartField();
        firstField.newFigure();
        handField = new FieldHandler();
        handField.customer = thread;
        //handField.client.main();

        handField.customSl = sleepyGUI;
        firstField.firstPosition();
        render = new Render();
        render.setField(handField.fieldChess);
        for (int i = 1; i <9; i++) {
            jtabField.getColumnModel().getColumn(i).setCellRenderer(render);
        }

        JLabel jlabBack = new JLabel();
        jlabBack.setPreferredSize(new Dimension(350, 350));

        MyPanel panel = new MyPanel();
        panel.setLayout(new FlowLayout());
        panel.add(BorderLayout.WEST,labMove);
        panel.add(BorderLayout.CENTER,jtabField);
        panel.add(BorderLayout.SOUTH,next);
        panel.setPreferredSize(new Dimension(1400, frame.getHeight()));
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setSize(1400, frame.getHeight());
        frame.setLocationRelativeTo(null);
        //Отобажение фрейма
        frame.setVisible(true);

        thread.start();
    }
    public void run() {
        try {
            sleepyGUI.join();
        } catch(InterruptedException e) {
            //return;
        }
    }
    private final class ColumnListener implements ListSelectionListener {
        private final JTable jtabField;
        private final JLabel jlabColumn;

        private ColumnListener(JTable jtabField, JLabel jlabColumn) {
            this.jtabField = jtabField;
            this.jlabColumn = jlabColumn;

        }

        public void valueChanged(ListSelectionEvent le1) {
            String strY = "";
            String str2 = "Selected Columns: ";
            int column = jtabField.getSelectedColumn();
            str2 += column + " ";
            strY +=column;
            jlabColumn.setText(str2);

        }

    }
    class OpenListener implements ActionListener {//слушатель кноки ОТКРЫТЬ
        public void actionPerformed(ActionEvent event) {


            handField.record.getNameBestReplay(bestGame);
            handField.record.replay();
        }
    }
    class StatisticsListener  implements ActionListener {//слушатель кноки ОТКРЫТЬ
        public void actionPerformed(ActionEvent event) {
            StatisticsHandler stat;
            stat = new StatisticsHandler();
            stat.startStatistics();
        }
    }
    class SortListener implements ActionListener {//слушатель кноки ОТКРЫТЬ
        public void actionPerformed(ActionEvent event) {
            SortHandler sort;
             sort = new SortHandler();
             sort.startSort();
             bestGame = sort.bestGame;

        }
    }
    class SaveListener implements ActionListener {//слушатель кноки СОХРАНИТЬ
        public void actionPerformed(ActionEvent event) {
            handField.record.save();
        }
    }
    class ExitListener implements ActionListener {//слушатель кноки ВЫХОД
        public void actionPerformed(ActionEvent event) {
            System.exit(0);
        }
    }


    class EasyListener implements ActionListener {//слушатель кноки НАЗАД
        public void actionPerformed(ActionEvent event) {
            handField.easyGame = true;
            System.out.println("EASY");
        }
    }
    class MediumListener implements ActionListener {//слушатель кноки НАЗАД
        public void actionPerformed(ActionEvent event) {
            handField.easyGame = false;
            System.out.println("MEDIUM");
        }
    }

    class AboutListener implements ActionListener {//слушатель кноки ОБ
        public void actionPerformed(ActionEvent event) {}
    }
    class RulesListener implements ActionListener {//слушатель кноки ПРАВИЛА
        public void actionPerformed(ActionEvent event) {}
    }
    class ChessListener implements ActionListener {//слушатель кноки ПРАВИЛА
        public void actionPerformed(ActionEvent event) {}
    }
    class ButtonListener implements ActionListener {//слушатель кноки ПРАВИЛА
        public void actionPerformed(ActionEvent event) {
            if(handField.flagReplay) {
                handField.sleepy.interrupt();
                handField.checkSelectedFigureX();
                handField.thread.interrupt();
                render.setField(handField.fieldChess);
                render.setGreenField(handField.GreanCircles);
            }
        }
    }
    class PlayerListener implements MouseListener {
        public void mousePressed(MouseEvent event) {}
        public void mouseClicked(MouseEvent event) {
            gui.render.setField(handField.fieldChess);
            System.out.print("kafkasfjaf");}
        public void mouseExited(MouseEvent  event) {}
        public void mouseEntered(MouseEvent  event) {}
        public void mouseReleased(MouseEvent  event) {
            gui.render.setField(handField.fieldChess);
            System.out.print("kafkasfjaf");
        }
    }
}

