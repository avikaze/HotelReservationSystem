// Title: Hotel Management System
// Project Description: This application is designed for hotel staff to keep track of their reservations. With this program,
// staff can book rooms for guests, check availability of rooms, look up guests, delete guests, modify the duration of stay
// and repeat the process for which ever day. When making a reservation or modifying one, the program prints out a log entry
// of the guest's information to a new file.

package files;

import java.util.Scanner;

public class Guest {
	
	Scanner keyboard = new Scanner(System.in);
	
	public String name, searchedName;
	public boolean foundName = false;
	
	public int duration;
	public int price;
	

	public Guest() 
	{
		//
	}
	
	public void initiliaze(Guest hotelGuest[])
	{
		for (int i = 0; i < hotelGuest.length; i++) 
		{
			hotelGuest[i].setName("no one");
		}
	}
	
	public void searchGuest(Guest hotelGuest[])
	{
		System.out.print("Please enter a name to search for: ");
		searchedName = keyboard.next();
		
		for (int i = 0; i < hotelGuest.length; i++) 
		{
			if (hotelGuest[i].getName().equalsIgnoreCase(searchedName))
			{
				System.out.println(searchedName + " is currently checked-in in room " + (i+1));
				foundName = true;
			}
						
		}
		
		if (foundName == false)
		{
			System.out.println("There are no active check-ins under the name '" + searchedName + "'");
		}
	}

	
	public void setName(String guestName)
	{
		name = guestName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public void setDuration(int roomDuration)
	{		
		duration = roomDuration;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
	public void setPrice(int roomPrice)
	{
		price = roomPrice;
	}
	
	public int getPrice()
	{
		return price;
	}

}
