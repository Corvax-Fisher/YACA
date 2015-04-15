package userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

public class MainView extends JFrame implements ActionListener {

	JTabbedPane tp;
	JList roomList, userList, chatView;
	JTextArea chatInput; 
	JPopupMenu roomPopup;
	JButton neuRoom, openRoom, closeRoom;
	JPanel pnlHome, pnlNewRoom;
	//JMenu menuStart;
	//JMenuItem miBeenden;
	
	//public ClosableTabbedPane tabbedPane;
	
    public MainView() {
    
    	JFrame frame = new JFrame("YACA - Yet Another Chat Application");
    	//frame.setLocation(100, 100);
    	frame.setSize(700, 700);
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	frame.setVisible(true);
    	
    	tp = new JTabbedPane();
    	frame.add(tp, BorderLayout.NORTH);
 			
//Home
			//list = new JList(DATA);
		    
		    pnlHome = new JPanel (new BorderLayout());
		    pnlHome.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung
		
	//Neuer Raum-Button
			neuRoom = new JButton("Raum anlegen");
			neuRoom.addActionListener(new MyAction());
			pnlHome.add(neuRoom, "South");
			//cp.add(pnlHome);
			tp.add("Home", pnlHome);
			//neuRoom.addActionListener(this);
    }	
/*     //Doppelklick auf Jlist
		MouseListener mouseListener = new MouseAdapter() {
			 public void mouseClicked(MouseEvent e) {
			    if (e.getClickCount() == 2) {
			       int index = roomList.locationToIndex(e.getPoint());
			       
			       
			       System.out.println("Double clicked on Item " + index);
			       
			       ListModel lm = roomList.getModel();
			       int[] sel = roomList.getSelectedIndices();
			       
			       for (int i = 0; i < sel.length; ++i) {
			         String value = (String)lm.getElementAt(sel[i]);
			         System.out.println("  " + value);
			       }
			         
			    }
			  }
			 };
			 roomList.addMouseListener(mouseListener);
    }*/
			 
	public void actionPerformed(ActionEvent e) {
		 String str = e.getActionCommand();
		 
		 if(str.equals("Raum schliessen")){
			  tp.remove(tp.getSelectedIndex());
			  }
		
		else if(e.getSource() == openRoom) {
			 ListModel lm = roomList.getModel();
		       int[] sel = roomList.getSelectedIndices();
		       for (int i = 0; i < sel.length; ++i)
		       {
		         String value = (String)lm.getElementAt(sel[i]);
		         System.out.println("  " + value);
		       }
		       }
}
	 public class MyAction implements ActionListener{
		  public void actionPerformed(ActionEvent e){
		  String str = e.getActionCommand();
		  if(str.equals("Raum anlegen")){
		  String st = JOptionPane.showInputDialog(null, "Geben Sie einen neuen Raumname an.");
		  
		  if(!st.equals(""))
		  {
		  JPanel pnlNeuRoom = new JPanel();	
		  pnlNeuRoom.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung
		  pnlNeuRoom.setLayout(new BorderLayout());
		  
		  JButton closeRoom =new JButton("Raum schliessen");
		  closeRoom.addActionListener(this);
		  pnlNeuRoom.add(closeRoom, "North");
			
		  tp.add(st, pnlNeuRoom);
		  //pack();
			}
		}
	}
		  
 }
		public static void main(String[] args) {
			MainView mainView = new MainView();	
		}
}



