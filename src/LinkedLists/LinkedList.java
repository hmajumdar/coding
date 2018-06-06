package com.ds.LinkedLists;

public class LinkedList {


    private class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

//    This is important!
    private Node head;
    private int size = 0;


    // Add in first by default, and that becomes head. No need of current pointer.
    private void add(int data) {

        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            node.next = head;
            head = node;
        }

    }


    private void removeMiddle(Node head, int position) {


    }

    private void removeFirst(Node head) {


    }

    private void removeLast(Node head) {


    }


    private int get(Node node) {


        return -1;
    }


    private void print(Node node) {
        Node current = node;

        if(current == null) {
            System.out.println("Empty List");
        }

        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    // Head is with you, its an instance variable!
    private int getSize() {
        if(head == null)
            return 0;
        Node current = head;
        while (current!=null) {
            current = current.next;
            size++;
        }
        return size;
    }

    // Make reverse argument take node as input
    private Node reverse(Node node) {

        Node prev = null;
        Node current= node;
        Node next;

        while (current!= null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;

    }

    Node node1, node2;

    private void findMiddle(Node node) {

        Node slow = node;
        Node fast = slow.next;

        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node1 = node;
        node2 = reverse(slow.next);

        // changes node1 from 1-2-3-4-5-null to 1-2-3-null
        slow.next = null; // Means NEXT pointer of the current node will point to null, it DOESN'T make node2 as null.
    }


//    https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
    private void zipList(){

        findMiddle(head); // splits two nodes from middle

        Node node = new Node(0);

        Node current = node;


        // Merge two nodes alternatively using current
        while (node1 != null ||  node2 != null) { // This should be OR, it wont cover all the nodes if its AND

            if (node1 != null) {
                current.next = node1;
                current = current.next;
                node1 = node1.next;
            }

            if (node2 != null) {
                current.next = node2;
                current = current.next;
                node2 = node2.next;
            }

        }

        node = node.next;
        print(node);

//        Node current = node1;
//        while(node1 != null && node2!=null) {
//
//            current.next = node2; // It effects node1 pointer as well; both node1, current -> (1->5->4)
//            node1 = node1.next;
//            current = node1;
//            node2 = node2.next;
//
//        }
//        System.out.println(node1.data);
//        System.out.println(node2.data);


    }


    // Temp points to 3rd node, next to Q.
    private Node swapPairs() {


        Node p = head;
        Node q, temp;

        Node newStart = p.next;

        while(true) {

            q = p.next;
            temp = q.next;
            q.next = p;

            if(temp == null || temp.next==null) {
                p.next = temp; // Not Q to next, remember P and Q will be swapped  and so at end Q->P>Temp where Temp==null
                break;
            }

            p.next = temp.next; // 1st node should point to 4th node.
            p = temp; // New destination of p, NOT just changing its next, it should itself jump to next pair node.

        }

        return newStart;
    }



    public static void main(String args[]) {

        LinkedList list = new LinkedList();
        list.add(6);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);

        list.zipList();
//        Node swapped = list.swapPairs();
//        list.print(swapped);

//        System.out.println(list.getSize());
//        list.print();
//        list.reverse();
//        list.print();

//        Node middle = list.findMiddle();
//        System.out.println("Middle Node: " + middle.data);

    }





}
