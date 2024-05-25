package com.linkedin.collections.module04.set.video03.treeset;

import java.util.*;

public class Application {
    public static void main(String[] args) {
  /*      Room picadilly = new Room("Picadilly","Guest Room",3,125.00);
        Room oxford = new Room("Oxford","Suite",5,225.00);
        Room oxfordDuplicate = new Room("Oxford","Suite",5,225.00);
        Room victoria = new Room("Victoria","Suite",5,225.00);
*/

        //does not evaluate using equals
        //it uses comparable and comparator

        List<Integer> numbers = Arrays.asList(500,1500,2500,1000,3000,2000);

        NavigableSet<Integer> numberTree = new TreeSet<>(numbers);

        System.out.println("\nall");
        numberTree.descendingSet().forEach(System.out::println);

        System.out.println("\nheadset");
        numberTree.headSet(1750).forEach(System.out::println);

        System.out.println("\ntail");
        numberTree.tailSet(1750).forEach(System.out::println);

        System.out.println("\nsubset");
        numberTree.subSet(1750,2750).forEach(System.out::println);

        System.out.println("\narriba de");
        System.out.println(numberTree.higher(750));

    }

}
