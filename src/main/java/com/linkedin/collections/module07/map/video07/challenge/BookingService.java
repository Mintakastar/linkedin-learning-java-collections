package com.linkedin.collections.module07.map.video07.challenge;



import java.util.HashMap;
import java.util.Map;

public class BookingService {

	private Map<Room, Guest> bookings = new HashMap<>();

	public boolean book(Room room, Guest guest) {

		/*
		 * 1. The provided Guest is placed in the bookings Map and
		 * associated with the provided room, only if no other guest
		 * is associated with the room.
		 * 
		 * Returns a boolean that indicates if the Guest was
		 * successfully placed in the room.
		 */

		//mine
		/*if(bookings.containsKey(room)){
			return false;
		}else{
			bookings.put(room,guest);
			return true;
		}*/

		//video
		return bookings.putIfAbsent(room,guest)==null;


		
	}

	public double totalRevenue() {
		
		/*
		 * 2. Returns a double that totals the rate of each Room booked
		 * in the bookings Map.
		 */
		//mine
		//return bookings.entrySet().stream().mapToDouble(entry -> entry.getKey().getRate()).sum();

		//video
		return bookings.keySet().stream().mapToDouble(Room::getRate).sum();

	}
	
	public Map<Room, Guest> getBookings() {
		return bookings;
	}
}
