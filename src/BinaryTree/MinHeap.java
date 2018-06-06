package com.ds.BinaryTree;

import java.util.Arrays;

public class MinHeap {

    int capacity = 50;

    int items[] = new int[50];

    int size = 0;

    private void ensureCapacity() {
        if(size == capacity) {
            items = Arrays.copyOf(items, capacity*2);
            capacity = capacity*2;
        }
    }

    private void swap(int idx1, int idx2) {
        int temp = items[idx1];
        items[idx1] = items[idx2];
        items[idx2] = temp;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1)/2;
    }

    private int getLeftChildIndex(int parentIndex) {
        return ( 2 * parentIndex + 1 );
    }

    private int getRightChildIndex(int parentIndex) {
        return ( 2 * parentIndex + 2 );
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) > 0;
    }

    private int peek() {
        if(size <= 0) {
            return Integer.MIN_VALUE;
        }
        return items[0];
    }

    private int pop() {
        if(size <= 0) {
            return Integer.MIN_VALUE;
        }
        int item = items[0];
        items[0] = items[size-1];
        heapifyDown();
        size--;
        return item;
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && items[getRightChildIndex(index)] < items[getLeftChildIndex(index)])
                smallIndex = getRightChildIndex(index);
            swap(index, smallIndex); // swap index values
            index = smallIndex; // current index will walk down
        }
    }

    private void push(int data) {
        ensureCapacity();
        items[size] = data;
        size++;
        heapifyUp();
    }


    private void heapifyUp() {

        int index = size-1;
        while (hasParent(index) && items[index] < items[getParentIndex(index)]) {
                swap(index, getParentIndex(index));
                index = getParentIndex(index); // current index will walk up
        }
    }

}
