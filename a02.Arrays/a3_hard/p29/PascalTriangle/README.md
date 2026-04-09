# p29. Pascal's Triangle

> **Platform:** [LeetCode 118](https://leetcode.com/problems/pascals-triangle/) |  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array` `Math` `Dynamic Programming`  
> **Date Solved:** 9-4-2026

---

## 📝 Problem Statement

> Given an integer `numRows`, return the first `numRows` of Pascal's triangle.  
> In Pascal's triangle, each number is the sum of the two numbers directly above it.

**Example:**
```
Input:  numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
```

---

## 💡 Intuition

> Pascal's Triangle has 3 common variation problems in interviews:
>
> **Variation 1 — Element at (row, col):**  
> Element at row `r`, col `c` = `C(r-1, c-1)` (0-indexed).  
> Compute nCr iteratively: `result = result * (n-i) / (i+1)` for each step.
>
> **Variation 2 — Print a full row:**  
> Each element = `prevElement * (row - col) / col`.  
> Start with 1 and build forward.
>
> **Variation 3 — Full Triangle:**  
> Use the row generator for each row from 1 to numRows.

---

## 🔄 Approaches

### Variation 1: Element at (row, col) — nCr Formula
**Time:** O(col) | **Space:** O(1)
```java
public long nCr(int n, int r) {
    long res = 1;
    for (int i = 0; i < r; i++) {
        res = res * (n - i);
        res = res / (i + 1);
    }
    return res;
}
// elementAt(row, col) = nCr(row-1, col-1)
```

### Variation 2: Generate Single Row
**Time:** O(n) | **Space:** O(n)
```java
public List<Long> generateRow(int row) {
    List<Long> ans = new ArrayList<>();
    long cur = 1;
    ans.add(1L);
    for (int col = 1; col < row; col++) {
        cur = cur * (row - col) / col;
        ans.add(cur);
    }
    return ans;
}
```

### ⚡ Variation 3: Full Pascal's Triangle
**Time:** O(n²) | **Space:** O(n²)
```java
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        for (int row = 1; row <= numRows; row++) {
            List<Integer> curRow = new ArrayList<>();
            long cur = 1;
            curRow.add(1);
            for (int col = 1; col < row; col++) {
                cur = cur * (row - col) / col;
                curRow.add((int) cur);
            }
            triangle.add(curRow);
        }
        return triangle;
    }
}
```

---

## 📊 Complexity Analysis

| Variation | Time | Space |
|-----------|------|-------|
| Element at (r, c) | O(c) | O(1) |
| Single Row | O(n) | O(n) |
| Full Triangle | O(n²) | O(n²) |

---

## 🗒 Personal Notes

> - 🔥 Key formula: element at row `r`, col `c` = `C(r-1, c-1)`
> - Row generation: `cur = cur * (row - col) / col` builds each element from previous
> - Always divide AFTER multiplying to keep integers exact
> - Use `long` for intermediate computations to avoid overflow
> - Pattern: Combinatorics — nCr with iterative computation

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../assets/p29_PascalTriangle/page1.png)

---
