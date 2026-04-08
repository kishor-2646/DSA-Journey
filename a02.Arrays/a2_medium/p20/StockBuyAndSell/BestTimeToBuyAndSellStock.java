package a1_easy.p20.BestTimeToBuyAndSellStock;

public class BestTimeToBuyAndSellStock {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Nested Loop
    // Try every pair (i, j) where j > i,
    // compute profit = prices[j] - prices[i],
    // track the maximum profit.
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int maxProfitBrute(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – One Pass
    // Maintain:
    //   minPrice   → best buying price seen so far
    //   maxProfit  → best profit achievable till today
    //
    // At day i, ask:
    //   1. Is this the lowest price I've seen so far?
    //   2. If I sell today, how much profit can I make?
    //   3. Is that profit better than my previous best?
    //
    // T(n) = O(n), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static int maxProfitOptimal(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {7, 6, 4, 3, 1};

        System.out.println("Brute   prices1: " + maxProfitBrute(prices1));    // 5
        System.out.println("Optimal prices1: " + maxProfitOptimal(prices1));  // 5

        System.out.println("Brute   prices2: " + maxProfitBrute(prices2));    // 0
        System.out.println("Optimal prices2: " + maxProfitOptimal(prices2));  // 0
    }
}
