package a1_easy.p24.SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    // ─────────────────────────────────────────────
    // Approach: Simulation with 4 Boundaries
    // Maintain 4 pointers:
    //   top, bottom, left, right
    //
    // Traverse in 4 directions in each iteration:
    //   1. Left → Right  (top row),  then top++
    //   2. Top  → Bottom (right col), then right--
    //   3. Right → Left  (bottom row, if top<=bottom), then bottom--
    //   4. Bottom → Top  (left col, if left<=right), then left++
    //
    // Continue while top <= bottom && left <= right
    //
    // T(n) = O(m×n), S(n) = O(1) [excluding output]
    // ─────────────────────────────────────────────
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1;
        int left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse top row: left → right
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            // Traverse right column: top → bottom
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            // Traverse bottom row: right → left (if row still exists)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // Traverse left column: bottom → top (if col still exists)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
        // [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
