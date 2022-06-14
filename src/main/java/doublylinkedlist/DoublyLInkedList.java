/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;

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
    public Node deleteFirst() {
        Node temp = first;
        if(first.next == null) {
            last = null;
        } else {
            first.next.previous = null;
        }
        first = first.next;
    }
    
}
