package com.mycompany.csse240prj1;

import java.util.Scanner;
import java.util.Comparator;


public class sort<T>{

    LinkedList sortedList = new LinkedList();
    //constructor class that requires 3 arguments of 2 indexes and array.
    //currently this is all we require to sort but could change in future depending if I solve integrating generic methods
    public LinkedList listSort(LinkedList list, int low, int high){
        this.sortedList = list;
        //add scanner to system
        Scanner scan = new Scanner(System.in);
        //promt user for type of filter they would like to sort by 
        System.out.println("What kind of data would you like to sort by?");
        System.out.println("n = name | t = team | s = season | p = position");
        //next letter typed will be what the data is sorted by
        char stage = scan.next().charAt(0);
        //call the quicksort method to actually sort
        quickSort(this.sortedList, low, high, stage);
        return this.sortedList;
    }
    //quicksort method uses all data given to constructor plus the data type it is now filtering by
    public void quickSort(LinkedList list, int low, int high, char type){
        //need to instantiate index or else program won't run.
        //To make sure program doesn't continue running for default case, make index a not possible number like -1
        int index = -1;
        //switch case for all possible types
        switch (type){
            //case for filter by Name
            case 'n':
                index = partition(list, low, high, Comparator.comparing(Player::getName));
                break;
            //case for filter by Team
            case 't':
                index = partition(list, low,  high, Comparator.comparing(Player::getTeam));
                break;
            //case for filter by Season
            case 's':
                index = partition(list, low, high, Comparator.comparing(Player::getSeason));
                break;
            //case for filter by Position
            case 'p':
                index = partition(list, low, high, Comparator.comparingInt(Player::getPosition));
                break;
            //if they gave a bad input then default will prompt them to try again from beginning in main
            default:
                System.out.println("Try Again");
                break;
        }
        //test if index is actually an accepted value for sake of future recursion
        if (index != -1){
            // Recursively call quicksort with left part of the partitioned array 
            if (low < index - 1) { quickSort(list, low, index - 1, type); } 
            // Recursively call quick sort with right part of the partitioned array 
            if (high > index) { quickSort(list, index, high, type); }
        }
    }
    //partition array into subarrays
    public int partition(LinkedList list){
        Node start = list.head;
        
        while (start != end) { 
            if (start.data < pivot) { 
  
                // keep tracks of last modified item 
                pivot_prev = curr; 
                int temp = curr.data; 
                curr.data = start.data; 
                start.data = temp; 
                curr = curr.next; 
            } 
            start = start.next; 
        } 
  
        // Swap the position of curr i.e. 
        // next suitable index and pivot 
        int temp = curr.data; 
        curr.data = pivot; 
        end.data = temp; 
  
        // Return one previous to current 
        // because current is now pointing to pivot 
        return pivot_prev; 
    } 
  
    // swap 2 elements in an array
    public void swap(LinkedList list, int low, int high){
        Player temp = list.getNode(low).data;
        System.out.println("Temp: " + temp); // Debugging line
        list.getNode(low).data = list.getNode(high).data;
        System.out.println("Low Data: " + list.getNode(low).data.printPlayer()); // Debugging line
        list.getNode(high).data = temp;
        System.out.println("High Data: " + list.getNode(high).data.printPlayer()); // Debugging line
    }
}