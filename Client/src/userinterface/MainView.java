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

import userinterface.AddRemoveTab.MyAction;
import userinterface.MainView_1.ClosableTabbedPane;

public class MainView extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		MainView mainView = new MainView();	
	}

	JTabbedPane tp;
	JTabbedPane tpHome;
	JList roomList, userList, chatView;
	JTextArea chatInput; 
	JPopupMenu roomPopup;
	JButton neuRoom, openRoom, closeRoom;
	JPanel pnlHome, pnlNewRoom;
	//JMenu menuStart;
	//JMenuItem miBeenden;
	
	public ClosableTabbedPane tabbedPane;
	
    public MainView() {
    
    	JFrame frame = new JFrame("YACA - Yet Another Chat Application");
    	//frame.setLocation(100, 100);
    	frame.setSize(700, 700);
    	frame.setLocationRelativeTo(null);
    	frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	frame.setVisible(true);
    
    	/*Container cp = getContentPane();
		cp.setLayout (new BorderLayout());
		frame.add(cp);*/
    	
    	tp = new JTabbedPane();
    	frame.add(tp, BorderLayout.NORTH);
 			
//Home
			//list = new JList(DATA);
		    JPanel panel = new JPanel();
		    
		    pnlHome = new JPanel (new BorderLayout());
		    pnlHome.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung
		    pnlHome.setLayout (new GridLayout(3,1));//Zeile, Spalte
		    
		    roomList = new JList(new DefaultListModel());
			((DefaultListModel) roomList.getModel()).addElement("Raum 1");
			((DefaultListModel) roomList.getModel()).addElement("Raum 2");
			((DefaultListModel) roomList.getModel()).addElement("Raum 3");
			roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			roomList.setSelectedIndex(2);
			roomList.setFixedCellWidth(150);
			pnlHome.add(new JScrollPane(roomList), "West");

	//Neuer Raum-Button
			neuRoom = new JButton("Raum anlegen");
			neuRoom.addActionListener(new MyAction());
			pnlHome.add(neuRoom);
			//cp.add(pnlHome);
			tp.add("Home", pnlHome);
			//neuRoom.addActionListener(this);
	
	//Raum �ffnen
			openRoom = new JButton("Raum betreten");
			pnlHome.add(openRoom);
			//cp.add(pnlHome);
			openRoom.addActionListener(this);
			
			openRoom.addActionListener(new MyAction());
			
	//Tab schlie�en		
			JPanel pnlRemove = new JPanel();
			JButton remove = new JButton("Raum schlie�en");
			remove.addActionListener(new MyAction());
			pnlRemove.add(remove);
			
			tp.add("Remove Tab", pnlRemove);
			
//Beim Klick auf Button	"Raum betreten"		
			openRoom.addActionListener(new ActionListener() 
			
			{
				private Component temporaryLostComponent;

				public void actionPerformed(ActionEvent arg0) 
				{
						 ListModel lm = roomList.getModel();
					       int[] sel = roomList.getSelectedIndices();
					       for (int i = 0; i < sel.length; ++i) {
					         String value = (String)lm.getElementAt(sel[i]);
					         System.out.println("  " + value + " betreten");
					         
					       }
				}
			});
			
  /* //RoomPopup
			roomPopup = new JPopupMenu();
	        
	        //getContentPane().add(list);
			//pack();
	        //setVisible(true);
	 
	        final MouseMoveActionHandler handler = new MouseMoveActionHandler();
	        roomList.addMouseListener(new MouseAdapter() {
	            public void mousePressed(MouseEvent evt) {
	                if (SwingUtilities.isRightMouseButton(evt)) {
	                    roomPopup.setLocation(500,100);
	                    
	                    //roomPopup.add("Betreten");
	                   
	 
	                 final JMenuItem item = roomPopup.add(roomList.getSelectedValue()
	               .toString());
	 
	                    final JMenuItem item0 = roomPopup.add(roomList.getSelectedValue()
	                            .toString()
	                            + " getLetterCount");
	 
	                    item.addActionListener(handler);
	                    item.addMouseMotionListener(handler);
	                    item.setRolloverEnabled(true);
	                    handler.map.put(item, new Runnable() {
	                        public void run() {
	                            System.out.println(item.getText());
	                            roomPopup.setVisible(false);
	                            roomPopup.removeAll();
	                        }
	                    });
	 
	                    item0.addActionListener(handler);
	                    item0.addMouseMotionListener(handler);
	                    item0.setRolloverEnabled(true);
	                    handler.map.put(item0, new Runnable() {
	                        public void run() {
	                            System.out.println(item.getText().length());
	                            roomPopup.setVisible(false);
	                            roomPopup.removeAll();
	                        }
	                    });
	 
	                    roomPopup.requestFocus();
	                    roomPopup.setVisible(true);
	                }
	            }
	        });	*/
			
     //Doppelklick auf Jlist
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
			         
			         //tp.addTab(" " + value, pnlHome);
			       }
			         
			    }
			  }
			 };
			 roomList.addMouseListener(mouseListener);
    }
			 


	public void actionPerformed(ActionEvent e) {
		 if(e.getSource() == neuRoom) {
				new RoomListView();
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
		  
		  if(!st.equals("")){
		  JPanel pnlNeuRoom = new JPanel();
		  JLabel label = new JLabel("Neuer Raum ist erfolgreich angelegt!");
		  pnlNeuRoom.add(label);
			
		  pnlNeuRoom.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung
		  pnlNeuRoom.setLayout(new BorderLayout());
			//list = new JList(DATA);
		   userList = new JList(new DefaultListModel());
			((DefaultListModel) userList.getModel()).addElement("Hans");
			((DefaultListModel) userList.getModel()).addElement("Franz");
			((DefaultListModel) userList.getModel()).addElement("Hinz");
			userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			userList.setSelectedIndex(2);
			userList.setFixedCellWidth(150);
			pnlNeuRoom.add(new JScrollPane(userList), "East");
			
			JTextArea chatInput = new JTextArea(" ", 2, 50);
			//ta.setTabSize(1000);???
			chatInput.setLineWrap(true);
			chatInput.setWrapStyleWord(true);
			pnlNeuRoom.add(new JScrollPane(chatInput));
			pnlNeuRoom.add(new JScrollPane(chatInput), "North");
			
			JButton btnSenden =new JButton();
			pnlNeuRoom.add(btnSenden, "South");
			
			chatView = new JList(new DefaultListModel());
			((DefaultListModel) chatView.getModel()).addElement("ChatView");
			userList.setSelectedIndex(2);
			userList.setFixedCellWidth(150);
			pnlNeuRoom.add(new JScrollPane(chatView), "Center");
			
	        
		  tp.add(st, pnlNeuRoom);
		  //pack();
				  }
		
			  }
		  if(str.equals("Remove Tab")){
			  tp.remove(tp.getTabCount()-1);
			  }
				  }
		  
		  
				  
				  }
		}

		
/*	public void actionPerformed(ActionEvent e)
	  {
	    String cmd = e.getActionCommand();
	     if (cmd.equals("Ausgabe")) {
	       System.out.println("---");
	       ListModel lm = list.getModel();
	       int[] sel = list.getSelectedIndices();
	       for (int i = 0; i < sel.length; ++i) {
	         String value = (String)lm.getElementAt(sel[i]);
	         System.out.println("  " + value);
	       }
	     }
	   }*/
		 

/*//Popup
	class MouseMoveActionHandler extends MouseMotionAdapter implements ActionListener 
	{

		protected Map map = new HashMap();

		public void mouseMoved(MouseEvent evt) {
			Object src = evt.getSource();
			if (src instanceof JMenuItem) {
				JMenuItem item = (JMenuItem) src;
				Component[] components = roomPopup.getComponents();
				for (int i = 0; i < components.length; i++) {
					if (components[i] != item && components[i] != null) {
						components[i].setBackground(Color.WHITE);
            }
        }
        item.setBackground(Color.GRAY);
        item.updateUI();
    }
}
	

public void actionPerformed(ActionEvent e) 
{
    Object src = e.getSource();
    Runnable runnable = (Runnable) map.get(src);
    if (runnable != null) 
    {
        runnable.run();
    }
}



}*/


