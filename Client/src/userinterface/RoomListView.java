package userinterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RoomListView extends JPanel implements ActionListener{

	private JPanel pnlRoom;
	private JList  roomList; 
	private JButton newRoom, privateRoom;

	private FrontController frontController;


	public RoomListView(FrontController frontController) {
		this.frontController = frontController;
		pnlRoom = new JPanel();
		pnlRoom.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung
		pnlRoom.setLayout(new BorderLayout());
		
		//list = new JList(DATA);
		roomList = new JList(new DefaultListModel());
//		((DefaultListModel) roomList.getModel()).addElement("Raum 1");
//		((DefaultListModel) roomList.getModel()).addElement("Raum 2");
//		((DefaultListModel) roomList.getModel()).addElement("Raum 3");
		roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		roomList.setSelectedIndex(2);
		roomList.setFixedCellWidth(150);
		
		pnlRoom.add(new JScrollPane(roomList), "Center");
		
		newRoom = new JButton("Öffentlichem Raum beitreten");
		newRoom.addActionListener(this);
		
		pnlRoom.add(newRoom, "South");
		
		add(pnlRoom);		
	}
	
	public void addRoom(String room) {
		((DefaultListModel) roomList.getModel()).addElement(room);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
