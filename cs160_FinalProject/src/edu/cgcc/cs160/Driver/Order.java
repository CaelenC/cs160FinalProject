//HEADER
//Program Name: cs160 Final Project
//Author: Caelen, David, Javi, Dianna
//Class: CS160 Fall 2019
//Date: 12/05/2019
//Description: Order Information

package edu.cgcc.cs160.Driver;

public class Order {
	//Simple Sheets order form:
	
	//Sales information
	//Set to int to only allow numbers in this field
	static boolean inSales;
	int orderNumber;
	int customerNumber;
	
	//Set to strings to allow flexibility
	String orderDate;
	String customerName;
	String salesAssociate;
	String billingAddress;
	String shippingAddress;
	String productName;
	
	//Set to double to account for money metrics
	double amountOrdered;
	double pricePerUnit;
	double balance;
	
	//Finance Information
	//Determine if order is in finance
	boolean inFinance;
	//Set to double to track money values
	double payment;
	double newBalance;
	
	//Packaging Values
	//Determine if order is in Packaging
	boolean inPackaging;
	//True or False values
	boolean boxed;
	boolean labeled;
			
	//Shipping Values
	//Determine if order is in shipping
	boolean inShipping;
	boolean shipped;


}