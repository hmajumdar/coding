package com.ds.lru;

import com.ds.LinkedLists.DLL.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> { // K, V is needed here to be used inside class.

    // Double linked list Node
    private class Node<T, U> {

        T key; // Key is needed to delete the node from cache(Hashmap) when required
        U value;
        Node<T, U> prev;
        Node<T, U> next;

        public Node(T key, U value, Node<T, U> prev, Node<T, U> next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Map<K, Node<K, V>> cache = new HashMap<>();
    private int max_size;
    private int current_size;

    // LRU and MRU pointers (to be tracked and updated)
    private Node<K, V> lru;
    private Node<K, V> mru;

    public LRUCache(int max_size) {
        this.cache = cache;
        this.max_size = max_size;
        this.current_size = current_size;
        this.lru = lru;
        this.mru = mru;
    }


    // Returns value of the Node, not the Node itself
    public V get(K key) {

        Node<K, V> tempNode = cache.get(key);

        if (tempNode == null) {
            return null;
        }

        // Temp node can be already MRU, LRU or Middle. It must become/remain MRU

        // MRU
        else if (tempNode.key == mru.key){
            return tempNode.value;
        }

        // Get previous and next
        Node<K, V> nextNode = tempNode.next;
        Node<K, V> prevNode = tempNode.prev;

        //If LRU: next node becomes new LRU (We will update tempNode as MRU later)
        if (tempNode.key == lru.key) {
            nextNode.prev = null;
            lru = nextNode; // Dont forget this
        }

        // If Middle
        else if(tempNode.next != null && tempNode.prev!=null) {
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        // Finally update it as MRU
        tempNode.prev = mru;
        mru.next = tempNode;
        mru = tempNode; // Dont forget this
        mru.next = null;

        return tempNode.value;

    }

    public void put(K key, V value) {

        // 0. Return; if key already exists
        if(cache.containsKey(key)) {
            return;
        }

        // 1. Create and Add as MRU
        Node<K, V> newNode = new Node<K, V>(key, value, mru, null); // Important!
        mru.next = newNode;
        cache.put(key, newNode);
        mru = newNode;

        // 2. Resize
        if(current_size < max_size) {
            if (current_size == 0) {
                lru = newNode;
                mru = newNode;
            }
            current_size++;
        }

        // 3. Evict: If currentCapacity more than maxCapacity, evict node from both cache/Hashmap and DLL/LRU
        else if(current_size == max_size) {
            cache.remove(lru.key); //
            lru = lru.next;
            lru.prev = null;
        }

    }


}
