package interview.asked;

import java.io.IOException;

public class PossibleSmallestNumberMatchingPattern {

    static int findPossibleSmallestNumberMatchingPattern(String pattern) {
        if (pattern == null || pattern.isEmpty() || pattern.length() > 8) {
            return -1; // Invalid input
        }

        int smallestNumber = Integer.MAX_VALUE;
        for (int startDigit = 1; startDigit <= 9; startDigit++) {
            boolean[] usedDigits = new boolean[10];
            usedDigits[startDigit] = true;

            int currentNumber = startDigit;
            boolean isValid = true;
            for (int i = 0; i < pattern.length(); i++) {
                char direction = pattern.charAt(i);
                int nextDigit;

                if (direction == 'N') {
                    nextDigit = findNextAscendingDigit(currentNumber % 10, usedDigits);
                } else if (direction == 'M') {
                    nextDigit = findNextDescendingDigit(currentNumber % 10, usedDigits);
                } else {
                    isValid = false;
                    break; // Invalid pattern character
                }

                if (nextDigit == -1) {
                    isValid = false;
                    break; // No valid digit available
                }

                currentNumber = (currentNumber % 10) * 10 + nextDigit;
                usedDigits[nextDigit] = true;
            }

            if (isValid && currentNumber < smallestNumber) {
                smallestNumber = currentNumber;
            }
        }

        return smallestNumber == Integer.MAX_VALUE ? -1 : smallestNumber;
    }

    private static int findNextAscendingDigit(int currentDigit, boolean[] usedDigits) {
        for (int digit = currentDigit + 1; digit <= 9; digit++) {
            if (!usedDigits[digit]) {
                return digit;
            }
        }
        return -1; // No valid ascending digit found
    }

    private static int findNextDescendingDigit(int currentDigit, boolean[] usedDigits) {
        for (int digit = currentDigit - 1; digit >= 1; digit--) {
            if (!usedDigits[digit]) {
                return digit;
            }
        }
        return -1; // No valid descending digit found
    }

    public static void main(String[] args) throws IOException {
        // Test cases
        String[] testCases = {"M", "MNM", "NNM", "MMN", "NNNNM", "MNNNN"};

        for (String testCase : testCases) {
            int result = findPossibleSmallestNumberMatchingPattern(testCase);
            System.out.println("Input: " + testCase + ", Output: " + result);
        }
    }
}
