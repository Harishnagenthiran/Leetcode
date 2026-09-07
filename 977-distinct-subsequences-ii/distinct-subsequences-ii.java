class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;

        long dp = 1; // empty subsequence

        long[] last = new long[26];

        for (char c : s.toCharArray()) {

            long oldDp = dp;

            dp = (2 * dp - last[c - 'a'] + MOD) % MOD;

            last[c - 'a'] = oldDp;
        }

        // remove empty subsequence
        return (int) ((dp - 1 + MOD) % MOD);
    }
}