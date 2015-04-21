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
	private JButton newRoom, privateRoom;

	private FrontController frontController;
	private String joinedRoom;


	public RoomListView(FrontController frontController) {
		this.frontController = frontController;
		pnlRoom = new JPanel();
		pnlRoom.setLayout(new BorderLayout());
		
		
		roomList = new JList(new DefaultListModel());
		roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		roomList.setSelectedIndex(2);
		roomList.setFixedCellWidth(150);
		roomList.addListSelectionListener(listSelectionListener);

		
		pnlRoom.add(new JScrollPane(getRoomList()), "Center");

		newRoom = new JButton("Öffentlichem Raum beitreten");
		newRoom.addActionListener(this);
		pnlRoom.add(newRoom, "South");
		
		privateRoom = new JButton("Privaten Raum anlegen");
		privateRoom.addActionListener(this);
		pnlRoom.add(privateRoom, "North");

		add(pnlRoom);
	}
	
	public void addRoom(String room) {
		((DefaultListModel) getRoomList().getModel()).addElement(room);
	}
	
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str.equals("Öffentlichem Raum beitreten")){
			frontController.joinRoom(joinedRoom = (String) getRoomList().getSelectedValue());
		} else if(str.equals("Privaten Raum anlegen")){
			joinedRoom = JOptionPane.showInputDialog(null, "Raumname:");

			if(!joinedRoom.equals(""))
				frontController.joinRoom(joinedRoom);
		}
		
	}
	
	public String getJoinedRoom() {
		return joinedRoom;
	}
	
	public JList getRoomList() {
		return roomList;
	}

	ListSelectionListener listSelectionListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent listSelectionEvent) {
			 if (listSelectionEvent.getValueIsAdjusting()) return;
	    	 String s = (String) getRoomList().getSelectedValue();
             if(s!=null) {            	 
            	 frontController.getUserList(s);
             }
	     }
	 };
}
