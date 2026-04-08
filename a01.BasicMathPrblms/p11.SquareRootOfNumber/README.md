# 11. Square Root of a Number

> **Platform:** [GeeksForGeeks](https://www.geeksforgeeks.org/square-root-of-an-integer/) | [LeetCode](https://leetcode.com/problems/sqrtx/)  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Math` `Binary Search`  
> **Date Solved:** 8-4-2026

---

## 📝 Problem Statement

> Given a positive integer `n`, find its **square root**.  
> If `n` is not a perfect square, return the **floor** of √n (largest integer whose square ≤ n).

**Examples:**
```
Input:  n = 4    →  Output: 2      (2 * 2 = 4, perfect square)
Input:  n = 11   →  Output: 3      (√11 lies between 3 & 4, floor = 3)
Input:  n = 36   →  Output: 6      (6 * 6 = 36, perfect square)
```

---

## 💡 Intuition

> **Naive Approach:** Start `res = 1`, keep incrementing until `res * res > n`. Return `res - 1`.  
> Works but slow — runs O(√n) times.
>
> **Binary Search:** The answer lies somewhere between `1` and `n`. Apply binary search — at each `mid`, check if `mid * mid <= n`. If yes, record `res = mid` and go right; else go left.  
> Efficient — O(log n).
>
> **Math Formula:** `sqrt(n) = e^(0.5 * log(n))`. Use `Math.exp` and `Math.log` directly.  
> O(1) but can have floating point errors — always verify with `(res+1)*(res+1) <= n`.

---

## 🔄 Approaches

### ⚡ Approach 1: Naive Linear Scan
**Idea:** Increment `res` from 1 until `res * res > n`, return `res - 1`.  
**Time:** O(√n) | **Space:** O(1)

```java
class Solution {
    public static int floorSqrt(int n) {
        int res = 1;
        while (res * res <= n) {
            res++;
        }
        return res - 1;
    }
}
```

---

### 🧠 Approach 2: Binary Search (Better)
**Idea:**
- `low = 1`, `high = n`
- At each `mid = low + (high - low) / 2`:
    - If `mid * mid <= n` → valid candidate, store `res = mid`, move `low = mid + 1`
    - Else → too big, move `high = mid - 1`
- Return `res`

**Time:** O(log n) | **Space:** O(1)

```java
class Solution {
    public static int floorSqrtBinarySearch(int n) {
        int low = 1, high = n;
        int res = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (mid * mid <= n) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return res;
    }
}
```

---

### 🚀 Approach 3: Math Formula (Most Efficient)
**Idea:**  
Derive formula mathematically:
- Let `x = sqrt(n)` → `x² = n` → `log(x²) = log(n)` → `2 log(x) = log(n)` → `log(x) = ½ log(n)` → `x = e^(½ * log(n))`

Use `Math.exp(0.5 * Math.log(n))` and cast to `int`.  
Always verify: if `(res+1)*(res+1) <= n` due to floating-point error, return `res+1`.

**Time:** O(1) | **Space:** O(1)

```java
class Solution {
    public static int floorSqrtFormula(int n) {
        int res = (int) Math.exp(0.5 * Math.log(n));

        if ((long)(res + 1) * (res + 1) <= n)
            return res + 1;

        return res;
    }
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Naive Linear Scan | O(√n) | O(1) |
| Binary Search | O(log n) | O(1) |
| Math Formula | O(1) | O(1) |

---

## 🗒 Personal Notes

> - **Binary Search** is the preferred interview answer — clean, O(log n), no floating point issues
> - **Math Formula** is O(1) but always handle floating-point edge cases
> - Use `(long)` cast when computing `mid * mid` to avoid integer overflow for large `n`
> - For n = 30: BS trace → low=1, high=30 → mid=15 (too big), mid=7 (too big), mid=4, mid=5 → res=5
> - Pattern: Binary Search on answer space

---

## 🖊 Handwritten Notes

![Handwritten Notes](../../../../assets/a01_basic_math/11_SquareRoot/page1.png)
![Handwritten Notes](../../../../assets/a01_basic_math/11_SquareRoot/page2.png)