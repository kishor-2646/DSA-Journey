# p04. Floor & Ceil in Sorted Array

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/problems/ceil-the-floor2802/1) |  
> **Difficulty:** 🟡 Medium  
> **Topic Tags:** `Array` `Binary Search`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given a sorted array of `n` integers and a value `x`:
> - **Floor** of `x` = the largest element in the array which is **≤ x**.
> - **Ceil** of `x` = the smallest element in the array which is **≥ x**.
> - Return `-1` if floor/ceil does not exist.

**Example:**
```
Input:  n = 6, arr = [3, 4, 4, 7, 8, 10], x = 5
Output: Floor = 4, Ceil = 7

Input:  n = 6, arr = [3, 4, 4, 7, 8, 10], x = 8
Output: Floor = 8, Ceil = 8
```

---

## 💡 Intuition

> Both floor and ceil can be found with binary search using two separate checks:
>
> **For Ceil (≥ x):**
> 1. If `arr[mid] >= x` → mid may be answer; search left for a smaller valid value.
> 2. If `arr[mid] < x` → too small; need bigger element, search right.
>
> **For Floor (≤ x):**
> 1. If `arr[mid] <= x` → mid may be answer; search right for a larger valid value.
> 2. If `arr[mid] > x` → too big; need smaller element, search left.

---

## 🔄 Approaches

### ⚡ Find Ceil — Binary Search
**Time:** O(log n) | **Space:** O(1)
```java
public int findCeil(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] >= x) { ans = arr[mid]; high = mid - 1; }
        else { low = mid + 1; }
    }
    return ans;
}
```

### ⚡ Find Floor — Binary Search
**Time:** O(log n) | **Space:** O(1)
```java
public int findFloor(int[] arr, int x) {
    int low = 0, high = arr.length - 1;
    int ans = -1;
    while (low <= high) {
        int mid = low + (high - low) / 2;
        if (arr[mid] <= x) { ans = arr[mid]; low = mid + 1; }
        else { high = mid - 1; }
    }
    return ans;
}
```

---

## 📊 Complexity Analysis

| Operation | Time     | Space |
|-----------|----------|-------|
| Find Ceil | O(log n) | O(1)  |
| Find Floor| O(log n) | O(1)  |

---

## 🗒 Personal Notes

> - Floor and Ceil are symmetric: floor uses `<=` and searches right; ceil uses `>=` and searches left.
> - Initialize `ans = -1` — covers the case where no valid element exists.
> - Store `arr[mid]` (the value) not `mid` (the index) as the answer.
> - When `x` is exactly in the array: floor = ceil = x.
> - Ceil is essentially Lower Bound returning the value at that index.

---