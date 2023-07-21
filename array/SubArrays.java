package org.datastructure.array;

import com.sun.istack.internal.NotNull;

public class SubArrays {
    // Java program to generate all possible subArrays
// Complexity- O(n^3)
    public static void toFindAllSubArrays(@NotNull int[] array) {
        int subset = 1;
        // Taking starting point of an array
        for (int i = 0; i < array.length; i++) {
            //Taking ending part of an array
            for (int j = i; j < array.length; j++) {
                // Printing from starting to ending interval of array elements
                System.out.print("Sub Array" + "(" + subset + ") :");
                for (int k = i; k <= j; k++) {
                    System.out.print(" [" + array[k] + "]");
                }
                subset += 1;
                System.out.println();
            }
        }
    }
}
