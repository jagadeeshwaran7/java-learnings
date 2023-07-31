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

    public static @NotNull String vowelIndicator(String inputString) {
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

    public static List<Integer> printFibonacci(Integer range) {
        List<Integer> fibonacci = new ArrayList<>();
        int a = 0;
        int b = 1;
        int c = 1;

        for (int i = 0; i < range; i++) {
            fibonacci.add(a);
            a = b;
            b = c;
            c = a + b;
        }
        return fibonacci;
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

    public static Boolean isFollowsAP(int[] sequence) {
        int t1 = sequence[0];
        int t2 = sequence[1];
        int commonDifference = t2 - t1;
        int testNext = sequence[0];

        for (int i = 0; i < sequence.length; i++) {
            if (!(sequence[i] == testNext)) {
                return Boolean.FALSE;
            }
            testNext += commonDifference;
        }
        return Boolean.TRUE;
    }

    /*
     * s: integer, starting point of house location.
     * t: integer, ending location of  house location.
     * a: integer, location of the Apple tree.
     * b: integer, location of the Orange tree.
     * apples: integer array, distances at which each apple falls from the tree.
     * oranges: integer array, distances at which each orange falls from the tree.
     */
    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {
        int noOfApples = 0;
        int noOfOranges = 0;

        for (Integer apple : apples) {
            if (s <= apple + a && t >= apple + a) {
                noOfApples++;
            }
        }
        for (Integer orange : oranges) {
            if (s <= (orange + b) && t >= (orange + b)) {
                noOfOranges++;
            }
        }
        System.out.println(noOfApples);
        System.out.println(noOfOranges);
    }

    public static Boolean isEven(Integer input) {
        return input % 2 == 0;
    }

    public static Boolean isOdd(Integer input) {
        return input % 2 != 0;
    }

    public static int add(int x, int y) {
        int z = x + y;
        return z;
    }

    public static void breakingRecords(List<Integer> scores) {
        int breakingHighScore = 0;
        int breakingLowScore = 0;
        int currentHighScore = scores.get(0);
        int currentLowScore = currentHighScore;
        for (Integer score: scores) {
            if (currentHighScore < score) {
                currentHighScore = score;
                breakingHighScore++;
            }

            if (currentLowScore > score) {
                currentLowScore = score;
                breakingLowScore++;
            }
        }

        System.out.println("Breaking High Scores: " + breakingHighScore);
        System.out.println("Breaking Low Scores: " + breakingLowScore);
    }

    public static void main(String[] args) {
        //int[] name = {4, 8, 12, 16, 20};
        //10 5 20 20 4 5 2 25 1
        List<Integer> scores = new ArrayList<>();
        breakingRecords(scores);
    }
}
