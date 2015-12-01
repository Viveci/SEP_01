package Model;

import java.util.Date;

public class Guest
{

   private String name;
   private String address;
   private int number;
   private int dateOfBirth;
   private String nationality;
   private Date from;
   private Date to;
   
   public Guest(String name, String address, int number, int dateOfBirth, String nationality){
      this.name = name;
      this.address = address;
      this.number = number;
      this.dateOfBirth = dateOfBirth;
      this.nationality = nationality;
   }
   
   public String getName()
   {
      return name;
   }

   public void setName(String name)
   {
      this.name = name;
   }

   public String getAddress()
   {
      return address;
   }

   public void setAddress(String address)
   {
      this.address = address;
   }

   public int getNumber()
   {
      return number;
   }

   public void setNumber(int number)
   {
      this.number = number;
   }

   public int getDateOfBirth()
   {
      return dateOfBirth;
   }

   public void setDateOfBirth(int dateOfBirth)
   {
      this.dateOfBirth = dateOfBirth;
   }

   public String getNationality()
   {
      return nationality;
   }

   public void setNationality(String nationality)
   {
      this.nationality = nationality;
   }
   
   public void setRentedFrom(Date date){
      this.from = date;
   }
   public Date getRentedFrom(){
      return from;
   }
   public void setRentedTo(Date date){
      this.to = date;
   }
   public Date getRentedTo(){
     return to;
   }
}
