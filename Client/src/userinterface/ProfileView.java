package userinterface;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProfileView extends JFrame {

	public String name;
	public int id;
	public ProfileView pv;
	
	private JTextField tfUserName;
	private JPasswordField tfPWD;
	private JTextField tfEmail;
	
	private JPanel pnlProfile;
	
	private JButton btnAbbrechen;
	private JButton btnRegistrieren;

	
	public ProfileView(){
		setTitle("YACA-Anwender Ansicht");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);		
		
		pnlProfile = new JPanel();
		pnlProfile.setLayout(new GridLayout(5,5));
		pnlProfile.add(new JLabel("Benutzername: "));
		pnlProfile.add(tfUserName = new JTextField("", 20));
		
		pnlProfile.add(new JLabel("Email: "));
		pnlProfile.add(tfEmail = new JTextField());
		
		pnlProfile.add(new JLabel("Passwort: "));
		pnlProfile.add(tfPWD = new JPasswordField());		
		
	   	this.add("Center",pnlProfile);
			
		setVisible(true);
		pack();
	}//UserRegister()
	
	static public void main(String argv[])
	{
		new ProfileView();
	}
	
}//class-ProfileView