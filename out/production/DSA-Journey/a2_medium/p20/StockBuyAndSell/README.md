# 20. Best Time to Buy and Sell Stock

> **Platform:** [LeetCode](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/) &nbsp;|&nbsp; LC: 121  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Greedy` `Sliding Window`  
> **Date Solved:** 8-4-2026

---

## 📝 Problem Statement

> Given an array `prices` where `prices[i]` is the price of a given stock on the i-th day.
> You want to maximize profit by choosing a **single day to buy** one stock and
> choosing a **different day in the future to sell** that stock.
> Return the **maximum profit** achievable. If no profit is possible, return `0`.

**Examples:**
```
Input:  prices = [7, 1, 5, 3, 6, 4]
Output: 5   → Buy on day 2 (price=1), sell on day 5 (price=6)

Input:  prices = [7, 6, 4, 3, 1]
Output: 0   → No profit possible (prices always decreasing)
```

---

## 💡 Intuition

> **Brute Force:** Try every pair (buy day i, sell day j) where j > i → O(n²).
>
> **Optimal:** Move day by day, maintaining:
> - `minPrice` → best buying price seen so far
> - `maxProfit` → best profit achievable till today
>
> At each day i, ask three questions:
> 1. Is this the **lowest price** I've seen so far?
> 2. If I **sell today**, how much profit can I make?
> 3. Is that profit **better than my previous best**?
>
> That's it.

---

## 🔄 Approaches

### ⚡ Approach 1: Brute Force – Nested Loop
**Idea:** Try every (buy, sell) pair, track maximum `prices[j] - prices[i]`.  
**Time:** O(n²) | **Space:** O(1)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
```

---

### 🧠 Approach 2: Optimal – One Pass Greedy
**Idea:**
1. `minPrice = prices[0]`, `maxProfit = 0`
2. For each day i from 1 to n-1:
   - Update `minPrice = min(minPrice, prices[i])`
   - Compute `profit = prices[i] - minPrice`
   - Update `maxProfit = max(maxProfit, profit)`

**Time:** O(n) | **Space:** O(1)

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            int profit = prices[i] - minPrice;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n²) | O(1) |
| One Pass Greedy | O(n) | O(1) |

---

## 🗒 Personal Notes

> - Key insight: you don't need to try every pair — just track the minimum seen so far
> - `maxProfit = 0` initialization handles the "no profit" case automatically
> - We never sell before we buy because we track min up to day i, then compute profit at day i
> - Pattern: **Greedy — Track Running Minimum**

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/a03_arrays/20_BestTimeToBuyAndSellStock/page1.png)
![Handwritten Notes](../../../../assets/a03_arrays/20_BestTimeToBuyAndSellStock/page2.png)

---
