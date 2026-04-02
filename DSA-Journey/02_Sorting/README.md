# 02. Sorting Algorithms

> ✅ **Completed: 7 / 7**

---

## Problem List

| # | Algorithm | File | Time | Space | Stable? | Status |
|---|-----------|------|------|-------|---------|--------|
| 1 | Selection Sort | [→](./S01_Selection_Sort.md) | O(n²) | O(1) | ❌ | ✅ |
| 2 | Bubble Sort | [→](./S02_Bubble_Sort.md) | O(n²) | O(1) | ✅ | ✅ |
| 3 | Insertion Sort | [→](./S03_Insertion_Sort.md) | O(n²) | O(1) | ✅ | ✅ |
| 4 | Merge Sort | [→](./S04_Merge_Sort.md) | O(n log n) | O(n) | ✅ | ✅ |
| 5 | Quick Sort | [→](./S05_Quick_Sort.md) | O(n log n) avg | O(log n) | ❌ | ✅ |
| 6 | Recursive Bubble Sort | [→](./S06_Recursive_Bubble.md) | O(n²) | O(n) | ✅ | ✅ |
| 7 | Recursive Insertion Sort | [→](./S07_Recursive_Insertion.md) | O(n²) | O(n) | ✅ | ✅ |

---

## 🧠 Key Concepts Learnt

- **Selection Sort:** Find min, swap — good for small arrays, never stable
- **Bubble Sort:** Bubble up max each pass — early exit optimisation
- **Insertion Sort:** Best for nearly sorted arrays — O(n) best case
- **Merge Sort:** Divide & conquer, always O(n log n) — uses extra space
- **Quick Sort:** Pivot partitioning — worst case O(n²) but great average
- **Stability:** Merge & Insertion are stable; Selection & Quick are not

### 📊 Comparison Table

| | Best | Average | Worst | Space | Stable |
|---|------|---------|-------|-------|--------|
| Selection | O(n²) | O(n²) | O(n²) | O(1) | ❌ |
| Bubble | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Insertion | O(n) | O(n²) | O(n²) | O(1) | ✅ |
| Merge | O(n log n) | O(n log n) | O(n log n) | O(n) | ✅ |
| Quick | O(n log n) | O(n log n) | O(n²) | O(log n) | ❌ |

---

[← Basics](../01_Basics/README.md) | [Next: Arrays →](../03_Arrays/README.md)
