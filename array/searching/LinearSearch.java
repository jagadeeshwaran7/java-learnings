package org.datastructure.array.searching;

public class LinearSearch implements Search {
    private static final LinearSearch LINEAR_SEARCH = new LinearSearch();

    /*
     * Here im using private constructor for restrict creating object externally,
     * It helps to maintain singleton object
     */
    private LinearSearch() {
    }

    public static LinearSearch getLinearSearch() {
        return LINEAR_SEARCH;
    }

    /*
     * This method is created for to find value in a given array,
     * If the element is present in a given array it returns "True"
     * otherwise it returns "False".

     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    @Override
    public final Boolean isPresent(int[] inputArray, int find) {
        for (int value : inputArray) {
            if (value == find) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    /*
     * This method is created for to get index by giving a value
     * To find where the given value is present in a given array
     * If the value is found it will return index of a value else,
     * It will return Boolean value Boolean.False

     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
   @Override
    public final Object getIndex(int[] inputArray, int value) {

        for (int index = 0; index < inputArray.length; index++) {
            if (inputArray[index] == value) {
                return index;
            }
        }
        return Boolean.FALSE;
    }
}
