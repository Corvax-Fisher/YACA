package userinterface;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class MainView extends JFrame implements ActionListener {

	JTabbedPane tp;
	JButton newRoom, closeRoom;
	JPanel pnlHome, pnlNewRoom;

	public MainView() {

		JFrame frame = new JFrame("YACA - Yet Another Chat Application");
		frame.setSize(1200, 900);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		//Tabbed Pane
		tp = new JTabbedPane();
		frame.add(tp, BorderLayout.NORTH);
		
		//Panel Home
		pnlHome = new JPanel (new BorderLayout());
		pnlHome.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung

		newRoom = new JButton("Raum anlegen");
		newRoom.addActionListener(this);
		
		pnlHome.add(newRoom, "South");
		
		tp.add("Home", pnlHome);
	}	
	

		public void actionPerformed(ActionEvent e){
			String str = e.getActionCommand();
			if(str.equals("Raum anlegen")){
				String roomname = JOptionPane.showInputDialog(null, "Raumname:");

				if(!roomname.equals(""))
				{
					JPanel pnlnewRoom = new JPanel();	
					pnlnewRoom.setBorder(BorderFactory.createLineBorder(Color.blue));
					pnlnewRoom.setLayout(new BorderLayout());

					JButton closeButton =new JButton("Raum schliessen");
					closeButton.addActionListener(this);
					
					pnlnewRoom.add(closeButton, "North");

					tp.add(roomname, pnlnewRoom);
				}
			}
			else if(str.equals("Raum schliessen")){
				tp.remove(tp.getSelectedIndex());
			}

		}

	
	public static void main(String[] args) {
		MainView mainView = new MainView();	
	}
}



