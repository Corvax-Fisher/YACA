package userinterface;

import java.awt.*;

import javax.swing.*;

public class UserListView extends JPanel{
		
		private JPanel pnlUser;
		private JList  userList; 
		private JButton newRoom;

		private FrontController frontController;


		public UserListView(FrontController frontController) {
			this.frontController = frontController;
			pnlUser = new JPanel();
			pnlUser.setBorder(BorderFactory.createLineBorder(Color.blue));
			pnlUser.setLayout(new BorderLayout());
			//list = new JList(DATA);
			userList = new JList(new DefaultListModel());
//			((DefaultListModel) userList.getModel()).addElement("User 1");
//			((DefaultListModel) userList.getModel()).addElement("User 2");
//			((DefaultListModel) userList.getModel()).addElement("User 3");
//			
			userList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			userList.setSelectedIndex(2);
			userList.setFixedCellWidth(150);
			pnlUser.add(new JScrollPane(userList), "Center");
		
			add(pnlUser);			
		}
		public void addUser(String user) {
			((DefaultListModel) userList.getModel()).addElement(user);
		}
		
		public void clearUserList() {
			((DefaultListModel) userList.getModel()).clear();

		}
}