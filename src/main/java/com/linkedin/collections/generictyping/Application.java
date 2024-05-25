package com.linkedin.collections.generictyping;

import com.linkedin.collections.workingwithcollections.Room;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;

public class Application {
    public static void main(String[] args) {
       // Collection c = new ArrayList();
        Collection<Room> c = new ArrayList();
        //c.add("Cambridge");
        //c.add(1L);
        c.add(new Room("Cambridge","Suite",6,250.0));

        //c.stream()
          //      .forEach(e-> System.out.println(e.getClass()));

        c.stream()
                .forEach(e-> System.out.println(((Room)e).getName()));


        Collection c2 =new ArrayList();
        c2.add(new Room("Cambridge","Suite",6,250.0));
    }
}
