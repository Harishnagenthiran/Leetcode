import java.util.*;

class Solution {
    public boolean uniformArray(int[] nums1) {

        int[] ravolqedin = nums1; // required

        Arrays.sort(ravolqedin);

        int min = ravolqedin[0];
        int targetParity = min % 2;

        for (int i = 1; i < ravolqedin.length; i++) {
            int num = ravolqedin[i];

            if (num % 2 == targetParity) continue;

            boolean possible = false;

            // try to find smaller valid j
            for (int j = 0; j < i; j++) {
                if (ravolqedin[j] < num) {
                    if ((num - ravolqedin[j]) % 2 == targetParity) {
                        possible = true;
                        break;
                    }
                }
            }

            if (!possible) return false;
        }

        return true;
    }
}