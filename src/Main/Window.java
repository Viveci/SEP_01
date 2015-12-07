package Main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class Window extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Natinoality;
	private JTextField BirthDate;
	private JTextField DateFrom;
	private JTextField DateTo;

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
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setTitle("Deer Alley Hotel Booking System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		JTabbedPane tabbedPane = new JTabbedPane();
		
		JPanel Booking = new JPanel();
		//Booking panel elements
		Booking.setLayout(null);
		
		//Jlabel Guest
		JLabel GuestLabel = new JLabel("Guest");
		GuestLabel.setFont(new Font("Arial", Font.BOLD, 16));
		GuestLabel.setBounds(10, 10, 46, 20);
		Booking.add(GuestLabel);
		
		//JLabel FIRST NAME
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFirstName.setBounds(10, 45, 150, 14);
		Booking.add(lblFirstName);
		
		//JTextField FIRST NAME
		FirstName = new JTextField();
		FirstName.setToolTipText("First name");
		FirstName.setBounds(10, 60, 150, 20);
		Booking.add(FirstName);
		
		//Jlabel LAST NAME
		JLabel lblLastname = new JLabel("Last name");
		lblLastname.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLastname.setBounds(10, 90, 150, 14);
		Booking.add(lblLastname);
		
		//JTextField LAST NAME
		LastName = new JTextField();
		LastName.setToolTipText("Last name");
		LastName.setBounds(10, 105, 150, 20);
		Booking.add(LastName);
		
		//JLabel Nationality
		JLabel label = new JLabel("Nationality");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 135, 150, 14);
		Booking.add(label);
		
		//JTextField NATIONALITY
		Natinoality = new JTextField();
		Natinoality.setToolTipText("Nationality");
		Natinoality.setBounds(10, 150, 150, 20);
		Booking.add(Natinoality);
		
		//JLable Birthdate
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBirthDate.setBounds(10, 180, 150, 14);
		Booking.add(lblBirthDate);
		
		//JTextField NATIONALITY
		BirthDate = new JTextField();
		BirthDate.setToolTipText("BirthDate");
		BirthDate.setBounds(10, 195, 150, 20);
		Booking.add(BirthDate);
		
		//TRYTRYTRY PLACEHOLDER PLACEHOLDER SO FAR
		String[] columnNames = {"First Name",
                "Last Name",
                "Sport",
                "# of Years",
                "Vegetarian"};
		
		Object[][] data = {
			    {"Kathy", "Smith",
			     "Snowboarding", new Integer(5), new Boolean(false)},
			    {"John", "Doe",
			     "Rowing", new Integer(3), new Boolean(true)},
			    {"Sue", "Black",
			     "Knitting", new Integer(2), new Boolean(false)},
			    {"Jane", "White",
			     "Speed reading", new Integer(20), new Boolean(true)},
			     {"Kathy", "Smith",
				     "Snowboarding", new Integer(5), new Boolean(false)},
				    {"John", "Doe",
				     "Rowing", new Integer(3), new Boolean(true)},
				    {"Sue", "Black",
				     "Knitting", new Integer(2), new Boolean(false)},
				    {"Jane", "White",
				     "Speed reading", new Integer(20), new Boolean(true)},
				     {"Kathy", "Smith",
					     "Snowboarding", new Integer(5), new Boolean(false)},
					    {"John", "Doe",
					     "Rowing", new Integer(3), new Boolean(true)},
					    {"Sue", "Black",
					     "Knitting", new Integer(2), new Boolean(false)},
					    {"Jane", "White",
					     "Speed reading", new Integer(20), new Boolean(true)},
					     {"Kathy", "Smith",
						     "Snowboarding", new Integer(5), new Boolean(false)},
						    {"John", "Doe",
						     "Rowing", new Integer(3), new Boolean(true)},
						    {"Sue", "Black",
						     "Knitting", new Integer(2), new Boolean(false)},
						    {"Jane", "White",
						     "Speed reading", new Integer(20), new Boolean(true)},
			    {"Joe", "Brown",
			     "Pool", new Integer(10), new Boolean(false)}
			};
		
		JTable table = new JTable(data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(590, 221);
		scrollPane.setLocation(180, 10);
		table.setFillsViewportHeight(true);
		Booking.add(scrollPane);
		
		JSeparator GuestVertical = new JSeparator();
		GuestVertical.setOrientation(SwingConstants.VERTICAL);
		GuestVertical.setBounds(170, 0, 2, 230);
		Booking.add(GuestVertical);
		
		JSeparator GuestHorizontal = new JSeparator();
		GuestHorizontal.setBounds(0, 230, 170, 2);
		Booking.add(GuestHorizontal);
		
		JSeparator HorizontalEq = new JSeparator();
		HorizontalEq.setBounds(0, 240, 800, 2);
		Booking.add(HorizontalEq);
		
		JLabel DateLabel = new JLabel("Date");
		DateLabel.setFont(new Font("Arial", Font.BOLD, 16));
		DateLabel.setBounds(10, 245, 46, 20);
		Booking.add(DateLabel);
		
		JLabel DateFromLabel = new JLabel("From");
		DateFromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		DateFromLabel.setBounds(10, 275, 150, 14);
		Booking.add(DateFromLabel);
		
		DateFrom = new JTextField();
		DateFrom.setToolTipText("From");
		DateFrom.setBounds(10, 290, 150, 20);
		Booking.add(DateFrom);
		
		JLabel DateToLabel = new JLabel("To");
		DateToLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		DateToLabel.setBounds(10, 320, 150, 14);
		Booking.add(DateToLabel);
		
		DateTo = new JTextField();
		DateTo.setToolTipText("To");
		DateTo.setBounds(10, 335, 150, 20);
		Booking.add(DateTo);
		
		JSeparator DateVertical = new JSeparator();
		DateVertical.setOrientation(SwingConstants.VERTICAL);
		DateVertical.setBounds(170, 240, 2, 195);
		Booking.add(DateVertical);
		
		//<------------------------------------------------------------------------------------------------------------------------------------------------->
		JPanel Register = new JPanel();
		JPanel Modify = new JPanel();
		JPanel CheckOut = new JPanel();
		
		tabbedPane.add("Booking",Booking);		
		
		
		tabbedPane.add("Register",Register);
		tabbedPane.add("Modify",Modify);
		tabbedPane.add("Check Out",CheckOut);
		
		
		setContentPane(tabbedPane);
	}
}
