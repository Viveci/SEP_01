package Panels;

import java.util.ArrayList;

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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModifyPanel extends JPanel {
	
	private RoomDB db = new RoomDB();
	private BookingDB bdb = new BookingDB();
	
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;	
	private static String[] columnNames = {"Room number",
        "Room type",
        "Capacity",
        "Price"};;

	private static final long serialVersionUID = 1L;
	
	public ModifyPanel(){
		setLayout(null);
		setBounds(100, 100, 800, 430);
				
				
				Object[][] data = bdb.toData();				
				tableModel = new DefaultTableModel(data,columnNames);				
				JTable table = new JTable(tableModel);
				
				scrollPane = new JScrollPane(table);
				scrollPane.setSize(500, 300);
				scrollPane.setLocation(290, 10);
				table.setFillsViewportHeight(true);
				add(scrollPane);
				
				JButton RefreshButton = new JButton("Refresh");
				RefreshButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						ArrayList<Booking> list = bdb.deserialize();
						
						Object[][] data = bdb.toData(list);						

						tableModel = new DefaultTableModel(data,columnNames);						
						table.setModel(tableModel);						
						table.repaint();
//						
//						scrollPane = new JScrollPane(table);
//						scrollPane.setSize(500, 300);
//						scrollPane.setLocation(290, 10);
//						table.setFillsViewportHeight(true);
//						add(scrollPane);
						
					}
				});
				RefreshButton.setBounds(10, 10, 100, 25);
				add(RefreshButton);
				
				JButton ClearDB = new JButton("Clear DB");
				ClearDB.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						bdb.clear();
					}
				});
				ClearDB.setBounds(10, 45, 100, 25);
				add(ClearDB);
		
	}

}

