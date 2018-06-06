package com.ds.LinkedLists.StackList.stack;

public class Stack {

//    public static class Node {
//        int data;
//        Node next;
//
//        public Node(int data) {
//            this.data = data;
//        }
//    }


    Node top;


    public void push(int data) {

        Node node = new Node(data);
        if (top == null) {
            top = node;
        } else {   // BUG: else is required!
            node.next = top;
            top = node;
        }

    }



    public int pop() {
        if(top != null) {
            int data = top.data;
            top = top.next;
            return data;
        }
        return -1;
    }

    //pop

    //peek
    public int peek() {

        if(top!=null) {
            return top.data;
        }
        return -1;

    }

    //isEmpty
    public boolean isEmpty() {
        return top == null;
    }




}
