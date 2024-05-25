package com.linkedin.collections.module03.video03.modifying.collections.whiile.iterating;

import javax.crypto.spec.PSource;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge","Premiere Room",4,175.00);
        Room manchester = new Room("Manchester","Suite",5,250.00);
        Room oxford = new Room("Oxford","Suite",5,225.00);
        Room victoria = new Room("Victoria","Suite",5,225.00);

        //Room picadilly = new Room("Picadilly","Guest Room",3,125.00);
        //Room westminister = new Room("Westminister","Premiere Room",4,200.00);
        //Room manchester = new Room("Manchester","Suite",5,250.00);
        //Room oxford = new Room("Oxford","suite",5,225.00);



        Collection<Room>rooms =new ArrayList<>(Arrays.asList(cambridge,oxford,victoria,manchester));

        oxford.setPetfriendly(true);
        victoria.setPetfriendly(true);

        //(1) problem throws Exception in thread "main" java.util.ConcurrentModificationException
        /*for(Room room : rooms ){//get the iterator, and gets the next element each time
            System.out.println(room.getName() + " petFriendly? "+room.isPetfriendly());
            if(room.isPetfriendly()){
                rooms.remove(room);
            }
        }*/


        //(2) solution, craete a new collection of the object to remove and remove them all at the end
        /*Collection<Room> removeRooms = new ArrayList<>();
        for(Room room : rooms ){//get the iterator, and gets the next element each time
            System.out.println(room.getName() + " petFriendly? "+room.isPetfriendly());
            if(room.isPetfriendly()){
                removeRooms.add(room);
            }
        }
        rooms.removeAll(removeRooms);
        */

        //(3) solution, using iterator
        Iterator<Room> iterator = rooms.iterator();

        while(iterator.hasNext()){
            Room room =iterator.next();
            if(room.isPetfriendly()){
                iterator.remove(); //this does not throws concurrent excweption
            }
        }



        System.out.println("\nfinal list\n");
        rooms.stream()
                .forEach(r -> System.out.println(r.getName() + " isPetFriendly "+r.isPetfriendly() ));

    }

}