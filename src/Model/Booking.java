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
	private int period;
	
	//Booked by...
	private Guest BookingGuest;
	//Number of guest in that room
	private int numGuest;
	
	//Booked the...
	private Room room;
	
	private int id;
	
	public Booking(Date from, Date to, Guest bg, Room room, int numGuest){
		this.from = from;
		this.to = to;
		this.BookingGuest = bg;
		this.room = room;
		this.numGuest = numGuest;
		period =this.from.diff(this.to);
	}
	
	public Booking(){
		this.from = null;
		this.to = null;
		this.BookingGuest = null;
		this.numGuest = 0;
		this.room = null;
	}

	//Setters and Getters
	public int getNumGuest() {
		return numGuest;
	}
	public void setNumGuest(int numGuest) {
		this.numGuest = numGuest;
	}
	public Date getFrom() {
		return from;
	}
	public void setFrom(Date from) {
		this.from = from;
	}
	public Date getTo() {
		return to;
	}
	public void setTo(Date to) {
		this.to = to;
	}
	public Guest getBookingGuest() {
		return BookingGuest;
	}
	public void setBookingGuest(Guest bookingGuest) {
		BookingGuest = bookingGuest;
	}
	public Room getRoom() {
		return room;
	}
	public void setRoom(Room room) {
		this.room = room;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public int getPeriod(){
		return period;
	}

	
}
