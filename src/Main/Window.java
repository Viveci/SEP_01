package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Font;

import Panels.BookingPanell;
import Panels.CheckoutPanel;
import Panels.DataBasePanel;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel Booking;
	private JPanel Database;
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
		setBounds(100, 100, 800, 485);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		Booking = new BookingPanell();
		Database = new DataBasePanel();
		
		tabbedPane.add("Booking",Booking);		
		tabbedPane.add("Database",Database);
		
		
		setContentPane(tabbedPane);
	}
}
