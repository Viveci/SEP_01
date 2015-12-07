package DataBase;

import java.util.ArrayList;

import Model.Booking;
import Model.Date;

public class BookingDB {
	
	private ArrayList<Booking> db;
	private static int id;
	
	public BookingDB(){
		this.db = new ArrayList<>();
		id = 1;
	}
	
	public void addBooking(Booking b){
		b.setId(id);
		db.add(b);
		id++;
	}
	
	public Booking getBooking(int id){
		Booking b = new Booking();
		for (int i = 0; i < db.size(); i++){
			if(db.get(i).getId()==id){
				b = db.get(i);
			}
		}
		return b;
	}

	/**
	 * This method is used to find which apartments are available on a certain time period.
	 * @return Returns an Integer array, filled with the taken room's numbers*/
	public int[] dateFilter(Date from, Date to){
		int counter = 0;
		
		for (int i = 0; i < db.size(); i++) {
			if(to.toDays()<=db.get(i).getTo().toDays() && from.toDays() >= db.get(i).getFrom().toDays() ||
					(to.toDays()>db.get(i).getTo().toDays() && from.toDays()>= db.get(i).getFrom().toDays()) ||
					(from.toDays()<db.get(i).getFrom().toDays() && to.toDays() > db.get(i).getFrom().toDays())){
				counter++;
			}
		}
		
		System.out.println(counter);
		int[] ids = new int[counter];
		
		counter=0;
		
		for (int i = 0; i < db.size(); i++) {
			if(to.toDays()<=db.get(i).getTo().toDays() && from.toDays() >= db.get(i).getFrom().toDays() ||
					(to.toDays()>db.get(i).getTo().toDays() && from.toDays()>= db.get(i).getFrom().toDays()) ||
					(from.toDays()<db.get(i).getFrom().toDays() && to.toDays() > db.get(i).getFrom().toDays())){
				ids[counter] = db.get(i).getRoom().getNumber();
				counter++;
			}
		}
		return ids;
	}

}
