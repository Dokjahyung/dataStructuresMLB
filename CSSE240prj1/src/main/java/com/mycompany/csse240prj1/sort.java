package com.mycompany.csse240prj1;

import java.util.Scanner;
import java.util.Comparator;

// A generic sorting class
public class sort<T>{

    // The list that will be sorted
    LinkedList sortedList = new LinkedList();

    // Constructor class that requires a linked list to sort
    public LinkedList listSort(LinkedList list){
        this.sortedList = list;
        Node start = list.head;
        Node end = list.getNode(list.getLength());

        // Add a scanner to system
        Scanner scan = new Scanner(System.in);

        // Prompt user for type of filter they would like to sort by 
        System.out.println("What kind of data would you like to sort by?");
        System.out.println("n = name | t = team | s = season | p = position");

        // The next letter typed will be what the data is sorted by
        char stage = scan.next().charAt(0);

        // Call the quicksort method to actually sort
        quickSort(start, end, stage);
        return this.sortedList;
    }

    // Partition array into subarrays
    // Takes first and last node, 
    // but do not break any links in 
    // the whole linked list 
    Node partitionLast(Node start, Node end, Comparator<Player> comparing) 
    { 
        if (start == end || start == null || end == null) 
            return start; 

        Node pivot_prev = start; 
        Node curr = start; 
        Player pivot = end.data; 

        // iterate till one before the end, 
        // no need to iterate till the end 
        // because end is pivot 

        while (start != end) { 
            if (comparing.compare(start.data, pivot) < 0) { 
                // keep tracks of last modified item 
                pivot_prev = curr; 
                Player temp = curr.data; 
                curr.data = start.data; 
                start.data = temp; 
                curr = curr.next; 
            } 
            start = start.next; 
        } 

        // Swap the position of curr i.e. 
        // next suitable index and pivot 
        Player temp = curr.data; 
        curr.data = pivot; 
        end.data = temp; 

        // Return one previous to current 
        // because current is now pointing to pivot 
        return pivot_prev; 
    } 

    // QuickSort method for sorting a linked list
    void quickSort(Node start, Node end, char type) 
    { 
        if (start == null || start == end 
            || start == end.next) 
            return; 

        int index = -1;

        // Switch case for all possible types
        Node pivot_prev = null;
        switch (type){
            // Case for filter by Name
            case 'n':
                pivot_prev = partitionLast(start, end, Comparator.comparing(Player::getName));
                break;
            // Case for filter by Team
            case 't':
                pivot_prev = partitionLast(start, end, Comparator.comparing(Player::getTeam));
                break;
            // Case for filter by Season
            case 's':
                pivot_prev = partitionLast(start, end, Comparator.comparing(Player::getSeason));
                break;
            // Case for filter by Position
            case 'p':
                pivot_prev = partitionLast(start, end, Comparator.comparingInt(Player::getPosition));
                break;
            // If they gave a bad input then default will prompt them to try again from beginning in main
            default:
                System.out.println("Try Again");
                break;
        }
        // Split list and partition recursively
        quickSort(start, pivot_prev, type); 

        // If pivot is picked and moved to the start, 
        // that means start and pivot are the same 
        // so pick from next of pivot 
        if (pivot_prev != null && pivot_prev == start) 
            quickSort(pivot_prev.next, end, type); 

        // If pivot is in between of the list, 
        // start from next of pivot, 
        // since we have pivot_prev, so we move two nodes 
        else if (pivot_prev != null
            && pivot_prev.next != null) 
            quickSort(pivot_prev.next.next, end, type); 
    } 

}
