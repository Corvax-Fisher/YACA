package userinterface;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView extends JFrame {

	public String name;
	public int id;
	public RegisterView rv;
	
	private JTextField tfUserName;
	private JPasswordField tfPWD_1;
	private JPasswordField tfPWD_2;
	private JTextField tfEmail;
	
	private JPanel pnlButton;
	private JPanel pnlRegister;
	
	private JButton btnAbbrechen;
	private JButton btnRegistrieren;

	
	public RegisterView(){
		setTitle("YACA-Registrierung");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
		
		pnlRegister = new JPanel();
		pnlRegister.setLayout(new GridLayout(5,5));
		pnlRegister.add(new JLabel("Benutzername: "));
		pnlRegister.add(tfUserName = new JTextField("", 20));
		
		pnlRegister.add(new JLabel("Email: "));
		pnlRegister.add(tfEmail = new JTextField());
		
		pnlRegister.add(new JLabel("Passwort: "));
		pnlRegister.add(tfPWD_1 = new JPasswordField());	
		
		pnlRegister.add(new JLabel("Passwort erneut: "));
		pnlRegister.add(tfPWD_2 = new JPasswordField());	
		
		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		
		pnlButton.add("South",btnRegistrieren=new JButton("Registrieren"));
		
		pnlButton.add("South",btnAbbrechen=new JButton("Abrechen"));
		
        
	   	this.add("Center",pnlRegister);
		this.add("South", pnlButton);
			
		setVisible(true);
		pack();
	}//UserRegister()
	
	static public void main(String argv[])
	{
		new RegisterView();
	}

	
}//class-RegisterView
