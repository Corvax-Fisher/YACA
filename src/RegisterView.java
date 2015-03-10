import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegisterView extends JFrame {

	public String name;
	public int id;
	public RegisterView rv;
	
	private JPasswordField tfUserName;
	private JPasswordField tfPWD_1;
	private JPasswordField tfPWD_2;
	private JPasswordField tfEmail;
	
	private JPanel pnlButton;
	private JPanel pnlRegister;

	private JMenu menuStart;
	private JMenuItem miBeenden;
	
	private JButton btnRegistrieren;
	private JButton btnAbrechen;
	
	public RegisterView(){
		super("Registrieren");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerFrame(500, 280);
		this.setResizable (false);		
		
		pnlRegister = new JPanel();
		pnlRegister.setLayout(new GridLayout(5,5));
		pnlRegister.add(new JLabel("Benutzername: "));
		pnlRegister.add(tfUserName = new JPasswordField());
		
		pnlRegister.add(new JLabel("Email: "));
		pnlRegister.add(tfEmail = new JPasswordField());
		
		pnlRegister.add(new JLabel("Passwort: "));
		pnlRegister.add(tfPWD_1 = new JPasswordField());	
		
		pnlRegister.add(new JLabel("Passwort wiederholen: "));
		pnlRegister.add(tfPWD_2 = new JPasswordField());	
		
		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlButton.add("South",btnRegistrieren=new JButton("Registrieren"));
		
		pnlButton.add("South",btnAbrechen=new JButton("Abrechen"));
		
        
	   	this.add("Center",pnlRegister);
		this.add("South", pnlButton);
			
		setVisible(true);
		pack();
	}//UserRegister()
	
	
	public void centerFrame(int x, int y) {
		 Dimension frameSize = new Dimension(x, y);
	     Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int top = (screenSize.height - frameSize.height) / 2;
         int left = (screenSize.width - frameSize.width) / 2;
         this.setSize(frameSize);
         this.setLocation(left, top);
	}
	
	static public void main(String argv[])
	{
		new RegisterView();
	}

	
}//class-RegisterView
