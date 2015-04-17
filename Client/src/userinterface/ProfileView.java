package userinterface;
import java.awt.*;
import javax.swing.*;

public class ProfileView extends JPanel {

	private JList email, userName,pwd;
	private JPanel pnlProfile;

	public ProfileView(){

		pnlProfile = new JPanel();
		pnlProfile.setLayout(new GridLayout(5,5));
		pnlProfile.add(new JLabel("Benutzername: "));

		userName = new JList();
		//jlUserName.setSelectedIndex(1);
		userName.setFixedCellWidth(40);
		pnlProfile.add(userName);

		pnlProfile.add(new JLabel("Email: "));
		email = new JList();
		email.setFixedCellWidth(40);
		pnlProfile.add(email);

		pnlProfile.add(new JLabel("Passwort: "));

		pwd = new JList();
		pwd.setSelectedIndex(1);
		pnlProfile.add(pwd);		

		this.add("Center",pnlProfile);	
	}
}