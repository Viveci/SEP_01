package Model;

import java.util.Date;

/**
 * This class stores the hotel's rooms
 * */

public class Room{
	
		//Room's simple variables
		private int number;
		private String type;
		private String size;
		private Date from;
		private Date to;
		
		//Room's own connections
		private Guest guest;
		private Booking booking;
      
   public Room(int number, String type, String size, Date startDate, Date endDate){
	   this.number = number;
	   this.type = type;
	   this.size = size;
	   this.from = startDate;
	   this.to = endDate;
	   
   }
   
   public int getNumber(){
	   return number;
   }
   public String getType(){
      return this.type + " " + this.size;
   }
   public boolean RoomIsAvailable(){
      return guest ==null;
   }
   public boolean isOccupied(){
      return guest != null; 
   }
   public void bookGuest(Guest guest){
      this.guest = guest;
   }
   
  
}
