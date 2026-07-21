class Solution {
    public int maxActiveSectionsAfterTrade(String s) {

        int ones = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') ones++;
        }

        String t = "1" + s + "1";
        int n = t.length();

        int[] start = new int[n];
        int[] len = new int[n];

        int m = 0;

        // Store every run (start index and length)
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && t.charAt(j) == t.charAt(i))
                j++;

            start[m] = i;
            len[m] = j - i;
            m++;

            i = j;
        }

        int ans = ones;

        // Runs alternate automatically.
        // A removable 1-run has a 0-run before and after it.
        for (int i = 1; i < m - 1; i++) {

            char ch = t.charAt(start[i]);

            if (ch == '1'
                    && t.charAt(start[i - 1]) == '0'
                    && t.charAt(start[i + 1]) == '0') {

                ans = Math.max(ans, ones + len[i - 1] + len[i + 1]);
            }
        }

        return ans;
    }
}