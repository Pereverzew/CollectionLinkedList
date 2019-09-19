package com.pereverzew.collectionlinkedlist;

import java.util.Optional;

public class CollectionLinkedListImpl <T> implements CollectionLinkedList <T> {
    Node head;
    Node tail;
    int size;

    public CollectionLinkedListImpl() {
        head=null;
        tail=null;
        size=0;
    }


    public void add(T element) {
        if (null==element){return;}
        Node node= new Node(element);
        if (size==0){
            head=node;
            tail=node;
        }else{
            tail.setNext(node);
            node.setPrevious(tail);
            tail=node;
        }
        size++;
    }

    public boolean remove(T element) {
        if (null==element){return false;}
        if (size==0){return false;}

        Node deletingNode=new Node(element);
        Node node=head;
        for (int i = 0; i <size ; i++) {
            if (node.getElement().equals(deletingNode.getElement())){
                return removeByIndex(i);
            }
            node=node.getNext();
        }
        return false;
    }


    public boolean removeByIndex(int index) {
        if (index<0 || index >= size){return false;}

        if (size==1){
            head=null;
            tail=null;
            size--;
            return true;
        }
        if (index==0){
            head=head.getNext();
            head.setPrevious(null);
            size--;
            return true;
        }
        if (index==size-1){
            tail=tail.getPrevious();
            tail.setNext(null);
            size--;
            return true;
        }

        Node node= head;
        for (int i = 1; i <=index ; i++) {
            node=node.getNext();
        }
        size--;

        Node prev=node.getPrevious();
        Node next= node.getNext();
        next.setPrevious(prev);
        prev.setNext(next);
        return true;
    }

    public Optional<T> get(T element) {
        if (null==element){return Optional.empty();}
        Node deletingNode= new Node(element);
        Node node= head;
        for (int i = 0; i <size ; i++) {
            if (node.getElement().equals(deletingNode.getElement())){
                return  Optional.of((T) node.getElement());
            }
            node=node.getNext();
        }
        return Optional.empty();
    }

    public Optional<T> getByIndex(int index) {
        if (index<0 || index >= size){return Optional.empty();}
        Node node= head;
        for (int i = 1; i <=index ; i++) {
            node=node.getNext();
        }
        return Optional.of((T) node.getElement());
    }

    public int size() {
        return size;
    }
}
