package Main;

import Model.Date;

public class Console {
	public static void main(String[] args) {
		
	System.out.println("SEP 01 test v1...");
	System.out.println("Date class test...\n");
	
	Date d = new Date(26,11,2015);
	Date c = new Date(27,11,2015);
	Date v = new Date(26,11,2015);
	
	System.out.println("<---Syso test--->");
	System.out.println(d.toString());
	System.out.println(c.toString());
	
	System.out.println("\n<---Equals test--->");
	System.out.println(d.equals(c));
	System.out.println(d.equals(d));
	System.out.println(d.equals(v));
	}
}
