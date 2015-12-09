package Panels;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javafx.scene.shape.CullFace;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import sun.text.normalizer.CharTrie.FriendAgent;
import DataBase.BookingDB;
import DataBase.RoomDB;
import Model.Booking;
import Model.Date;
import Model.Guest;
import Model.Room;

public class BookingPanell extends JPanel {
	
	private RoomDB db = new RoomDB();
	private BookingDB bdb = new BookingDB();
	private JTextField FirstName;
	private JTextField NumGuests;
	private JTextField Natinoality;
	private JTextField BirthDate;
	private JTextField DateFrom;
	private JTextField DateTo;
	private JTable table;
	private JScrollPane scrollPane;
	
	private String gName;
	private int nGuests;
	private String nationality;
	private Date birthDate;	
	private Room room;
	private String address;
	
	private int[] inputs = new int[7]; 
	private Boolean global;
	
	private DefaultTableModel tableModel;
	
	private static String[] columnNames = {"Room number",
        "Room type",
        "Capacity",
        "Price"};;
	

	private static final long serialVersionUID = 1L;
	private JTextField Address;

	public BookingPanell(){
		
		global = false;
		
		setBounds(100, 100, 800, 430);
		setLayout(null);
		
		gName = "";
		nGuests = -1;
		nationality = "Hun";
		birthDate = new Date();	
		room = new Room();
		
		
		
		//Jlabel Guest
		JLabel GuestLabel = new JLabel("Guest");
		GuestLabel.setFont(new Font("Arial", Font.BOLD, 16));
		GuestLabel.setBounds(10, 10, 46, 20);
		add(GuestLabel);
		
		//JLabel Name
		JLabel lblFirstName = new JLabel("Name of the guest");
		lblFirstName.setFont(new Font("Arial", Font.PLAIN, 14));
		lblFirstName.setBounds(10, 45, 150, 14);
		add(lblFirstName);
		
		//Jlabel Number of guests
		JLabel lblLastname = new JLabel("Number of guests");
		lblLastname.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLastname.setBounds(10, 355, 150, 15);
		add(lblLastname);
		
		//JLabel Nationality
		JLabel label = new JLabel("Nationality");
		label.setFont(new Font("Arial", Font.PLAIN, 14));
		label.setBounds(10, 135, 150, 14);
		add(label);
		
		JLabel AdressLabel = new JLabel("Address");
		AdressLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		AdressLabel.setBounds(10, 89, 150, 14);
		add(AdressLabel);
		
		//JLable Birth date
		JLabel lblBirthDate = new JLabel("Birth date");
		lblBirthDate.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBirthDate.setBounds(10, 180, 150, 14);
		add(lblBirthDate);
		
		JLabel FilterLabel = new JLabel("Filters");
		FilterLabel.setFont(new Font("Arial", Font.BOLD, 16));
		FilterLabel.setBounds(10, 245, 150, 20);
		add(FilterLabel);
		
		JLabel DateFromLabel = new JLabel("From");
		DateFromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		DateFromLabel.setBounds(10, 265, 150, 14);
		add(DateFromLabel);
		
		JSeparator GuestVertical = new JSeparator();
		GuestVertical.setOrientation(SwingConstants.VERTICAL);
		GuestVertical.setBounds(170, 0, 2, 230);
		add(GuestVertical);
				
		JLabel DateToLabel = new JLabel("To");
		DateToLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		DateToLabel.setBounds(10, 310, 150, 14);
		add(DateToLabel);
		
		JSeparator GuestHorizontal = new JSeparator();
		GuestHorizontal.setBounds(0, 230, 170, 2);
		add(GuestHorizontal);
		
		JSeparator HorizontalEq = new JSeparator();
		HorizontalEq.setBounds(0, 240, 800, 2);
		add(HorizontalEq);
		
		JSeparator DateVertical = new JSeparator();
		DateVertical.setOrientation(SwingConstants.VERTICAL);
		DateVertical.setBounds(170, 240, 2, 195);
		add(DateVertical);
		
		
		
		
		//JTextField Name
		FirstName = new JTextField();
		FirstName.setToolTipText("Name");
		FirstName.setBounds(10, 60, 150, 20);
		add(FirstName);
		
		FirstName.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	if(!FirstName.getText().isEmpty()){
	        		inputs[0] = 1;
	        	}
	        	else{
	        		inputs[0] = 0;
	        	}
	        	
	        	for(int i = 0; i < inputs.length; i++){
	        		if(inputs[i]==1){
	        			global = true;
	        		}
	        	}
	        	
	        }
	    });
		
		//JTextField Number of guests
		NumGuests = new JTextField();
		NumGuests.setToolTipText("Number of guests");
		NumGuests.setBounds(10, 370, 150, 20);
		add(NumGuests);
		
		NumGuests.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	if(!NumGuests.getText().isEmpty()){
	        		inputs[0] = 1;
	        	}
	        	else{
	        		inputs[0] = 0;
	        	}
	        	
	        	for(int i = 0; i < inputs.length; i++){
	        		if(inputs[i]==1){
	        			global = true;
	        		}
	        	}
	        	
	        }
	    });
		
		//JTextField NATIONALITY
		Natinoality = new JTextField();
		Natinoality.setToolTipText("Nationality");
		Natinoality.setBounds(10, 150, 150, 20);
		add(Natinoality);
		
		Natinoality.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	if(!Natinoality.getText().isEmpty()){
	        		inputs[0] = 1;
	        	}
	        	else{
	        		inputs[0] = 0;
	        	}
	        	
	        	for(int i = 0; i < inputs.length; i++){
	        		if(inputs[i]==1){
	        			global = true;
	        		}
	        	}
	        	
	        }
	    });
				
		//JTextField NATIONALITY
		BirthDate = new JTextField();
		BirthDate.setToolTipText("BirthDate");
		BirthDate.setBounds(10, 195, 150, 20);
		add(BirthDate);
		
		BirthDate.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	if(!BirthDate.getText().isEmpty()){
	        		inputs[0] = 1;
	        	}
	        	else{
	        		inputs[0] = 0;
	        	}
	        	
	        	for(int i = 0; i < inputs.length; i++){
	        		if(inputs[i]==1){
	        			global = true;
	        		}
	        	}
	        	
	        }
	    });
		
		//JTextField Address
		Address = new JTextField();
		Address.setToolTipText("Name");
		Address.setBounds(10, 104, 150, 20);
		add(Address);
		
		Address.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	if(!Address.getText().isEmpty()){
	        		inputs[0] = 1;
	        	}
	        	else{
	        		inputs[0] = 0;
	        	}
	        	
	        	for(int i = 0; i < inputs.length; i++){
	        		if(inputs[i]==1){
	        			global = true;
	        		}
	        	}
	        	
	        }
	    });
		
		DateFrom = new JTextField();
		DateFrom.setToolTipText("From");
		DateFrom.setBounds(10, 280, 150, 20);
		add(DateFrom);
		
		DateFrom.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	if(!DateFrom.getText().isEmpty()){
	        		inputs[0] = 1;
	        	}
	        	else{
	        		inputs[0] = 0;
	        	}
	        	
	        	for(int i = 0; i < inputs.length; i++){
	        		if(inputs[i]==1){
	        			global = true;
	        		}
	        	}
	        	
	        }
	    });
		
		DateTo = new JTextField();
		DateTo.setToolTipText("To");
		DateTo.setBounds(10, 325, 150, 20);
		add(DateTo);
		
		DateTo.addCaretListener(new CaretListener() {
	        @Override
	        public void caretUpdate(CaretEvent e) {
	        	if(!DateTo.getText().isEmpty()){
	        		inputs[0] = 1;
	        	}
	        	else{
	        		inputs[0] = 0;
	        	}
	        	
	        	for(int i = 0; i < inputs.length; i++){
	        		if(inputs[i]==1){
	        			global = true;
	        		}
	        	}
	        	
	        }
	    });
		
		//<-------------------------------------JTabel filler------------------------------------------------>				
					
		ArrayList<Room> list = db.getAllRoom();
		
		Object[][] data = db.toData(list);
		
		refreshTable(data);
				
		scrollPane = new JScrollPane(table);
		scrollPane.setSize(590, 221);
		scrollPane.setLocation(180, 10);
		table.setFillsViewportHeight(true);
		add(scrollPane);
		
		table.addMouseListener(new MouseAdapter(){
		    public void mouseClicked(MouseEvent evnt) {
		        if (evnt.getClickCount() == 1) {
		        	System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
		         }
		     }
		});
		
		//<------------------------------------------------------------------------------------------------------>
						
		JButton SaveBooking = new JButton("Save booking");
		SaveBooking.setEnabled(global);
		SaveBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				gName = FirstName.getText();
				nGuests = Integer.parseInt(NumGuests.getText());
				nationality = Natinoality.getText();
				birthDate = new Date(BirthDate.getText());
				address = Address.getText();
				Date from = new Date(DateFrom.getText());
				Date to = new Date(DateTo.getText());
				
				Guest g = new Guest(gName,address,birthDate,nationality);
				Room r = db.getRoom(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString().substring(12)));
				Booking b = new Booking(from,to,g,r,nGuests);
				
				bdb.addBooking(b);
				
				ArrayList<Room> list1 = db.roomFilter(nGuests);
				ArrayList<Room> list2 = db.filter(bdb.dateFilter(from, to), list1);
				
				Object[][] data = db.toData(list2);
				
				refreshTable(data);
				
				bdb.serialize();
			}
		});
		SaveBooking.setBounds(620, 365, 150, 25);
		add(SaveBooking);
		
		JButton Clear = new JButton("Clear all");
		Clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		Clear.setBounds(620, 400, 150, 25);
		add(Clear);
		
		JButton RefreshButton = new JButton("Filter");
		RefreshButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!NumGuests.getText().isEmpty()){
					
					if(DateFrom.getText().isEmpty() || DateTo.getText().isEmpty()){
						ArrayList<Room> list1 = db.roomFilter(Integer.parseInt(NumGuests.getText()));
						
						Object[][] data = db.toData(list1);
						
						tableModel = new DefaultTableModel(data,columnNames);				
						table.setModel(tableModel);				
						table.repaint();
					}
					else{
						Date from = new Date(DateFrom.getText());
						Date to = new Date(DateTo.getText());
						
						ArrayList<Room> list1 = db.roomFilter(Integer.parseInt(NumGuests.getText()));
						ArrayList<Room> list2 = db.filter(bdb.dateFilter(from, to), list1);
						
						Object[][] data = db.toData(list2);
						
						tableModel = new DefaultTableModel(data,columnNames);				
						table.setModel(tableModel);				
						table.repaint();
					}
				}
				else if(!DateFrom.getText().isEmpty() && !DateTo.getText().isEmpty()){
					
					Date from = new Date(DateFrom.getText());
					Date to = new Date(DateTo.getText());
					
					ArrayList<Room> list =db.filter(bdb.dateFilter(from, to));
					
					Object[][] data = db.toData(list);
					
					tableModel = new DefaultTableModel(data,columnNames);				
					table.setModel(tableModel);				
					table.repaint();
				}
				else{					
					ArrayList<Room> list =db.getAllRoom();
					
					Object[][] data = db.toData(list);
					
					tableModel = new DefaultTableModel(data,columnNames);				
					table.setModel(tableModel);				
					table.repaint();
				}
			}
		});
		RefreshButton.setBounds(10, 395, 150, 25);
		add(RefreshButton);
		
		
		
		
	}

	private void refreshTable(Object[][] data) {
		tableModel = new DefaultTableModel(data,columnNames);
		table = new JTable(tableModel);
	}
}
