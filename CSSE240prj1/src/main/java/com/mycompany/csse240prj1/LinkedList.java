package com.mycompany.csse240prj1;

/*
 * CREDIT!!
 * 
 * used GeekforGeek for basic structure of list knowledge
 */
public class LinkedList {
    //every snake needs a head and so should lists to start iterating.
    Node head;

    // Method to insert a Player at the end of the list
    public static LinkedList insertPlayer(LinkedList list, Player data) {
        //create new node with given data value to be inserted
        Node newNode = new Node(data);
        //check if list is empty
        if (list.head == null){
            //if empty insert node into empty list
            list.head  = newNode;
        }
        else {
            //iterate through list to find last node in list and add after
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    // Method to delete a Player at a specific index
    public static LinkedList deletePlayer(LinkedList list, int index) {
        //error check for invalid indexes
        if (index <= 0 || index >= list.getLength()) {
            System.out.println("Invalid index. Player not found in the list.");
            return list;
        }
        if (index == 1) {
            // If the player to delete is the head of the list
            list.head = list.head.next;
        } else {
            //intitialize node that will edit
            Node current = list.head;
            int currentIndex = 0;
            while (currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
            //make sure element after index are not null
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        System.out.println("Player at index " + index + " has been deleted.");
        return list;
    }
    
    // Method to print the details of all players in the list
    public static void printList(LinkedList list) {
        Node node = list.head;
        while (node != null){
            System.out.println(node.data.printPlayer());
            node = node.next;
        }
    }

    // Method to get the length of the list
    public int getLength() {
        //iterate through list and add 1 to size each time
        int size = 0;
        Node current = this.head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    // Method to get a specific node by index
    public Node getNode(int index){
        Node current = this.head;
        int count = 0;
        //iterate through list till index is found and always check if node is null before accessing
        while (current != null && current.next != null){
            if (count == index){
                return current;
            }
            current = current.next;
            count ++;
        }
        return current;
    }
}
