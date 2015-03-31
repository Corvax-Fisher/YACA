package userinterface;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;


public class LoginView extends JFrame {
	
	private JTextField tfUserName;
	private JPasswordField tfPWD;
	private JPanel pnlButton,pnlLogIn;
	private JButton btnRegistrieren;
	private JButton btnGast;
	private JButton btnAnmelden;

	
	public LoginView(){
		
		setTitle("YACA-Anmeldung");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);	
		
		pnlLogIn = new JPanel();
		pnlLogIn.setLayout(new GridLayout(3,3));
		
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
			
		setVisible(true);
		pack();
	}//UserLogIn()
	
	static public void main(String argv[]){
		new LoginView();
	}
	
}//class-LoginView

