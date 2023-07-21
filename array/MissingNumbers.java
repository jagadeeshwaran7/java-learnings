package org.datastructure.array;

import com.sun.istack.internal.NotNull;

public class MissingNumbers {
    // To find a missing number in an array
//Time Complexity=O(n)
    public static int toFindOneMissingNumber(@NotNull int[] array, @NotNull int length) {
        int sumOfArray = 0;
        int expectedSum = length * ((length + 1) / 2);
        for (int i : array) {
            sumOfArray += i;
        }
        return expectedSum - sumOfArray;
    }
}
