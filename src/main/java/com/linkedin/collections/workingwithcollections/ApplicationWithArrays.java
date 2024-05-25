package com.linkedin.collections.workingwithcollections;

import java.util.Arrays;

public class ApplicationWithArrays {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge","Premiere Room",4,175.00);
        Room manchester = new Room("Manchester","Suite",5,250.00);
        Room picadilly = new Room("Picadilly","Guest Room",3,125.00);
        Room oxford = new Room("Oxford","suite",5,225.00);

        //Collection<Room>rooms = List.of(cambridge,manchester,picadilly,oxford);
        Room[] rooms = new Room[4];
        rooms[0] = cambridge;
        rooms[1] = manchester;
        rooms[2] = picadilly;
        rooms[3] = oxford;



        double total = getPotentialRevenew(rooms);
        System.out.println(total);

    }

    private static double  getPotentialRevenew(Room[] rooms){
        return Arrays.stream(rooms).mapToDouble(r -> r.getRate () ).sum();
    }
}