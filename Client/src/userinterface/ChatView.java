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
	private JLabel errorMsg;



	public ChatView(FrontController frontController, String roomName) {
		this.roomName = roomName;
		
		this.frontController = frontController;
		chatPnl = new JPanel();
		//BorderLayout layout = new BorderLayout();//GridLayout(3,3);
		chatPnl.setLayout(new BorderLayout());
		chatPnl.setPreferredSize (new Dimension(750,650));
		
		historyPnl = new JTextArea();
		historyPnl.setEditable(false);
		historyPnl.setBackground(Color.lightGray);
        chatPnl.add(historyPnl, BorderLayout.CENTER);
        
		userList = new JList(new DefaultListModel());
		userList.setBorder(BorderFactory.createLineBorder(Color.blue));
		userList.setPreferredSize (new Dimension(100,650));
        chatPnl.add(userList, BorderLayout.WEST);
        
        inputArea = new JTextArea();
        chatPnl.add(inputArea, BorderLayout.NORTH);
        
        sendPnl = new JPanel();
        sendPnl.setLayout(new BoxLayout(sendPnl, BoxLayout.Y_AXIS));
        chatPnl.add(sendPnl, BorderLayout.EAST);
        
        errorMsg = new JLabel("TEST");
        sendPnl.add(errorMsg);
        
        sendChatBtn = new JButton("Senden");
        sendPnl.add(sendChatBtn);
        sendChatBtn.addActionListener(this);
        
        closeBtn = new JButton("Raum schliessen");
        sendPnl.add(closeBtn);       
       
        this.add(chatPnl);
	}

	public void actionPerformed(ActionEvent event){
		String str = event.getActionCommand();
		if(str.equals("Senden")){
			frontController.sendMessage(inputArea.getText(), roomName);
			inputArea.setText("");
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
