package com.linkedin.collections.module03.video05.lamda.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ApplicationMod03Vid05 {
    public static void main(String[] args) {
        Room cambridge = new Room("Cambridge","Premiere Room",4,175.00);
        Room manchester = new Room("Manchester","Suite",5,250.00);
        Room oxford = new Room("Oxford","Suite",5,225.00);
        Room victoria = new Room("Victoria","Suite",5,225.00);



        Collection<Room>rooms =new ArrayList<>(Arrays.asList(cambridge,oxford,victoria,manchester));

        oxford.setPetfriendly(true);
        victoria.setPetfriendly(true);

        //FUNCTIONAL style as streams
        rooms.stream()
                .filter( Room::isPetfriendly)
                .forEach(room -> System.out.println(room.getName()));

    }

}