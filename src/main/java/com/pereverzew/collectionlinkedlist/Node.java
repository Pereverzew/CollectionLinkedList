package com.pereverzew.collectionlinkedlist;

import lombok.Data;

@Data
public class Node <T>{
    Node next;
    Node previous;
    T element;

    public Node(T element) {
        next = null;
        previous = null;
        this.element=element;
    }
}
