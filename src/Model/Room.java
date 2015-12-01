package Model;



import java.util.Date;

public class Room
{
   
   public int number;
   public String type;
   public String size;
   private Guest guest;
   
   
   public Room(int number, String type, String size, Date startDate, Date endDate){
      this.number = number;
      this.type = type;
      this.size = size;
      this.guest = new Guest(null, null, 0, 0, null);
     
      
     
   }
   public void setNumber(int number){
      this.number = number;
   }
   public int getNumber(){
      return number;
   }
   public String getType(){
      String m,n = null;
      
      if (type.equals("Room")){
         n = "Room";
         if (size.equals("Double")){
            m = "Double";
         }
         else if (size.equals("Single")){
            m = "Single";
         }
         else{
            m = null;
         }
         return n + " " +m;
      }
   else if (type.equals("Suite")){
         n = "Suite";
         
         if (size.equals("SingleBedroom")){
            m = "SingleBedroom";
         }
         else if (size.equals("2Bedrooms")){
            m = "2Bedrooms";
         }
         else if (size.equals("3Bedrooms")){
            m = "3Bedrooms";
         }
         else{
            m = null;
         }
         return n + " " +m;
         
      }
      else{
         m = null;
      }
      return m;
   }

   public boolean RoomIsAvailable(){
      return guest ==null;
   }
   public boolean isOccupied(){
      return guest != null; 
   }
   public void bookGuest(Guest guest){
      this.guest = guest;
   }
   
  
}
