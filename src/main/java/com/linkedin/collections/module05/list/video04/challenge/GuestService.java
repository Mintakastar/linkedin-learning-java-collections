package com.linkedin.collections.module05.list.video04.challenge;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */

		System.out.println("Room: "+room);
		System.out.println();
		printList("All guest",guests);


		//this does not take into account first elemnt
		List<Guest> guestFound=guests.stream()
				.filter( g -> g.getPreferredRooms().contains(room)).collect(Collectors.toList());

		/// this is == 0 as they have indicated that this is the first element
		List<Guest> guestFoundVideo=guests.stream()
								.filter( g -> g.getPreferredRooms().indexOf(room)==0).collect(Collectors.toList());  // who have indicated the provided room as the first preference in their preferred



		printList("Filtered guest",guestFound);

		return guestFoundVideo;
	}

	private static void printList(String title,List<Guest> toPrint){
		System.out.format("\n"+title+"\n");
		toPrint.forEach(
				g -> System.out.println("\t"+g.isLoyaltyProgramMember()+"\t"+g.getFirstName()+" [ "+g.getPreferredRooms()+"]")
		);

		//System.out.println();
	}

	public void checkIn(Guest guest) {

		//checkInMine(guest);
		checkInVideo(guest);

	}

	private void checkInMine(Guest guest){
		System.out.println("\n\n");
		System.out.println("CHECK IN");
		System.out.println("------------------------------------------");

		System.out.println("USER TO VALIDATE ");
		System.out.println("\t"+guest.isLoyaltyProgramMember()+"\t"+guest.getFirstName()+" [ "+guest.getPreferredRooms()+"]");
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		int size=checkinList.size();
		if(size == 0){
			checkinList.add(guest);
			printList("checkIn",checkinList);
			System.out.println("------------------------------------------");
			return ;
		}


		if(guest.isLoyaltyProgramMember()){
			//add guest to the position that is needed
			boolean found= false;
			for (int i = 0; i < size; i++) {
				if(!checkinList.get(i).isLoyaltyProgramMember()){
					found= true;
					//not loyalty programm, so take previouse element
					if(i==0){
						checkinList.add(0,guest);
						break ;
					}else{
						checkinList.add(i,guest);
						break ;
					}
				}
			}
			if(!found){
				//not found
				checkinList.add(guest);
			}

		}else{
			//add guest to the end
			checkinList.add(guest);
		}
		printList("checkIn",checkinList);

		System.out.println("------------------------------------------");

	}
	private void checkInVideo(Guest guest){
		if(guest.isLoyaltyProgramMember() && !this.checkinList.isEmpty()){
			int i = 0;
			for (; i < checkinList.size(); i++) {
				if(checkinList.get(i).isLoyaltyProgramMember()){
					continue;
				}
				break;
			}
			this.checkinList.add(i,guest);
		}else{
			checkinList.add(guest);
		}
	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */
		int g1Index=checkinList.indexOf(guest1);
		int g2Index=checkinList.indexOf(guest2);

		if(g1Index >= 0 && g2Index >=0 ){
			checkinList.set(g2Index,guest1);
			checkinList.set(g1Index,guest2);
		}

		//this method was exactly as they wanted

	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}

