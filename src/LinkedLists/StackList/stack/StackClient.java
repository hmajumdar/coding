package com.ds.LinkedLists.StackList.stack;

public class StackClient {

    public static void main(String args[]) {

        Stack stack = new Stack();
        System.out.println(stack.peek()); // -1
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // 3
        System.out.println(stack.pop()); //3
        System.out.println(stack.peek()); //2
        System.out.println(stack.pop()); //2
        System.out.println(stack.pop()); //1
        System.out.println(stack.peek()); //-1
        System.out.println(stack.pop()); //-1


    }
}
