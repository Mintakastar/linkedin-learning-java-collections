package com.linkedin.collections.challenge.advance.collections.problems;

import java.util.*;
import java.util.stream.Collectors;

public class RoomService {

	private Collection<Room> inventory;

	public RoomService() {
 		//this.inventory = new HashSet<>();//does not maintain order    :(
		this.inventory = new LinkedHashSet<>();  //DOES MAINTAIN ORDER :)
		//this.inventory = new ArrayList<>();     //DOES MAINTAIN ORDER :)
	}
	
	public boolean hasRoom(Room room) {
		// 1. Returns a boolean that indicates if the Room Inventory contains a Room.
		return this.inventory.contains(room);
	}
	
	public Room[] asArray() {
		// 2. Returns all Rooms as an Array of Rooms in the **order** they were Added.
		Room[] inventoryArray = new Room[this.inventory.size()];
		return this.inventory.toArray(inventoryArray);

	}
	
	public Collection<Room> getByType(String type){
		/*
		   3. Return a new Collection of Rooms where Room#type matches the provided String.
			  The original Room Inventory collection MUST NOT BE MODIFIED.
		*/
		//return this.inventory.stream().filter(r-> type.equals(r.getType())).collect(Collectors.toList());

		//instructor does this method in another way.
		Collection<Room> copy = new HashSet<>(this.inventory);
		copy.removeIf(r->!r.getType().equals(type));
		return copy;
	}

	public Collection<Room> getInventory() {
		return new HashSet<>(this.inventory); 
	}

	public void createRoom(String name, String type, int capacity, double price) {
		this.inventory.add(new Room(name, type, capacity, price));
	}

	public void createRooms(Room[] rooms) {
		this.inventory.addAll(Arrays.asList(rooms));
	}

	public void removeRoom(Room room) {
		this.inventory.remove(room);
	}

}
