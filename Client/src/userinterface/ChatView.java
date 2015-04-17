package userinterface;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class ChatView extends JPanel implements ActionListener
{
	private JPanel chatPnl, historyPnl;
	private JButton sendChatBtn;
	private JList userList;
	private JTextArea inputArea;

	public ChatView () 
	{
		chatPnl = new JPanel();
		GridLayout layout = new GridLayout(2,2);
		chatPnl.setLayout(layout);
		
		historyPnl = new JPanel();
		historyPnl.setSize(300, 300);
        chatPnl.add(historyPnl);
        
        userList = new JList();
        userList.setSize(100, 300);
        chatPnl.add(userList);
        
        inputArea = new JTextArea();
        inputArea.setSize(100, 300);
        chatPnl.add(inputArea);
        
        sendChatBtn = new JButton("Senden");
        sendChatBtn.setSize(100, 300);
        chatPnl.add(sendChatBtn);
        
        this.add("CENTER", chatPnl);
	}

	public void actionPerformed(ActionEvent event){
		
	}
}
