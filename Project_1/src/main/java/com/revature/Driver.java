package com.revature;

import java.util.Scanner;

public class Driver {
	
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

}
