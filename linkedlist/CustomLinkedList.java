package org.datastructure.linkedlist;

public class CustomLinkedList <T> {
    int size = 0;
    Node<T> head = null;

    public void linkLast(T data) {
        Node<T> newNode = new Node<>(data);

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        this.size++;
    }

    public void linkFirst(T data) {
        Node<T> newNode = new Node<>(data);
        if (this.head == null) {
            this.head = newNode;
        } else {
            Node<T> temp = this.head;
            this.head = newNode;
            newNode.next = temp;
        }
        this.size++;
    }

    public  void insert(int position, T data) {
        Node<T> newNode = new Node<>(data);
        int i = 1;
        Node<T> temp = this.head;
        while (i < position-1) {
            temp = temp.next;
            i++;
        }
        Node<T> temp2 = temp.next;
        temp.next = newNode;
        newNode.next = temp2;
        this.size++;
    }

    public void deleteHead() {
        this.head = this.head.next;
        this.size--;
    }

    public void deleteTail() {
       Node<T> temp = this.head;
       int i = 1;
       while (i < this.size-1) {
           temp = temp.next;
           i++;
       }
       temp.next = null;
       this.size--;
    }

    public  void deleteByPosition(int position) {
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
        this.size--;
    }

    public  void merge(CustomLinkedList<T> linkedList) {
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
    }

    public  void display() {
        Node<T> temp = head;
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
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        // customLinkedList.deleteByPosition(10);
        customLinkedList.linkLast("j");
        customLinkedList.linkLast("A");
        customLinkedList.linkLast("G");
        customLinkedList.linkLast("A");
        customLinkedList.display();
        // customLinkedList.deleteByPosition(6);
        // System.out.println(customLinkedList.size);
        // customLinkedList.reverse();
        // customLinkedList.display();
    }
}
