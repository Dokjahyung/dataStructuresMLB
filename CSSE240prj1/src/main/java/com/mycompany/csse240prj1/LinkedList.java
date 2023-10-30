package com.mycompany.csse240prj1;

/*
 * CREDIT!!
 */
public class LinkedList {
    Node head;

    public class Node{
        Player data;
        Node next;

        public Node(Player data) {
            this.data = data;
            next = null;
        }
    }

    public static LinkedList insertPlayer(LinkedList list, Player data) {
        Node newNode = new Node(data);
        if (list.head == null){
            list.head  = newNode;
        }
        else {
            Node last = list.head;
            while (last.next != null){
                last = last.next;
            }

            last.next = newNode;
        }
        return list;
    }

    public static LinkedList deletePlayer(LinkedList list, int index) {
        if (index <= 0 || index >= list.getLength()) {
            System.out.println("Invalid index. Player not found in the list.");
            return list;
        }
        if (index == 1) {
            // If the player to delete is the head of the list
            list.head = list.head.next;
        } else {
            Node current = list.head;
            int currentIndex = 0;
            while (currentIndex < index - 1) {
                current = current.next;
                currentIndex++;
            }
            if (current.next != null) {
                current.next = current.next.next;
            }
        }
        System.out.println("Player at index " + index + " has been deleted.");
        return list;
    }
    
    
    public static void printList(LinkedList list) {
        Node node = list.head;

        while (node != null){
            System.out.println(node.data.printPlayer());
            node = node.next;
        }
    }

    public int getLength() {
        int size = 0;
        Node current = this.head;
        while (current != null) {
            size++;
            current = current.next;
        }
        return size;
    }

    public Node getNode(int index){
        Node current = this.head;
        int count = 0;
        while (current != null && current.next != null){
            if (count == index){
                return current;
            }
            current = current.next;
        }
        return current;

    }
    
    /*
        Node[] array = new Node[size()];
        int index = 0;
        Node current = head;
        while (current != null) {
            array[index++] = current;
            current = current.next;
        }

        if (!ascending) {
            comparator = comparator.reversed();
        }

        // Sort the array of nodes based on the specified player
        Arrays.sort(array, 0, size(), Comparator.comparing(node -> comparator.compare(node.data, node.data)));

        // Reconstruct the linked list based on the sorted array
        head = array[0];
        current = head;
        for (int i = 1; i < size(); i++) {
            current.next = array[i];
            current = current.next;
        }
        current.next = null;

        saveDataToFile(); // Save changes to the file
        */
    }
