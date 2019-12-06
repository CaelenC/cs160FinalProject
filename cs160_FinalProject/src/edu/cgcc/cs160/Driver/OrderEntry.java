//HEADER
//Program Name: cs160 Final Project
//Author: Caelen, David, Javi, Dianna
//Class: CS160 Fall 2019
//Date: 12/05/2019
//Description: Order Entry scanner class

package edu.cgcc.cs160.Driver;

import java.util.Scanner;
import java.lang.reflect.*;


public class OrderEntry {
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	 * Request information for a given object
	 * @param o
	 * @return
	 */
	//Creates an object to be filled with data values from user
	public static boolean newObject(Object o) {
		//Starts false so that it must be called to create the object
		boolean created = false;
		Field[] fields = o.getClass().getDeclaredFields();
		//Tells user to expect a prompt
		System.out.println("Creating new Order:");
		//Uses generalized message to call all data from the Order class
		for(Field field : fields) {
			//if the values are booleans, print extra information
			System.out.println("Enter value for " + field.getName() + ": ");
			if(field.getName() == "inSales" || field.getName() == "inFinance" ||
					field.getName() == "inPackaging" || field.getName() == "boxed" ||
					field.getName() == "labeled" || field.getName() == "inShipping" ||
					field.getName() == "shipped") {
				System.out.print("true/false (?)");
			}
			String entry = scanner.nextLine();
			
			//Interprets scanner inputs to their respective data types
			try {				
				if(field.getType().toString().toLowerCase().contains("string"))
					field.set(o, entry.trim());
				
				else if(field.getType().toString().toLowerCase().contains("int"))
					field.set(o, Integer.parseInt(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("boolean"))
					field.set(o, Boolean.parseBoolean(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("char"))
					field.set(o, entry.charAt(0));
				
				else if(field.getType().toString().contains("double"))
					field.set(o, Double.parseDouble(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("float"))
					field.set(o, Float.parseFloat(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("long"))
					field.set(o, Long.parseLong(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("short"))
					field.set(o, Short.parseShort(entry.trim()));
				
				else if(field.getType().toString().toLowerCase().contains("byte"))
					field.set(o, Byte.parseByte(entry.trim()));
				//Exception handling if the data type is unrecognized
				else
					throw new Exception("Unable to set " + field.getName());
				
			}
			//Exception handling for the creation of the object, telling the user if something went wrong
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return created;
	}
	
	/**
	 * Print object information
	 * @param o
	 * @return
	 */
	//Method to print created objects
	public static boolean printObject(Object o) {
		boolean created = false;
		Field[] fields = o.getClass().getDeclaredFields();
		for(Field field : fields) {
			try {				
				System.out.print(field.getName() + ": ");
				System.out.println(field.get(o));
			}
			//Exception handling if something is not recognized
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
		return created;
	}
	
	/**
	 * Expand array as new objects are added
	 * @param objects
	 * @param o
	 * @return
	 */

	
		/*
		 * else { Object[] temp = new Object[objects.length + 2]; temp =
		 * objects.clone(); temp[temp.length - 2] = o; return temp; }
		 * 
		 * return null;
		 */
	
	/**
	 * A method to select whether to create a new order or find an existing order.
	 * @return option 1 to create new order, 2 to search existing order
	 * or -1 if the option wasn't understood.
	 */
	public static int selectOption() {
		//Tells the user user what to do
		System.out.println("Available Options:\n1 = Enter New Order\n2 = Print Existing Orders\n-1 = End Program");
		System.out.println("Please select an option(1 or 2):");
		while(scanner.hasNextLine()) {
			try {
				int entry = Integer.parseInt(scanner.nextLine());
				switch(entry) {
					//Calls method to create new order
					case 1: 
						return 1;
					//Calls method that displays previous orders	
					case 2:
						return 2;
					//Ends the program	
					case -1:
						return -1;
					default:
						throw new Exception("The value was not between 1 or 2.");
				}
			}
			catch(NumberFormatException e) {
				System.err.println("You must enter a valid number. Try again:");
			}
			catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
		return -1;
	}
}