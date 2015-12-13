package Model;

import java.io.Serializable;


/**
 * @author Teperics Márton
 *	This class stores the infomration of one room.
 *	The RoomDB creates 25 objects from this class, declaring all the possible variety of rooms in the hotel.
 */
public class Room implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Room's simple variables
	//Room number
	private int number;
	// Room's type. Either Suite or Room
	private String type;
	// Room's size. Single, Double, King sized or One, Two, Three bedroom. (First is for rooms, latter is for suites)
	private String size;
	//Price of the room
	private int price;
	//Capacity of the room. How many ppl can book it.
	private int capacity;
		
      
   public Room(int number, String type, String size, int price){
	   this.number = number;
	   this.type = type;
	   this.size = size;
	   this.price = price;
	   
	   if(size.equals("Single")){
		   capacity = 1;
	   }
	   else if(size.equals("Twin")){
		   capacity = 2;
	   }
	   else if(size.equals("KingSized")){
		   capacity = 2;
	   }
	   else if(size.equals("One")){
		   capacity = 1;
	   }
	   else if(size.equals("Two")){
		   capacity = 2;
	   }
	   else if(size.equals("Three")){
		   capacity = 3;
	   }
   }
   
   public Room(){
	number = -1;
	type = "Not set";
	size = "Not set";
	price = -1;
	capacity = -1;
   }
   //Getters and setters
	public String getType(){
	      return this.type;
	   }
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public void setType(String type) {
	this.type = type;
}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCapacity(){
		return capacity;
	}
	
	//toString 
	public String toString(){
		return this.type + " " + this.size;
	}
	
	/**
	 * @return Returns an Object array. These elements are the columns of the BookingPanel's JTable.
	 */
	public Object[] toArray(){
		Object [] data = {"Room number " + number, this.toString(), capacity, price};
		return data;
	}
}
