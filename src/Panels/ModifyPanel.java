package Panels;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import DataBase.BookingDB;
import DataBase.RoomDB;
import Model.Booking;
import Model.Date;
import Model.Guest;
import Model.Room;

public class ModifyPanel extends JPanel {
	
	private RoomDB db = new RoomDB();
	private BookingDB bdb = new BookingDB();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ModifyPanel(){
		
		
		
		//TRYTRYTRY PLACEHOLDER PLACEHOLDER SO FAR
				String[] columnNames = {"Name",
		                "Room",
		                "From",
		                "To"};
				
				//Booking object fillers
						
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
				
				Object[][] data = bdb.toData();
				
				JTable table = new JTable(data, columnNames);
				
				JScrollPane scrollPane = new JScrollPane(table);
				scrollPane.setSize(590, 221);
				scrollPane.setLocation(180, 10);
				table.setFillsViewportHeight(true);
				add(scrollPane);
		
	}

}
