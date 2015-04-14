package userinterface;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class MainView extends JFrame implements ActionListener
{
	public ClosableTabbedPane tabbedPane;
	private JPanel pnlChat, pnlUser, pnlRoom, pnlHome;
	private JMenu menuStart;
	private JMenuItem miBeenden;
	private JList list;
	private JButton neuRoom, openRoom;
	private JTabbedPane tpHome;

	public MainView () 
	{
		super ("YACA - Yet Another Chat Application");
		addMenu();
		addTabbedPane();
		
		
	  /*  setSize(700, 700);
		setVisible(true);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		*/
		add(tabbedPane, BorderLayout.NORTH);
		
		
		
//HOME
		
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
//Room
		JPanel pnlRoom = new JPanel();
		pnlRoom.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung
		pnlRoom.setLayout(new BorderLayout());
		
		//list = new JList(DATA);
		list = new JList(new DefaultListModel());
		((DefaultListModel) list.getModel()).addElement("Raum 1");
		((DefaultListModel) list.getModel()).addElement("Raum 2");
		((DefaultListModel) list.getModel()).addElement("Raum 3");
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setSelectedIndex(2);
		list.setFixedCellWidth(150);
		pnlRoom.add(new JScrollPane(list), "Center");
		//Neuer Raum-Button
		neuRoom = new JButton("Raum anlegen");
		pnlRoom.add(neuRoom, "South");
		cp.add(pnlRoom);
		
		//openRoom = new JButton("Raum betreten");
		//pnlRoom.add(openRoom, "South");
		//cp.add(pnlRoom);
		 // bei einem Knopfdruck die actionPerformed Methode aufrufen
		neuRoom.addActionListener(this);
		
//User
		JPanel pnlUser = new JPanel();
		
		pnlUser.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung
		pnlUser.setLayout(new BorderLayout());
		//list = new JList(DATA);
		list = new JList(new DefaultListModel());
		((DefaultListModel) list.getModel()).addElement("Hans");
		((DefaultListModel) list.getModel()).addElement("Franz");
		((DefaultListModel) list.getModel()).addElement("Hinz");
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setSelectedIndex(2);
		list.setFixedCellWidth(150);
		pnlUser.add(new JScrollPane(list), "Center");
		
		JPanel pnlChatWindow = new JPanel();
		
		pnlChatWindow.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung
		pnlChatWindow.setLayout(new BorderLayout());
		//list = new JList(DATA);
		list = new JList(new DefaultListModel());
		((DefaultListModel) list.getModel()).addElement("   ");
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		list.setSelectedIndex(2);
		list.setVisibleRowCount(500);
		list.setFixedCellWidth(150);
		pnlChatWindow.add(new JScrollPane(list), "Center");
		
//ChatWindow
		JPanel pnlChat = new JPanel();
		pnlChat.setLayout(new FlowLayout());
		//pnlUser.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung	
		
		JTextArea chat = new JTextArea(" ", 2, 50);
		//ta.setTabSize(1000);???
		chat.setLineWrap(true);
		chat.setWrapStyleWord(true);
		pnlChat.add(new JScrollPane(chat));
		pnlChat.add(new JButton("Senden"));
		add(pnlChat);
		
		//Schrift
		JPanel pnlSchrift = new JPanel();
		//pnlSchrift.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung	
		//pnlSchrift.setVisible(false);
		//pnlSchrift.add(new JLabel("offene Räume                                                                                                                                                   angemeldete Anwender"));
		//ta.setTabSize(1000);???
		add(pnlSchrift);
		
	   	this.add("North",  pnlSchrift);
		this.add("South",  pnlChat);
		this.add("West",   pnlRoom);
		this.add("East",   pnlUser);
		this.add("Center", pnlChatWindow);
		
		/*GridLayout pnlHome = new GridLayout(3,3);
		
		{
			pnlHome += new pnlRoom(1,1);
		}*/
			
		setVisible(true);
		//pack();
	}
	
	public void actionPerformed(ActionEvent event){
		 if(event.getSource() == neuRoom) {
		new NeuRoomView();
		 }
		  
		/* else if(event.getSource() == buttonServus) {
		 System.out.println("Servus");
		 }
		  
		 }// TODO Auto-generated method stub
*/		
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

	private void addMenu() 
	{
		JMenuBar menuBar = new JMenuBar();
		
		JMenu menu = new JMenu("Chat");
		JMenuItem menuItem = new JMenuItem("Einstellungen");
		//tabbedPane.addTab("Home ", new JPanel());
		
		menuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				tabbedPane.addTab("TAB " + (tabbedPane.getTabCount() + 1),
						new JPanel());
			}
		});
		menu.add(menuItem);
		menuBar.add(menu);
		setJMenuBar(menuBar);
	}

	private void addTabbedPane() 
	{
		
		tabbedPane = new ClosableTabbedPane();
		getContentPane().add(tabbedPane);
	}
	
	public class ClosableTabbedPane extends JTabbedPane
	{
		private TabCloseUI closeUI = new TabCloseUI(this);
		
		public void paint(Graphics g)
		{
			super.paint(g);
			closeUI.paint(g);
		}
		
		public void addTab(String title, Component component) 
		{
			super.addTab(title+"  ", component);
		}
		
		
		public String getTabTitleAt(int index) 
		{
			return super.getTitleAt(index).trim();
		}
	}
		
	
	private class TabCloseUI implements MouseListener, MouseMotionListener 
	{
		private ClosableTabbedPane  tabbedPane;
		private int closeX = 0 ,closeY = 0, meX = 0, meY = 0;
		private int selectedTab;
		private final int  width = 8, height = 8;
		private Rectangle rectangle = new Rectangle(0,0,width, height);
		
		public TabCloseUI(ClosableTabbedPane pane) 
		{
			tabbedPane = pane;
			tabbedPane.addMouseMotionListener(this);
			tabbedPane.addMouseListener(this);
		}
			public void mouseEntered(MouseEvent me) {}
			public void mouseExited(MouseEvent me)  {}
			public void mousePressed(MouseEvent me) {}
			public void mouseClicked(MouseEvent me) {}
			public void mouseDragged(MouseEvent me) {}	

			public void mouseReleased(MouseEvent me) 
			{
				if(closeUnderMouse(me.getX(), me.getY())){
					boolean isToCloseTab = tabAboutToClose(selectedTab);
					if (isToCloseTab && selectedTab > -1){			
						tabbedPane.removeTabAt(selectedTab);
					}
					selectedTab = tabbedPane.getSelectedIndex();
				}
			}

			public void mouseMoved(MouseEvent me) 
			{	
				meX = me.getX();
				meY = me.getY();			
				if(mouseOverTab(meX, meY)){
					controlCursor();
					tabbedPane.repaint();
				}
			}

			private void controlCursor() 
			{
				if(tabbedPane.getTabCount()>0)
					if(closeUnderMouse(meX, meY)){
						tabbedPane.setCursor(new Cursor(Cursor.HAND_CURSOR));	
						if(selectedTab > -1)
							tabbedPane.setToolTipTextAt(selectedTab, "Close " +tabbedPane.getTitleAt(selectedTab));
					}
					else{
						tabbedPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						if(selectedTab > -1)
							tabbedPane.setToolTipTextAt(selectedTab,"");
					}	
			}

			private boolean closeUnderMouse(int x, int y) 
			{		
				rectangle.x = closeX;
				rectangle.y = closeY;
				return rectangle.contains(x,y);
			}

			public void paint(Graphics g) 
			{
				
				int tabCount = tabbedPane.getTabCount();
				for(int j = 0; j < tabCount; j++)
					if(tabbedPane.getComponent(j).isShowing()){			
						int x = tabbedPane.getBoundsAt(j).x + tabbedPane.getBoundsAt(j).width -width-5;
						int y = tabbedPane.getBoundsAt(j).y +5;	
						drawClose(g,x,y);
						break;
					}
				if(mouseOverTab(meX, meY)){
					drawClose(g,closeX,closeY);
				}
			}

			private void drawClose(Graphics g, int x, int y) 
			{
				if(tabbedPane != null && tabbedPane.getTabCount() > 0)
				{
					Graphics2D g2 = (Graphics2D)g;				
					drawColored(g2, isUnderMouse(x,y)? Color.RED : Color.WHITE, x, y);
				}
			}

			private void drawColored(Graphics2D g2, Color color, int x, int y) 
			{
				g2.setStroke(new BasicStroke(5,BasicStroke.JOIN_ROUND,BasicStroke.CAP_ROUND));
				g2.setColor(Color.BLACK);
				g2.drawLine(x, y, x + width, y + height);
				g2.drawLine(x + width, y, x, y + height);
				g2.setColor(color);
				g2.setStroke(new BasicStroke(3, BasicStroke.JOIN_ROUND, BasicStroke.CAP_ROUND));
				g2.drawLine(x, y, x + width, y + height);
				g2.drawLine(x + width, y, x, y + height);

			}

			private boolean isUnderMouse(int x, int y) 
			{
				if(Math.abs(x-meX)<width && Math.abs(y-meY)<height )
					return  true;		
				return  false;
			}

			private boolean mouseOverTab(int x, int y) {
				int tabCount = tabbedPane.getTabCount();
				for(int j = 0; j < tabCount; j++)
					if(tabbedPane.getBoundsAt(j).contains(meX, meY)){
						selectedTab = j;
						closeX = tabbedPane.getBoundsAt(j).x + tabbedPane.getBoundsAt(j).width -width-5;
						closeY = tabbedPane.getBoundsAt(j).y +5;					
						return true;
					}
				return false;
			}

		}

		public boolean tabAboutToClose(int tabIndex) {
			return true;
		}

	
	public static void main(String[] args) {
		
		MainView frame = new MainView();
		
		frame.setTitle("YACA - Yet Another Chat Application");
		frame.setSize(700, 700);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}
