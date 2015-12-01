package Main;

import Model.Date;

public class Console {
	public static void main(String[] args) {
		
	System.out.println("SEP 01 test v1...");
	System.out.println("Date class test...\n");
	
	Date d = new Date(31,12,2015);
	Date c = new Date(1,3,2015);
	Date v = new Date(1,3,2015);
	Date s = new Date("1/1/2015");
	
	System.out.println("<---Syso test--->");
	System.out.println(s.toString());
	System.out.println(d.toString());
	
	System.out.println("\n<---Equals test--->");
	System.out.println(d.equals(c));
	System.out.println(d.equals(d));
	System.out.println(d.equals(v));
	
	System.out.println("\n<---toDays test--->");
	System.out.println(d.toDays());
	
	System.out.println("\n<---Diff test--->");
	System.out.println(s.diff(v));
	}
}
