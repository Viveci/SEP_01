package Panels;

import java.util.ArrayList;

import javax.swing.JFrame;
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

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private static String[] columnNames = {"Booking guest",
        "Room number","Room type",
        "Date from",
        "Date to"};;

	private static final long serialVersionUID = 1L;
	private JTextField NameText;
	private JTextField RoomNumText;
	private JTextField DateFromText;
	private JTextField DateToText;
	
	private String name;
	private int roomNumber;
	private Date from;
	private Date to;
	
	private int checkout = 1;
	
	public DataBasePanel(){
		setLayout(null);
		setBounds(100, 100, 800, 430);
		
		name = "";
		roomNumber = -1;
		from = null;
		to = null;
				
				
				Object[][] data = bdb.toData();				
				tableModel = new DefaultTableModel(data,columnNames);				
				
		//<----------------------------Table Panel----------------------------------------->
				TablePanel = new JPanel();
				TablePanel.setBounds(10, 10, 770, 300);
				add(TablePanel);
				TablePanel.setLayout(null);
				table = new JTable(tableModel);				
				scrollPane = new JScrollPane(table);
				scrollPane.setBounds(0, 0, 770, 300);
				TablePanel.add(scrollPane);
				table.setFillsViewportHeight(true);
		//<----------------------------Table Panel----------------------------------------->
				
		//<----------------------------Table Panel----------------------------------------->
				
				CheckoutPanel checkoutpanel = new CheckoutPanel();
				checkoutpanel.setBounds(10, 10, 770, 300);
				add(checkoutpanel);
				checkoutpanel.setVisible(false);
				
		//<----------------------------Table Panel----------------------------------------->
				
				
				JButton RefreshButton = new JButton("Refresh");
				RefreshButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
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
						bdb.clear();
					}
				});
				ClearDB.setBounds(680, 395, 100, 25);
				add(ClearDB);
				
				
				//Genereated design
				JLabel lblName = new JLabel("Name");
				lblName.setBounds(10, 325, 46, 14);
				lblName.setFont(new Font("Arial", Font.PLAIN, 14));
				add(lblName);
				
				NameText = new JTextField();
				NameText.setToolTipText("Guest name");
				NameText.setBounds(100, 320, 150, 20);
				add(NameText);
				NameText.setColumns(10);
				
				RoomNumText = new JTextField();
				RoomNumText.setToolTipText("Guest name");
				RoomNumText.setColumns(10);
				RoomNumText.setBounds(100, 346, 150, 20);
				add(RoomNumText);
				
				JLabel RoomLabel = new JLabel("Room number");
				RoomLabel.setFont(new Font("Arial", Font.PLAIN, 14));
				RoomLabel.setBounds(10, 351, 80, 14);
				add(RoomLabel);
				
				DateFromText = new JTextField();
				DateFromText.setToolTipText("Guest name");
				DateFromText.setColumns(10);
				DateFromText.setBounds(100, 371, 150, 20);
				add(DateFromText);
				
				JLabel DateFromLabel = new JLabel("Date From");
				DateFromLabel.setFont(new Font("Arial", Font.PLAIN, 14));
				DateFromLabel.setBounds(10, 376, 80, 14);
				add(DateFromLabel);
				
				DateToText = new JTextField();
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
				
				JButton CheckoutButton = new JButton("Check out");
				CheckoutButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						checkout *= -1;
						if(checkout>0){
							TablePanel.setVisible(true);
							checkoutpanel.setVisible(false);
						}
						else{
							TablePanel.setVisible(false);
							checkoutpanel.setVisible(true);
						}
					}
				});
				CheckoutButton.setBounds(380, 396, 120, 25);
				add(CheckoutButton);
				
				JButton CheckinButton = new JButton("Check in");
				CheckinButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				CheckinButton.setBounds(380, 368, 120, 25);
				add(CheckinButton);
				
				JButton EditButton = new JButton("Edit booking");
				EditButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				EditButton.setBounds(380, 340, 120, 25);
				add(EditButton);
				
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				separator.setBackground(Color.LIGHT_GRAY);
				separator.setBounds(370, 310, 2, 120);
				add(separator);
		
	}
	
	private void refreshTable(Object[][] data) {
		tableModel = new DefaultTableModel(data,columnNames);						
		table.setModel(tableModel);						
		table.repaint();						
	}
}

