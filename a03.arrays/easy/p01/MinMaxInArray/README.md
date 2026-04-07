# 1. Find Min & Max Element in Array

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/problems/find-minimum-and-maximum-element-in-an-array4428/1) |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Divide and Conquer`  
> **Date Solved:** 7-4-2026

---

## 📝 Problem Statement

> Given an array `arr[]`, find the **minimum** and **maximum** element in the array.

**Example:**
```
Input:  arr[] = {3, 5, 4, 1, 9}
Output: Min = 1, Max = 9
```

---

## 💡 Intuition

> **Linear Scan:** Start with `min = max = arr[0]`, then update as you traverse.  
> Simple and optimal for most use cases.
>
> **Divide & Conquer:** Split array into two halves recursively.  
> Get (min, max) from left and right halves, then combine.  
> Same time complexity as linear, but uses recursion stack O(log n) space.

---

## 🔄 Approaches

### ⚡ Approach 1: Linear Scan
**Idea:** Single pass, update min and max at every step.  
**Time:** O(n) | **Space:** O(1)

```java
class Solution {
    public static int[] getMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];

        for (int num : arr) {
            if (num < min) min = num;
            if (num > max) max = num;
        }

        return new int[]{min, max};
    }
}
```

---

### 🧠 Approach 2: Divide & Conquer (Better)
**Idea:**
- If single element: return `{arr[low], arr[low]}`
- If two elements: compare and return smaller as min, larger as max
- Else: split at `mid`, recursively get (min, max) of both halves
- Combine: `min = min(left[0], right[0])`, `max = max(left[1], right[1])`

**Time:** O(n) | **Space:** O(log n) – recursion stack

```java
class Solution {
    public static int[] getMinMax(int[] arr, int low, int high) {
        if (low == high)
            return new int[]{arr[low], arr[low]};

        if (low + 1 == high) {
            if (arr[low] < arr[high]) return new int[]{arr[low], arr[high]};
            else return new int[]{arr[high], arr[low]};
        }

        int mid = (low + high) / 2;
        int[] left  = getMinMax(arr, low, mid);
        int[] right = getMinMax(arr, mid + 1, high);

        int min = Math.min(left[0], right[0]);
        int max = Math.max(left[1], right[1]);

        return new int[]{min, max};
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Linear Scan | O(n) | O(1) |
| Divide & Conquer | O(n) | O(log n) |

---

## 🗒 Personal Notes

> - Linear scan is preferred in interviews (simpler, O(1) space)
> - Divide & Conquer: number of comparisons ≈ 3n/2 - 2 (fewer than 2n in linear)
> - DnC returns `int[]` of size 2: `{min, max}`
> - Pattern: Divide & Conquer — split, recurse, combine

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/01_Find_Min_Max/page1.png)
![Handwritten Notes](../../../assets/01_Find_Min_Max/page2.png)

---
