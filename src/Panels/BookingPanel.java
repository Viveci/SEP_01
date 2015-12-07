package Panels;

import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import DataBase.BookingDB;
import DataBase.RoomDB;
import Model.Booking;
import Model.Date;
import Model.Guest;
import Model.Room;

public class BookingPanel extends JPanel {
	
	private RoomDB db = new RoomDB();
	private BookingDB bdb = new BookingDB();
	private JTextField FirstName;
	private JTextField LastName;
	private JTextField Natinoality;
	private JTextField BirthDate;
	private JTextField DateFrom;
	private JTextField DateTo;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingPanel(){
		//Booking panel elements
		setLayout(null);
		
		//Jlabel Guest
		JLabel GuestLabel = new JLabel("Guest");
		GuestLabel.setFont(new Font("Arial", Font.BOLD, 16));
		GuestLabel.setBounds(10, 10, 46, 20);
		add(GuestLabel);
		
		//JLabel FIRST NAME
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFirstName.setBounds(10, 45, 150, 14);
		add(lblFirstName);
		
		//JTextField FIRST NAME
		FirstName = new JTextField();
		FirstName.setToolTipText("First name");
		FirstName.setBounds(10, 60, 150, 20);
		add(FirstName);
		
		//Jlabel LAST NAME
		JLabel lblLastname = new JLabel("Last name");
		lblLastname.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLastname.setBounds(10, 90, 150, 14);
		add(lblLastname);
		
		//JTextField LAST NAME
		LastName = new JTextField();
		LastName.setToolTipText("Last name");
		LastName.setBounds(10, 105, 150, 20);
		add(LastName);
		
		//JLabel Nationality
		JLabel label = new JLabel("Nationality");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 135, 150, 14);
		add(label);
		
		//JTextField NATIONALITY
		Natinoality = new JTextField();
		Natinoality.setToolTipText("Nationality");
		Natinoality.setBounds(10, 150, 150, 20);
		add(Natinoality);
		
		//JLable Birthdate
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBirthDate.setBounds(10, 180, 150, 14);
		add(lblBirthDate);
		
		//JTextField NATIONALITY
		BirthDate = new JTextField();
		BirthDate.setToolTipText("BirthDate");
		BirthDate.setBounds(10, 195, 150, 20);
		add(BirthDate);		
		
		//<-------------------------------------JTabel filler------------------------------------------------>				
		
		String[] columnNames = {"Room number",
                "Room type",
                "Capacity",
                "Price"};
		
		Date from = new Date(5,5,2015);
		Date to = new Date(10,5,2015);
		Guest g = new Guest("Dony","Fasztudja",new Date(29,5,1995),"Litván");
		Room r = db.getRoom(1);
		Booking b = new Booking(from,to,g,r,1);
		bdb.addBooking(b);
		bdb.addBooking(b);
		bdb.addBooking(b);
		bdb.addBooking(b);
		bdb.addBooking(b);
		
		Date from1 = new Date(5,5,2015);
		Date to1 = new Date(10,5,2015);
		Guest g1 = new Guest("Dony","Fasztudja",new Date(29,5,1995),"Litván");
		Room r1 = db.getRoom(2);
		Booking b1 = new Booking(from1,to1,g1,r1,2);
		bdb.addBooking(b1);
		bdb.addBooking(b1);	
		bdb.addBooking(b1);	
		bdb.addBooking(b1);
		
		ArrayList<Room> list =db.filter(bdb.dateFilter(from1, to1));
		
		Object[][] data = db.toData(list);
		
		JTable table = new JTable(data, columnNames);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(590, 221);
		scrollPane.setLocation(180, 10);
		table.setFillsViewportHeight(true);
		add(scrollPane);
		//<------------------------------------------------------------------------------------------------------>
		
		JSeparator GuestVertical = new JSeparator();
		GuestVertical.setOrientation(SwingConstants.VERTICAL);
		GuestVertical.setBounds(170, 0, 2, 230);
		add(GuestVertical);
		
		JSeparator GuestHorizontal = new JSeparator();
		GuestHorizontal.setBounds(0, 230, 170, 2);
		add(GuestHorizontal);
		
		JSeparator HorizontalEq = new JSeparator();
		HorizontalEq.setBounds(0, 240, 800, 2);
		add(HorizontalEq);
		
		JLabel DateLabel = new JLabel("Date");
		DateLabel.setFont(new Font("Arial", Font.BOLD, 16));
		DateLabel.setBounds(10, 245, 46, 20);
		add(DateLabel);
		
		JLabel DateFromLabel = new JLabel("From");
		DateFromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		DateFromLabel.setBounds(10, 275, 150, 14);
		add(DateFromLabel);
		
		DateFrom = new JTextField();
		DateFrom.setToolTipText("From");
		DateFrom.setBounds(10, 290, 150, 20);
		add(DateFrom);
		
		JLabel DateToLabel = new JLabel("To");
		DateToLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		DateToLabel.setBounds(10, 320, 150, 14);
		add(DateToLabel);
		
		DateTo = new JTextField();
		DateTo.setToolTipText("To");
		DateTo.setBounds(10, 335, 150, 20);
		add(DateTo);
		
		JSeparator DateVertical = new JSeparator();
		DateVertical.setOrientation(SwingConstants.VERTICAL);
		DateVertical.setBounds(170, 240, 2, 195);
		add(DateVertical);
		
		
	}
	
}
