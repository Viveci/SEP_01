package Model;

public class Guest{

   private String name;
   private String address;
   private Date dateOfBirth;
   private String nationality;
   //private int BookingID;
   
   public Guest(String name, String address, Date dateOfBirth, String nationality){
      this.name = name;
      this.address = address;
      this.dateOfBirth = dateOfBirth;
      this.nationality = nationality;
   }
   
   	public Guest() {
	super();
}
	//Setters and Getters
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getNationality() {
		return nationality;
	}
	
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
   
}
