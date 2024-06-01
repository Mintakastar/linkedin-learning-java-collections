package com.linkedin;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Map<Integer,Integer> dups = new HashMap<>();
        dups.put(5,1);
        dups.put(5,2);

        dups.put(6,1);
        dups.put(6,2);

        dups.put(7,1);

        Set<Map.Entry<Integer, Integer>> entries = dups.entrySet();

    }
}

