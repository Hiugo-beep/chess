import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import javax.imageio.ImageIO;

import java.io.File;
import java.io.IOException;

class Interface implements ActionListener {

	JLabel jlab;

	Graphics g;
	
	Interface()
	{
		
		JFrame jfrm = new JFrame ("Chess");
		jfrm.getContentPane().setLayout(new FlowLayout());
		jfrm.setSize(800,800);
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		jlab = new JLabel();
		JMenuBar jmb = new JMenuBar();
		
		JMenu jmFile = new JMenu("File");
		JMenuItem jmiOpen = new JMenuItem("Open");
		JMenuItem jmiClose = new JMenuItem("Close");
		JMenuItem jmiSave = new JMenuItem("Save");
		JMenuItem jmiExit = new JMenuItem("Exit");
		jmFile.add(jmiOpen);
		jmFile.add(jmiClose);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		
		JMenu jmOptions = new JMenu ("Options");
		JMenu jmColors = new JMenu ("Colors");
		JMenuItem jmiWhite= new JMenuItem("White figures");
		JMenuItem jmiBlack = new JMenuItem("Black figures");
		jmColors.add(jmiWhite);
		jmColors.add(jmiBlack);
		jmOptions.add(jmColors);
		
		
		JMenuItem jmiReset = new JMenuItem("Reset" );
		jmOptions.addSeparator();
		jmOptions.add(jmiReset);
		jmb.add(jmOptions);
		
		
		JMenu jmHelp = new JMenu("Help");
		JMenuItem jmiAbout = new JMenuItem ("About");
		jmHelp.add(jmiAbout);
		jmb.add(jmHelp);
		
		jmiOpen.addActionListener(this);
		jmiClose.addActionListener(this);
		jmiSave.addActionListener(this);
		jmiExit.addActionListener(this);
		jmiWhite.addActionListener(this);
		jmiBlack.addActionListener(this);

		jmiReset.addActionListener(this);
		jmiAbout.addActionListener(this);
		
		jfrm.getContentPane().add(jlab);
		jfrm.setJMenuBar(jmb);
		
		//drawIcon(g);
		PanelPictureFrame pp = new PanelPictureFrame();
        pp.setLayout(new BorderLayout());
        try {
        	pp.setImage(ImageIO.read(new File("res/board.png")));
        } catch (IOException e) {
            e.printStackTrace();
        } 
        pp.setPreferredSize(new Dimension(504, 504));
        //jfrm.add(new JScrollPane(pp));
        jfrm.add(pp);
        JPanel jpl = new JPanel();
       ///////////////////////////////////////////////////
        PanelPictureFrame rookblack = new PanelPictureFrame();
        rookblack.setLayout(new BorderLayout());
        try {
        	rookblack.setImage(ImageIO.read(new File("res/rookBlack.png")));
        } catch (IOException e) {
            e.printStackTrace();
        } 
        rookblack.setPreferredSize(new Dimension(100, 100));
       // Graphics g;
        //jfrm.add(new JScrollPane(rookblack));
       //rookblack.paintComponent(g,10,10);
        //jpl.add(rookblack,10,10);
        jfrm.add(jpl);
        jfrm.pack();
        jfrm.setSize(600, 600);
        jfrm.setLocationRelativeTo(null);
		jfrm.setVisible(true);
	}
	public void gameRender()
	{
		//back.draw(g);
	}
	
	public void actionPerformed(ActionEvent ae) {
			String comStr = ae.getActionCommand();
			if(comStr.equals("Exit")) System.exit(0);
			//jlab.setText(comStr + " Selected");
			gameRender();
	}
		
	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Interface();
			}
		});
	}
	
}
