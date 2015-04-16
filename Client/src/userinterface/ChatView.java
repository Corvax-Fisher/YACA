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
		GridLayout layout = new GridLayout(0,2);
		chatPnl.setLayout(layout);

        chatPnl.add(historyPnl = new JPanel());
        chatPnl.add(userList = new JList());
        chatPnl.add(inputArea = new JTextArea());
        chatPnl.add(sendChatBtn = new JButton());
        
        chatPnl.setVisible(true);

	}

	public void actionPerformed(ActionEvent event){
		
	}
}
