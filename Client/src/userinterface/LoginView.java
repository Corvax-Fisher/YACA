package userinterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class LoginView extends JPanel implements ActionListener{

	private JTextField tfUserName;
	private JPasswordField tfPWD;
	private JPanel pnlButton,pnlLogIn;
	private JButton btnRegistrieren;
	private JButton btnGast;
	private JButton btnAnmelden;


	public LoginView(){


		pnlLogIn = new JPanel();
		pnlLogIn.setLayout(new GridLayout(3,2));

		pnlLogIn.add(new JLabel("Benutzername: "));
		pnlLogIn.add(tfUserName = new JTextField(" ", 20));

		pnlLogIn.add(new JLabel("Passwort: "));
		pnlLogIn.add(tfPWD = new JPasswordField("", 20));	

		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));

		pnlButton.add("South",btnRegistrieren=new JButton("Registrieren"));
		pnlButton.add("South",btnGast=new JButton("Gast"));
		pnlButton.add("South",btnAnmelden=new JButton("Anmelden"));

		this.add("North",pnlLogIn);
		this.add("South", pnlButton);
	}

	public void actionPerformed(ActionEvent e){

	}
}


