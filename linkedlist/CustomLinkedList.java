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
        customLinkedList.linkFirst(1);
        customLinkedList.linkLast(2);
        customLinkedList.linkLast(3);
        customLinkedList.linkLast(4);
        customLinkedList.linkLast(6);
        customLinkedList.insert(5,5);
        System.out.println("NODES: " + customLinkedList.size);
        customLinkedList.display();

        CustomLinkedList customLinkedList2 = new CustomLinkedList();
        customLinkedList2.linkLast(7);
        customLinkedList2.linkLast(8);
        customLinkedList2.linkLast(9);
        customLinkedList2.linkLast(10);
        System.out.println("LINKED LIST B");
        System.out.println("NODES: " + customLinkedList2.size);
        customLinkedList2.display();
        System.out.println("----------------------------");
        System.out.println("AFTER MERGE");
        customLinkedList.merge(customLinkedList2);
        System.out.println("NODES: " + customLinkedList.size);
        customLinkedList.display();

        System.out.println("LINKED LIST B");
        System.out.println("NODES: " + customLinkedList2.size);
        customLinkedList2.display();

        CustomLinkedList linkedList3 = new CustomLinkedList();
        linkedList3.linkLast(11);
        linkedList3.linkLast(12);
        linkedList3.linkLast(13);
        linkedList3.linkLast(14);
        linkedList3.linkLast(15);
        customLinkedList.merge(linkedList3);

        System.out.println("NODES: " + customLinkedList.size);
        customLinkedList.display();
        customLinkedList.deleteByPosition(6);
        System.out.println("After Delete: " + customLinkedList.size);
        customLinkedList.deleteByPosition(12);
        System.out.println("After Delete: " + customLinkedList.size);
        System.out.println(customLinkedList.size);
        customLinkedList.display();
    }
}
