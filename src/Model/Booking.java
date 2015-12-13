package Model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is the skeleton of the database. The program stores all the
 * relevant information in connection with a specific booking in a booking object.
 * Besides all the general setter and getter methods there are two constructor and one 
 * toArray method. 
 * 
 * <p> The class is Serializable. 
 * */
/**
 * @author Teperics Márton
 *
 */
public class Booking implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	//The two Date class stores the start and end date of the booking. 
	private Date from;
	private Date to;
	
	//This variable is calcualted from the two dates above. Shows how many days do the guest(s) spend there.
	private int period;
	
	//The booking guest. Used as one of the cullums on DataBasePanel
	private Guest BookingGuest;
	
	//Number of guests arriving to the same room.
	private int numGuest;
	
	//ArrayList of all the Guest objects beloning to this class. Indivudal recording is done on the CheckInPanel
	private ArrayList<Guest> guests;
	
	//Booked room.
	private Room room;
	
	//Required extras
	private Extras extras;
	
	//ID, this variable is set by the BookingDB. Used as a key in the database, simillary to SQLite, but not SQLite
	private int id;
	
	
	/**
	 * @param from The date of arrival
	 * @param to The date of departure
	 * @param bg The booking guest.
	 * @param room The booked room.
	 * @param numGuest How many guests will arrive
	 */
	public Booking(Date from, Date to, Guest bg, Room room, int numGuest){
		this.from = from;
		this.to = to;
		this.BookingGuest = bg;
		this.room = room;
		this.numGuest = numGuest;
		period =this.from.diff(this.to);
		this.extras = new Extras();
		this.guests = new ArrayList<>();
		this.guests.add(BookingGuest);
	}
	/**
	 * Empty argument constructor. Only used to make placeholders
	 */
	public Booking(){
		this.from = null;
		this.to = null;
		this.BookingGuest = null;
		this.numGuest = 0;
		this.room = null;
		this.extras = null;
		this.guests = new ArrayList<>();
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
	public ArrayList<Guest> getGuests(){
		return this.guests;
	}
	public void setGuests(ArrayList<Guest> list){
		this.guests = list;
	} 
	public Extras getExtras() {
		return extras;
	}
	public void setExtras(Extras extras) {
		this.extras = extras;
	}
	
	//This method is used to send back an Object array to the DataBasePanel. These are the columns on the JTable
	public Object[] toArray(){
		Object [] objectarr = {this.id,BookingGuest.getName(),"Room number " + room.getNumber(),room.toString(),from.toString(),to.toString()};
		return  objectarr;
	}
	
	
}
