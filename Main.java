// Title: Hotel Management System
// Project Description: This application is designed for hotel staff to keep track of their reservations. With this program,
// staff can book rooms for guests, check availability of rooms, look up guests, delete guests, modify the duration of stay
// and repeat the process for which ever day. When making a reservation or modifying one, the program prints out a log entry
// of the guest's information to a new file.

package files; // package location

import java.io.IOException;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) throws IOException // main method, IOException handling (to write to file)
	{
		Scanner keyboard = new Scanner(System.in); // Scanner object "keyboard" for input
		
 		int roomNum; // room number variable
 		int hotelDay = 1; // variable for the current day
 		boolean run = true; // run variable, to allow program to keep running
 		String function = ""; // function variable must be initialized 		
 		
 		
 		Guest hotelGuest[] = new Guest[10];
 		Room hotelRoom[] = new Room[10];
 		
 		for (int i = 0; i < hotelRoom.length; i++) 
 		{
 			hotelGuest[i] = new Guest();
			hotelRoom[i] = new Room();
		}	
 		
 		
 		hotelGuest[0].initiliaze(hotelGuest); // sets all names to "no one"
 		// since this is an array, 0 or any other variables can be used to call the method
 		
 		System.out.println("Welcome to the Hotel Management System"); // welcome message
 		
 		// while loop allows program to keep running
 		while (run) {
 			 
 		System.out.println("\nDay " + hotelDay); // displays current day
 		
 		// main menu options
 		System.out.println("\nMain Menu");	
 		System.out.println("1. Book a room");
 		System.out.println("2. Check availability");
 		System.out.println("3. Search Guests");
 		System.out.println("4. Delete guest");
 		System.out.println("5. Extend room stay");
 		System.out.println("6. Next day");
 		
 		
 		System.out.print("\nPlease select an option: "); // prompt user for an option from the list above
 		function = keyboard.nextLine(); // assign user input to function variable
 		System.out.println(); // next line cursor
 		
 		// switch statement, takes in function as input
 		 switch (function)
 		{ 		 
 		 	
 			case "1": // if function = 1
 				roomNum = 0; // initialize roomNum (changes)
 				//calls method to add a guest to room with the following inputs
 				hotelRoom[0].addGuestToRoom(hotelGuest, roomNum, hotelRoom[0].getRoomType()); 
 				break;
 				
 			case "2": // if function = 2
 				hotelRoom[0].checkAvailability(hotelGuest); // calls function to display rooms status'
 				break;
 				
 			case "3": // if function = 3
 				hotelGuest[0].searchGuest(hotelGuest); // calls function to search up a customer
 				break;
 				
 			case "4": // if function = 4
 				hotelRoom[0].deleteGuestFromRoom(hotelGuest); // calls to delete a guest that is currently checked in
 				break;
 				
 			case "5": // if function = 5
 				hotelRoom[0].extendDuration(hotelGuest); // calls method to extend a guest's duration
 				break;
 				
 			case "6": // if function = 6
 				hotelDay++; // increment the current day
 				hotelRoom[0].newDayDuration(hotelGuest); // calls the function to subtract a day from the current stay of guests
 				break;
 				
 			default: // if input isn't 1-6, prompt again
 					System.out.println("This is an unavalid input. Please select (1-6).");
 		} 
 	
	}
 		
	}

}
