package com.pereverzew.collectionlinkedlist;

import java.util.Optional;

public interface CollectionLinkedList <T> {
    void add(T element);
    boolean remove(T element);
    boolean removeByIndex(int index);
    Optional<T> get(T element);
    Optional<T> getByIndex(int index);
    int size();
}
