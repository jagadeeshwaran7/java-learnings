package org.datastructure.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class CustomLinkedList<T> implements CustomList<T> {
    private transient int size = 0;
    private transient int modCount = 0;
    Node head = null;

    private <T> void linkLast(T data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
            ++this.size;
            ++this.modCount;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            ++this.size;
            ++this.modCount;
        }
    }

    private void linkFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> temp = this.head;
            this.head = newNode;
            newNode.next = temp;
        }
        ++this.size;
        ++this.modCount;
    }

    @Override
    public void add(T data) {
        this.linkLast(data);
    }
    @Override
    public boolean add(int position, T data) {
        if (position == 0) {
            System.out.println("WARNING: Invalid Position");
            return false;
        }
        this.insertByPosition(position, data);
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void insert(int position, T data) {
        this.insertByPosition(position, data);
        ++this.modCount;
    }

    private void insertByPosition(int position, T data) {
        Node<T> newNode = new Node<>(data);
        int i = 1;
        Node temp = this.head;
        while (i < position - 1) {
            temp = temp.next;
            i++;
        }
        Node<T> temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        ++this.size;
        ++this.modCount;
    }

    public void deleteHead() {
        this.head = this.head.next;
        --this.size;
        ++this.modCount;
    }

    public Boolean deleteTail() {
        if (isEmpty()) {
            System.out.println("WARNING: Already LinkedList Is Empty");
            return false;
        }
        Node<T> temp = this.head;
        int i = 1;
        if (temp.next == null) {
            this.head = null;
        }
        while (i < this.size - 1) {
            temp = temp.next;
            i++;
        }
        temp.next = null;
        --this.size;
        ++this.modCount;
        return false;
    }

    @Override
    public void deleteByPosition(int position) {
        Node<T> temp = this.head;
        int i = 0;
        int pre = position - 2;
        Node<T> prev = null;
        while (i < position - 1) {
            if (i == pre) {
                prev = temp;
                i++;
            }
            temp = temp.next;
            i++;
        }
        assert prev != null;
        prev.next = temp.next;
        --this.size;
        ++this.modCount;
    }

    @Override
    public void remove() {
        this.deleteTail();
        ++this.modCount;
    }

    @Override
    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public void merge(CustomLinkedList<T> linkedList) {
        Node<T> temp = this.head;
        while (temp.next != null) {
            temp = temp.next;
        }

        while (linkedList.head != null) {
            --linkedList.size;
            temp.next = linkedList.head;
            temp = temp.next;
            linkedList.head = linkedList.head.next;
            this.size++;
        }
        ++this.modCount;
    }

    @Override
    public void show() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println();
    }

    @Override
    public void clear() {
        Node var2;
        while (head != null) {
            var2 = head.next;
            head.data = null;
            head.next = null;
            head = var2;
        }
        this.size = 0;
        ++this.modCount;
    }

    @Override
    public Integer modCount() {
        return this.modCount;
    }

    @Override
    public List<Object> toArray() {
        List<Object> bucket = new ArrayList<>();
        int index = 0;
        Node var1 = this.head;
        while (var1 != null) {
            bucket.add(var1.data);
            var1 = var1.next;
        }
        return bucket;
    }
}
