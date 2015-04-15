package userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class UserListView extends JPanel{
		
		private JPanel pnlUser;
		private JList  userList; 
		private JButton newRoom;

		public UserListView(){	
			
			/*setTitle("Raumliste");
			setSize(400,400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);*/
			
			pnlUser = new JPanel();
			//pnlRoom.setLayout(new GridLayout(1, 1));
			
			pnlUser.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung
			pnlUser.setLayout(new BorderLayout());
			//list = new JList(DATA);
			userList = new JList(new DefaultListModel());
			((DefaultListModel) userList.getModel()).addElement("User 1");
			((DefaultListModel) userList.getModel()).addElement("User 2");
			((DefaultListModel) userList.getModel()).addElement("User 3");
			userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			userList.setSelectedIndex(2);
			userList.setFixedCellWidth(150);
			pnlUser.add(new JScrollPane(userList), "Center");
		
			add(pnlUser);
			
			//setVisible(true);
			//pack();			
		}
		
/*	public static void main(String[] args) {
		new UserListView();	
	}*/
}