# S04. Merge Sort

> **Platform:** [GFG](https://practice.geeksforgeeks.org/problems/merge-sort/1)  
> **Difficulty:** 🟡 Medium  
> **Topic Tags:** `Sorting` `Divide and Conquer` `Recursion`  
> **Date Solved:** <!-- YYYY-MM-DD -->

---

## 📝 Problem Statement

Sort a given array using Merge Sort (divide and conquer approach).

**Example:**
```
Input:  [9, 4, 7, 6, 3, 1, 5]
Output: [1, 3, 4, 5, 6, 7, 9]
```

---

## 💡 Intuition

Divide the array into two halves, recursively sort each half, then merge the two sorted halves. The merge step is where the actual work happens — two sorted arrays can always be merged in O(n).

---

## 🔄 Implementation

### ⚡ Recursive Merge Sort
**Time:** O(n log n) — always | **Space:** O(n) — temp array

```cpp
void merge(vector<int>& arr, int lo, int mid, int hi) {
    vector<int> temp;
    int left = lo, right = mid + 1;

    while (left <= mid && right <= hi) {
        if (arr[left] <= arr[right])  // <= ensures stability
            temp.push_back(arr[left++]);
        else
            temp.push_back(arr[right++]);
    }
    while (left <= mid)   temp.push_back(arr[left++]);
    while (right <= hi)   temp.push_back(arr[right++]);

    // Copy back
    for (int i = lo; i <= hi; i++)
        arr[i] = temp[i - lo];
}

void mergeSort(vector<int>& arr, int lo, int hi) {
    if (lo >= hi) return;           // base case: single element
    int mid = lo + (hi - lo) / 2;
    mergeSort(arr, lo, mid);        // sort left half
    mergeSort(arr, mid + 1, hi);    // sort right half
    merge(arr, lo, mid, hi);        // merge the two halves
}
```

---

## 📊 Complexity Analysis

| Case | Time | Space |
|------|------|-------|
| Best | O(n log n) | O(n) |
| Average | O(n log n) | O(n) |
| Worst | O(n log n) | O(n) |

---

## 🗒 Personal Notes

> - **Always O(n log n)** — unlike Quick Sort which degrades to O(n²) in worst case
> - Uses **extra O(n) space** — not in-place; this is the tradeoff
> - The `<=` in merge comparison makes it **stable**
> - Merge Sort is the basis for **Count Inversions** and **Reverse Pairs** (Hard array problems)
> - For linked lists, Merge Sort is preferred over Quick Sort (no random access needed)

---

## 🖊 Handwritten Notes

<!-- ![Notes](../assets/sorting_merge-sort_notes.jpg) -->
*Add your handwritten notes photo here*

---
