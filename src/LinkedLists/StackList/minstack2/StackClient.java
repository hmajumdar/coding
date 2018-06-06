package com.ds.LinkedLists.StackList.minstack2;


public class StackClient {

    public static void main(String args[]) {

        MinStack stack = new MinStack();
        System.out.println(stack.peek()); // -1

        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // 3
        System.out.println(stack.getMin()); // 2
        stack.push(1);
        System.out.println(stack.getMin()); // 1
        stack.pop();
        System.out.println(stack.getMin()); // 2
    }
}
