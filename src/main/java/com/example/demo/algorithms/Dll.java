//package com.example.demo.algorithms;
//
//import com.example.demo.algorithms.exceptions.InvalidElementException;
//
//import java.util.NoSuchElementException;
//
//public class Dll<E> {
//
//    DllNode<E> dummyHead;
//    DllNode<E> dummyTail;
//
//
//
//    public  Dll() {
//        dummyHead = new DllNode<>(null);
//        dummyTail = new DllNode<>(null);
//
//        dummyHead.next = dummyTail;
//        dummyTail.next = dummyHead;
//
//    }
//
//    // method 1 - Detach Node
//
//    public void detachNode(DllNode<E> node) {
//        if(node!=null)
//        {
//             node.prev.next = node.next;
//             node.next.prev = node.prev;
//
//        }
//    }
//
//    public void addNodeAtLast(DllNode<E> node) {
//        DllNode<E> tailPrev = dummyTail.prev;
//        tailPrev.next = node;
//        node.next = dummyTail;
//        dummyTail.prev = node;
//        node.prev = tailPrev;
//
//    }
//
//    public DllNode<E> addElementAtLast(E element) {
//
//        if(element==null) {
//            throw new InvalidElementException();
//        }
//        DllNode<E> node = new DllNode<>(element);
//        addNodeAtLast(node);
//        return node;
//
//    }
//
//    public boolean isItemPresent() {
//        return dummyHead.next == dummyTail;
//    }
//
//    public DllNode<E> getFirstNode() throws NoSuchElementException {
//        if (isItemPresent()) {
//            return null;
//        }
//        return dummyHead.next;
//
//    }
//    public DllNode<E> getLastNode() throws NoSuchElementException {
//        if (isItemPresent()) {
//            return null;
//        }
//        return dummyTail.prev;
//    }
//
//}

package com.example.demo.algorithms;

import com.example.demo.algorithms.exceptions.InvalidElementException;

import java.util.NoSuchElementException;

public class Dll<E> {

    private final DllNode<E> dummyHead;
    private final DllNode<E> dummyTail;

    public Dll() {
        // Properly initialize the dummy head and tail
        dummyHead = new DllNode<>(null);
        dummyTail = new DllNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;  // FIXED: Link tail to head properly
    }

    // Detach a node safely
    public void detachNode(DllNode<E> node) {
        if (node != null && node.prev != null && node.next != null) {
            node.prev.next = node.next;
            node.next.prev = node.prev;

            // Clear the detached node's pointers
            node.next = null;
            node.prev = null;
        }
    }

    // Add a node at the end of the list
    public void addNodeAtLast(DllNode<E> node) {
        if (node == null) {
            return;
        }

        DllNode<E> tailPrev = dummyTail.prev;

        // Correctly attach the new node before dummyTail
        tailPrev.next = node;
        node.prev = tailPrev;

        node.next = dummyTail;
        dummyTail.prev = node;
    }

    // Add an element at the end and return the new node
    public DllNode<E> addElementAtLast(E element) {
        if (element == null) {
            throw new InvalidElementException();
        }

        DllNode<E> node = new DllNode<>(element);
        addNodeAtLast(node);
        return node;
    }

    // Check if the DLL is empty
    public boolean isItemPresent() {
        return dummyHead.next == dummyTail;  // FIXED: Proper empty check
    }

    // Get the first node or throw an exception if the list is empty
    public DllNode<E> getFirstNode() {
        if (isItemPresent()) {
            throw new NoSuchElementException("DLL is empty");
        }
        return dummyHead.next;
    }

    // Get the last node or throw an exception if the list is empty
    public DllNode<E> getLastNode() {
        if (isItemPresent()) {
            throw new NoSuchElementException("DLL is empty");
        }
        return dummyTail.prev;
    }
}

