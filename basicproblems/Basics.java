package org.datastructure.basicproblems;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Basics {
    public static @NotNull String reverseStringM1(String inputString) {
        StringBuilder response = new StringBuilder(inputString);
        return response.reverse().toString();
    }

    public static @NotNull String reverseStringM2(String inputString) {
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

    public static @NotNull Boolean isPresentVowel(String inputString) {
        String vowels = "aeiou";
        Map<Integer, Character> hash = new HashMap<>();
        Integer key = 1;
        for (Character character1 : vowels.toCharArray()) {
            hash.put(key, character1);
            key++;
        }
        for (Character character : inputString.toCharArray()) {
            if (hash.containsValue(character)) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static @NotNull Boolean stringContainsVowels(String input) {
        return input.toLowerCase().matches(".*[aeiou].*");
    }

    public static@NotNull String vowelIndicator(String inputString) {
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

    public static @NotNull Boolean isPrimeNumber(Integer number) {
        if (number >= 2) {
            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    return Boolean.FALSE;
                }
            }
        }
        return Boolean.TRUE;
    }

     public static @NotNull List<Integer> getPrimeNumbers(Integer from, Integer to) {
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = from; i < to; i++) {

            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    break;
                } else if (j == i - 1) {
                    primeNumbers.add(i);

                }
            }

        }

        return primeNumbers;
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

    public static @NotNull Boolean isPalindrome(String inputString) {
        String reversedString = reverseStringM1(inputString);
        return reversedString.equals(inputString);
    }

    public static @NotNull String spaceFree(String inputStrng) {
        return inputStrng.replaceAll(" ", "");
    }

    public static @NotNull Integer toFindFactorial(Integer inputNumber) {
        int factorial = 1;
        for (int i = 1; i <= inputNumber; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static @NotNull Boolean isArmstrong(Integer inputNumber) {
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
        System.out.println(getPrimeNumbers(10, 50));
    }
}

