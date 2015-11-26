package Model;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	//Constructors
	public Date(int day, int month, int year){
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public Date(String s){
		String [] data = s.split(".");
		this.day = Integer.parseInt(data[0]);
		this.month = Integer.parseInt(data[1]);
		this.year = Integer.parseInt(data[2]);
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

	//self-explanatory 
	public String toString(){
		return day+"."+month+"."+year;
	}
	
	public boolean equals(Date d){
		return (this.day==d.getDay()&&this.month==d.getMonth()&&this.year==d.getYear());
	}

		
}
