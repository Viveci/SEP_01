package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Font;

import Panels.BookingPanell;
import Panels.CheckoutPanel;
import Panels.ModifyPanel;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window frame = new Window();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Window() {
		setResizable(false);
				
		
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Deer Alley Hotel Booking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel Booking = new BookingPanell();
		JPanel Register = new JPanel();
		JPanel Modify = new ModifyPanel();
		JPanel CheckOut = new CheckoutPanel();
		
		tabbedPane.add("Booking",Booking);
		
		
		
		
		
		
		tabbedPane.add("Register",Register);
		tabbedPane.add("Modify",Modify);
		tabbedPane.add("Check Out",CheckOut);
		
		
		setContentPane(tabbedPane);
	}
}
