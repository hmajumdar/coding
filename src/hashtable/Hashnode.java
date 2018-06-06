package com.ds.hashtable;

class Hashnode {

    String key;

    String value;

    Hashnode next;

    Hashnode(String key, String value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }

}