# 1. Binary Search

> **Platform:** [LeetCode](https://leetcode.com/problems/binary-search/) &nbsp;|&nbsp; LC: 704 &nbsp;|&nbsp; [GeeksForGeeks](https://www.geeksforgeeks.org/binary-search/)  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Binary Search`  
> **Date Solved:** 11-4-2026

---

## 📝 Problem Statement

> Given an integer array sorted in **ascending order** and a `target`,  
> if `target` exists return its **index**, else return **-1**.

**Example:**
```
Input:  nums = [-1, 0, 3, 5, 9, 12], target = 9
Output: 4
```

---

## 💡 Intuition

> The array is **sorted** — so we can eliminate half the search space at every step.
>
> Calculate `mid`. Compare `nums[mid]` with `target`:
> - If equal → found it, return `mid`
> - If `nums[mid] > target` → target is in the **left half** → `high = mid - 1`
> - If `nums[mid] < target` → target is in the **right half** → `low = mid + 1`
>
> Use `mid = low + (high - low) / 2` instead of `(low + high) / 2` to **avoid integer overflow**.  
> Note: `/2` gives **floor division** — e.g., `5/2 = 2`, not `2.5`.

---

## 🔄 Approaches

### ⚡ Approach 1: Iterative
**Idea:** Two pointers `low` and `high`. Narrow search space each iteration.  
**Time:** O(log n) | **Space:** O(1)

```java
class Solution {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
}
```

---

### 🧠 Approach 2: Recursive
**Idea:** Same logic with recursion. Base case: `low > high → return -1`.  
**Time:** O(log n) | **Space:** O(log n) — recursion stack

```java
class Solution {
    public int search(int[] a, int target, int low, int high) {
        if (low > high) return -1;
        int mid = low + (high - low) / 2;
        if (target == a[mid]) return mid;
        else if (target > a[mid]) return search(a, target, mid + 1, high);
        else return search(a, target, low, mid - 1);
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Iterative | O(log n) | O(1) |
| Recursive | O(log n) | O(log n) |

---

## 🗒 Personal Notes

> - Iterative is **preferred** in interviews — O(1) space and no stack overflow risk
> - Always use `low + (high - low) / 2` to prevent integer overflow
> - The `while (low <= high)` condition is critical — `<=` not just `<`
> - Pattern: **Classic Binary Search Template**

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/b5_1D_Arrays/01_BinarySearch/page1.png)

---
