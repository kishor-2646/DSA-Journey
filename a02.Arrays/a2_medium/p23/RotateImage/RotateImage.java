package a1_easy.p23.RotateImage;

public class RotateImage {

    // ─────────────────────────────────────────────
    // Approach 1: Brute Force – Extra Matrix
    // For each element at (i, j), its new position
    // in the rotated matrix is (j, n-i-1).
    // Use a new matrix, then copy back.
    // T(n) = O(n²), S(n) = O(n²)
    // Note: Problem requires in-place — not allowed.
    // ─────────────────────────────────────────────
    public static int[][] rotateBrute(int[][] matrix) {
        int n = matrix.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - i - 1] = matrix[i][j];
            }
        }
        return rotated;
    }

    // ─────────────────────────────────────────────
    // Approach 2: Optimal – Transpose + Reverse Rows
    // A 90° clockwise rotation = two simple in-place
    // operations:
    //   Step 1: Transpose the Matrix
    //           Swap elements across the diagonal:
    //           matrix[i][j] ↔ matrix[j][i]
    //           (Converts rows into columns)
    //
    //   Step 2: Reverse each row
    //           Use two pointers left/right
    //
    // T(n) = O(n²), S(n) = O(1)
    // ─────────────────────────────────────────────
    public static void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        // j starts from i+1 because diagonal doesn't change
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left <= right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(matrix);
        for (int[] row : matrix) {
            for (int val : row) System.out.print(val + " ");
            System.out.println();
        }
        // [[7,4,1],[8,5,2],[9,6,3]]
    }
}
