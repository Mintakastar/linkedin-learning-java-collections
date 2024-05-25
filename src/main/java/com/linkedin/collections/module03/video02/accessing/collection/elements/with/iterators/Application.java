package com.linkedin.collections.module03.video02.accessing.collection.elements.with.iterators;

import javax.crypto.spec.PSource;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge","Premiere Room",4,175.00);
        Room picadilly = new Room("Picadilly","Guest Room",3,125.00);
        Room westminister = new Room("Westminister","Premiere Room",4,200.00);

        //Room manchester = new Room("Manchester","Suite",5,250.00);
        //Room oxford = new Room("Oxford","suite",5,225.00);

        Collection<Room>rooms =new ArrayList<>(Arrays.asList(cambridge,picadilly,westminister));

        /*
        Iterator<Room> iterator = rooms.iterator();
        Iterator<Room> iterator2 = rooms.iterator();
        System.out.println(iterator.next().getName());
        System.out.println(iterator.next().getName());
        System.out.println(iterator2.next().getName());
        */

        /*
        Iterator<Room> iterator = rooms.iterator();
        while(iterator.hasNext()){
            Room room = iterator.next();
            System.out.println(room.getName());
        }*/

        for(Room room : rooms /*get the iterator, and gets the next element each time */){
            System.out.println(room.getName());
        }

    }

}