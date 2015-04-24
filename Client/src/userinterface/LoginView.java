package userinterface;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class LoginView extends JPanel implements ActionListener{

	private JTextField tfUserName;
	private JTextField tfPWD;
	private JPanel pnlButton,pnlLogIn;
	private JButton btnRegistrieren;
	private JButton btnGast;
	private JButton btnAnmelden;
	private JLabel errorMsg;
	private FrontController frontController;


	public LoginView(FrontController frontController) {
		this.frontController = frontController;
		pnlLogIn = new JPanel();
		pnlLogIn.setLayout(new GridLayout(3,2));

		pnlLogIn.add(new JLabel("Benutzername: "));
		pnlLogIn.add(tfUserName = new JTextField("", 20));

		pnlLogIn.add(new JLabel("Passwort: "));
		pnlLogIn.add(tfPWD = new JTextField("", 20));
		
		pnlLogIn.add(errorMsg = new JLabel(""));

		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));

		pnlButton.add("South",btnRegistrieren=new JButton("Registrieren"));
		btnRegistrieren.addActionListener(this);
		pnlButton.add("South",btnGast=new JButton("Gast"));
		btnGast.addActionListener(this);
		pnlButton.add("South",btnAnmelden=new JButton("Anmelden"));
		btnAnmelden.addActionListener(this);

		this.add("North",pnlLogIn);
		this.add("South", pnlButton);
		
		
	}

	public void actionPerformed(ActionEvent e){
		String str = e.getActionCommand();
		if(str.equals("Gast")){
			logInGuest(tfUserName.getText());
		}else if(str.equals("Anmelden")) {
				logIn(tfUserName.getText(), tfPWD.getText());
		}else if(str.equals("Registrieren")) {
			frontController.dispatchRequest("REGISTER");
		}
	}
	
	public void logInGuest(String guestName) {
		frontController.logInGuest(guestName);
	}
	
	public void logIn(String name, String password) {
		frontController.logIn(name, password);	
		System.out.println("login view " + name);
	}
	
	public void setText(String str) {
		errorMsg.setText(str);
	}
	
	
}


