import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();

    public int totalNumbers(int[] digits) {
        boolean[] used = new boolean[digits.length];

        backtrack(digits, used, 0, 0);

        return set.size();
    }

    void backtrack(int[] digits, boolean[] used, int number, int length) {

        // We have formed a 3-digit number
        if (length == 3) {
            set.add(number);
            return;
        }

        for (int i = 0; i < digits.length; i++) {

            // Don't use the same index twice
            if (used[i]) {
                continue;
            }

            int digit = digits[i];

            // First digit cannot be 0
            if (length == 0 && digit == 0) {
                continue;
            }

            // Last digit must be even
            if (length == 2 && digit % 2 != 0) {
                continue;
            }

            // Choose
            used[i] = true;

            // Add digit to number
            int newNumber = number * 10 + digit;

            // Explore
            backtrack(digits, used, newNumber, length + 1);

            // Undo
            used[i] = false;
        }
    }
}