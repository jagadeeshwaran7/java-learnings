package org.datastructure;

import org.datastructure.mycollections.linkedlist.CustomLinkedList;
import org.datastructure.mycollections.linkedlist.CustomList;

public class Main {
    public static void main(String[] args) {
        // int[] name = {1, 2, 3, 4, 5};
        CustomList<Integer> mark = new CustomLinkedList<>();
        for (int i = 10; i <= 35; i++) {
            mark.add(i);
        }
        mark.show();
        // mark.clear();
        System.out.println(mark.toArray());
        System.out.println(mark.modCount());
        mark.remove();
        mark.show();
        System.out.println(mark.isEmpty());
    }
}
