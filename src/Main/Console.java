package Main;

import Model.Booking;
import Model.Date;
import Model.Guest;
import Model.Room;

public class Console {
	public static void main(String[] args) {
		
	System.out.println("SEP 01 test v1...");
	System.out.println("Date class test...\n");
	
	Date d = new Date(1,1,2015);
	Date s = new Date("1/1/2015");
	
	Guest g = new Guest("Dony","Fasztudja",d,"Litván");
	
	Room r = new Room(123,"Room","Double",s,d);
	
	/*
	System.out.println("<---Syso test--->");
	System.out.println(s.toString());
	System.out.println(d.toString());
	
	System.out.println("\n<---Equals test--->");
	System.out.println(d.equals(s));
	System.out.println(s.equals(d));
	
	System.out.println("\n<---toDays test--->");
	System.out.println(d.toDays());
	
	System.out.println("\n<---Diff test--->");
	System.out.println(s.diff(d));
	
	
	System.out.println("Booking class test...");
	
	Booking b = new Booking(d, s, g, r, 1);
	System.out.println(b.getBookingGuest().getName());
	System.out.println(b.getBookingGuest().getDateOfBirth());
	System.out.println(b.getRoom().getNumber());
	System.out.println(r.getBooking().getBookingGuest());
	*/
	}
}
