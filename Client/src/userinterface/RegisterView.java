package userinterface;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RegisterView extends JPanel implements ActionListener {

	private JTextField UserName;
	private JPasswordField pwd_1;
	private JPasswordField pwd_2;
	private JTextField Email;
	private JPanel pnlButton;
	private JPanel pnlRegister;
	private JButton btnAbbrechen;
	private JButton btnRegistrieren;
	
	private FrontController frontController;


	public RegisterView(FrontController frontController) {
		this.frontController = frontController;
		pnlRegister = new JPanel();
		pnlRegister.setLayout(new GridLayout(5,5));
		pnlRegister.add(new JLabel("Benutzername: "));
		pnlRegister.add(UserName = new JTextField("", 20));
		
		pnlRegister.add(new JLabel("Email: "));
		pnlRegister.add(Email = new JTextField());
		
		pnlRegister.add(new JLabel("Passwort: "));
		pnlRegister.add(pwd_1 = new JPasswordField());	
		
		pnlRegister.add(new JLabel("Passwort erneut: "));
		pnlRegister.add(pwd_2 = new JPasswordField());	
		
		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		pnlButton.add("South",btnRegistrieren=new JButton("OK"));
		pnlButton.add("South",btnAbbrechen=new JButton("Abrechen"));
		
	   	this.add("Center",pnlRegister);
		this.add("South", pnlButton);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	
}
