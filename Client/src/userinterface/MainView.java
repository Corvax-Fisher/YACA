package userinterface;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainView extends JFrame implements WindowListener {

	private JTabbedPane tp;
	private JPanel pnlHome;

	private FrontController frontController;

	public MainView(FrontController frontController) {
		this.frontController = frontController;
		setTitle("YACA-Chat");
		setSize(800, 600);
		setLocationRelativeTo(null);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//Tabbed Pane
		tp = new JTabbedPane();
		add(tp, BorderLayout.NORTH);
		addWindowListener(this);
		
		//Panel Home
		pnlHome = new JPanel (new BorderLayout());
		pnlHome.setSize(800, 600);
		tp.add("Home", pnlHome);
	}

	public JTabbedPane getTp() {
		return tp;
	}

	public JPanel getPnlHome() {
		return pnlHome;
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		frontController.logOut();
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
		
}



