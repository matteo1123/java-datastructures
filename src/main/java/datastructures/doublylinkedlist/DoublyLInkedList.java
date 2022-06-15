/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures.doublylinkedlist;

/**
 *
 * @author matt
 */
public class DoublyLInkedList {
    private Node first;
    private Node last;
    
    public void DoublyLinkedList() {
        this.first = null;
        this.last = null;
    }
    
    public boolean isEmpty() {
        return first == null;
    }
    
    public void insertFirst(int data) {
        Node newNode = new Node();
        newNode.data = data;
        
        if(isEmpty()) {
            last = newNode; //if empty, last will refer to the new node
        } else {
            first.previous = newNode;
        }
        
        newNode.next = first; // the new node's next field will point to the old first
        this.first = newNode;
    }
    
    public void insertLast(int data) {
        Node newNode = new Node();
        newNode.data = data;
        
        if(isEmpty()) {
            first = newNode;
        } else {
            last.next = newNode; //assigning old last to newnode
            newNode.previous = last;
        }
        last = newNode;
    }
    //assuming non empty list    
    public Node deleteFirst() {
        Node temp = first;
        if(first.next == null) { //if there is only one item in the list
            last = null;
        } else {
            first.next.previous = null; //what was the second node now becomes the first, so it's previous is now null
        }
        first = first.next; //the old 2nd field will now be first
        return temp; //return the deleted old first node
    }
    //assuming non empty list
    public Node deleteLast() {
        Node temp = last;
        if(first.next == null) {
            first = null;
        } else {
            last.previous.next = null; //second to the last now becomes last so it's next = null
        }
        last = last.previous; 
        return temp;
    }
        //assuming non empty list
    public boolean insertAfter(int key, int data) {
        Node current = first; //start from the beginning of the list
        
        while (current.data != key) { //as long as we have not found the key in a particular node
            current = current.next;
            if(current == null) {
                return false;
            }
        }
        
        Node newNode = new Node();
        newNode.data = data;

        if(current == last) {
            current.next = null;
            last = newNode;
        } else {
            newNode.next = current.next; //new node's next field should point to the node after the current one
            current.next.previous = newNode; //the node ahead of current's previous should point to the newNode
        }
        newNode.previous = current;
        current.next = newNode;
        
        return true;
    }
    //assuming non empty list
    public Node deleteKey(int key) {
        Node current = first; //start from the beginning of the list
        
        while (current.data != key) { //as long as we have not found the key in a particular node
            current = current.next;
            if(current == null) {
                return null;
            }
        }
        
        if(current == first) {
            first = current.next;
        } else {
            current.previous.next = current.next;        
        }
        
        if(current == last) {
            last = current.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }
    
    public void displayForward() {
        System.out.print("List(first --> last): ");
        Node current = first;
        while(current != null) {
            current.displayNode();
            current=current.next;
        }   
        System.out.println();
    }
    
    public void displayBackward() {
        System.out.print("List(last --> first): ");
        Node current = last;
        while(current != null) {
            current.displayNode();
            current=current.previous;
        }   
        System.out.println();
    }
}
