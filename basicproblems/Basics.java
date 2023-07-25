package org.datastructure.basicproblems;

import org.datastructure.array.searching.CustomSearch;

import java.util.HashMap;
import java.util.Map;

public class Basics {
    public static String reverseStringM1(String inputString) {
        StringBuilder response = new StringBuilder(inputString);
        return response.reverse().toString();
    }

    public static String reverseStringM2(String inputString) {
        StringBuilder response = new StringBuilder();
        char[] out = inputString.toCharArray();
        for (int i = inputString.length() - 1; i >= 0; i--) {
            response.append(out[i]);
        }
        return response.toString();
    }

    public static void swap(Integer a, Integer b) {
        System.out.println("A: " + a + " " + "B: " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("A: " + a + " " + "B: " + b);
    }

    public static Boolean isPresentVowel(String inputString) {
        String vowels = "aeiou";
        Map<Integer, Character> hash = new HashMap<>();
        Integer key = 1;
        for (Character character1 : vowels.toCharArray()) {
            hash.put(key, character1);
            key++;
        }
        for (Character character : inputString.toCharArray()) {
            if (hash.containsValue(character)) {

            }
        }
        return Boolean.FALSE;
    }

    public static boolean stringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }

    public static String vowelIndicator(String inputString) {
        String vowels = "aeiou";
        StringBuilder response = new StringBuilder();
        for (Character character : inputString.toCharArray()) {
            for (Character vowel : vowels.toCharArray()) {
                if (vowel.equals(character)) {
                    response.append("->");
                    break;
                }
            }
            response.append(character);

        }
        return response.toString();
    }

    public static Boolean isPrimeNumber(Integer number) {
        if (number >= 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

    public static void printFibonacci(Integer range) {
       int a = 0;
       int b = 1;
       int c = 1;

       for (int i = a; i < range; i++) {
           if (i == range-1) {
               System.out.print(a);
           } else {
               System.out.print(a + ", ");
           }
           a = b;
           b = c;
           c = a + b;
       }
    }

    public static Boolean isPalindrome(String inputString) {
        String reversedString = reverseStringM1(inputString);
        return reversedString.equals(inputString);
    }

    public static String spaceFree(String inputStrng) {
        return inputStrng.replaceAll(" ", "");
    }

    public static Integer toFindFactorial(Integer inputNumber) {
        int factorial = 1;
        for (int i = 1; i <= inputNumber; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static Boolean isArmstrong(Integer inputNumber) {
        int compare = inputNumber;
        int digit = 0;
        int result = 0;
        int testDigit = inputNumber;

        while (testDigit >= 1) {
            digit += 1;
            testDigit /= 10;
        }

        for (int i = 0; i < digit; i++) {
            int response = 1;
            int innerDigit = inputNumber % 10;
            inputNumber /= 10;
            for (int j = 0; j < digit; j++) {
                response *= innerDigit;
            }
            result += response;
        }
        return result == compare;

    }

    public static void main(String[] args) {
        printFibonacci(13);
    }
}

