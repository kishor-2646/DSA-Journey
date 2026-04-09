# 19. Maximum Subarray

> **Platform:** [LeetCode](https://leetcode.com/problems/maximum-subarray/) &nbsp;|&nbsp; LC: 53  
> **Difficulty:** 🟡 Medium  
> **Topic Tags:** `Array` `Divide and Conquer` `Dynamic Programming` `Kadane's Algorithm`  
> **Date Solved:** 8-4-2026

---

## 📝 Problem Statement

> Given an integer array `nums`, find the **subarray with the largest sum** and return its sum.

**Examples:**
```
Input:  nums = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
Output: 6   → Subarray: [4, -1, 2, 1]

Input:  nums = [5, 4, -1, 7, 8]
Output: 23  → Subarray: [5, 4, -1, 7, 8]
```

---

## 💡 Intuition

> **Brute Force:** Calculate sum of every possible subarray → O(n³).
>
> **Better (Prefix Sum):** Try all (i, j) pairs using prefix sum difference → O(n²).
>
> **Optimal (Kadane's Algorithm):**
> Core Idea — *"Is it better to extend the previous subarray, or start a new one from here?"*
>
> Key Observation: If the current running sum becomes **negative**, it will only
> reduce future sums. So discard it and start fresh.

---

## 🔄 Approaches

### ⚡ Approach 1: Brute Force – Three Nested Loops
**Idea:** Calculate the sum of every possible subarray, track the maximum.  
**Time:** O(n³) | **Space:** O(1)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) sum += nums[k];
                maxSum = Math.max(maxSum, sum);
            }
        return maxSum;
    }
}
```

---

### 🗺 Approach 2: Better – Prefix Sum
**Idea:**
1. Compute prefix sum array
2. Try all (i, j) pairs using `prefixSum[j] - prefixSum[i]`
3. Track maximum

**Time:** O(n²) | **Space:** O(n)

---

### 🧠 Approach 3: Optimal – Kadane's Algorithm
**Idea:**
1. Initialize `currentSum = nums[0]`, `maxSum = nums[0]`
2. For each element from index 1:
   - `currentSum = max(nums[i], currentSum + nums[i])`
   - `maxSum = max(maxSum, currentSum)`

The `max(nums[i], currentSum + nums[i])` line asks:  
*"Is it better to start fresh from here, or extend the previous subarray?"*

**Dry Run** on `[-2, 1, -3, 4, -1, 2, 1, -5, 4]`:

| i | nums[i] | currentSum | maxSum |
|---|---------|------------|--------|
| 0 | -2      | -2         | -2     |
| 1 | 1       | 1          | 1      |
| 2 | -3      | -2         | 1      |
| 3 | 4       | 4          | 4      |
| 4 | -1      | 3          | 4      |
| 5 | 2       | 5          | 5      |
| 6 | 1       | 6          | 6      |
| 7 | -5      | 1          | 6      |
| 8 | 4       | 5          | **6**  |

**Time:** O(n) | **Space:** O(1)

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(maxSum, curSum);
        }
        return maxSum;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n³) | O(1) |
| Prefix Sum | O(n²) | O(n) |
| Kadane's Algorithm | O(n) | O(1) |

---

## 🗒 Personal Notes

> - Kadane's is the classic O(n) solution — must know for interviews
> - The key decision at each step: start fresh vs extend
> - If you find a negative number, `max(nums[i], currentSum + nums[i])` handles it automatically
> - Note: if all elements are negative, Kadane's still returns the least negative (single element)
> - Pattern: **Kadane's Algorithm / Dynamic Programming on Array**

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/a03_arrays/19_MaximumSubarray/page1.png)
![Handwritten Notes](../../../../assets/a03_arrays/19_MaximumSubarray/page2.png)

---
