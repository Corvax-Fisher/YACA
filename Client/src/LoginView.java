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


public class LoginView extends JFrame {

	public String name;
	public int id;
	public LoginView lv;
	
	private JPasswordField tfUserName;
	private JPasswordField tfPWD;
	
	private JPanel pnlButton;
	private JPanel pnlLogIn;

	private JMenu menuStart;
	private JMenuItem miBeenden;
	
	private JButton btnAnmelden;
	private JButton btnGast;
	
	public LoginView(){
		super("YACA");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		centerFrame(500, 280);
		this.setResizable (false);		
		
		pnlLogIn = new JPanel();
		pnlLogIn.setLayout(new GridLayout(3,3));
		pnlLogIn.add(new JLabel("Benutzername: "));
		pnlLogIn.add(tfUserName = new JPasswordField());	
		
		pnlLogIn.add(new JLabel("Passwort: "));
		pnlLogIn.add(tfPWD = new JPasswordField());	
		
		pnlButton = new JPanel();
		pnlButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		pnlButton.add("South",btnAnmelden=new JButton("Anmelden"));
		
		pnlButton.add("South",btnGast=new JButton("Gast"));
		
		menuBar();
        
	   	this.add("Center",pnlLogIn);
		this.add("South", pnlButton);
			
		setVisible(true);
		pack();
	}//UserLogIn()
	
	// Methode zur Generierung einer MenuBar
	void menuBar(){
		JMenuBar menubar = new JMenuBar();
		setJMenuBar(menubar);
		menuStart =  new JMenu("Registrieren");
		menubar.add(menuStart);
		miBeenden = new JMenuItem("Neue User");
		menuStart.add(miBeenden);		
		
	}//menuBar()
	
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
		new LoginView();
	}

	
}//class-LoginView

