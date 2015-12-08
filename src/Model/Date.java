package Model;

import java.io.Serializable;

/**
 * Date class
 * <p>
 * This class is used to store all the dates in the project
 * uses Integer variables to store the day, month year separately.
 * */

public class Date implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int day;
	private int month;
	private int year;
	private boolean isleap;
	
	private int[] months;
	
	public Date(){
		day = -1;
		month = -1;
		year = -1;
	}
	
	//Constructors
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
		if(year%4==0){
			this.isleap = true;
			months = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		}
		else{
			this.isleap = false;
			months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
			}
	}
	public Date(String s){
		String [] split = s.split("/");
		this.day = Integer.parseInt(split[0]);
		this.month = Integer.parseInt(split[1]);
		this.year = Integer.parseInt(split[2]);
		if(this.year%4==0){
			this.isleap = true;
			months = new int[]{31,29,31,30,31,30,31,31,30,31,30,31};
		}
		else{
			this.isleap = false;
			months = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
			}
	}
	
	//Setters and Getters
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public boolean isIsleap() {
		return isleap;
	}
	public void setIsleap(boolean isleap) {
		this.isleap = isleap;
	}
	
	//self-explanatory 
	public String toString(){
		return day+"/"+month+"/"+year;
	}
	
	//Equals or not
	public boolean equals(Date d){
		return (this.day==d.getDay()&&this.month==d.getMonth()&&this.year==d.getYear());
	}
	
	/**
	 * @return Returns how many days passed in a year*/
	public int toDays(){
		int toDay = 0, sumMonth = 0;
		toDay += this.day;
		for(int i = 0; i < this.month-1; i++){
			sumMonth += months[i];
		}
		toDay += sumMonth;
		return toDay;
	}
	
	/**
	 * @return Returns the difference from the other date object in days*/
	public int diff(Date d){
		return d.toDays()-this.toDays();
	}
	
}
