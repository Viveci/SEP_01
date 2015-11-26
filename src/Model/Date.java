package Model;

public class Date {
	
	private int day;
	private int month;
	private int year;
	private boolean isleap;
	
	private int[] months;
	
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

	public int toDays(){
		int toDay = 0, sumMonth = 0;
		toDay += this.day;
		for(int i = 0; i < this.month-1; i++){
			sumMonth += months[i];
		}
		toDay += sumMonth;
		return toDay;
	}
	
	public int diff(Date d){
		return d.toDays()-this.toDays();
	}
	
}
