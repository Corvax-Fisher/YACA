package userinterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RoomListView extends JPanel implements ActionListener{

	private JPanel pnlRoom;
	private JList  roomList;
	private JList  userList;
	private JButton newRoom, privateRoom;

	private FrontController frontController;


	public RoomListView(FrontController frontController) {
		this.frontController = frontController;
		pnlRoom = new JPanel();
		pnlRoom.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung
		pnlRoom.setLayout(new BorderLayout());
		
		//list = new JList(DATA);
		roomList = new JList(new DefaultListModel());
		userList = new JList(new DefaultListModel());
		userList.setFixedCellWidth(150);
//		((DefaultListModel) roomList.getModel()).addElement("Raum 1");
//		((DefaultListModel) roomList.getModel()).addElement("Raum 2");
//		((DefaultListModel) roomList.getModel()).addElement("Raum 3");
		roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		roomList.setSelectedIndex(2);
		roomList.setFixedCellWidth(150);
		roomList.addListSelectionListener(listSelectionListener);
		
		pnlRoom.add(new JScrollPane(roomList), "Center");
		pnlRoom.add(new JScrollPane(userList), "West");

		newRoom = new JButton("Öffentlichem Raum beitreten");
		newRoom.addActionListener(this);
		
		pnlRoom.add(newRoom, "South");
		
		add(pnlRoom);		
	}
	
	public void addRoom(String room) {
		((DefaultListModel) roomList.getModel()).addElement(room);
	}
	
	public void addUser(String user) {
		((DefaultListModel) userList.getModel()).addElement(user);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	ListSelectionListener listSelectionListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent listSelectionEvent) {
			((DefaultListModel) userList.getModel()).clear();
			 if (listSelectionEvent.getValueIsAdjusting()) return;
	    	 String s = (String) roomList.getSelectedValue();
             System.out.println("Value Selected: " + s);
             if(s!=null) {            	 
            	 frontController.getUserList(s);
             }
	     }
	 };
}
