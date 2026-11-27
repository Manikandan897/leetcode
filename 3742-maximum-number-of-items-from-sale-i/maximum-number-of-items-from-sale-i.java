class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int[] dp = new int[budget + 1];
        int minPrice = Integer.MAX_VALUE;

        for (int[] item : items) {
            int factor = item[0];
            int price = item[1];

            minPrice = Math.min(minPrice, price);

            // Count free items obtained by purchasing this item
            int count = 0;
            for (int[] other : items) {
                if (other[0] % factor == 0) {
                    count++;
                }
            }

            // 0/1 Knapsack: each item type gives its bonus only once
            for (int j = budget; j >= price; j--) {
                dp[j] = Math.max(dp[j], dp[j - price] + count);
            }
        }

        int ans = 0;

        // Use remaining budget to buy the cheapest items
        for (int spent = 0; spent <= budget; spent++) {
            ans = Math.max(ans, dp[spent] + (budget - spent) / minPrice);
        }

        return ans;
    }
}