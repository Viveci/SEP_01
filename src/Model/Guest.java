package Model;

import java.io.Serializable;

/**
 * @author Teperics Márton
 *	This class stores all the information of a Guest.
 *	Uses Strings to save all information.
 */
public class Guest implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

   private String name;
   private String address;
   private Date dateOfBirth;
   private String nationality;
   private String email;
   private String passport;
   private String cell;
   
   /**
 * @param name Name of the guest
 * @param address Address of the Guest
 * @param dateOfBirth The birth date of the guest
 * @param nationality Nationality of the guest
 */
   public Guest(String name, String address, Date dateOfBirth, String nationality){
      this.name = name;
      this.address = address;
      this.dateOfBirth = dateOfBirth;
      this.nationality = nationality;
      email = "UNSET";
  	  passport = "UNSET";
  	  cell = "UNSET";
   }

   /**
 * Empty argument constructor. Used to create placeholders.
 */
	public Guest() {
	name = "UNSET";
	address = "UNSET";
	nationality = "UNSET";
	email = "UNSET";
	passport = "UNSET";
	cell = "UNSET";
	dateOfBirth = new Date();
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassport() {
		return passport;
	}
	public void setPassport(String passport) {
		this.passport = passport;
	}
	public String getCell() {
		return cell;
	}
	public void setCell(String cell) {
		this.cell = cell;
	}
   
}
