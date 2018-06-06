package com.ds.LinkedLists.StackList.minstack;

public  class Stack {


    com.ds.LinkedLists.StackList.minstack.Node top;


    public void push(int data) {

        com.ds.LinkedLists.StackList.minstack.Node node = new com.ds.LinkedLists.StackList.minstack.Node(data);
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
        return Integer.MAX_VALUE;

    }

    //isEmpty
    public boolean isEmpty() {
        return top == null;
    }




}
