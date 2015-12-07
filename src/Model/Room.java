package Model;

/**
 * This class stores the hotel's rooms
 * */

public class Room{
	
	//Room's simple variables
	private int number;
	private String type;
	private String size;
	private int price;
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
  
	public String toString(){
		return this.type + " " + this.size;
	}
	
	public int getCapacity(){
		return capacity;
	}
	
	public Object[] toArray(){
		Object [] data = {"Room number " + number, this.toString(), capacity, price};
		return data;
	}
}
