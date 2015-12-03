package Model;

import Model.Date;

/**
 * This class stores the hotel's rooms
 * */

public class Room{
	
		//Room's simple variables
		private int number;
		private String type;
		private String size;
		private int price;
		
      
   public Room(int number, String type, String size, int price){
	   this.number = number;
	   this.type = type;
	   this.size = size;
	   this.price = price;
   }
   
   //Getters and setters
	public String getType(){
	      return this.type + " " + this.size;
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
  
}
