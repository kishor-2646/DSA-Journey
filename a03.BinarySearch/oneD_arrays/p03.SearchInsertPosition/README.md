# 3. Search Insert Position

> **Platform:** [LeetCode](https://leetcode.com/problems/search-insert-position/) &nbsp;|&nbsp; LC: 35  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Binary Search`  
> **Date Solved:** 11-4-2026

---

## 📝 Problem Statement

> Given a sorted array of **distinct** elements and a `target`.
> - If `target` is **found**, return its index.
> - If `target` is **not found**, return the index where it **would be inserted** in order.

**Examples:**
```
Input:  nums = [1, 3, 5, 6], target = 5  →  Output: 2  (found)
Input:  nums = [1, 3, 5, 6], target = 2  →  Output: 1  (insert between 1 and 3)
Input:  nums = [1, 3, 5, 6], target = 7  →  Output: 4  (insert at end)
Input:  nums = [1, 3, 5, 6], target = 0  →  Output: 0  (insert at beginning)
```

---

## 💡 Intuition

> This is **exactly the Lower Bound problem** in disguise.
>
> Lower Bound = first index where `arr[index] >= target`.
> - If target **exists** → that's its index.
> - If target **doesn't exist** → that's the first element greater than it,
>   which is exactly where target should be inserted!
>
> So: run the Lower Bound binary search algorithm directly.

---

## 🔄 Approach: Lower Bound via Binary Search

**Dry Run** on `arr = [1, 2, 4, 7]`, target = 6:

```
low=0, high=3 → mid=1 → arr[1]=2 < 6 → low=2
low=2, high=3 → mid=2 → arr[2]=4 < 6 → low=3
low=3, high=3 → mid=3 → arr[3]=7 >= 6 → ans=3, high=2
low > high → return 3  ✅  (insert 6 at index 3, before 7)
```

**Time:** O(log n) | **Space:** O(1)

```java
class Solution {
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
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Binary Search (Lower Bound) | O(log n) | O(1) |

---

## 🗒 Personal Notes

> - Recognize this as Lower Bound — the conceptual link makes it trivial
> - `ans = nums.length` initialization handles "insert at the end" case
> - No special case needed for "found" vs "not found" — Lower Bound handles both
> - Pattern: **Lower Bound = Search Insert Position**

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/b5_1D_Arrays/03_SearchInsertPosition/page1.png)

---
