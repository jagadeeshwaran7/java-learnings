package org.datastructure.practice.arrayproblems;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;
import java.util.BitSet;

public class MissingNumbers {
    // To find a missing number in an array
   //Time Complexity=O(n)
    public static int toFindAMissingNumber(@NotNull int[] array, @NotNull int length) {
        int sumOfArray = 0;
        int expectedSum = length * ((length + 1) / 2);
        for (int i : array) {
            sumOfArray += i;
        }
        return expectedSum - sumOfArray;
    }

    public static void printMissingNumbers(int[] numbers, int count) {
        int missingCount = count - numbers.length;
        BitSet bitSet = new BitSet(count);

        for (int number : numbers) {
            bitSet.set(number - 1);
        }

        System.out.printf("Missing numbers in integer array %s, with total number %d is %n", Arrays.toString(numbers), count);
        int lastMissingIndex = 0;

        for (int i = 0; i < missingCount; i++) {
            lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
            System.out.println(++lastMissingIndex);
        }

    }

    public static void ToFindMissingNumberInAP(int[] numbers, int count) {
        //No of elements in given array
        int noOfElements = numbers.length;
        //To storing AP(Arithmetic Progression) values
        int result = 0;
        // To store first element of given array
        int firstElement = numbers[0];
        //To store last element of given array
        int lastElement = numbers[noOfElements - 1];
        //To store sum of all elements in a given array
        int sumOfElements = 0;
        //Iterating each index for fetching each values from the given array for finding sum of all elements
        for (int number : numbers) {
            sumOfElements += number;
        }

        /*
         * s(n) = n/2 (a+l)
         * To find series of n where, a is first element of an array and l is last element of an array
         * we divided the below AP(Arithmetic Progression) formula
         */
        result = (firstElement + lastElement) / 2;
        result = result * (noOfElements + 1);

        int missingNumber = result - sumOfElements;
        System.out.println(missingNumber);

        //Time Complexity: O(n)
        //Space Complexity: O(1)

    }

}
