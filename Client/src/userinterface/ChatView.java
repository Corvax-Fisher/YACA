package userinterface;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class ChatView extends JPanel implements ActionListener
{

	private JPanel pnlChatWindow, pnlChat;
	private JMenu menuStart;
	private JMenuItem miBeenden;
	private JList list;
	private JButton btnSend;

	public ChatView () 
	{
		pnlChatWindow = new JPanel();
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
		
//ChatInput
		pnlChat = new JPanel();
		pnlChat.setLayout(new FlowLayout());
		//pnlUser.setBorder(BorderFactory.createLineBorder(Color.blue));//Umrandung	
		
		JTextArea chat = new JTextArea(" ", 2, 30);
		//ta.setTabSize(1000);???
		chat.setLineWrap(true);
		chat.setWrapStyleWord(true);
		pnlChat.add(new JScrollPane(chat));
		
		btnSend =new JButton("Senden");
		pnlChat.add(btnSend);
		
		add(pnlChat);
		
		this.add("Center", pnlChatWindow);
		this.add("South", pnlChat);
		
		/*
		setVisible(true);
		pack();*/
	}
	
	public void actionPerformed(ActionEvent event){
		 if(event.getSource() == btnSend) {
		
		 }
		  
		/* else if(event.getSource() == buttonServus) {
		 System.out.println("Servus");
		 }
		  
		 }// TODO Auto-generated method stub
*/		
}
	
/*	
	public static void main(String[] args) {
		
		ChatView frame = new ChatView();
		
		frame.setTitle("Chatfenster");
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}*/

}
