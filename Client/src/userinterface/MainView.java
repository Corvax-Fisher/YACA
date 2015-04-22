package userinterface;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainView extends JFrame {

	private JTabbedPane tp;
	private JPanel pnlHome;


	public MainView() {
		setTitle("YACA-Chat");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tabbed Pane
		tp = new JTabbedPane();
		add(tp, BorderLayout.NORTH);
		
		//Panel Home
		pnlHome = new JPanel (new BorderLayout());
		pnlHome.setSize(800, 600);
		tp.add("Home", pnlHome);
	}


	public JTabbedPane getTp() {
		return tp;
	}


	public void setTp(JTabbedPane tp) {
		this.tp = tp;
	}


	public JPanel getPnlHome() {
		return pnlHome;
	}


	public void setPnlHome(JPanel pnlHome) {
		this.pnlHome = pnlHome;
	}
		
}



