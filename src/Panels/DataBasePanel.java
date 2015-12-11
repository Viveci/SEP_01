package Panels;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javafx.scene.control.TextFormatter;

import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DataBase.BookingDB;
import DataBase.RoomDB;
import Model.Booking;
import Model.Date;
import Model.Guest;
import Model.Room;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSeparator;

import java.awt.Color;

import javax.swing.SwingConstants;

public class DataBasePanel extends JPanel {
	
	private RoomDB db = new RoomDB();
	private BookingDB bdb = new BookingDB();
	
	private JPanel TablePanel; 
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JTable table;
	private static String[] columnNames = {"Id","Booking guest",
        "Room number","Room type",
        "Date from",
        "Date to"};;

	private static final long serialVersionUID = 1L;
	private JTextField NameText;
	private JTextField RoomNumText;
	private JTextField DateFromText;
	private JTextField DateToText;
	
	private JButton CheckinButton;
	private JButton CheckoutButton;
	private JButton EditButton;
	
	private CheckinPanel CheckinPanel;
	private CheckoutPanel CheckoPanel;
	private ModifyPanel ModifyPanel;
	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	private String name;
	private int roomNumber;
	private Date from;
	private Date to;
	
	private int checkout = 1;
	private int edit = 1;
	private int checkin = 1; 
	
	public DataBasePanel(){
		setLayout(null);
		setBounds(100, 100, 800, 430);
		
		name = "";
		roomNumber = -1;
		from = null;
		to = null;
		
		//Placeholder Booking UnUSED
		Date blank1 = new Date();
		Date blank2 = new Date();
		Guest g = new Guest("NULL","NULL",new Date(),"NULL");
		Room r = db.getRoom(1);
		Booking b = new Booking(blank1,blank2,g,r,1);
		
		Booking blank = new Booking();
		CheckinPanel = new CheckinPanel(b);
		CheckoPanel = new CheckoutPanel(b);
		ModifyPanel = new ModifyPanel(b);
				
				Object[][] data = bdb.toData();				
				tableModel = new DefaultTableModel(data,columnNames);				
				
		//<----------------------------Table Panel----------------------------------------->
				TablePanel = new JPanel();
				TablePanel.setBounds(10, 10, 770, 300);
				add(TablePanel);
				TablePanel.setLayout(null);
				table = new JTable(new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"Id", "Booking guest", "Room number", "Room type", "Date from", "Date to"
					}
				));				
				
				refreshTable(data);
				
				table.addMouseListener(new MouseAdapter(){
				    public void mouseClicked(MouseEvent evnt) {
				        if (evnt.getClickCount() == 1) {
				        	System.out.println(table.getValueAt(table.getSelectedRow(), 0).toString());
				        	CheckinButton.setEnabled(true);
				        	CheckoutButton.setEnabled(true);
				        	EditButton.setEnabled(true);
				         }
				        else{
				        	CheckinButton.setEnabled(false);
				        	CheckoutButton.setEnabled(false);
				        	EditButton.setEnabled(false);
				        }
				     }
				});
				
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(0, 0, 770, 300);
				TablePanel.add(scrollPane);
				table.setFillsViewportHeight(true);
		//<----------------------------Table Panel----------------------------------------->				
				
			JButton RefreshButton = new JButton("Refresh");
			RefreshButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					bdb = new BookingDB();
					
					ArrayList<Booking> list = bdb.deserialize();						
					Object[][] data = bdb.toData(list);
					
					refreshTable(data);
					
				}

				
			});
			RefreshButton.setBounds(680, 368, 100, 25);
			add(RefreshButton);
			
			JButton ClearDB = new JButton("Clear DB");
			ClearDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 JDialog.setDefaultLookAndFeelDecorated(true);
					    int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
					        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
					    if (response == JOptionPane.NO_OPTION) {
					    } else if (response == JOptionPane.YES_OPTION) {
					      bdb.clear();
					    } else if (response == JOptionPane.CLOSED_OPTION) {
					    }
				}
			});
			ClearDB.setBounds(680, 395, 100, 25);
			add(ClearDB);
			
			
			JLabel lblName = new JLabel("Name");
			lblName.setBounds(10, 325, 46, 14);
			lblName.setFont(new Font("Arial", Font.PLAIN, 14));
			add(lblName);
			
			NameText = new JTextField();
			NameText.setToolTipText("Guest name");
			NameText.setBounds(100, 320, 150, 20);
			add(NameText);
			NameText.setColumns(10);
			
			NumberFormat format = NumberFormat.getInstance();
		    NumberFormatter formatter = new NumberFormatter(format);
		    formatter.setValueClass(Integer.class);
		    formatter.setMinimum(0);
		    formatter.setMaximum(Integer.MAX_VALUE);
			
			RoomNumText = new JFormattedTextField(formatter);
			RoomNumText.setToolTipText("Guest name");
			RoomNumText.setColumns(10);
			RoomNumText.setBounds(100, 346, 150, 20);
			add(RoomNumText);
			
			JLabel RoomLabel = new JLabel("Room number");
			RoomLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			RoomLabel.setBounds(10, 351, 80, 14);
			add(RoomLabel);
			
			DateFromText = new JFormattedTextField(dateFormat);
			DateFromText.setToolTipText("Guest name");
			DateFromText.setColumns(10);
			DateFromText.setBounds(100, 371, 150, 20);
			add(DateFromText);
			
			JLabel DateFromLabel = new JLabel("Date From");
			DateFromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
			DateFromLabel.setBounds(10, 376, 80, 14);
			add(DateFromLabel);
			
			DateToText = new JFormattedTextField(dateFormat);
			DateToText.setToolTipText("Guest name");
			DateToText.setColumns(10);
			DateToText.setBounds(100, 399, 150, 20);
			add(DateToText);
			
			JLabel DateToLAbel = new JLabel("Date To");
			DateToLAbel.setFont(new Font("Arial", Font.PLAIN, 14));
			DateToLAbel.setBounds(10, 404, 80, 14);
			add(DateToLAbel);
			
			JButton ClearFilterButton = new JButton("Clear Filter");
			ClearFilterButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					DateFromText.setText("");
					DateToText.setText("");
					RoomNumText.setText("");
					NameText.setText("");
					ArrayList <Booking> list = bdb.deserialize();
					Object[][] data = bdb.toData(list);
					refreshTable(data);
				}
			});
			ClearFilterButton.setBounds(260, 395, 100, 25);
			add(ClearFilterButton);
			
			JButton FilterButton = new JButton("Filter");
			FilterButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList <Booking> list = bdb.deserialize();
					if(!NameText.getText().isEmpty()){
						name = NameText.getText();
						list = bdb.filter(name,list);
					}
					if(!RoomNumText.getText().isEmpty()){
						roomNumber = Integer.parseInt(RoomNumText.getText());
						list = bdb.filter(roomNumber,list);
					}
					if(!DateFromText.getText().isEmpty()){
						from = new Date(DateFromText.getText());
						list = bdb.filterf(from,list);
					}
					if(!DateToText.getText().isEmpty()){
						to = new Date(DateToText.getText());
						list = bdb.filtert(to,list);
					}
					Object[][] data = bdb.toData(list);
					refreshTable(data);
				}
			});
			FilterButton.setBounds(260, 368, 100, 25);
			add(FilterButton);
			
			CheckoutButton = new JButton("Check out");
			CheckoutButton.setEnabled(false);
			CheckoutButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					checkout *= -1;
					if(checkout>0){
						CheckoPanel.setVisible(false);
						TablePanel.setVisible(true);
					}
					else{
						Booking temp = bdb.getBooking((int)table.getValueAt(table.getSelectedRow(), 0));
						CheckoPanel = new CheckoutPanel(temp);
						CheckoPanel.setBounds(10, 10, 770, 300);
						add(CheckoPanel);
						TablePanel.setVisible(false);
						CheckoPanel.setVisible(true);		
					}
					if (checkin<0) {
						checkin*=-1;
						CheckinPanel.setVisible(false);
					}
					if (edit<0) {
						edit*=-1;
						ModifyPanel.setVisible(false);
					}
				}
			});
			CheckoutButton.setBounds(380, 396, 120, 25);
			add(CheckoutButton);
			
			CheckinButton = new JButton("Check in");
			CheckinButton.setEnabled(false);
			CheckinButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkin *=-1;
					if(checkin>0){
						CheckinPanel.setVisible(false);	
						TablePanel.setVisible(true);
						Booking temp = null;
					}
					else{
						Booking temp = bdb.getBooking((int)table.getValueAt(table.getSelectedRow(), 0));
						CheckinPanel = new CheckinPanel(temp);
						CheckinPanel.setBounds(10, 10, 770, 300);
						add(CheckinPanel);
						CheckinPanel.setVisible(true);	
						TablePanel.setVisible(false);
					}
					if (edit<0) {
						edit*=-1;
						ModifyPanel.setVisible(false);
						
					}
					if (checkout<0) {
						checkout*=-1;
						CheckoPanel.setVisible(false);
					}
				}
			});
			CheckinButton.setBounds(380, 368, 120, 25);
			add(CheckinButton);
			
			EditButton = new JButton("Edit booking");
			EditButton.setEnabled(false);
			EditButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edit *=-1;
					
					if(edit>0){
						TablePanel.setVisible(true);
						ModifyPanel.setVisible(false);
					}
					else{
						Booking temp = bdb.getBooking((int)table.getValueAt(table.getSelectedRow(), 0));
						ModifyPanel = new ModifyPanel(temp);
						ModifyPanel.setBounds(10, 10, 770, 300);
						add(ModifyPanel);
						TablePanel.setVisible(false);
						ModifyPanel.setVisible(true);
					}
					if (checkin<0) {
						checkin*=-1;
						CheckinPanel.setVisible(false);
					}
					if (checkout<0) {
						checkout*=-1;
						CheckoPanel.setVisible(false);
					}
				}
			});
			EditButton.setBounds(380, 340, 120, 25);
			add(EditButton);
			
			JSeparator separator = new JSeparator();
			separator.setOrientation(SwingConstants.VERTICAL);
			separator.setBackground(Color.LIGHT_GRAY);
			separator.setBounds(370, 310, 2, 120);
			add(separator);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(0, 310, 800, 4);
			add(separator_1);
		
	}
	
	private void refreshTable(Object[][] data) {
		tableModel = new DefaultTableModel(data,columnNames);	
		table.setModel(tableModel);						
		table.repaint();						
	}
}