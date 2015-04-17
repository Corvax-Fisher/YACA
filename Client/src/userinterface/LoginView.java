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
	private JLabel errorMsg;
	private FrontController frontController;


	public LoginView(FrontController frontController) {
		this.frontController = frontController;
		pnlLogIn = new JPanel();
		pnlLogIn.setLayout(new GridLayout(3,2));

		pnlLogIn.add(new JLabel("Benutzername: "));
		pnlLogIn.add(tfUserName = new JTextField("", 20));

		pnlLogIn.add(new JLabel("Passwort: "));
		pnlLogIn.add(tfPWD = new JPasswordField("", 20));
		
		pnlLogIn.add(errorMsg = new JLabel(""));

		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));

		pnlButton.add("South",btnRegistrieren=new JButton("Registrieren"));
		pnlButton.add("South",btnGast=new JButton("Gast"));
		btnGast.addActionListener(this);
		pnlButton.add("South",btnAnmelden=new JButton("Anmelden"));

		this.add("North",pnlLogIn);
		this.add("South", pnlButton);
		
		
	}

	public void actionPerformed(ActionEvent e){
		String str = e.getActionCommand();
		if(str.equals("Gast")){
			if(!tfUserName.getText().equals("")) {
				logInGuest(tfUserName.getText());
			} else {
				errorMsg.setText("Username eingeben");
			}
		}
	}
	
	public void logInGuest(String guestName) {
		frontController.logInGuest(guestName);
	}
	
	
}


