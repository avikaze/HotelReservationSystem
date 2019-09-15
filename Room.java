// Title: Hotel Management System
// Project Description: This application is designed for hotel staff to keep track of their reservations. With this program,
// staff can book rooms for guests, check availability of rooms, look up guests, delete guests, modify the duration of stay
// and repeat the process for which ever day. When making a reservation or modifying one, the program prints out a log entry
// of the guest's information to a new file.

package files;

import java.util.Scanner;
import java.io.*;


public class Room 
{
	public String deleteName, extendName;
	public int roomType, totalPrice;
	public int doublePrice = 55;
	public int quadPrice = 85;
	public int suitePrice = 135;
	public int durationPrice;
	public int extendPrice;
	public int totalSales = 0;
	public int priceDifference;
	public int previousStay, extendStay;
	public int numberRoom = 0;
	public boolean logEntry = true;
	public boolean roomExceed = false;
	
	Scanner keyboard = new Scanner(System.in);
	
	public Room() 
	{
		
	}

	public void addGuestToRoom(Guest hotelRoom[], int roomNum, int roomType) throws IOException
	{
		roomExceed = false; 
		
		FileWriter fwriter = new FileWriter("HotelFileLog.txt", true);
		PrintWriter outputFile = new PrintWriter(fwriter);
		
		
		
		if (logEntry)
		{
			outputFile.println("\n\nNew Log Entry: ");
			logEntry = false;
		}
		
		
		if (roomType == 1)
		{
			roomNum = 0;
			
			while (!(roomExceed) && !(hotelRoom[roomNum].getName().equalsIgnoreCase("no one"))) //if room 1 is free
			{
				roomNum++;
				
				if (roomNum == 3)
				{
					roomExceed = true;
				}
			}
			
			if (!(hotelRoom[3].getName().equalsIgnoreCase("no one")))
			{
				System.out.println("\nThere are no more double rooms available. Sorry!");
			}
			
			else
			{
				System.out.print("\nPlease enter name for room " + (roomNum+1) + ": ");		
				hotelRoom[roomNum].setName(keyboard.next());
				System.out.print("Please enter the amount of days would you like to stay: ");
				hotelRoom[roomNum].setDuration(keyboard.nextInt());
				while(hotelRoom[roomNum].getDuration() <= 0)
				{
					System.out.print("This is an invalid input. Please enter a positive number :");
					hotelRoom[roomNum].setDuration(keyboard.nextInt());
				}
				durationPrice = hotelRoom[roomNum].getDuration() * doublePrice;
				hotelRoom[roomNum].setPrice(durationPrice);
				totalSales += durationPrice;
				System.out.printf("This room is rated at $" + doublePrice + " per night. Your total will come down to $" + durationPrice);
				
			}
			
		}
		
		else if (roomType == 2)
		{
			roomNum = 4;
			
			while (!(roomExceed) && !(hotelRoom[roomNum].getName().equalsIgnoreCase("no one"))) //if room 1 is free
			{
				roomNum++;
				
				if (roomNum == 6)
				{
					roomExceed = true;
				}
			}
			
			if (!(hotelRoom[6].getName().equalsIgnoreCase("no one")))
			{
				System.out.println("\nThere are no more quad rooms available. Sorry!");
			}
			
			else
			{
				
				System.out.print("\nPlease enter name for room " + (roomNum+1) + ": ");
				hotelRoom[roomNum].setName(keyboard.next());
				System.out.print("Please enter the amount of days would you like to stay: ");
				hotelRoom[roomNum].setDuration(keyboard.nextInt());
				while(hotelRoom[roomNum].getDuration() <= 0)
				{
					System.out.print("This is an invalid input. Please enter a positive number :");
					hotelRoom[roomNum].setDuration(keyboard.nextInt());
				}
				durationPrice = hotelRoom[roomNum].getDuration() * quadPrice;
				hotelRoom[roomNum].setPrice(durationPrice);
				totalSales += durationPrice;
				System.out.printf("This room is rated at $" + quadPrice + " per night. Your total will come down to $" + durationPrice);
			}
			
		}
		
		else if (roomType == 3)
		{
			roomNum = 7;
			while (!(roomExceed) && !(hotelRoom[roomNum].getName().equalsIgnoreCase("no one"))) //if room 1 is free
			{
				roomNum++;
				
				
				if (roomNum == 9)
				{
					roomExceed = true;
				}
				
				
			}
			
			if (!(hotelRoom[9].getName().equalsIgnoreCase("no one")))
			{
				System.out.println("\nThere are no more suites available. Sorry!");
			}
			
			else
			{
				System.out.print("\nPlease enter name for room " + (roomNum+1) + ": ");
				hotelRoom[roomNum].setName(keyboard.next());
				System.out.print("Please enter the amount of days would you like to stay: ");
				hotelRoom[roomNum].setDuration(keyboard.nextInt());
				while(hotelRoom[roomNum].getDuration() <= 0)
				{
					System.out.print("This is an invalid input. Please enter a positive number :");
					hotelRoom[roomNum].setDuration(keyboard.nextInt());
				}
				durationPrice = hotelRoom[roomNum].getDuration() * suitePrice;
				hotelRoom[roomNum].setPrice(durationPrice);
				totalSales += durationPrice;
				System.out.printf("This room is rated at $" + suitePrice + " per night. Your total will come down to $" + durationPrice);
				
			}
		}
	
		String roomTypeString = "";
		
		if(roomType == 1)
		{
			roomTypeString = "Double";
		}
		
		else if(roomType == 2)
		{
			roomTypeString = "Quad";
		}
		
		else if(roomType == 3)
		{
			roomTypeString = "Suite";
		}
		
		
		outputFile.println("Name: " + hotelRoom[roomNum].getName()
				+ "\t\tDuration: " + hotelRoom[roomNum].getDuration() + " days"
				+ "\t\tRoom_Number: " + (roomNum+1)
				+ "\t\tRoom_Type: " + roomTypeString
				+ "\t\tAmount_Owed: $" + hotelRoom[roomNum].getPrice()
				+ "\t\tTotal_Hotel_Revenue: $" + totalSales);
		outputFile.println("-----------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\n\nData written to file.\n");
		outputFile.close();
		
	}
	
	
	public int getRoomType()
	{
		
			System.out.print("Please select a room type"
					+ "\n1. Double (2 people)"
					+ "\n2. Quad (4 people)"
					+ "\n3. Suite (6 people): ");
			roomType = keyboard.nextInt();
		
			while (roomType < 1 ||  roomType > 3)
			{
				System.out.print("That is an unvalid choice. Please choose (1-3): ");
				roomType = keyboard.nextInt();
			}
		return roomType;
	}
	
	public void checkAvailability(Guest hotelRoom[])
	{
		for (int j = 0; j < hotelRoom.length; j++) 
		{
			if (j <= 3)
			{
				System.out.print((j+1) + ". Double - \t");
			}
			
			if (j <= 6 && j >= 4)
			{
				System.out.print((j+1) + ". Quad - \t");
			}
			
			if (j <= 9 && j >= 7)
			{
				System.out.print((j+1) + ". Suite - \t");
			}
			
			if (hotelRoom[j].getName().equalsIgnoreCase("no one"))
			{
				System.out.println("Room " + (j+1) + " is occupied by " + hotelRoom[j].getName());
			}
			
			else
			{
				System.out.println("Room " + (j+1) + " is occupied by " + hotelRoom[j].getName() + " for " + hotelRoom[j].getDuration() + " days");
			}
		}
		
		System.out.println();
	}
	
	public void deleteGuestFromRoom(Guest hotelRoom[])
	{
		boolean guestFound = false;
		
		System.out.print("Which guest would you like to delete? ");
		deleteName = keyboard.next();
		
		for (int i = 0; i < hotelRoom.length; i++) 
		{
			if (hotelRoom[i].getName().equalsIgnoreCase(deleteName))
			{
				hotelRoom[i].setName("no one");
				System.out.println(deleteName + " has been removed from room " + (i+1));
				guestFound = true;
			}
			
		}
		
		if (guestFound == false)
		{
			System.out.println("There is nobody currently checked-in under the name '" + deleteName + "'");
		}
	}
	
	public void extendDuration(Guest hotelRoom[]) throws IOException
	{
		boolean guestFound = false;
		
		FileWriter fwriter = new FileWriter("HotelFileLog.txt", true);
		PrintWriter outputFile = new PrintWriter(fwriter);
		
		System.out.print("Which guest's duration would you like to extend? ");
		extendName = keyboard.next();
		
		String roomTypeString = "";
		
		for (int i = 0; i < hotelRoom.length; i++) 
		{
					
			if (hotelRoom[i].getName().equalsIgnoreCase(extendName))
			{
				previousStay = hotelRoom[i].getDuration();
				System.out.print("How many days would you like to extend your stay by? ");
				extendStay = keyboard.nextInt();
				hotelRoom[i].setDuration(extendStay + previousStay);
				
				while(extendStay < 1)
				{
					System.out.print("This is an invalid input. Please enter a positive number (at least 1):");
					extendStay = keyboard.nextInt();
					hotelRoom[i].setDuration(extendStay + previousStay);
				}
				guestFound = true;				
				
				if (i <= 4)
				{
					roomTypeString = "Double";
					extendPrice = doublePrice * extendStay;
					System.out.println(hotelRoom[i].getName() + " will be charged $" + extendPrice + " for this extension.");
					totalSales += extendPrice;
				}
				
				else if (i <= 7 && i >= 5)
				{
					roomTypeString = "Quad";
					extendPrice = quadPrice * extendStay;
					System.out.println(hotelRoom[i].getName() + " will be charged $" + extendPrice + " for this extension.");
					totalSales += extendPrice;
				}
				
				else if (i <= 10 && i >= 8)
				{
					roomTypeString = "Suite";
					extendPrice = suitePrice * extendStay;
					System.out.println(hotelRoom[i].getName() + " will be charged $" + extendPrice + " for this extension.");
					totalSales += extendPrice;
				}
				
				outputFile.println("Name: " + hotelRoom[numberRoom].getName()
						+ "\t\tExtension: " + hotelRoom[numberRoom].getDuration() + " days"
						+ "\t\tRoom_Number: " + (numberRoom+1)
						+ "\t\tRoom_Type: " + roomTypeString
						+ "\t\tAmount_Owed: $" + hotelRoom[numberRoom].getPrice()
						+ "\t\tTotal_Hotel_Revenue: $" + totalSales);
				outputFile.println("-----------------------------------------------------------------------------------------------------------------------------------");
				
				outputFile.close();
			}
			
			
			
		}
		
		
		
		if (guestFound == false)
		{
			System.out.println("There is nobody currently checked-in under the name '" + extendName + "'");
		}
		
		System.out.println("\nData written to file.");
		
	}
	

	public void newDayDuration(Guest hotelRoom[])
	{
		for (int i = 0; i < hotelRoom.length; i++) 
		{
			if (!hotelRoom[i].getName().equalsIgnoreCase("no one"))
			{
				hotelRoom[i].setDuration(hotelRoom[i].getDuration() - 1);
			}
			
			if (hotelRoom[i].getDuration() == 0)
			{
				hotelRoom[i].setName("no one");
			}
		}
	}
	
	
}
