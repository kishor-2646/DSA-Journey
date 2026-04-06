# 11. Move Zeroes

> **Platform:** [LeetCode](https://leetcode.com/problems/move-zeroes/description/) |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Two Pointers`  
> **Date Solved:** 6-4-2026

---

## 📝 Problem Statement

> Given an integer array `nums`, move all `0`'s to the end of it while maintaining the relative order of the non-zero elements.
> Note that you must do this **in-place** without making a copy of the array.

**Example:**
```
Input:  nums = [0, 1, 0, 3, 12]
Output: [1, 3, 12, 0, 0]
```

---

## 💡 Intuition

> **Moving zeroes means:**
> - All non-zero elements should stay in their relative order at the front
> - All zeroes should pile up at the end
>
> **Key Insight:**  
> Use two pointers — one to traverse (`i`) and one to track where the next non-zero should go (`j`).  
> Zeroes get naturally pushed back as non-zero elements fill forward positions.

---

## 🔄 Approaches

### 🐌 Brute Force
**Idea:**  
- Create a temp array
- Copy all non-zero elements first
- Fill remaining positions with 0s
- Copy back to original array

**Time:** O(n) | **Space:** O(n)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        int j = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                temp[j++] = nums[i];
            }
        }

        while (j < n) temp[j++] = 0;

        for (int i = 0; i < n; i++) nums[i] = temp[i];
    }
}
```

---

### ⚡ Optimal
**Idea:** **Two Pointer In-place**
- `j` tracks the index where next non-zero element should go
- `i` traverses the array
  - If `nums[i] != 0`: write at `nums[j]`, increment `j`, count non-zeroes
  - Else: count zeroes
- After loop, fill back zeroes from end using `k = n - 1`

**Time:** O(n) | **Space:** O(1)

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int j = 0;
        int zeroes = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                j++;
            } else {
                zeroes++;
            }
        }

        int k = n - 1;
        for (int i = 0; i < zeroes; i++) {
            nums[k] = 0;
            k--;
        }
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute | O(n) | O(n) |
| Optimal | O(n) | O(1) |

---

## 🗒 Personal Notes

> - 🔥 Best approach = Two Pointer In-place
> - `j` always ≤ `i` so no data overwrite happens
> - Count zeroes as you go, then fill from the back
> - Pattern: Two Pointer for in-place rearrangement

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/11_Move_Zeroes/page1.png)
![Handwritten Notes](../../../assets/11_Move_Zeroes/page2.png)

---
