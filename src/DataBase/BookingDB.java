package DataBase;

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

public class BookingDB implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Booking> db;
	private static int id;
	
	public BookingDB(){
		this.db = this.deserialize();
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
	
	public Object[][] toData(){
		Object[][] data = new Object[db.size()][5];
		
		for(int i = 0; i< db.size();i++){
			Object[] temp = db.get(i).toArray();
			for(int o = 0; o< 5; o++){
				data[i][o] = temp[o];
			}
		}
		return data;
	}
	
	public Object[][] toData(ArrayList<Booking> list){
		Object[][] data = new Object[list.size()][5];
		
		for(int i = 0; i< list.size();i++){
			Object[] temp = list.get(i).toArray();
			for(int o = 0; o< 5; o++){
				data[i][o] = temp[o];
			}
		}
		return data;
	}
	
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

	public void clear() {
		db = new ArrayList<Booking>();
		this.serialize();
	}
	
}
