package com.ds.LinkedLists.StackList.minstack;

public class MinStack extends Stack {

    Node top;

    Stack minStack = new Stack(); // BUG: Stack Overflow if you dont "extends"

    public void push(int data) {

        Node node = new Node(data);
        if (top == null) {
            top = node;
        } else {   // BUG: else is required!
            node.next = top;
            top = node;
        }
        if (this.peek() <= minStack.peek()) {
            minStack.push(data);
        }

    }

    public int getMin() {
        return minStack.peek();
    }


    public int pop() {
        if(top != null) {
            int data = top.data;
            if (top.data == minStack.peek()) {
                minStack.pop();
            }
            top = top.next;
            return data;
        }
        return -1;
    }


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
