package com.ds.LinkedLists.QueueList;



public class Queue {

    Node head, tail;
    
    // Add to tail

    public void enqueue(int data) {

        Node node = new Node(data);
        if (tail!=null) {
            tail.next = node; // BUG: Visualize queue properly (Start from Node1 and add Node2)
        }
        tail = node; // BUG: new node should be tail now.
        if(head == null) {
            head = node; // If its the first node, its the only node and so its both head and tail.
        }

    }

    // Remove from head
    public int dequeue() {
        int data = head.data;
        head = head.next;

        if(head == null) {
            tail = null; // If you removed the last element, then make sure tail is null
        }

        return data;
    }

    public int peek() {
        if (head != null)
            return head.data;
        return -1;
    }

    public boolean isEmptyQueue() {
        return head == null;
    }

    public void printQueue() {


    }




}
