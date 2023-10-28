package com.mycompany.csse240prj1;

public class LinkedList {
    Node head;

    static class Node{
        Player data;
        Node next;

        public Node(Player data) {
            this.data = data;
            next = null;
        }
    }

    public static LinkedList insert(LinkedList list, Player data) {
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
    public static LinkedList delete(LinkedList list, int entry){
        return list;
    }
    public static void printList(LinkedList list) {
        Node node = list.head;

        while (node != null){
            System.out.println(node.data.printPlayer());
            node = node.next;
        }
    }

    public static int listSize(LinkedList list){
        int size = 0;
        while (list.head != null){
            size++;
            list.head = list.head.next;
        }
        return size;
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
