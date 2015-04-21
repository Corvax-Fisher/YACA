package userinterface;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class MainView extends JFrame implements ActionListener {

	JTabbedPane tp;
	JButton privateRoom, closeRoom;
	JPanel pnlHome, pnlNewRoom;
	private FrontController frontController;

	public MainView(FrontController frontController) {
		this.frontController = frontController;
		setTitle("YACA-Chat");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tabbed Pane
		tp = new JTabbedPane();
		add(tp, BorderLayout.NORTH);
		
		//Panel Home
		pnlHome = new JPanel (new BorderLayout());
				
		tp.add("Home", pnlHome);
		
	}	
	
//
		public void actionPerformed(ActionEvent e){
			String str = e.getActionCommand();

			if(str.equals("Raum schliessen")){
				tp.remove(tp.getSelectedIndex());
			}

		}
		
}



