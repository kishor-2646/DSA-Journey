# p35. Reverse Pairs

> **Platform:** [LeetCode 493](https://leetcode.com/problems/reverse-pairs/) |  
> **Difficulty:** 🔴 Hard  
> **Topic Tags:** `Array` `Merge Sort` `Divide and Conquer`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an integer array `nums`, return the number of **reverse pairs**.  
> A reverse pair is a pair `(i, j)` where `i < j` and `nums[i] > 2 * nums[j]`.

**Example:**
```
Input:  nums = [1, 3, 2, 3, 1]  →  Output: 2
Input:  nums = [2, 4, 3, 5, 1]  →  Output: 3
```

---

## 💡 Intuition

> **Brute:** Check all pairs → O(n²).  
>
> **Optimal — Modified Merge Sort:**  
> During merge sort, BEFORE merging, count pairs between left and right halves.  
> Since both halves are sorted, use two pointers to count in O(n).  
> For each `i` in left half, advance `right` pointer while `arr[i] > 2*arr[right]`.  
> Count = `right - (mid+1)` for each `i`.  
> **Important:** Count BEFORE merging — merging would destroy the order we need for counting.

---

## 🔄 Approaches

### 🐌 Brute — All Pairs
**Time:** O(n²) | **Space:** O(1)
```java
// Check all (i,j) pairs where i < j
```

### ⚡ Optimal — Modified Merge Sort
**Time:** O(n log n) | **Space:** O(n)

```java
class Solution {
    int count = 0;

    public int reversePairs(int[] nums) {
        count = 0;
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + (high - low) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        countPairs(arr, low, mid, high);  // count BEFORE merge
        merge(arr, low, mid, high);
    }

    private void countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2L * arr[right]) right++;
            count += (right - (mid + 1));
        }
    }

    // Standard merge
    private void merge(int[] arr, int low, int mid, int high) { ... }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute | O(n²) | O(1) |
| Modified Merge Sort | O(n log n) | O(n) |

---

## 🗒 Personal Notes

> - 🔥 **Count BEFORE merging** — critical ordering mistake to avoid
> - Use `2L * arr[right]` (long) to avoid integer overflow
> - Pattern: Modified Merge Sort for counting inversions/pairs problems
> - Same template as Count Inversions (p40), just different comparison condition

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/p35_ReversePairs/page1.png)

---
