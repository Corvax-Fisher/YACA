package userinterface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChatView extends JPanel implements ActionListener
{
	private String roomName;
	private JPanel chatPnl, sendPnl;
	private JButton sendChatBtn, closeBtn;
	private JList userList;
	private JTextArea inputArea,historyPnl;
	private FrontController frontController;



	public ChatView(FrontController frontController, String roomName) {
		this.roomName = roomName;
		
		this.frontController = frontController;
		chatPnl = new JPanel();
		GridLayout layout = new GridLayout(3,3);
		chatPnl.setLayout(layout);
		chatPnl.setPreferredSize(new Dimension(750,750));
		
		historyPnl = new JTextArea();
		historyPnl.setEditable(false);
		historyPnl.setBackground(Color.lightGray);
        chatPnl.add(historyPnl);
        
		userList = new JList(new DefaultListModel());
        chatPnl.add(userList);
        
        inputArea = new JTextArea();
        chatPnl.add(inputArea);
        
        sendPnl = new JPanel();
        sendPnl.setLayout(new BoxLayout(sendPnl, BoxLayout.Y_AXIS));
        chatPnl.add(sendPnl);
        
        sendChatBtn = new JButton("Senden");
        sendPnl.add(sendChatBtn);
        sendChatBtn.addActionListener(this);
        
        closeBtn = new JButton("Raum schliessen");
        sendPnl.add(closeBtn);
        closeBtn.addActionListener(this);
       
        this.add("CENTER", chatPnl);
	}

	public void actionPerformed(ActionEvent event){
		String str = event.getActionCommand();
		if(str.equals("Senden")){
			frontController.sendMessage(inputArea.getText(), roomName);
			inputArea.setText("");
		} else if(str.equals("Raum schliessen")){
			frontController.leaveRoom(roomName);
			System.out.println("chatview");
		}
		
		
	}
	public void setText(String str) {
		
		historyPnl.append(str);
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void addUser(String user) {
		((DefaultListModel) userList.getModel()).addElement(user);
	}
	
	public void clearUserList() {
		((DefaultListModel) userList.getModel()).clear();

	}
	
	
}
