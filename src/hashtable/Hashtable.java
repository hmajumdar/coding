package com.ds.hashtable;

class Hashtable {

     static int TABLE_SIZE = 5;

    //actual size
    int size = 0;

    private Hashnode[] bucketsArray;

    Hashtable() {
        bucketsArray = new Hashnode[TABLE_SIZE];
        for(int i=0; bucketsArray.length<5; i++) {
            bucketsArray[i] = null;
        }
    }

    // HASH FUNCTION
    int hashfunc(String key) {
        int code = key.hashCode();
        return code%TABLE_SIZE;
    }

    // Add
    public void add(String key, String value) {

        int index = hashfunc(key);

        // If key exists, simply replace the value
        Hashnode headNode = bucketsArray[index];
        while(headNode != null) {
            if (headNode.key.equals(key)) {
                headNode.value = value;
                return;
            }
            headNode = headNode.next;
        }

        // if key is not found,  either headNode is the null or the lastNode
        Hashnode lastNode = headNode;

        // Reset headNode as the first Node
        headNode = bucketsArray[index];

        Hashnode newNode = new Hashnode(key, value);

        // Now your new node can be the first Node, or you could do
        newNode.next = headNode;
        bucketsArray[index]= newNode;
        size++;

        // Alternatively
        if (lastNode!= null) {
            lastNode.next = newNode;
        } else {
            bucketsArray[index]= newNode;
        }
    }


    public void remove(String key) {
        int index = hashfunc(key);
        Hashnode headNode = bucketsArray[index];
        Hashnode prevNode = null;

            // loop until you don't find, prevNode and headNode(as the keyNode)
            while(headNode != null) {
                if (headNode.key.equals(key)) {
                    break;
                }
                prevNode = headNode;
                headNode = headNode.next;
            }

            if(prevNode==null) {
                bucketsArray[index]= headNode.next;
            } else {
                prevNode.next = headNode.next;
            }
            size--;
    }

    public String get(String key) {

        int index = hashfunc(key);
        Hashnode headNode =  bucketsArray[index];

            while(headNode != null) {
                if(headNode.key.equals(key)) {
                    return headNode.value;
                }
                headNode = headNode.next;
            }
            return "-1";
    }



    // Print
    public void printTable() {

        int count = 0;
        for(Hashnode headNode: bucketsArray) {

            System.out.println("Bucket: "+count++);

            while (headNode != null) {
//                System.out.println("Key: " + headNode.key );
                System.out.println(headNode.value);
                headNode = headNode.next;
            }
        }

    }

}