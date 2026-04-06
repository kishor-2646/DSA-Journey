# 12. Union of Two Sorted Arrays

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/problems/union-of-two-sorted-arrays-1587115621/1) |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Two Pointers`  
> **Date Solved:** 6-4-2026

---

## 📝 Problem Statement

> Given two sorted arrays `arr1` and `arr2` of size `n` and `m` respectively, find the **union** of the two sorted arrays.
> The given arrays may contain duplicates either across both arrays or within the same array.

**Example:**
```
Input:  n = 5, m = 5
        arr1 = [1, 2, 3, 4, 5]
        arr2 = [2, 3, 4, 4, 5]
Output: [1, 2, 3, 4, 5]
```

---

## 💡 Intuition

> Since both arrays are **already sorted**, we can use the Two Pointer technique.
> - Compare elements from both arrays
> - Always pick the smaller element (skip duplicates)
> - After one array exhausts, drain the other

> **Duplicate check:**  
> Before adding to union, verify union is empty OR last element ≠ current element.  
> This prevents duplicates from being added again.

---

## 🔄 Approaches

### ⚡ Optimal: Two Pointer
**Idea:**  
- Use pointers `i` and `j` for `arr1` and `arr2`
- While both are in range:
  - If `arr1[i] < arr2[j]`: add `arr1[i]` if not duplicate, increment `i`
  - If `arr2[j] < arr1[i]`: add `arr2[j]` if not duplicate, increment `j`
  - If equal: add `arr1[i]` if not duplicate, increment both
- Drain remaining elements from either array (with duplicate check)

**Time:** O(m + n) | **Space:** O(m + n)

```java
class Solution {
    public static List<Integer> findUnion(int[] arr1, int[] arr2, int n, int m) {
        List<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i])
                    union.add(arr1[i]);
                i++;
            } else if (arr2[j] < arr1[i]) {
                if (union.isEmpty() || union.get(union.size() - 1) != arr2[j])
                    union.add(arr2[j]);
                j++;
            } else {
                if (union.isEmpty() || union.get(union.size() - 1) != arr1[i])
                    union.add(arr1[i]);
                i++;
                j++;
            }
        }

        while (i < n) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr1[i])
                union.add(arr1[i]);
            i++;
        }

        while (j < m) {
            if (union.isEmpty() || union.get(union.size() - 1) != arr2[j])
                union.add(arr2[j]);
            j++;
        }

        return union;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Optimal (Two Pointer) | O(m + n) | O(m + n) |

---

## 🗒 Personal Notes

> - 🔥 Best approach = Two Pointer
> - The duplicate check: `union.isEmpty() || union.get(union.size() - 1) != current`
>   - Checks if union is empty OR last element in union ≠ current element being added
>   - Prevents duplicates from being added again
> - Works because arrays are already sorted — duplicates will always be adjacent
> - Pattern: Two Pointer traversal on sorted arrays

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/12_Union_Of_Two_Sorted_Arrays/page1.png)
![Handwritten Notes](../../../assets/12_Union_Of_Two_Sorted_Arrays/page2.png)

---
