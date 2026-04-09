# p37. Largest Subarray with Sum Zero

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1) |  
> **Difficulty:** 🟡 Medium  
> **Topic Tags:** `Array` `HashMap` `Prefix Sum`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an array `arr[]`, find the **length of the largest subarray** with a sum of 0.

**Example:**
```
Input:  arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
Output: 5   (subarray [-2, 2, -8, 1, 7])
```

---

## 💡 Intuition

> **Key insight:** If `prefixSum[i] == prefixSum[j]` for `i < j`, then the subarray `(i+1, j)` has sum 0 (the equal prefix sums cancel out).  
> Store the **first occurrence** of each prefix sum in a HashMap.  
> If a prefix sum is seen again at index `j`, the subarray length = `j - firstOccurrence`.  
> Initialize map with `{0: -1}` to handle subarrays starting from index 0.

---

## 🔄 Approach

### ⚡ Optimal — Prefix Sum + HashMap
**Time:** O(n) | **Space:** O(n)

```java
class Solution {
    public int maxLen(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0, maxLen = 0;
        map.put(0, -1); // handle subarrays starting from index 0

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            if (map.containsKey(prefixSum)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum));
            } else {
                map.put(prefixSum, i); // store FIRST occurrence only
            }
        }
        return maxLen;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute | O(n²) | O(1) |
| Optimal (Prefix + HashMap) | O(n) | O(n) |

---

## 🗒 Personal Notes

> - 🔥 Same prefix sum pattern as Longest Subarray with Sum K — but target is 0
> - `map.put(0, -1)` is essential (when entire prefix sums to 0, length = i - (-1) = i+1)
> - Store FIRST occurrence only — we want the longest subarray
> - Pattern: Prefix Sum + HashMap for longest subarray problems

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/p37_LargestSubarrayWithSumZero/page1.png)

---
