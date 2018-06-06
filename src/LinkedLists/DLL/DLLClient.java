package com.ds.LinkedLists.DLL;


public class DLLClient {



    public static void main(String args[]) {

        DoubleLinkedList drr = new DoubleLinkedList();
        drr.append(1);
        drr.append(2);
        drr.append(3);
        drr.append(4);
        drr.append(5);
        drr.append(6);
        drr.append(7);
        drr.remove(7);
        drr.remove(6);
        drr.remove(5);
        drr.remove(4);
        drr.remove(3);

    }

}
