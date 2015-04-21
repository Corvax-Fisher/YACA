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
<<<<<<< HEAD
				
=======
		privateRoom = new JButton("Privaten Raum anlegen");
		privateRoom.addActionListener(this);
		privateRoom.setVisible(false);
		
		pnlHome.add(privateRoom, BorderLayout.SOUTH);
		
>>>>>>> 6266543c91131e1579ce4810152070117ed98f98
		tp.add("Home", pnlHome);
		
	}	
	
//
		public void actionPerformed(ActionEvent e){
			String str = e.getActionCommand();

<<<<<<< HEAD
			if(str.equals("Raum schliessen")){
=======
				if(!roomname.equals(""))
				{
					JPanel pnlnewRoom = new JPanel();	
					pnlnewRoom.setLayout(new BorderLayout());

					JButton closeButton =new JButton("Raum schliessen");
					closeButton.addActionListener(this);
					
					pnlnewRoom.add(closeButton, "North");

					tp.add(roomname, pnlnewRoom);
				}
			}
			else if(str.equals("Raum schliessen")){
>>>>>>> 6266543c91131e1579ce4810152070117ed98f98
				tp.remove(tp.getSelectedIndex());
			}

		}
		
}



