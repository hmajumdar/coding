package com.ds.LinkedLists.StackList.minstack2;

public class MinStack {

    Node top;

    public void push(int data) {

        Node node;

        if( top!=null && data > top.minData) { // BUG: data > top.minData
            node = new Node(data, top.minData);
        } else {
            node = new Node(data, data);
        }

        node.next = top;
        top = node;

    }

    public int pop() {

        int data;

        if (top != null) {
            data = top.data;
            top = top.next;
            return data;
        }

        return -1;
    }


    public int getMin() {

        if (top != null)
            return top.minData;

        return Integer.MAX_VALUE;

    }

    public int peek() {

        if (top != null)
            return top.data;

        return Integer.MAX_VALUE;
    }



}
