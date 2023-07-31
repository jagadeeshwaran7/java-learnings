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
            this.size++;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
            this.size++;
        }
    }
    public void linkFirst(int data) {
        Node newNode = new Node(data);
        if (this.head == null) {
            this.head = newNode;
            this.size++;
        } else {
            Node temp = this.head;
            this.head = newNode;
            newNode.next = temp;
            this.size++;
        }
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {

        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.linkFirst(1);
        customLinkedList.linkLast(2);
        customLinkedList.linkLast(3);
        customLinkedList.linkLast(4);
        customLinkedList.linkLast(6);
        customLinkedList.insert(5,5);
        System.out.println("NODES: " + customLinkedList.size);
        customLinkedList.display();
    }
}
