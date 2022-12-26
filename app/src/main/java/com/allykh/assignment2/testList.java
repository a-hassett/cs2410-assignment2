package com.allykh.assignment2;

public class testList {
    public static void main(String[] args){
        DoublyLinkedList history = new DoublyLinkedList();

        history.addNew("a");
        history.addNew("b");
        history.addNew("c");
        //System.out.println(history.goForward());
        System.out.println(history.goBack());
    }
}
