package userinterface;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class ChatView extends JPanel implements ActionListener, KeyListener
{
	private String roomName;
	private JPanel chatPnl, sendPnl;
	private JButton sendChatBtn, closeBtn, sendPrivateChatBtn;
	private JList userList;
	private JTextField inputField;
	private JTextArea historyPnl;
	
	private FrontController frontController;

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
        
        inputField = new JTextField();
        inputField.addKeyListener(this);
        chatPnl.add(inputField, BorderLayout.NORTH);
        
        sendPnl = new JPanel();
        sendPnl.setLayout(new BoxLayout(sendPnl, BoxLayout.Y_AXIS));
        chatPnl.add(sendPnl, BorderLayout.EAST);
        
        sendChatBtn = new JButton("Senden");
        sendPnl.add(sendChatBtn);
        sendChatBtn.addActionListener(this);
        
        sendPrivateChatBtn = new JButton("Sende privat");
        sendPnl.add(sendPrivateChatBtn);
        sendPrivateChatBtn.addActionListener(this);
        
        closeBtn = new JButton("Raum schliessen");
        sendPnl.add(closeBtn);
        closeBtn.addActionListener(this);
       
        this.add(chatPnl);
	}

	public void actionPerformed(ActionEvent event){
		String str = event.getActionCommand();
		if(str.equals("Senden") && inputField.getText().length() != 0){
			frontController.sendMessage(inputField.getText(), roomName);
			inputField.setText("");
		}else if(str.equals("Sende privat") && inputField.getText().length() != 0){
			frontController.sendPrivateMessage((String)userList.getSelectedValue(),inputField.getText(), roomName);
			inputField.setText("");
		}else if(str.equals("Raum schliessen")){
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

	public void refreshUserList(List<String> list) {
		((DefaultListModel) userList.getModel()).clear();
		for (String auser : list) {
			((DefaultListModel) userList.getModel()).addElement(auser);
		}		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER && inputField.getText().length() != 0) {
			frontController.sendMessage(inputField.getText(), roomName);
			inputField.setText("");
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
}
