package com.linkedin.collections.module03.video04.accesing.collection.elements.with.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Application {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge","Premiere Room",4,175.00);
        Room manchester = new Room("Manchester","Suite",5,250.00);
        Room oxford = new Room("Oxford","Suite",5,225.00);
        Room victoria = new Room("Victoria","Suite",5,225.00);



        Collection<Room>rooms =new ArrayList<>(Arrays.asList(cambridge,oxford,victoria,manchester));

        oxford.setPetfriendly(true);
        victoria.setPetfriendly(true);

        //imperative  specify everything exactly as it is, what we want to achieve
        /*for (Room room : rooms ) {
            if(room.isPetfriendly()){
                System.out.println(room.getName());
            }
        }*/

        //FUNCTIONAL style as streams
        rooms.stream()
                .filter( new Predicate<Room>() {
                            @Override
                            public boolean test(Room room) {
                                System.out.println("testing "+ room.getName()+" is pet friendly");
                                return room.isPetfriendly();
                            }
                        }).forEach(new Consumer<Room>() {
                           @Override
                            public void accept(Room room) {
                               System.out.println(room.getName());
                            }
                });

/*
        System.out.println("\nfinal list\n");
        rooms.stream()
                .forEach(r -> System.out.println(r.getName() + " isPetFriendly "+r.isPetfriendly() ));*/

    }

}