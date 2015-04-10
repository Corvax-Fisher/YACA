package userinterface;
	import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


	public class MainView extends JFrame {
		
		private JPanel pnlChat, pnlMain, pnlRoom;
		private JMenu menuStart;
		private JMenuItem miBeenden;
		

		
		public MainView(){	
			
			super ("YACA - Yet Another Chat Application");
			
			Container cp = getContentPane();
			cp.setLayout(new GridLayout(2, 2));//Zeilen, Spalten
			
			menuBar();
			
			//Room
			JPanel pnlRoom = new JPanel();
			pnlRoom.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung
			
			JTextArea room = new JTextArea("Hello world \nHallo Welt \nHuhu \ng \nh \nEnde", 5, 30);
			//ta.setTabSize(1000);???
			room.setLineWrap(true);
			room.setWrapStyleWord(true);
			//room.add(new JScrollPane(room));
			pnlRoom.add(room);

	        
		   	//this.add("North",pnlMain);
			//this.add("South", pnlChat);
			//this.add("West", pnlRoom);
				
			setVisible(true);
			pack();
		}//UserLogIn()
		
		// Methode zur Generierung einer MenuBar
		void menuBar(){
			JMenuBar menubar = new JMenuBar();
			setJMenuBar(menubar);
			menuStart =  new JMenu("Raumverwaltung");
			menubar.add(menuStart);
			miBeenden = new JMenuItem("Raum öffnen");
			menuStart.add(miBeenden);	
			miBeenden = new JMenuItem("Raum schließen");
			menuStart.add(miBeenden);
			
			menuStart =  new JMenu("Userverwaltung");
			menubar.add(menuStart);
			miBeenden = new JMenuItem("User editieren");
			menuStart.add(miBeenden);	
			
		}//menuBar()
		
		
		
//class-MainView


	public static void main(String[] args) {
		
		MainView frame = new MainView();
		//frame.setTitle("YACA - Yet Another Chat Application");
		frame.setSize(700,700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
