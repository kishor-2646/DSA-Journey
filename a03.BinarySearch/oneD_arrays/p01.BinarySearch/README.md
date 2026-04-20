# p01. Binary Search

> **Platform:** [LeetCode 704](https://leetcode.com/problems/binary-search/) |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Binary Search`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an integer array `nums` sorted in ascending order, and an integer `target`.  
> If `target` exists, return its index, else return `-1`.

**Example:**
```
Input:  nums = [-1, 0, 3, 5, 9, 12], target = 9
Output: 4
```

---

## 💡 Intuition

> Since the array is sorted, we can eliminate half the search space at each step.  
> Compare `nums[mid]` with `target`:
> - If equal → found it.
> - If `nums[mid] > target` → target is in the left half.
> - If `nums[mid] < target` → target is in the right half.
>
> Two classic implementations: **Iterative** and **Recursive**.

---

## 🔄 Approaches

### Approach 1: Iterative
**Time:** O(log n) | **Space:** O(1)
```java
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
```

### Approach 2: Recursive
**Time:** O(log n) | **Space:** O(log n) — call stack
```java
public int search(int[] a, int target, int low, int high) {
    if (low > high) return -1;
    int mid = low + (high - low) / 2;
    if (target == a[mid]) return mid;
    else if (target > a[mid]) return search(a, target, mid + 1, high);
    else return search(a, target, low, mid - 1);
}
```

---

## 📊 Complexity Analysis

| Approach  | Time       | Space    |
|-----------|------------|----------|
| Iterative | O(log n)   | O(1)     |
| Recursive | O(log n)   | O(log n) |

---

## 🗒 Personal Notes

> - Always compute mid as `low + (high - low) / 2` to avoid integer overflow.
> - Integer division floors automatically: `5/2 = 2`, not `2.5`.
> - Iterative is preferred in practice — no extra stack space.
> - Loop condition is `low <= high` (not `<`), so single-element arrays are handled.

---