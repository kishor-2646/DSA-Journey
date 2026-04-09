package arrays.hard.p29.PascalTriangle;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    // ─────────────────────────────────────────────
    // VARIATION 1: Find element at row r, column c
    // C(r-1, c-1) = (r-1)! / ((c-1)! * (r-c)!)
    // Compute iteratively to avoid overflow.
    // T(n) = O(c), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static long nCr(int n, int r) {
        long res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public static long elementAt(int row, int col) {
        return nCr(row - 1, col - 1);
    }

    // ─────────────────────────────────────────────
    // VARIATION 2: Print an entire row of Pascal's Triangle
    // Each element = previous * (row - col) / col
    // Start with 1 and build iteratively.
    // T(n) = O(n), S(n) = O(n)
    // ─────────────────────────────────────────────
    public static List<Long> generateRow(int row) {
        List<Long> ans = new ArrayList<>();
        long cur = 1;
        ans.add(1L);

        for (int col = 1; col < row; col++) {
            cur = cur * (row - col);
            cur = cur / col;
            ans.add(cur);
        }

        return ans;
    }

    // ─────────────────────────────────────────────
    // VARIATION 3: Generate the entire Pascal's Triangle
    // Build each row using the generateRow helper.
    // T(n) = O(n²), S(n) = O(n²)
    // ─────────────────────────────────────────────
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int row = 1; row <= numRows; row++) {
            List<Integer> curRow = new ArrayList<>();
            long cur = 1;
            curRow.add(1);

            for (int col = 1; col < row; col++) {
                cur = cur * (row - col);
                cur = cur / col;
                curRow.add((int) cur);
            }

            triangle.add(curRow);
        }

        return triangle;
    }

    public static void main(String[] args) {
        // Variation 1
        System.out.println(elementAt(5, 3)); // 6  (row 5, col 3 → C(4,2)=6)

        // Variation 2
        System.out.println(generateRow(5)); // [1, 4, 6, 4, 1]

        // Variation 3
        List<List<Integer>> result = generate(5);
        for (List<Integer> row : result) {
            System.out.println(row);
        }
        // [1]
        // [1, 1]
        // [1, 2, 1]
        // [1, 3, 3, 1]
        // [1, 4, 6, 4, 1]
    }
}
