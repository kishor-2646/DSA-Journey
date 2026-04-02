# BS01. Binary Search

> **Platform:** [LeetCode 704](https://leetcode.com/problems/binary-search/)  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Binary Search` `Array`  
> **Date Solved:** <!-- YYYY-MM-DD -->

---

## 📝 Problem Statement

Given an array of integers `nums` sorted in ascending order, and an integer `target`, return the index if target is found, else return `-1`.

**Example:**
```
Input:  nums = [-1, 0, 3, 5, 9, 12], target = 9
Output: 4

Input:  nums = [-1, 0, 3, 5, 9, 12], target = 2
Output: -1
```

---

## 💡 Intuition

In a sorted array, if `nums[mid] < target`, the answer must be in the right half. If `nums[mid] > target`, it's in the left half. Keep halving the search space — O(log n).

---

## 🔄 Approaches

### Iterative (Recommended)
**Time:** O(log n) | **Space:** O(1)

```cpp
int search(vector<int>& nums, int target) {
    int lo = 0, hi = nums.size() - 1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;  // avoids integer overflow
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target)   lo = mid + 1;
        else                           hi = mid - 1;
    }
    return -1;
}
```

### Recursive
**Time:** O(log n) | **Space:** O(log n) — call stack

```cpp
int binarySearch(vector<int>& nums, int lo, int hi, int target) {
    if (lo > hi) return -1;
    int mid = lo + (hi - lo) / 2;
    if (nums[mid] == target) return mid;
    if (nums[mid] < target)  return binarySearch(nums, mid + 1, hi, target);
    return binarySearch(nums, lo, mid - 1, target);
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

> - Always use `mid = lo + (hi - lo) / 2` to avoid overflow
> - Condition is `lo <= hi` (not `lo < hi`) — handles single element arrays
> - This is the **foundation** — every BS problem is a variation of this template
> - Overflow trick: same as `(lo + hi) / 2` but safe when lo + hi > INT_MAX

---

## 🖊 Handwritten Notes

<!-- ![Notes](../../assets/bs_binary_search_notes.jpg) -->
*Add your handwritten notes photo here*

---
