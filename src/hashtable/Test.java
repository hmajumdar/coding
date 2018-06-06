package com.ds.hashtable;

public class Test {

    public static void main(String[] args){

        Hashtable hashtable = new Hashtable();
        hashtable.add("name", "15");
        hashtable.add("age", "16");
        hashtable.add("abc", "17");
        hashtable.add("def", "18");
        hashtable.add("ghi", "19");
        hashtable.add("asdf", "20");
        hashtable.add("agas", "21");
        hashtable.add("asad", "22");
        hashtable.add("fds", "23");
        hashtable.add("gdfi", "24");


        hashtable.remove("gdfi");
//        hashtable.remove("name");
//        hashtable.remove("abc");
        hashtable.remove("asad");
//        hashtable.remove("age");

        hashtable.printTable();

        System.out.println("Value: "+ hashtable.get("asdf"));



    }


}
