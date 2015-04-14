package userinterface;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NeuRoomView extends JFrame implements ActionListener{
	
	private JTextField tfRoomName;
	private JPasswordField tfPWD;
	private JPanel pnlRoom,pnlButton;
	
	private JButton btnAbbrechen, btnSpeichern;

	
	public NeuRoomView(){
		
		setTitle("Neuer Raum anlegen");
		setSize(400,400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
		
		pnlRoom = new JPanel();
		pnlRoom.setLayout(new FlowLayout());
		
		pnlRoom.add(new JLabel("Raumname: "));
		pnlRoom.add(tfRoomName = new JTextField(" ", 20));
			
		
		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		pnlButton.add("South",btnAbbrechen=new JButton("Abbrechen"));
		pnlButton.add("South",btnSpeichern=new JButton("Speichern"));
        
	   	this.add("North",pnlRoom);
		this.add("South", pnlButton);
			
		setVisible(true);
		pack();
	}//UserLogIn()
	
	public void actionPerformed(ActionEvent e){
		
	}
	
	static public void main(String argv[]){
		new NeuRoomView();
	}
	
}//class-LoginView
