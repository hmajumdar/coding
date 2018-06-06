package com.ds.LinkedLists.QueueList;

public class QueueClient {



    public static void main(String args[]) {

        Queue queue = new Queue();
        System.out.println(queue.peek()); // -1
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println(queue.peek()); //1
        System.out.println(queue.dequeue()); //1
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        System.out.println(queue.peek()); //2
    }

}
