package userinterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class RoomListView extends JPanel implements ActionListener{
		
		private JPanel pnlRoom;
		private JList  roomList; 
		private JButton newRoom;

		public RoomListView(){	
			
			/*setTitle("Raumliste");
			setSize(400,400);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setVisible(true);*/
			
			pnlRoom = new JPanel();
			//pnlRoom.setLayout(new GridLayout(1, 1));
			
			pnlRoom.setBorder(BorderFactory.createLineBorder(Color.blue)); //Umrandung
			pnlRoom.setLayout(new BorderLayout());
			//list = new JList(DATA);
			roomList = new JList(new DefaultListModel());
			((DefaultListModel) roomList.getModel()).addElement("Raum 1");
			((DefaultListModel) roomList.getModel()).addElement("Raum 2");
			((DefaultListModel) roomList.getModel()).addElement("Raum 3");
			roomList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			roomList.setSelectedIndex(2);
			roomList.setFixedCellWidth(150);
			pnlRoom.add(new JScrollPane(roomList), "Center");
			//Neuer Raum-Button
			newRoom = new JButton("Raum anlegen");
			newRoom.addActionListener(this);
			pnlRoom.add(newRoom, "South");
			add(pnlRoom);
			
			//setVisible(true);
			//pack();			
		}
		
	public void actionPerformed(ActionEvent arg0) {

}
	/*public static void main(String[] args) {
		new RoomListView();	
	}*/
}
