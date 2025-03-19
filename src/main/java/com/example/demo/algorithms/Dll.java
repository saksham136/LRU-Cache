package com.example.demo.algorithms;

import com.example.demo.algorithms.exceptions.InvalidElementException;

import java.util.NoSuchElementException;

public class Dll<E> {

    DllNode<E> dummyHead;
    DllNode<E> dummyTail;



    public  Dll() {
        dummyHead = new DllNode<>(null);
        dummyTail = new DllNode<>(null);

        dummyHead.next = dummyTail;
        dummyTail.next = dummyHead;

    }

    // method 1 - Detach Node

    public void detachNode(DllNode<E> node) {
        if(node!=null)
        {
             node.prev.next = node.next;
             node.next.prev = node.prev;

        }
    }

    public void addNodeAtLast(DllNode<E> node) {
        DllNode<E> tailPrev = dummyTail.prev;
        tailPrev.next = node;
        node.next = dummyTail;
        dummyTail.prev = node;
        node.prev = tailPrev;

    }

    public DllNode<E> addElementAtLast(E element) {

        if(element==null) {
            throw new InvalidElementException();
        }
        DllNode<E> node = new DllNode<>(element);
        addNodeAtLast(node);
        return node;

    }

    public boolean isItemPresent() {
        return dummyHead.next == dummyTail;
    }

    public DllNode<E> getFirstNode() throws NoSuchElementException {
        if (isItemPresent()) {
            return null;
        }
        return dummyHead.next;

    }
    public DllNode<E> getLastNode() throws NoSuchElementException {
        if (isItemPresent()) {
            return null;
        }
        return dummyTail.prev;
    }

}
