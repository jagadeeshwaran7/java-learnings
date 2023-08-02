package org.datastructure.linkedlist;

import java.util.List;

public interface CustomList <T> {
    void add(T data);

    int size();

    int hashCode();

    void insert(int position, T data);

    void deleteByPosition(int position);

    void remove();

    boolean isEmpty();

    void show();

    void clear();
    Integer modCount();

    List<Object> toArray();

    public boolean add(int position, T data);
}
