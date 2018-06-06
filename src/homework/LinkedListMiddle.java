package com.homework;

public class LinkedListMiddle {


    private class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;

    private void addLast(int data) {

        Node node = new Node(data);
        Node current = head;

        if(head == null) {
            head = node;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = node; // NOT current = node;
        }
    }

    // By default add to linked list is in the beginning of the list
    private void add(int data) {

        Node node = new Node(data);

        if(head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }
    }

    private int middle(LinkedListMiddle list) {

        Node fast = head; // Adding to the list would have set the head.
        Node slow = head;

        if(list == null || list.head == null) {
            return -1;
        }

        while( fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow.data;

    }


    public static void main(String args[]) {

        LinkedListMiddle middle = new LinkedListMiddle();
        middle.addLast(1);
        middle.addLast(2);
        middle.addLast(3);

        LinkedListMiddle list = new LinkedListMiddle();
        list.add(1);
        list.add(2);
        list.add(3);


        System.out.println(list.middle(list));


    }







}
