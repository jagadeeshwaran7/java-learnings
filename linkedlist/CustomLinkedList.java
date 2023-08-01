package org.datastructure.linkedlist;

class Node {
    int data;
    Node next = null;

    public Node(int data) {
        this.data = data;
    }
}

public class CustomLinkedList {
    int size = 0;
    Node head = null;

    public void linkLast(int data) {
        Node newNode = new Node(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        this.size++;
    }

    public void linkFirst(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;
            this.head = newNode;
            newNode.next = temp;
        }
        this.size++;
    }

    public void insert(int position, int data) {
        Node newNode = new Node(data);
        int i = 1;
        Node temp = this.head;
        while (i < position-1) {
            temp = temp.next;
            i++;
        }
        Node temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        this.size++;
    }

    public void deleteHead() {
        this.head = this.head.next;
        this.size--;
    }

    public void deleteTail() {
       Node temp = this.head;
       int i = 1;
       while (i < this.size-1) {
           temp = temp.next;
           i++;
       }
       temp.next = null;
       this.size--;
    }

    public void deleteByPosition(int position) {
        Node temp = this.head;
        int i = 0;
        int pre = position - 2;
        Node prev = null;
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
        this.size--;
    }

    public  void merge(CustomLinkedList linkedList) {
        Node temp = this.head;
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
    }

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("LINKED LIST A");
        CustomLinkedList customLinkedList = new CustomLinkedList();
        for (int i = 1; i <= 10; i++) {
            customLinkedList.linkLast(i);
        }
        customLinkedList.deleteByPosition(10);
        customLinkedList.insert(10, 10);
        customLinkedList.insert(11, 11);
        customLinkedList.insert(12, 12);
        System.out.println(customLinkedList.size);
        customLinkedList.display();
    }
}
