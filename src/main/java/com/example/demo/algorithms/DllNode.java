package com.example.demo.algorithms;


//import lombok.Getter;

import lombok.Getter;

//@Getter
public class DllNode<E> {
    DllNode<E> prev;
    DllNode<E> next;
    @Getter
    E element;

    public DllNode(E element) {
        this.element = element;
        this.next = null;
        this.prev = null;
    }


}
