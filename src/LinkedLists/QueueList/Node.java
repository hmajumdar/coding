package com.ds.LinkedLists.QueueList;

public class Node {

    int data;

    Node next; // head and tail will not be their in node data structure;

    public Node(int data) { // Just data in constructor would suffice, clients wont pass next anyways
        this.data = data;
    }
}