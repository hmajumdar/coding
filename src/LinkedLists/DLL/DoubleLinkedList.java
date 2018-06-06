package com.ds.LinkedLists.DLL;

public class DoubleLinkedList {

    Node head, tail;

    public void append(int data){

        Node current = head;

        Node node = new Node(data);
        if(head == null) {
            head = node;
            return;
        }

        while(current.next!=null) {
            current = current.next;
        }
        current.next = node; // This assignments CAN and SHOULD be done outside while
        node.prev = current;

    }

    public void remove(int data) {

        if(head == null) {
            return;
        }

        Node current = head;

        if(head.data == data) {  // This is important!
            head = head.next;
            return;
        }

        while(current.next!=null) {
            if(current.next.data == data) {
                current.next = current.next.next;
                if (current.next != null) {
                    current.next.prev = current;
                }
                return; // BUG: make sure you return
            }
            current = current.next;
        }
    }

    public void printList() {


    }


}
