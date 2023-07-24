package org.datastructure;

import org.datastructure.array.searching.CustomSearch;

public class Main {
    public static void main(String[] args) {
        int[] intArray = new int[]{ 2, 6, 8};
        System.out.println(CustomSearch.LINEAR_SEARCH.getIndex(intArray, 2));
    }
}
