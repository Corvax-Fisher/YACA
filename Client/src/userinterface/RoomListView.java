package userinterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class RoomListView extends JPanel implements ActionListener{

	private JPanel pnlRoom;
	public JList  roomList;
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
		roomList.addListSelectionListener(listSelectionListener);
		
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
		String str = e.getActionCommand();
		if(str.equals("Öffentlichem Raum beitreten")){
			frontController.joinRoom((String) roomList.getSelectedValue());
		}
		
	}
	
	ListSelectionListener listSelectionListener = new ListSelectionListener() {
		public void valueChanged(ListSelectionEvent listSelectionEvent) {
			 if (listSelectionEvent.getValueIsAdjusting()) return;
	    	 String s = (String) roomList.getSelectedValue();
             if(s!=null) {            	 
            	 frontController.getUserList(s);
             }
	     }
	 };
}
