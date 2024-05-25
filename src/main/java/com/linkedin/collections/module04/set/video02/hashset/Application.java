package com.linkedin.collections.module04.set.video02.hashset;

import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Room picadilly = new Room("Picadilly","Guest Room",3,125.00);
        Room oxford = new Room("Oxford","Suite",5,225.00);
        Room oxfordDuplicate = new Room("Oxford","Suite",5,225.00);
        Room victoria = new Room("Victoria","Suite",5,225.00);

        //Room cambridge = new Room("Cambridge","Premiere Room",4,175.00);
        //Room manchester = new Room("Manchester","Suite",5,250.00);

        //Set<Room> rooms = new HashSet<>(); // no order
        Set<Room> rooms = new LinkedHashSet<>(); // ordered

        //TEST 1
        //Set<Room> otherRooms = Set.of(picadilly,oxford);//unmodifible set
        //otherRooms.add(victoria);//throws exeption

        rooms.add(picadilly);
        rooms.add(oxford);
        rooms.add(oxford);
        rooms.add(oxfordDuplicate);
        rooms.add(victoria);

        Set<Room> moreRooms = Set.copyOf(rooms); //unmodifible

        //rooms.stream().map(r->r.getName()).forEach(System.out::println);
        moreRooms.stream().map(r->r.getName()).forEach(System.out::println);



    }

}
