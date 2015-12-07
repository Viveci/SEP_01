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
		Guest g = new Guest("Dony","Fasztudja",new Date(29,5,1995),"Litván");
		Room r = db.getRoom(1);
				
		Booking b = new Booking(from,to,g,r,1);
		
		bdb.addBooking(b);
		
		Date from1 = new Date(5,5,2015);
		Date to1 = new Date(10,5,2015);
		Guest g1 = new Guest("Dony","Fasztudja",new Date(29,5,1995),"Litván");
		Room r1 = db.getRoom(2);
				
		Booking b1 = new Booking(from1,to1,g1,r1,2);
		
		bdb.addBooking(b1);
		
		Date testFrom = new Date(4,5,2015);
		Date testTo = new Date(5,5,2015);
		
		ArrayList<Room> filter1 = db.filter(bdb.dateFilter(testFrom, testTo));
		
		System.out.println("<---All the available room from testfrom and testTo--->");
		for (int i = 0; i < filter1.size(); i++) {
			System.out.println(filter1.get(i).toString());
		}
		
		System.out.println("\n");
		ArrayList<Room> filter2 = db.roomFilter(1);
		
		System.out.println("<---All the rooms with capacity of 1--->");
		for (int i = 0; i < filter2.size(); i++) {
			System.out.println(filter2.get(i).toString());
		}
		
		System.out.println("\n");
		ArrayList<Room> filter3 = db.filter(bdb.dateFilter(testFrom, testTo), filter2);
		
		System.out.println("<---All avaialbe room with capacity one, from testFrom and testTo--->");
		for (int i = 0; i < filter3.size(); i++) {
			System.out.println(filter3.get(i).toString());
		}
		
	}
}
