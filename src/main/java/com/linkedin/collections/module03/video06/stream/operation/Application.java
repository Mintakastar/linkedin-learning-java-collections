package com.linkedin.collections.module03.video06.stream.operation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge","Premiere Room",4,175.00);
        Room manchester = new Room("Manchester","Suite",5,250.00);
        Room oxford = new Room("Oxford","Suite",5,225.00);
        Room victoria = new Room("Victoria","Suite",5,225.00);



        Collection<Room>rooms =new ArrayList<>(Arrays.asList(cambridge,oxford,victoria,manchester));

        oxford.setPetfriendly(true);
        victoria.setPetfriendly(true);

        Collection<Room> petFriendlyRooms  =  rooms.stream()
                .filter( Room::isPetfriendly)
                .collect(Collectors.toList());

        //petFriendlyRooms.stream()
           //     .forEach(r->System.out.println(r.getName()));

        //get names of all the pet friendly rooms
        petFriendlyRooms.stream()
                .map(r->r.getName())
                .forEach(System.out::println);

        System.out.println( "\nrevenue:");

        //get the revenue of pet friendly
        double  total = petFriendlyRooms.stream()
                .mapToDouble(Room::getRate)
                .sum();
        System.out.println( total);

    }

}