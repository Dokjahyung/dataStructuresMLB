    package com.mycompany.csse240prj1;

//make Node class to be accessed by anyone
    public class Node{
        //data will of node contains player object
        Player data;
        String stat;
        //pointer to next node
        Node next;

        //only have method to add Node with player data attached. reduces confusion and if your node is null just make it Node node = null;
        public Node(Player data) {
            this.data = data;
            next = null;
        }

        public Node(String stat) {
            this.stat = stat;
            next = null;
        }
        
    }