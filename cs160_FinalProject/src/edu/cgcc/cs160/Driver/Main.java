//HEADER
//Program Name: cs160 Final Project
//Author: Caelen, David, Javi, Dianna
//Class: CS160 Fall 2019
//Date: 12/05/2019
//Description: Main driver, calls all methods
package edu.cgcc.cs160.Driver;

public class Main {
	//an array that contains objects		
	private static java.util.ArrayList<Object> objects = new java.util.ArrayList<Object>(); 
	public static void main(String[] args) {
				
		//get the the user input
		while(true) {
			int option = OrderEntry.selectOption();
			processOption(option);
		}
	}
	
	public static void processOption(int option) {
		/**
		 * Example 1 driver program using an if..else if..else
		 */
		//perform logic determining the option chosen by user
		//-1 = end program
		if(option == -1)
			System.exit(0);
		//1 = make new object
		else if(option == 1) {
			Order o = new Order();
			OrderEntry.newObject(o);
			objects.add(o);
			//print the object information
		}
		//2 = print existing orders
		else if(option == 2) {
			System.out.println("=====BEGIN REPORT=====");
			for(Object o : objects) {
				if(o != null) {
					OrderEntry.printObject(o);
					System.out.println();
					System.out.println();
				}
			}
			System.out.println("=====END REPORT=====");
		}
		//final error message
		else {
			System.err.println("Option selected was not understood.");
		}
	}
}
/* FOOTER
=====BEGIN REPORT=====
inSales: true
orderNumber: 1
customerNumber: 1
orderDate: 12/05/2019
customerName: Jimmy
salesAssociate: Tim
billingAddress: 123 West Ave.
shippingAddress: 123 West Ave.
productName: paper potat
amountOrdered: 2.0
pricePerUnit: 20.0
balance: 40.0
inFinance: true
payment: 40.0
newBalance: 0.0
inPackaging: true
boxed: true
labeled: true
inShipping: true
shipped: true


=====END REPORT=====
Available Options:
1 = Enter New Order
2 = Print Existing Orders
-1 = End Program
Please select an option(1 or 2):
 */
