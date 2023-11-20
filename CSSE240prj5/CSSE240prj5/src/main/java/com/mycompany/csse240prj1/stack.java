package com.mycompany.csse240prj1;
/*
Credit for information on how stacks work
https://www.geeksforgeeks.org/introduction-to-stack-data-structure-and-algorithm-tutorials/
*/
public class stack{

    LinkedList stack = new LinkedList();

    public stack(){}
    public stack(LinkedList list){
        this.stack = list;
    }

    public void push(Node n){
        if (stack.head == null){ stack = new LinkedList();}
        n.next = stack.head;
        stack.head = n;
    }

    public Node pop(){
        if (stack.head == null){ return null;}
        Node curr = stack.head;
        stack.head = stack.head.next;
        return curr;
    }
}