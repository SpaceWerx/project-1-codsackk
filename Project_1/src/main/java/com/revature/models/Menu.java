package com.revature.models;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		Scanner scanned = new Scanner(System.in);
		int choice = -1;
		printMenu();
		choice = scanned.nextInt();
		while (choice != 5) {
			switch (choice) {
			case 1: 
				System.out.println("You chose Pizza!");
				break;
			case 2: 
				System.out.println("You chose Tacos!");
				break;
			case 3: 
				System.out.println("You chose Beer!");
				break;
			case 4: 
				System.out.println("You chose Wine!");
				break;
			default:
				System.out.println("Invalid selection!");
				break;
			}
			printMenu();
			choice = scanned.nextInt();
		}
		System.out.println("Thanks for your business!");
		
	}
	
	public static void printMenu() {
		System.out.println("Please select one of the following: \n"
				+ "1) Pizza \n"
				+ "2) Tacos \n"
				+ "3) Beer \n"
				+ "4) Wine \n"
				+ "5) byeeee ");
	}
	
//	public void displayMenu() {
//		  boolean menuOptions = true; //Using this to let the menu continue after the input
//		  
//		  //Greetings for the user
//		  System.out.println("--------------------------------------------------");
//		  System.out.println("Welcome to the Revature Reimbursement System");
//		  System.out.println("--------------------------------------------------");
//		  System.out.println();
//		  
//		  //display the menu as long as the menuoptions boolen = true
//		  //display all my menuoptions until boolean = false
//		  while(menuOptions) {
//		    //menu options
//		    System.out.println("PLEASE ENTER THE NUMBER OF YOUR CHOICE");
//		    System.out.println("1 -> Employee Portal");
//		    System.out.println("2 -> Finance Manager Portal");
//		    System.out.println("0 -> Exit Application");
//		  
//		  
//		    // The user chooses a menu option and the scanner takes the input and put it into a variable
//		    //  CAlls the promptSelection() helper method to help validation
//		    // The parameters list the valid options the user must choose from
//		    int firstChoice = promptSelection(1,2,0);
//		    
//		    //Takes the user input and the switch statement executes the appropriate code
//		    switch(firstChoice) {
//		    
//		    //
//		    case 1: 
//		      handlePortal(Roles.EMPLOYEE);
//		      break;
//		    case 2:
//		      handlePortal(Roles.MANAGER);
//		      break;
//		    case 0:
//		      System.out.println("\nHave a great day! Goodbye.");
//		      menuOptions = false;
//		      break;
//		    }
//		  }//end of the while loop
//		}// end of the displayMenu method

}
