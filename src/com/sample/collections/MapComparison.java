package com.sample.collections;

import java.util.*;

public class MapComparison {

    public static void main(String[] args) {

        // Sample data
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> linkedHashMap = new LinkedHashMap<>();

        // Insert elements using HashMap
        hashMap.put("Banana", 10);
        hashMap.put("Apple", 20);
        hashMap.put("Mango", 30);
        hashMap.put("Grapes", 40);
        // Print contents of Hash map
        System.out.println("HashMap (No specific order):");
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // using TreeMap
        treeMap.put("Banana", 10);
        treeMap.put("Apple", 20);
        treeMap.put("Mango", 30);
        treeMap.put("Grapes", 40);

        System.out.println("\nTreeMap (Sorted by key):");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }

        // using LinkedHashMap
        linkedHashMap.put("Banana", 10);
        linkedHashMap.put("Apple", 20);
        linkedHashMap.put("Mango", 30);
        linkedHashMap.put("Grapes", 40);
        System.out.println("\nLinkedHashMap (Insertion order):");
        for (Map.Entry<String, Integer> entry : linkedHashMap.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
        }
    }
}
