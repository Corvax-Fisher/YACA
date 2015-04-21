package userinterface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChatView extends JPanel implements ActionListener
{
	private String roomName;
	private JPanel chatPnl;
	private JButton sendChatBtn;
	private JPanel userList;
	private JTextArea inputArea,historyPnl;
	private FrontController frontController;
	private JLabel errorMsg;



	public ChatView(FrontController frontController, String roomName) {
		this.roomName = roomName;
		
		this.frontController = frontController;
		chatPnl = new JPanel();
		GridLayout layout = new GridLayout(3,3);
		chatPnl.setLayout(layout);
		chatPnl.setPreferredSize(new Dimension(750,750));
		
		historyPnl = new JTextArea();
		historyPnl.setEditable(false);
        chatPnl.add(historyPnl);
        
        userList = new JPanel();
        chatPnl.add(userList);
        
        inputArea = new JTextArea();
        inputArea.setPreferredSize(new Dimension(750,100));
        chatPnl.add(inputArea);
        
        sendChatBtn = new JButton("Senden");
        chatPnl.add(sendChatBtn);
        
        chatPnl.add(errorMsg = new JLabel("TEST"));
       
        this.add("CENTER", chatPnl);
	}

	public void actionPerformed(ActionEvent event){
		
	}
	public void setText(String str) {
		
		errorMsg.setText(roomName + ": " + str);
	}
	
	
}
