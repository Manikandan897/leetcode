class Solution {
    public String smallestPalindrome(String s, int k) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }

        int[] half = new int[26];
        StringBuilder mid = new StringBuilder();

        for (int i = 0; i < 26; i++) {
            half[i] = freq[i] / 2;
            if ((freq[i] & 1) == 1) {
                mid.append((char) ('a' + i));
            }
        }

        if (countWays(half, k) < k) {
            return "";
        }

        int halfLen = 0;
        for (int x : half) halfLen += x;

        StringBuilder left = new StringBuilder();

        for (int pos = 0; pos < halfLen; pos++) {
            for (int c = 0; c < 26; c++) {
                if (half[c] == 0) continue;

                half[c]--;
                long ways = countWays(half, k);

                if (ways >= k) {
                    left.append((char) ('a' + c));
                    break;
                } else {
                    k -= ways;
                    half[c]++;
                }
            }
        }

        String right = new StringBuilder(left).reverse().toString();
        return left.toString() + mid.toString() + right;
    }

    private long countWays(int[] cnt, long limit) {
        int total = 0;
        for (int x : cnt) total += x;

        long res = 1;
        int used = 0;

        for (int x : cnt) {
            for (int i = 1; i <= x; i++) {
                res = res * (used + i) / i;
                if (res > limit) return limit + 1;
            }
            used += x;
        }

        return res;
    }
}