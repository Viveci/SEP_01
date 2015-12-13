package DataBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Model.Booking;
import Model.Date;

/**
 * @author Teperics Márton
 *	<p>This class is responsible for handling all the recorded bookings. 
 *	All the booking are stored in an ArrayList. The records can be filtered by various inputs.
 *	The class assigns an ID for each booking, and later it is used to modify or delete them.
 *	<p>The serialization of the database is handled here as well. The two method, serialize and deserialize handles it.
 *	
 */
public class BookingDB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//"Database"
	private ArrayList<Booking> db;
	//Id for the bookings
	private int id;
	
	/**
	 * The constructor checks if the file exists. If not, the first creatse an empty file with an empty db.
	 * If the file existed, it reads in and sets the id accordingly.
	 */
	public BookingDB(){
		File yourFile = new File("db.ser");
		if(!yourFile.exists()) {
			db = new ArrayList<>();
			this.serialize();
		}
		try{
			this.db = this.deserialize();
			id = db.get(db.size()-1).getId()+1;}
		catch (ArrayIndexOutOfBoundsException e){
				db = new ArrayList<>(); 
				id =1;
		}
	}
	
	
	/**
	 * @param b Adds a booking to the database. Sets it's id.
	 */
	public void addBooking(Booking b){
		b.setId(id);
		db.add(b);
		id++;
	}
	
	
	/**
	 * @param id The id of the searched booking.
	 * @return Returns the matching id booking.
	 */
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
	 * @param b The modified booking. Updates it in the database
	 */
	public void setBooking(Booking b){
		for (int i = 0; i < db.size(); i++) {
			if(db.get(i).getId()==b.getId()){
				db.remove(i);
				db.add(b);
			} 
		}
	}
	
	
	/**
	 * This method is used to find which apartments are available on given time periods.
	 * @return Returns an Integer array, filled with the taken room's numbers. This array is used by the RoomDB to filter out the taken rooms.*/
	public int[] dateFilter(Date from, Date to){
		int counter = 0;
		
		for (int i = 0; i < db.size(); i++) {
			if((from.toDays()>=db.get(i).getFrom().toDays() && to.toDays()<=db.get(i).getTo().toDays()) ||
					(from.toDays()<=db.get(i).getFrom().toDays() && to.toDays()>=db.get(i).getFrom().toDays()) ||
					(to.toDays()>=db.get(i).getTo().toDays() && from.toDays()<=db.get(i).getTo().toDays()) ||
					(from.toDays()<=db.get(i).getFrom().toDays() && to.toDays()>=db.get(i).getTo().toDays())){
				counter++;
			}
		}
		
		int[] ids = new int[counter];
		
		counter=0;
		
		for (int i = 0; i < db.size(); i++) {
			if((from.toDays()>=db.get(i).getFrom().toDays() && to.toDays()<=db.get(i).getTo().toDays()) ||
					(from.toDays()<=db.get(i).getFrom().toDays() && to.toDays()>=db.get(i).getFrom().toDays()) ||
					(to.toDays()>=db.get(i).getTo().toDays() && from.toDays()<=db.get(i).getTo().toDays()) ||
					(from.toDays()<=db.get(i).getFrom().toDays() && to.toDays()>=db.get(i).getTo().toDays())){
				ids[counter] = db.get(i).getRoom().getNumber();
				counter++;
			}
		}
		return ids;
	}
	
	
	/**
	 * @return Object[][] Used to fill up the JTable with data. 
	 */
	public Object[][] toData(){
		Object[][] data = new Object[db.size()][6];
		
		for(int i = 0; i< db.size();i++){
			Object[] temp = db.get(i).toArray();
			for(int o = 0; o< 6; o++){
				data[i][o] = temp[o];
			}
		}
		return data;
	}
	
	
	
	/**
	 * @param list Takes in an ArrayList of bookins
	 * @return Returns Object [][] to fill up the JTable. This emthod is used after filtering
	 */
	public Object[][] toData(ArrayList<Booking> list){
		Object[][] data = new Object[list.size()][6];
		
		for(int i = 0; i< list.size();i++){
			Object[] temp = list.get(i).toArray();
			for(int o = 0; o< 6; o++){
				data[i][o] = temp[o];
			}
		}
		return data;
	}
	
	
	

	
	/**
	 * Serializes the database. Writes out the file with all the recorded bookings.
	 */
	@SuppressWarnings("resource")
	public void serialize(){
		try {
		    FileOutputStream outputStream=new FileOutputStream("db.ser");
		    ObjectOutputStream objectOutputStream= new ObjectOutputStream(outputStream);
		    objectOutputStream.writeObject(db);
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}
	
	
	
	/**
	 * @return Returns the read in database in an ArrayList. These are all the previoously serialized bookings.
	 */
	@SuppressWarnings({ "unchecked", "resource" })
		public ArrayList<Booking> deserialize(){
		ArrayList<Booking> list = new ArrayList<>();
		try {
		    FileInputStream inputStream=new FileInputStream("db.ser");
		    ObjectInputStream objectInputStream =new ObjectInputStream(inputStream);
		    list= (ArrayList<Booking>) objectInputStream.readObject();
		    
		} catch (FileNotFoundException e) {
		    e.printStackTrace();
		} catch (IOException e) {
		    e.printStackTrace();
		} catch (ClassNotFoundException e) {
		    e.printStackTrace();
		}
		return list;
	}

	

	/**
	 * Clears the database. Only used after a confirmation.
	 */
	public void clear() {
		db = new ArrayList<Booking>();
		this.serialize();
	}

	public ArrayList<Booking> filter(String name,ArrayList<Booking> list) {
		ArrayList<Booking> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getBookingGuest().getName().equals(name)){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	public ArrayList<Booking> filter(int roomNumber, ArrayList<Booking> list) {
		ArrayList<Booking> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getRoom().getNumber()==roomNumber){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	public ArrayList<Booking> filterf(Date date, ArrayList<Booking> list) {
		ArrayList<Booking> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getFrom().equals(date)){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	public ArrayList<Booking> filtert(Date date, ArrayList<Booking> list) {
		ArrayList<Booking> list1 = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i).getTo().equals(date)){
				list1.add(list.get(i));
			}
		}
		return list1;
	}
	
	public void deleteBooking(int id){
		for (int i = 0; i < db.size(); i++) {
			if(id==db.get(i).getId()){
				db.remove(i);
			}
		}
	}
	
}
