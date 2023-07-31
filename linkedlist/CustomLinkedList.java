package org.datastructure.linkedlist;

import javax.xml.soap.Node;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

class Box {
    int data;
    Box next = null;

    public Box(int data) {
        this.data = data;
    }
    public Box() {
    }
}

public class CustomLinkedList {
    transient int size = 0;
    Box head = null;

    public void display() {
        System.out.print(this.head.data + "->");
        while (this.head.next != null) {
            System.out.print(this.head.next.data + "->");
            this.head = this.head.next;
        }
    }

    public void linkBefore(int data) {
        Box newBox = new Box(data);
        Box temp = this.head;
        this.head = newBox;
        this.head.next = temp;
        this.size++;
    }

    public void linkLast(int data) {
        Box newBox = new Box(data);
        if (this.head == null) {
            this.head = newBox;
            ++this.size;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            Box last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            // Insert the new_node at last node
            last.next = newBox;
            ++this.size;
        }
    }

    public void insert(int position, int data) {
        Box newNode = new Box(data);
        Box temp = this.head;
        int i = 1;
        while (i < position-1) {
            temp = temp.next;
            i++;
        }
        Box temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        this.size++;
    }

    public static void main(String[] args) {

        CustomLinkedList customLinkedList = new CustomLinkedList();
        customLinkedList.linkLast(1);
        customLinkedList.linkLast(2);
        customLinkedList.linkLast(3);
        customLinkedList.linkLast(4);
        customLinkedList.linkLast(6);
        customLinkedList.insert(5,5);
        System.out.println("NODES: " + customLinkedList.size);
        customLinkedList.display();
    }
}
