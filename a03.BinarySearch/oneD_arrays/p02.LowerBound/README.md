# 2. Lower Bound

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1)  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Binary Search`  
> **Date Solved:** 11-4-2026

---

## 📝 Problem Statement

> Given a sorted array of N integers and an integer `x`,  
> return the **lower bound** of `x`.
>
> **Lower Bound** = The 1st smallest index in a sorted array where  
> value at that index is **greater than or equal to** given key `x`.  
> i.e., `arr[index] >= x`
>
> If no such index found, return `n` (size of array).

**Example:**
```
Input:  N = 5, arr[] = {3, 5, 8, 15, 19},  x = 9
Output: 3   → arr[3] = 15 >= 9 (first such index)
```

---

## 💡 Intuition

> **Brute Force:** Traverse from the beginning. Return first index where `arr[index] >= x`. O(n).
>
> **Optimal:** Since array is **sorted**, use Binary Search.
>
> At each `mid`, we ask: is `arr[mid] >= x`?
> - **Yes** → `mid` could be the answer. Save it as `ans = mid`.
>   Then search the **left half** — there may be a smaller index that still satisfies the condition.
> - **No** (`arr[mid] < x`) → `mid` cannot be the answer. We need a bigger element.
>   Search the **right half**: `low = mid + 1`.
>
> Initialize `ans = n` — because if no index satisfies the condition, we return `n`.

---

## 🔄 Approaches

### ⚡ Approach 1: Brute Force – Linear Scan
**Idea:** Scan from left. Return first index where `arr[i] >= x`.  
**Time:** O(n) | **Space:** O(1)

```java
public static int lowerBound(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++)
        if (arr[i] >= x) return i;
    return arr.length;
}
```

---

### 🧠 Approach 2: Optimal – Binary Search
**Dry Run** on `[3, 5, 8, 15, 19]`, x = 5:

```
low=0, high=4 → mid=2 → arr[2]=8 >= 5 → ans=2, high=1
low=0, high=1 → mid=0 → arr[0]=3 < 5  → low=1
low=1, high=1 → mid=1 → arr[1]=5 >= 5 → ans=1, high=0
low > high → stop. Return ans = 1 ✅
```

**Time:** O(log₂ n) | **Space:** O(1)

```java
class Solution {
    public static int lowerBound(int[] arr, int x) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] >= x) {
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
| Brute Force | O(n) | O(1) |
| Binary Search | O(log n) | O(1) |

---

## 🗒 Personal Notes

> - Lower bound is a **fundamental building block** — used in many other BS problems
> - Key: initialize `ans = n` (not -1), because the "not found" answer is `n`
> - The difference vs plain binary search: when `arr[mid] >= x`, we **save** the answer but keep searching left
> - **Upper Bound** is similar but uses `arr[mid] > x` (strictly greater)
> - Pattern: **Binary Search with Answer Tracking**

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/b5_1D_Arrays/02_LowerBound/page1.png)
![Handwritten Notes](../../../../assets/b5_1D_Arrays/02_LowerBound/page2.png)

---
