# [1]. Find the Largest element in an array

  
> **Difficulty:** 🟢 Easy  
> **Topic Tags:** `Array`  
> **Date Solved:** YYYY-MM-DD

---

## 📝 Problem Statement

> Given an array, we have to find the largest element in the array.

**Example:**
```
Input:  arr[] = {2, 5, 1, 3, 0} 
Output:  5
Explanation:  5 is the largest element in the array.
```
---

## 🔄 Approaches

### 🐌 Brute Force
**Idea:**  
1.Sort the array in ascending order.  
2.Print the element at the (size of the array - 1)th index, which corresponds to the largest element in the array.  
**Time:** O(N log N) | **Space:** O(1)

```cpp
// Function to sort the array and return the largest element
    public static int sortArr(int[] arr) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        // Return the last element (largest element) after sorting
        return arr[arr.length - 1];
    }
```

---

### ⚡ Optimal
**Idea:**   
1.Create a variable called max and initialize it with the value of the first element in the array.  
2.Use a for loop to iterate through the rest of the elements in the array.   
3.In each iteration, compare the current element with the max variable.  
4.If the current element is greater than the max value, update the max value with the current element's value.  
5.After completing the loop, print the max variable, which will hold the largest value in the array.  
**Time:** O(n) | **Space:** O(1)

```cpp
// Function to find the largest element in the array
    public static int findLargestElement(int[] arr, int n) {
        int max = arr[0];  // Initialize max with the first element in the array

        // Iterate through the array to find the maximum element
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {  // If the current element is greater than max, update max
                max = arr[i];
            }
        }

        return max;  // Return the largest element found
    }
```

---

## 📊 Complexity Analysis

| Approach | Time | Space |
|----------|------|-------|
| Brute | O(N log N) | O(1) |
| Optimal | O(N) | O(1) |

---


## 🖊 Handwritten Notes

<!-- Add your handwritten notes image here -->
<!-- ![Notes](../../assets/topic_problem-name_notes.jpg) -->

*Handwritten notes: see `/assets/` folder*

---
