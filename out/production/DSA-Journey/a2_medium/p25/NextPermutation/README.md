# 33. Next Permutation

> **Platform:** [LeetCode](https://leetcode.com/problems/next-permutation/) &nbsp;|&nbsp; LC: 31  
> **Difficulty:** 🟡 Medium  
> **Topic Tags:** `Array` `Two Pointers`  
> **Date Solved:** 8-4-2026

---

## 📝 Problem Statement

> Given an array `nums`, find the **next permutation** of nums.
> The next permutation is the next lexicographically greater arrangement.
> If no such arrangement exists (fully descending), return the smallest (ascending) permutation.
> Must be done **in-place**.

**Example:**
```
Input:  [1, 2, 3]  →  Output: [1, 3, 2]
Input:  [2, 3, 6, 5, 4, 1]  →  Output: [2, 4, 1, 3, 5, 6]
Input:  [5, 4, 3, 2, 1]  →  Output: [1, 2, 3, 4, 5]
```

---

## 💡 Intuition

> **Brute Force:** Generate all n! permutations, sort lexicographically, find current, return next. Too slow (O(n! log n!)).
>
> **Key Observation:**
> - We want the **next slightly bigger** number, not the biggest.
> - We should change the number from the **right side** — only the rightmost eligible position needs to change.
>
> **Pattern:**
> Arrange `[1, 2, 3]` as numbers: 123 < 132 < 213 < 231 < 312 < 321
>
> For `[1, 5, 4, 3, 2]`:
> - Everything to the right of `1` → `[5, 4, 3, 2]` is strictly decreasing → already the largest arrangement → we MUST change `1`
> - Find just bigger than 1 from right → `2`
> - Swap: `[2, 5, 4, 3, 1]`
> - Right part `[5, 4, 3, 1]` is still strictly decreasing → largest → reverse to get smallest → `[1, 3, 4, 5]`
> - Answer: `[2, 1, 3, 4, 5]`

---

## 🔄 Approach: Optimal In-Place Algorithm

**Step 1: Find Breakpoint**  
Scan from right to left. Find first index `i` where `nums[i] < nums[i+1]`.  
If no such index → fully decreasing → reverse entire array → return.

**Step 2: Find Next Greater**  
From the right, find first element just greater than `nums[breakpoint]`.

**Step 3: Swap** those two elements.

**Step 4: Reverse Right Part**  
Reverse everything after `breakpoint`. (Right part is strictly decreasing = largest — reverse = smallest.)

**Dry Run** on `[2, 3, 6, 5, 4, 1]`:
1. Breakpoint: `3 < 6` → index = 1 (value = 3)
2. Just greater than 3 from right side `[6,5,4,1]` → `4`
3. Swap(3, 4) → `[2, 4, 6, 5, 3, 1]`
4. Reverse right of index 1 → `[6,5,3,1]` → `[1,3,5,6]`
5. **Answer: `[2, 4, 1, 3, 5, 6]`** ✅

**Time:** O(n) | **Space:** O(1)

```java
class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length, index = -1;

        // Step 1: Find breakpoint
        for (int i = n - 2; i >= 0; i--)
            if (nums[i] < nums[i + 1]) { index = i; break; }

        // No breakpoint → reverse all
        if (index == -1) { reverse(nums, 0, n - 1); return; }

        // Step 2 & 3: Find just-greater and swap
        for (int i = n - 1; i > index; i--)
            if (nums[i] > nums[index]) { swap(nums, i, index); break; }

        // Step 4: Reverse right part
        reverse(nums, index + 1, n - 1);
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute Force | O(n! × log(n!)) | O(n!) |
| Optimal (In-Place) | O(n) | O(1) |

---

## 🗒 Personal Notes

> - Edge case: fully decreasing array → no breakpoint → just reverse
> - The right part after swap is still sorted in decreasing order → reverse gives smallest
> - Pattern: **Find Breakpoint → Swap → Reverse Suffix**

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/a03_arrays/33_NextPermutation/page1.png)
![Handwritten Notes](../../../../assets/a03_arrays/33_NextPermutation/page2.png)
![Handwritten Notes](../../../../assets/a03_arrays/33_NextPermutation/page3.png)

---
