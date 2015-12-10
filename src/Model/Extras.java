package Model;

import java.io.Serializable;

public class Extras implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Boolean smoking;
	private Boolean extraBed;
	private Boolean roomService;
	private Boolean laundry;
	
	public Extras(){
		smoking = false;
		extraBed = false;
		roomService = false;
		laundry = false;
	}
	public Extras(Boolean smoking,Boolean extraBed,Boolean roomService,Boolean laundry){
		this.smoking = smoking;
		this.extraBed = extraBed;
		this.roomService = roomService;
		this.laundry = laundry;
	}	
	
	
	
	public Boolean getSmoking() {
		return smoking;
	}
	public void setSmoking(Boolean smoking) {
		this.smoking = smoking;
	}
	public Boolean getExtraBed() {
		return extraBed;
	}
	public void setExtraBed(Boolean extraBed) {
		this.extraBed = extraBed;
	}
	public Boolean getRoomService() {
		return roomService;
	}
	public void setRoomService(Boolean roomService) {
		this.roomService = roomService;
	}
	public Boolean getaundry() {
		return laundry;
	}
	public void setlaundry(Boolean laundry) {
		this.laundry = laundry;
	}
	
}
