package com.mycompany.csse240prj1;

import java.util.Scanner;
import java.util.Comparator;


public class sort<T>{

    
    LinkedList sortedList = new LinkedList();
    //constructor class that requires 3 arguments of 2 indexes and array.
    //currently this is all we require to sort but could change in future depending if I solve integrating generic methods
    public LinkedList listSort(LinkedList list){
        this.sortedList = list;
        Node start = list.head;
        Node end = list.getNode(list.getLength());
        //add scanner to system
        Scanner scan = new Scanner(System.in);
        //promt user for type of filter they would like to sort by 
        System.out.println("What kind of data would you like to sort by?");
        System.out.println("n = name | t = team | s = season | p = position");
        //next letter typed will be what the data is sorted by
        char stage = scan.next().charAt(0);
        //call the quicksort method to actually sort
        quickSort(start, end, stage);
        return this.sortedList;
    }
    //partition array into subarrays
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
			if (comparing.compare(start.data, pivot)< 0) { 
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

	void quickSort(Node start, Node end, char type) 
	{ 
		if (start == null || start == end 
			|| start == end.next) 
			return; 

        int index = -1;
        //switch case for all possible types
        Node pivot_prev = null;
        switch (type){
            //case for filter by Name
            case 'n':
                pivot_prev = partitionLast(start, end, Comparator.comparing(Player::getName));
                break;
            //case for filter by Team
            case 't':
                pivot_prev = partitionLast(start, end, Comparator.comparing(Player::getTeam));
                break;
            //case for filter by Season
            case 's':
                pivot_prev = partitionLast(start, end, Comparator.comparing(Player::getSeason));
                break;
            //case for filter by Position
            case 'p':
                pivot_prev = partitionLast(start, end, Comparator.comparingInt(Player::getPosition));
                break;
            //if they gave a bad input then default will prompt them to try again from beginning in main
            default:
                System.out.println("Try Again");
                break;
        }
		// Split list and partition recurse 
		quickSort(start, pivot_prev, type); 

		// If pivot is picked and moved to the start, 
		// that means start and pivot is same 
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