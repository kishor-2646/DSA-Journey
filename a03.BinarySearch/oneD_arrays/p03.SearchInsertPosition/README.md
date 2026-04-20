# p03. Search Insert Position

> **Platform:** [LeetCode 35](https://leetcode.com/problems/search-insert-position/) |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Binary Search`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given a sorted array of distinct integers and a target value,  
> return its index if found, otherwise return the index where it **would be inserted** in order.

**Example:**
```
Input:  nums = [1, 3, 5, 6], target = 5   →  Output: 2
Input:  nums = [1, 3, 5, 6], target = 2   →  Output: 1
```

---

## 💡 Intuition

> This is exactly the **Lower Bound** problem.  
> We want the first index where `nums[index] >= target`.
> - If `target` is found → that's its index.
> - If `target` is not found → lower bound gives where it would be inserted.
>
> Use Binary Search with an `ans` variable initialized to `N`.
> - `nums[mid] >= target` → update `ans = mid`, search left.
> - `nums[mid] < target` → search right.

---

## 🔄 Approaches

### Approach 1: Brute Force — Linear Scan
**Time:** O(n) | **Space:** O(1)
```java
public int searchInsert(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] >= target) return i;
    }
    return nums.length;
}
```

### ⚡ Approach 2: Optimal — Binary Search (Lower Bound)
**Time:** O(log n) | **Space:** O(1)
```java
public int searchInsert(int[] nums, int target) {
    int low = 0, high = nums.length - 1;
    int ans = nums.length;

    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (nums[mid] >= target) {
            ans = mid;
            high = mid - 1;
        } else {
            low = mid + 1;
        }
    }
    return ans;
}
```

---

## 📊 Complexity Analysis

| Approach      | Time     | Space |
|---------------|----------|-------|
| Brute Force   | O(n)     | O(1)  |
| Binary Search | O(log n) | O(1)  |

---

## 🗒 Personal Notes

> - This problem is a direct application of Lower Bound.
> - Initialize `ans = N` (array length) — covers the case where target > all elements.
> - Key insight: the condition `nums[mid] >= target` handles both "found" and "insert" cases uniformly.
> - Condition `high = mid - 1` (not `mid`) prevents infinite loops when `ans = mid`.

---