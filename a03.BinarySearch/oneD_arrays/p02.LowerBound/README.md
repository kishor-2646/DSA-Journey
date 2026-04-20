# p02. Lower Bound

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1) |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Binary Search`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given a sorted array of N integers and an integer `x`, return the **lower bound** of `x`.  
> Lower Bound = the 1st smallest index in the array where `arr[index] >= x`.  
> If no such index exists, return `N` (size of array).

**Example:**
```
Input:  N = 5, arr = [3, 5, 8, 15, 19], x = 9
Output: 3
```

---

## 💡 Intuition

> The lower bound algorithm finds the **first** index where `arr[index] >= x`.  
> Since the array is sorted, use Binary Search to find this efficiently.
>
> - If `arr[mid] >= x` → mid could be the answer; try going left for a smaller valid index.
> - If `arr[mid] < x` → mid cannot be answer; move right.
>
> Initialize `ans = N` as default (no index found → return N).

---

## 🔄 Approaches

### Approach 1: Brute Force — Linear Scan
**Time:** O(n) | **Space:** O(1)
```java
public int lowerBoundBrute(int[] arr, int x) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] >= x) return i;
    }
    return arr.length;
}
```

### ⚡ Approach 2: Optimal — Binary Search
**Time:** O(log n) | **Space:** O(1)
```java
public int lowerBound(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = arr.length; // default if no index found

    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] >= x) {
            ans = mid;       // mid may be answer
            high = mid - 1;  // search left for smaller index
        } else {
            low = mid + 1;   // need bigger element
        }
    }
    return ans;
}
```

---

## 📊 Complexity Analysis

| Approach     | Time     | Space |
|--------------|----------|-------|
| Brute Force  | O(n)     | O(1)  |
| Binary Search| O(log n) | O(1)  |

---

## 🗒 Personal Notes

> - Initialize `ans = N` because if no index satisfies `arr[i] >= x`, return N.
> - Key condition: `arr[mid] >= x` → update ans AND search LEFT for potentially smaller index.
> - Upper Bound is similar but uses strict `>` instead of `>=`.
> - Java's `Arrays.binarySearch()` behaves similarly but has different return conventions.

---