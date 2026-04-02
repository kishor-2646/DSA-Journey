# BSA08. Aggressive Cows

> **Platform:** [GFG](https://practice.geeksforgeeks.org/problems/aggressive-cows/0) | [SPOJ](https://www.spoj.com/problems/AGGRCOW/)  
> **Difficulty:** 🔴 Hard  
> **Topic Tags:** `Binary Search` `Search Space` `Greedy`  
> **Date Solved:** <!-- YYYY-MM-DD -->

---

## 📝 Problem Statement

Given `n` stalls at positions `stalls[]` and `k` cows to place, find the **largest minimum distance** between any two cows (place cows such that minimum distance between them is maximised).

**Example:**
```
Input:  stalls = [1, 2, 4, 8, 9], k = 3
Output: 3
Explanation: Place cows at positions 1, 4, 9 → min distance = 3
```

---

## 💡 Intuition

We want to **maximise the minimum distance** — this screams BS on answer space!

- **Search space:** `lo = 1` (min possible gap), `hi = max(stalls) - min(stalls)`
- For a given `mid` (gap), check greedily: can we place all `k` cows with at least `mid` distance?
- If yes → try a larger gap (`lo = mid + 1`), save `mid` as answer
- If no → try smaller gap (`hi = mid - 1`)

---

## 🔄 Approaches

### ⚡ Binary Search on Answer Space
**Time:** O(n log n + n log(max_dist)) | **Space:** O(1)

```cpp
bool canPlace(vector<int>& stalls, int k, int minDist) {
    int cows = 1;
    int lastPos = stalls[0];
    for (int i = 1; i < stalls.size(); i++) {
        if (stalls[i] - lastPos >= minDist) {
            cows++;
            lastPos = stalls[i];
        }
    }
    return cows >= k;
}

int aggressiveCows(vector<int>& stalls, int k) {
    sort(stalls.begin(), stalls.end());
    int lo = 1;
    int hi = stalls.back() - stalls.front();
    int ans = -1;
    while (lo <= hi) {
        int mid = lo + (hi - lo) / 2;
        if (canPlace(stalls, k, mid)) {
            ans = mid;    // valid, try to maximise
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return ans;
}
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| BS on Answer | O(n log n + n log D) where D = max distance | O(1) |

---

## 🗒 Personal Notes

> - **Classic "maximise the minimum" problem** — the first of its kind
> - Sorting is mandatory before applying the greedy check
> - Same pattern as: Book Allocation, Painter's Partition, Ship Packages
> - The `canPlace` check is greedy: place cow at earliest valid position
> - When `canPlace` returns true → we've found a valid answer, but push for more

---

## 🖊 Handwritten Notes

<!-- ![Notes](../../assets/bs_aggressive_cows_notes.jpg) -->
*Add your handwritten notes photo here*

---
