package Model;

/**
 * This class stores all the data for a booking
 * The user of the application fills up the variables with 
 * the Guest's data and then saves as a current state
 * 
 * <p>Current state can be either modified or deleted by the program
 * */

public class Booking
{
	//Booked from ... to
	private Date from;
	private Date to;
	
	//Booked by...
	private Guest BookingGuest;
	
	//Booked the...
	private Room room;
	
	public Booking(Date from, Date to, Guest bg, Room room){
		this.from = from;
		this.to = to;
		this.BookingGuest = bg;
		this.room = room;
	}
}
