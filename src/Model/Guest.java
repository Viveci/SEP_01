package Model;

public class Guest{

   private String name;
   private String address;
   private int number;
   private Date dateOfBirth;
   private String nationality;
   private Date from;
   private Date to;
   
   public Guest(String name, String address, int number, Date dateOfBirth, String nationality){
      this.name = name;
      this.address = address;
      this.number = number;
      this.dateOfBirth = dateOfBirth;
      this.nationality = nationality;
   }
}
