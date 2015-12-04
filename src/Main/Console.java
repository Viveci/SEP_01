package Main;

import java.util.ArrayList;

import DataBase.BookingDB;
import DataBase.RoomDB;
import Model.Booking;
import Model.Date;
import Model.Guest;
import Model.Room;

public class Console {
	public static void main(String[] args) {
		
		RoomDB db = new RoomDB();
		BookingDB bdb = new BookingDB();
		
		
		//Booking object fillers
		Date from = new Date(5,5,2015);
		Date to = new Date(10,5,2015);
		Guest g = new Guest("Dony","Fasztudja",new Date(29,05,1995),"Litván");
		Room r = new Room(1,"Suite","One",220);
				
		Booking b = new Booking(from,to,g,r,1);
		
		bdb.addBooking(b);
		
		Date from1 = new Date(5,5,2015);
		Date to1 = new Date(10,5,2015);
		Guest g1 = new Guest("Dony","Fasztudja",new Date(29,05,1995),"Litván");
		Room r1 = new Room(2,"Suite","One",220);
				
		Booking b1 = new Booking(from1,to1,g1,r1,2);
		
		bdb.addBooking(b1);
		
		Date testFrom = new Date(5,5,2015);
		Date testTo = new Date(11,5,2015);
		
		ArrayList<Room> filter = db.filter(bdb.dateFilter(testFrom, testTo));
		
		for (int i = 0; i < filter.size(); i++) {
			System.out.println(filter.get(i).toString());
		}
		
	}
}
