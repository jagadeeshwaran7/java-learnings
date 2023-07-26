package org.datastructure;

import org.datastructure.array.searching.CustomSearch;

public class Main {
    public static void main(String[] args) {
        int[] name = {1, 2, 3, 4, 5};
        Boolean itContains = CustomSearch.LINEAR_SEARCH.isPresent(name, 6);
        Boolean isPresent = CustomSearch.LINEAR_SEARCH.isPresent(name, 1);
        System.out.println(isPresent);
        System.out.println(itContains);
    }
}
