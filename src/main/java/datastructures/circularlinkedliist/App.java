/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.circularlinkedliist;

import datastructures.circularlinkedliist.CircularLinkedList;

/**
 *
 * @author matte
 */
public class App {
    public static void main(String[] args) {
        CircularLinkedList mylist = new CircularLinkedList();
        mylist.insertFirst(1);
        mylist.insertFirst(490);
        mylist.insertFirst(244);
        mylist.insertFirst(416);
        mylist.insertLast(223);
        
        mylist.displayList();
    }
}
