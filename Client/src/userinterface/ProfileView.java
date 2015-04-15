package userinterface;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ProfileView extends JPanel {

	public String name;
	public int id;
	public ProfileView pv;
	private JList email, userName,pwd;
	private JPanel pnlProfile;
	public ProfileView(){
		/*setTitle("YACA-Anwender Ansicht");
		setSize(300,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);*/		
		
		pnlProfile = new JPanel();
		pnlProfile.setLayout(new GridLayout(5,5));
		pnlProfile.add(new JLabel("Benutzername: "));
		
		userName = new JList();
		//jlUserName.setSelectedIndex(1);
		userName.setFixedCellWidth(40);
		pnlProfile.add(userName);
		

		
		
		pnlProfile.add(new JLabel("Email: "));
		email = new JList();
		//jlEmail.setSelectedIndex(1);
		email.setFixedCellWidth(40);
		pnlProfile.add(email);
		
		pnlProfile.add(new JLabel("Passwort: "));
		
		pwd = new JList();
		pwd.setSelectedIndex(1);
		//jlPWD.setFixedCellWidth(40);
		pnlProfile.add(pwd);
		pnlProfile.add(pwd);		
		
	   	this.add("Center",pnlProfile);
			
		//setVisible(true);
		//pack();
	}//UserRegister()
	
/*	static public void main(String argv[])
	{
		new ProfileView();
	}*/
	
}//class-ProfileView