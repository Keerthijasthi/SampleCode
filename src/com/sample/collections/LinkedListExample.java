package com.sample.collections;

import java.util.*;

public class LinkedListExample {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        // Add elements
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        // Add at specific index
        list.add(1, "Mango");
        // Get element by index
        System.out.println("Element at index 2: " + list.get(2));  // Banana
        // Set element at index
        list.set(2, "Blueberry");
        // Remove by index
        list.remove(0);
        // Remove by object
        list.remove("Cherry");
        // Check if list contains an element
        System.out.println("Contains Mango? " + list.contains("Mango"));
        // Get size
        System.out.println("Size: " + list.size());
        // Check if list is empty
        System.out.println("Is empty? " + list.isEmpty());
        // Iterate using for-each
        for (String fruit : list) {
            System.out.println("Fruit: " + fruit);
        }

        // Using LinkedList as a Queue
        Queue<String> queue = new LinkedList<>();
        queue.add("John");   // John joins the line
        queue.add("Alice");  // Alice joins the line

        System.out.println(queue);
        System.out.println(queue.peek());// Just looks who is in front of the line
        queue.poll();
        System.out.println(queue); //retrive the person at the front and remove them from the line.
    }
}

