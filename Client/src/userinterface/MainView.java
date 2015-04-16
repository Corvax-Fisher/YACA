package userinterface;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

import javax.swing.*;

public class MainView extends JFrame implements ActionListener {

	JTabbedPane tp;
	JButton privateRoom, closeRoom;
	JPanel pnlHome, pnlNewRoom;

	public MainView() {

		setTitle("YACA-Chat");
		setSize(1200, 900);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tabbed Pane
		tp = new JTabbedPane();
		add(tp, BorderLayout.NORTH);
		
		//Panel Home
		pnlHome = new JPanel (new BorderLayout());
		privateRoom = new JButton("Privaten Raum anlegen");
		privateRoom.addActionListener(this);
		privateRoom.setVisible(false);
		
		pnlHome.add(privateRoom, "South");
		
		tp.add("Home", pnlHome);
		
	}	
	

		public void actionPerformed(ActionEvent e){
			String str = e.getActionCommand();
			if(str.equals("Privaten Raum anlegen")){
				String roomname = JOptionPane.showInputDialog(null, "Raumname:");

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
			if(str.equals("Raum schliessen")){
				tp.remove(tp.getSelectedIndex());
			}

		}
		
}



